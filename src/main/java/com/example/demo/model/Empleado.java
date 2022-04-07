package com.example.demo.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "cedula")
    private String cedula;
    @ManyToMany
    @JsonIgnoreProperties("empleado")
    @JoinTable(name = "emp_tareas", joinColumns = {
            @JoinColumn(name = "empleado_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "tarea_id", referencedColumnName = "id",unique=true) })
    private List<Tarea> tareas;

    public Empleado() {

    }

  

    public Empleado(String nombre, String cedula, List<Tarea> tareas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tareas = tareas;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List <Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List <Tarea> tarea) {
        this.tareas = tarea;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nombre, this.cedula, this.tareas);
    }
}
