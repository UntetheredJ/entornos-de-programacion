/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entornos.ejemplo0001.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juan
 */

@RestController
public class SaludoController {
    
    @GetMapping(value = "saludo/{titulo}/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String saludo(@PathVariable("titulo") String titulo, @PathVariable("name") String name){
        return "Bienvenid@ " + titulo + ": " + name + " al curso de Spring Boot";
    }
    
}
