
package com.example.demo.repo;
import java.util.List;

import com.example.demo.model.Tarea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("repo_tarea")
public interface ITareaRepo extends JpaRepository<Tarea,Integer> {

    @Query(value="SELECT tareas.id,tareas.nombre,emp_tareas.empleado_id FROM tareas inner join emp_tareas on tareas.id=emp_tareas.tarea_id", nativeQuery = true) 
    public List<Tarea>todos();
}   
