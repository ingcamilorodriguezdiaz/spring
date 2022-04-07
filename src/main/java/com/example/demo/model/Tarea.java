package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="tareas")
public class Tarea{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="nombre",nullable = false)
    private String nombre;    
    @Column(name="estado",nullable = false)
    private int estado;    

    @ManyToMany(mappedBy = "tareas",cascade = CascadeType.REMOVE)
    private List<Empleado> empleado;

    public Tarea() {

    }   

    public Tarea(String nombre, int estado, List<Empleado> empleado) {
        this.nombre = nombre;
        this.estado = estado;
        this.empleado = empleado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  

    public List <Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleado = empleado;
    }
}
