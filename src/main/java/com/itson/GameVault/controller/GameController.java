package com.itson.GameVault.controller;

import com.itson.GameVault.model.Juego;
import com.itson.GameVault.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GameController {

    @Autowired
    private JuegoService juegoService;

    @GetMapping("/fragments-demo")
    public String fragments() {
        return "fragments-demo";
    }

    @GetMapping("/juegos/nuevo")
    public String mostrarFormulario() {
        return "formulario";
    }

    @GetMapping({"/", "/juegos"})
    public String listarJuegos(Model model) {
        model.addAttribute("juegos", juegoService.listarTodos());
        return "juegos";
    }

    @PostMapping("/juegos")
    public String guardarJuego(@RequestParam("titulo") String titulo, @RequestParam("descripcion") String descripcion, @RequestParam("portada") MultipartFile portada) {
        Juego juego = new Juego();
        juego.setTitulo(titulo);
        juego.setDescription(descripcion);

        juegoService.guardarJuego(juego, portada);

        return "redirect:/juegos";
    }
}
