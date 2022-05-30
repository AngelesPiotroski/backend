package com.trabajoArgentinaPrograma.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "educacion")
public class Educacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_educacion;

    @Column(name = "instituto", length = 100)
    private String instituto;

    @Column(name = "ubicacion", length = 100)
    private String ubicacion;

    @Column(name = "titulo", length = 100)
    private String titulo;

    @Column(name = "descripcion", length = 600)
    private String descripcion;

    @Column(name = "fechaInicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fechaFin")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    public Educacion() {
    }

    public Educacion(Long id_educacion, String instituto, String ubicacion, String titulo, String descripcion, Date fechaInicio, Date fechaFin) {
        this.id_educacion = id_educacion;
        this.instituto = instituto;
        this.ubicacion = ubicacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
       
    }

    public Long getId_educacion() {
        return id_educacion;
    }

    public void setId_educacion(Long id_educacion) {
        this.id_educacion = id_educacion;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
