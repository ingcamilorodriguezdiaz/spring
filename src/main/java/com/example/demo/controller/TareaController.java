package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Tarea;
import com.example.demo.service.ITareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TareaController {
    
 
    @Autowired
    @Qualifier("servicioTarea")
    private ITareaService service;

   
    @GetMapping("/tareas")
    public List<Tarea> getTareas() {
        return service.listar();
    }


    @PostMapping("/tarea/registrar")
    public ResponseEntity<Tarea> crear(@RequestBody Tarea Tarea) {
       
        service.save(Tarea);
        return new ResponseEntity<>(Tarea, HttpStatus.OK);
    }

    @PutMapping("/tarea/registrar")
    public ResponseEntity<Tarea> actualizar(@RequestBody Tarea Tarea) {       
        service.save(Tarea);
        return new ResponseEntity<>(Tarea, HttpStatus.OK);
    }

    @DeleteMapping("/tarea/eliminar/{id}")
    public List<Tarea> eliminar(@PathVariable Integer id, Model model) {
        Optional<Tarea> tarea = service.listarId(id);
        service.delete(tarea.get());
        return this.getTareas();
    }
  


}
