package com.trabajoArgentinaPrograma.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author piotr
 */
@Entity
@Table(name = "tecnologias")
public class Tecnologia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tecnologia;

    @Column(name = "nombre", length = 60)
    private String nombre;

    @Column(name = "descripcion", length = 60)
    private String descripcion;
    
    @Column(name = "porcentaje", length = 60)
    private String porcentaje;

    public Tecnologia() {
    }

    public Tecnologia(Long id_tecnologia, String nombre, String descripcion) {
        this.id_tecnologia = id_tecnologia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId_tecnologia() {
        return id_tecnologia;
    }

    public void setId_tecnologia(Long id_tecnologia) {
        this.id_tecnologia = id_tecnologia;
    }

    
    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

}
