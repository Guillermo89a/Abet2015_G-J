package co.com.edu.usbcali.abet;
// Generated 1/09/2015 07:32:31 PM by Zathura powered by Hibernate Tools 3.2.4.GA



/**
 * Categoria generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Categoria  implements java.io.Serializable {


     private Long idCategoria;
     private Rubrica rubrica;
     private String nombrecategoria;

    public Categoria() {
    }

	
    public Categoria(Long idCategoria, String nombrecategoria) {
        this.idCategoria = idCategoria;
        this.nombrecategoria = nombrecategoria;
    }
    public Categoria(Long idCategoria, Rubrica rubrica, String nombrecategoria) {
       this.idCategoria = idCategoria;
       this.rubrica = rubrica;
       this.nombrecategoria = nombrecategoria;
    }
   
    public Long getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
    public Rubrica getRubrica() {
        return this.rubrica;
    }
    
    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }
    public String getNombrecategoria() {
        return this.nombrecategoria;
    }
    
    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }




}


