package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Tarea;
import com.example.demo.repo.ITareaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * UsuarioServiceImpl
 */
@Service("servicioTarea")
public class TareaServiceImpl implements ITareaService {

    @Autowired
    @Qualifier("repo_tarea")
    private ITareaRepo data;
    

   
    @Override
    public List<Tarea> listar() {
        return (List<Tarea>) data.findAll();
    }

    @Override
    public Optional<Tarea> listarId(Integer id) {

        return data.findById(id);
    }

    @Override
    public int save(Tarea usuario) {
        Tarea res = data.save(usuario);
        if (!res.equals(null)) {
            return 1;
        }
        return 0;
    }

    @Override
    public void delete(Tarea usuario) {
        data.delete(usuario);
    }  

}