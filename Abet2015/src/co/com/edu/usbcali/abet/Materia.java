package co.com.edu.usbcali.abet;
// Generated 1/09/2015 07:32:31 PM by Zathura powered by Hibernate Tools 3.2.4.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Materia generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Materia  implements java.io.Serializable {


     private Long idCodigoMateria;
     private String nombre;
     private String creditos;
     private Set<Curso> cursos = new HashSet<Curso>(0);
     private Set<Pensum> pensums = new HashSet<Pensum>(0);

    public Materia() {
    }

	
    public Materia(Long idCodigoMateria) {
        this.idCodigoMateria = idCodigoMateria;
    }
    public Materia(Long idCodigoMateria, String nombre, String creditos, Set<Curso> cursos, Set<Pensum> pensums) {
       this.idCodigoMateria = idCodigoMateria;
       this.nombre = nombre;
       this.creditos = creditos;
       this.cursos = cursos;
       this.pensums = pensums;
    }
   
    public Long getIdCodigoMateria() {
        return this.idCodigoMateria;
    }
    
    public void setIdCodigoMateria(Long idCodigoMateria) {
        this.idCodigoMateria = idCodigoMateria;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCreditos() {
        return this.creditos;
    }
    
    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }
    public Set<Curso> getCursos() {
        return this.cursos;
    }
    
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
    public Set<Pensum> getPensums() {
        return this.pensums;
    }
    
    public void setPensums(Set<Pensum> pensums) {
        this.pensums = pensums;
    }




}

