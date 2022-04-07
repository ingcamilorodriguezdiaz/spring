package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Empleado;
import com.example.demo.service.IEmpleadoService;

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
public class EmpleadoController {

    @Autowired
    @Qualifier("servicioEmpleado")
    private IEmpleadoService service;

    @GetMapping("/empleados")
    public List<Empleado> getEmpleados() {
        return service.listar();
    }

    @PostMapping("/empleado/registrar")
    public ResponseEntity<Empleado> crear(@RequestBody Empleado res) {
       
        service.save(res);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/empleado/registrar")
    public ResponseEntity<Empleado> actualizar(@RequestBody Empleado res) {
        if(res.getTareas().isEmpty()){
            res.setTareas(new ArrayList<>());
            service.save(res);
        }else{
            Optional<Empleado> empleado = service.listarId(res.getId());
            empleado.get().getTareas().add(res.getTareas().get(0));
            try {
                service.save(empleado.get());
            } catch (Exception e) {
                System.out.println("Error actualizando el empleado");
            }   
            res = empleado.get();
        }
    
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/empleado/eliminar/{id}")
    public List<Empleado> eliminar(@PathVariable Integer id, Model model) {
        Optional<Empleado> empleado = service.listarId(id);
        service.delete(empleado.get());
        return this.getEmpleados();
    }

}
