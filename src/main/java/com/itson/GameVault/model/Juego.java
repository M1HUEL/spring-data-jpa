package com.itson.GameVault.model;

import jakarta.persistence.*;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "juegos")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "description", nullable = false, length = 1000)
    private String description;
    @Column(name = "portada_url")
    private String portadaUrl;
}
