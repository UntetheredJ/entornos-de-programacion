package uis.edu.entornos.ejemplo0002.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import uis.edu.entornos.ejemplo0002.model.Curso;

@RestController
public class CursoController {

    // Attributes
    private List<Curso> cursos;

    /**
     * Method to show a new Curso
     * 
     * @return Curso as JSON
     */
    @GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso getCurso() {
        return new Curso("Java", 100, "Mañana");
    }

    /**
     * Initializes Cursos list.
     */
    @PostConstruct
    public void init() {
        cursos = new ArrayList<>();
        cursos.add(new Curso("Spring", 25, "Tarde"));
        cursos.add(new Curso("Python", 20, "Tarde"));
        cursos.add(new Curso("Java EE", 30, "Tarde"));
        cursos.add(new Curso("Spring Boot", 50, "Fin de Semana"));
        cursos.add(new Curso("Java Básico", 30, "Mañana"));
        cursos.add(new Curso("Flutter", 37, "Noche"));
    }

    /**
     * Gets all cursos
     * 
     * @return cursos list as JSON
     */
    @GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> getCursos() {
        return cursos;
    }

    /**
     * Finds all Cursos which contain a certain word as its name
     * 
     * @param name the Curso name
     * @return list of found Cursos based on name
     */
    @GetMapping(value = "cursos/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> buscarCursos(@PathVariable("name") String name) {
        List<Curso> aux = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getNombre().contains(name)) {
                aux.add(curso);
            }
        }
        return aux;
    }

    /**
     * Adds a new Curso into the cursos list
     * 
     * @param curso the Curso to add
     * @return the Cursos list
     */
    @PostMapping(value = "addCurso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> addCurso(@RequestBody Curso curso) {
        cursos.add(curso);
        return cursos;
    }

    /**
     * Updates a Curso
     * 
     * @param curso the Curso to update
     * @return
     */
    @PutMapping(value = "updateCurso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> updateCurso(@RequestBody Curso curso) {
        // Loops through all Cursos and replaces the one which contains the name of the
        // Curso to update
        for (Curso foundCurso : cursos) {
            if (foundCurso.getNombre().equals(curso.getNombre())) {
                cursos.set(cursos.indexOf(foundCurso), curso);
            }
        }
        return cursos;
    }

    /**
     * Deletes a Curso from the list based on its name
     * 
     * @param name the name of the Curso to delete
     */
    @DeleteMapping(value = "deleteCurso/{name}")
    public void deleteCurso(@PathVariable("name") String name) {
        cursos.removeIf(curso -> curso.getNombre().equals(name));
    }
}
