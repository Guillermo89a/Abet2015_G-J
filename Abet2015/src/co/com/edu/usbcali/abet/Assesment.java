package co.com.edu.usbcali.abet;
// Generated 1/09/2015 07:32:31 PM by Zathura powered by Hibernate Tools 3.2.4.GA



/**
 * Assesment generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Assesment  implements java.io.Serializable {


     private Long idCodigoAssesment;
     private ListaSepia listaSepia;
     private RubricaPorCurso rubricaPorCurso;
     private Long calificacion;

    public Assesment() {
    }

	
    public Assesment(Long idCodigoAssesment, Long calificacion) {
        this.idCodigoAssesment = idCodigoAssesment;
        this.calificacion = calificacion;
    }
    public Assesment(Long idCodigoAssesment, ListaSepia listaSepia, RubricaPorCurso rubricaPorCurso, Long calificacion) {
       this.idCodigoAssesment = idCodigoAssesment;
       this.listaSepia = listaSepia;
       this.rubricaPorCurso = rubricaPorCurso;
       this.calificacion = calificacion;
    }
   
    public Long getIdCodigoAssesment() {
        return this.idCodigoAssesment;
    }
    
    public void setIdCodigoAssesment(Long idCodigoAssesment) {
        this.idCodigoAssesment = idCodigoAssesment;
    }
    public ListaSepia getListaSepia() {
        return this.listaSepia;
    }
    
    public void setListaSepia(ListaSepia listaSepia) {
        this.listaSepia = listaSepia;
    }
    public RubricaPorCurso getRubricaPorCurso() {
        return this.rubricaPorCurso;
    }
    
    public void setRubricaPorCurso(RubricaPorCurso rubricaPorCurso) {
        this.rubricaPorCurso = rubricaPorCurso;
    }
    public Long getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }




}

