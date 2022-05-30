package com.trabajoArgentinaPrograma.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author piotr
 */
@Entity
@Table(name = "trabajos")
public class Trabajo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_trabajo;
    
    @Column(name = "nombre",length = 100)
    private String nombre;
    
    @Column(name = "puesto",length = 100)
    private String puesto;
    
    @ElementCollection  
    private List<String> tareas;
    
    @Column(name = "fechaInicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fechaFin")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;
    
    @Column(name = "ubicacion",length = 100)
    private String ubicacion;
    
    public Trabajo() {
    }

    public Trabajo(Long id_trabajo, String nombre, String puesto, List<String> tareas, Date fechaInicio, Date fechaFin, String ubicacion) {
        this.id_trabajo = id_trabajo;
        this.nombre = nombre;
        this.puesto = puesto;
        this.tareas = tareas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ubicacion = ubicacion;
    }
   
    public Long getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(Long id_trabajo) {
        this.id_trabajo = id_trabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<String> getTareas() {
        return tareas;
    }

    public void setTareas(List<String> tareas) {
        this.tareas = tareas;
    }
    
    public void addTareas(String tarea) {
        this.tareas.add(tarea);
    }
    public void removeTareas(String tarea) {
        this.tareas.remove(tarea);
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
