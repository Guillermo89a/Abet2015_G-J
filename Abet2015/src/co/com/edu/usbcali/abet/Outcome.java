package co.com.edu.usbcali.abet;
// Generated 1/09/2015 07:32:31 PM by Zathura powered by Hibernate Tools 3.2.4.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Outcome generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Outcome  implements java.io.Serializable {


     private Long idOutcome;
     private String detalle;
     private Set<OutcomePorPrograma> outcomePorProgramas = new HashSet<OutcomePorPrograma>(0);
     private Set<OutcomePorCurso> outcomePorCursos = new HashSet<OutcomePorCurso>(0);
     private Set<Evaluacion> evaluacions = new HashSet<Evaluacion>(0);

    public Outcome() {
    }

	
    public Outcome(Long idOutcome, String detalle) {
        this.idOutcome = idOutcome;
        this.detalle = detalle;
    }
    public Outcome(Long idOutcome, String detalle, Set<OutcomePorPrograma> outcomePorProgramas, Set<OutcomePorCurso> outcomePorCursos, Set<Evaluacion> evaluacions) {
       this.idOutcome = idOutcome;
       this.detalle = detalle;
       this.outcomePorProgramas = outcomePorProgramas;
       this.outcomePorCursos = outcomePorCursos;
       this.evaluacions = evaluacions;
    }
   
    public Long getIdOutcome() {
        return this.idOutcome;
    }
    
    public void setIdOutcome(Long idOutcome) {
        this.idOutcome = idOutcome;
    }
    public String getDetalle() {
        return this.detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public Set<OutcomePorPrograma> getOutcomePorProgramas() {
        return this.outcomePorProgramas;
    }
    
    public void setOutcomePorProgramas(Set<OutcomePorPrograma> outcomePorProgramas) {
        this.outcomePorProgramas = outcomePorProgramas;
    }
    public Set<OutcomePorCurso> getOutcomePorCursos() {
        return this.outcomePorCursos;
    }
    
    public void setOutcomePorCursos(Set<OutcomePorCurso> outcomePorCursos) {
        this.outcomePorCursos = outcomePorCursos;
    }
    public Set<Evaluacion> getEvaluacions() {
        return this.evaluacions;
    }
    
    public void setEvaluacions(Set<Evaluacion> evaluacions) {
        this.evaluacions = evaluacions;
    }




}

