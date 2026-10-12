package com.itson.GameVault.service;

import com.itson.GameVault.model.Juego;
import com.itson.GameVault.repository.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class JuegoService {

  @Autowired
  private JuegoRepository juegoRepository;

  private static final String UPLOAD_DIR = "src/main/resources/static/uploads";

  public List<Juego> listarTodos() {
    return juegoRepository.findAll();
  }

  public void guardarJuego(Juego juego, MultipartFile portada) {
    String nombreArchivo = "default.png";

    if (!portada.isEmpty()) {
      nombreArchivo = guardarImagenEnProyecto(portada);
    }

    juego.setPortadaUrl(nombreArchivo);

    juegoRepository.save(juego);
  }

  public String guardarImagenEnProyecto(MultipartFile portada) {
    String nombreArchivo = null;
    try {
      Path uploadPath = Paths.get(UPLOAD_DIR);
      if (!Files.exists(uploadPath)) {
        Files.createDirectories(uploadPath);
      }

      nombreArchivo = UUID.randomUUID().toString() + "_" + portada.getOriginalFilename();
      Path filePath = uploadPath.resolve(nombreArchivo);

      Files.copy(portada.getInputStream(), filePath);

      System.out.println("Archivo guardado en en" + filePath.toAbsolutePath());
    } catch (IOException e) {
      return "default.png";
    }

    return nombreArchivo;
  }
}
