
package com.example.demo.repo;
import com.example.demo.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("repo_empleado")
public interface IEmpleadoRepo extends CrudRepository<Empleado,Integer> {
    // @Query(value="SELECT * FROM usuarios  WHERE nombre  like %?1%", nativeQuery = true) 
    // public Page<Empleado>getUserName(String nombre,Pageable page);

    // @Query(value="SELECT * FROM usuarios  WHERE id >= ?1", nativeQuery = true) 
    // public Page<Empleado>buscarPorId(int id,Pageable page);
}   
