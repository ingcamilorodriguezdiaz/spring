package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Empleado;



public interface IEmpleadoService {

    public List<Empleado> listar();
    public Optional<Empleado> listarId(int id);
    public int save(Empleado empleado);
    public void delete(Empleado empleado);
       
}
