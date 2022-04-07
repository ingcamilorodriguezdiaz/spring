package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Empleado;
import com.example.demo.repo.IEmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * UsuarioServiceImpl
 */
@Service("servicioEmpleado")
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    @Qualifier("repo_empleado")
    private IEmpleadoRepo data;
    

   
    @Override
    public List<Empleado> listar() {
        List<Empleado> todos = new ArrayList<>();
        data.findAll().forEach(todos::add);
        return todos;
    }

    @Override
    public Optional<Empleado> listarId(int id) {

        return data.findById(id);
    }

    @Override
    public int save(Empleado usuario) {
        Empleado res = data.save(usuario);
        if (!res.equals(null)) {
            return 1;
        }
        return 0;
    }

    @Override
    public void delete(Empleado usuario) {
        data.delete(usuario);
    }  

}