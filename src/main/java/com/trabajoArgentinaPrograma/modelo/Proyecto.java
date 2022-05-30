package com.trabajoArgentinaPrograma.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author piotr
 */
@Entity
@Table(name = "proyectos")
public class Proyecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proyecto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "url")
    private String url;
    
    @Column(name = "urlImagen")
    private String urlImagen;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaRealizacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRealizacion;
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "proye_tecno",
            joinColumns = {
                @JoinColumn(name = "id_proyecto")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_tecnologia")})
    private List<Tecnologia> tecnologias;

    public Proyecto() {
    }

    public Proyecto(Long id_proyecto, String nombre, String url, String urlImagen, String descripcion, Date fechaRealizacion, List<Tecnologia> tecnologias) {
        this.id_proyecto = id_proyecto;
        this.nombre = nombre;
        this.url = url;
        this.urlImagen = urlImagen;
        this.descripcion = descripcion;
        this.fechaRealizacion = fechaRealizacion;
        this.tecnologias = tecnologias;
    }

    public Long getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Long id_proyecto) {
        this.id_proyecto = id_proyecto;
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

    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // getters and setters
    public void addtecnologia(Tecnologia tecno) {
        this.tecnologias.add(tecno);
        
    }

    public void removeTecnologia(long id_tecnologia) {
        Tecnologia tecno = this.tecnologias.stream().filter(t -> t.getId_tecnologia() == id_tecnologia).findFirst().orElse(null);
        if (tecno != null) {
            this.tecnologias.remove(tecno);
        }
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }
    
}
