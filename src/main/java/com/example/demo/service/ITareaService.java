package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.model.Tarea;



public interface ITareaService {

    public List<Tarea> listar();
    public Optional<Tarea> listarId(Integer id);
    public int save(Tarea tarea);
    public void delete(Tarea tarea);
       
}
