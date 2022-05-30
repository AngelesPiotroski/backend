package com.trabajoArgentinaPrograma.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author piotr
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_persona;

    @Column(name = "nombre", length = 60)
    private String nombre;

    @Column(name = "apellido", length = 70)
    private String apellido;
    
    @Column(name = "email", length = 60)
    private String email;
    
     @Column(name = "fotoPortada", length = 600)
    private String fotoPortada;
    
    @Column(name = "telefono", length = 60)
    private Long telefono;
    
    @Column(name = "lugarNacimiento", length = 100)
    private String lugarNacimiento;

    @Column(name = "dni", length = 60, unique = true)
    private Long dni;

    @Column(name = "domicilio", length = 100)
    private String domicilio;

    @Column(name = "fechaNacimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "fotoPerfil")
    private String fotoPerfil;

    @Column(name = "aboutMe", length= 600)
    private String aboutMe;
    
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private List<Educacion> educaciones;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private List<Contacto> contactos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private List<Trabajo> trabajos;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private List<Tecnologia> tecnologias;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private List<Proyecto> proyectos;

    public Persona() {
    }

    public Persona(Long id_persona, String nombre, String apellido, String email, String fotoPortada, Long telefono, String lugarNacimiento, Long dni, String domicilio, Date fechaNacimiento, String fotoPerfil, String aboutMe, Usuario usuario, List<Educacion> educaciones, List<Contacto> contactos, List<Trabajo> trabajos, List<Tecnologia> tecnologias, List<Proyecto> proyectos) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fotoPortada = fotoPortada;
        this.telefono = telefono;
        this.lugarNacimiento = lugarNacimiento;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.fotoPerfil = fotoPerfil;
        this.aboutMe = aboutMe;
        this.usuario = usuario;
        this.educaciones = educaciones;
        this.contactos = contactos;
        this.trabajos = trabajos;
        this.tecnologias = tecnologias;
        this.proyectos = proyectos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public List<Educacion> getEducaciones() {
        return educaciones;
    }

    public void setEducaciones(List<Educacion> educaciones) {
        this.educaciones = educaciones;
    }

    public List<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(List<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public String getFotoPortada() {
        return fotoPortada;
    }

    public void setFotoPortada(String fotoPortada) {
        this.fotoPortada = fotoPortada;
    }

}
