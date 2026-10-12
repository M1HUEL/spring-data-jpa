package com.itson.GameVault.controller;

import com.itson.GameVault.model.Juego;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class GameController {


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
        model.addAttribute("juegos", juegosdb);
        return "juegos";
    }

    @PostMapping("/juegos")
    public String guardarJuego(@RequestParam("titulo") String titulo, @RequestParam("descripcion") String descripcion, @RequestParam("portada") MultipartFile portada) {

        return "redirect:/juegos";
    }
}
