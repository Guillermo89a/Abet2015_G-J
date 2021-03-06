package co.com.edu.usbcali.abet.control;

import co.com.edu.usbcali.abet.*;
import co.com.edu.usbcali.abet.dto.CursoDTO;
import co.com.edu.usbcali.dataaccess.dao.*;
import co.com.edu.usbcali.exceptions.*;
import co.com.edu.usbcali.utilities.Utilities;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
@Scope("singleton")
@Service("CursoLogic")
public class CursoLogic implements ICursoLogic {
    /**
     * DAO injected by Spring that manages Curso entities
     *
     */
    @Autowired
    private ICursoDAO cursoDAO;

    /**
    * DAO injected by Spring that manages Evaluacion entities
    *
    */
    @Autowired
    private IEvaluacionDAO evaluacionDAO;

    /**
    * DAO injected by Spring that manages ListaSepia entities
    *
    */
    @Autowired
    private IListaSepiaDAO listaSepiaDAO;

    /**
    * DAO injected by Spring that manages OutcomePorCurso entities
    *
    */
    @Autowired
    private IOutcomePorCursoDAO outcomePorCursoDAO;

    /**
    * DAO injected by Spring that manages RubricaPorCurso entities
    *
    */
    @Autowired
    private IRubricaPorCursoDAO rubricaPorCursoDAO;

    /**
    * Logic injected by Spring that manages Docente entities
    *
    */
    @Autowired
    IDocenteLogic logicDocente1;

    /**
    * Logic injected by Spring that manages Materia entities
    *
    */
    @Autowired
    IMateriaLogic logicMateria2;

    /**
    * Logic injected by Spring that manages PeriodoAcademico entities
    *
    */
    @Autowired
    IPeriodoAcademicoLogic logicPeriodoAcademico3;

    @Transactional(readOnly = true)
    public List<Curso> getCurso() throws Exception {
        List<Curso> list = new ArrayList<Curso>();

        try {
            list = cursoDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Curso");
        } finally {
        }

        return list;
    }

//    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
//    public void saveCurso(Long idCurso, String nombreCurso,
//        Long idCodigoDocente_Docente, Long idCodigoMateria_Materia,
//        Long idPeriodoAcademico_PeriodoAcademico) throws Exception {
//        Curso entity = null;
//
//        try {
//            if (idCurso == null) {
//                throw new ZMessManager().new EmptyFieldException("idCurso");
//            }
//
//            if ((idCurso != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        idCurso, 22, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException("idCurso");
//            }
//
//            if ((nombreCurso != null) &&
//                    (Utilities.checkWordAndCheckWithlength(nombreCurso, 100) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "nombreCurso");
//            }
//
//            if (idCodigoDocente_Docente == null) {
//                throw new ZMessManager().new EmptyFieldException(
//                    "idCodigoDocente_Docente");
//            }
//
//            if ((idCodigoDocente_Docente != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        idCodigoDocente_Docente, 22, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "idCodigoDocente_Docente");
//            }
//
//            if (idCodigoMateria_Materia == null) {
//                throw new ZMessManager().new EmptyFieldException(
//                    "idCodigoMateria_Materia");
//            }
//
//            if ((idCodigoMateria_Materia != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        idCodigoMateria_Materia, 22, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "idCodigoMateria_Materia");
//            }
//
//            if (idPeriodoAcademico_PeriodoAcademico == null) {
//                throw new ZMessManager().new EmptyFieldException(
//                    "idPeriodoAcademico_PeriodoAcademico");
//            }
//
//            if ((idPeriodoAcademico_PeriodoAcademico != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        idPeriodoAcademico_PeriodoAcademico, 22, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "idPeriodoAcademico_PeriodoAcademico");
//            }
//
//            Docente docenteClass = logicDocente1.getDocente(idCodigoDocente_Docente);
//            Materia materiaClass = logicMateria2.getMateria(idCodigoMateria_Materia);
//            PeriodoAcademico periodoAcademicoClass = logicPeriodoAcademico3.getPeriodoAcademico(idPeriodoAcademico_PeriodoAcademico);
//
//            if (docenteClass == null) {
//                throw new ZMessManager().new ForeignException("docente");
//            }
//
//            if (materiaClass == null) {
//                throw new ZMessManager().new ForeignException("materia");
//            }
//
//            if (periodoAcademicoClass == null) {
//                throw new ZMessManager().new ForeignException(
//                    "periodoAcademico");
//            }
//
//            entity = getCurso(idCurso);
//
//            if (entity != null) {
//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//            }
//
//            entity = new Curso();
//            entity.setIdCurso(idCurso);
//            entity.setNombreCurso(nombreCurso);
//            entity.setDocente(docenteClass);
//            entity.setMateria(materiaClass);
//            entity.setPeriodoAcademico(periodoAcademicoClass);
//            cursoDAO.save(entity);
//        } catch (Exception e) {
//            throw e;
//        } finally {
//        }
//    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveCurso( String nombreCurso) throws Exception {
        Curso entity = null;

        try {
           

            if ((nombreCurso != null) &&
                    (Utilities.checkWordAndCheckWithlength(nombreCurso, 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nombreCurso");
            }

         



            if (entity != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            entity = new Curso();
            entity.setNombreCurso(nombreCurso);

            cursoDAO.save(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteCurso(Long idCurso) throws Exception {
        Curso entity = null;

        if (idCurso == null) {
            throw new ZMessManager().new EmptyFieldException("idCurso");
        }

        List<Evaluacion> evaluacions = null;
        List<ListaSepia> listaSepias = null;
        List<OutcomePorCurso> outcomePorCursos = null;
        List<RubricaPorCurso> rubricaPorCursos = null;
        entity = getCurso(idCurso);

        if (entity == null) {
            throw new ZMessManager().new EmptyFieldException("Curso");
        }

        try {
            evaluacions = evaluacionDAO.findByProperty("curso.idCurso", idCurso);

            if (Utilities.validationsList(evaluacions) == true) {
                throw new ZMessManager().new DeletingException("evaluacions");
            }

            listaSepias = listaSepiaDAO.findByProperty("curso.idCurso", idCurso);

            if (Utilities.validationsList(listaSepias) == true) {
                throw new ZMessManager().new DeletingException("listaSepias");
            }

            outcomePorCursos = outcomePorCursoDAO.findByProperty("curso.idCurso",
                    idCurso);

            if (Utilities.validationsList(outcomePorCursos) == true) {
                throw new ZMessManager().new DeletingException(
                    "outcomePorCursos");
            }

            rubricaPorCursos = rubricaPorCursoDAO.findByProperty("curso.idCurso",
                    idCurso);

            if (Utilities.validationsList(rubricaPorCursos) == true) {
                throw new ZMessManager().new DeletingException(
                    "rubricaPorCursos");
            }

            cursoDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateCurso(Long idCurso, String nombreCurso,
        Long idCodigoDocente_Docente, Long idCodigoMateria_Materia,
        Long idPeriodoAcademico_PeriodoAcademico) throws Exception {
        Curso entity = null;

        try {
            if (idCurso == null) {
                throw new ZMessManager().new EmptyFieldException("idCurso");
            }

            if ((idCurso != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idCurso, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("idCurso");
            }

            if ((nombreCurso != null) &&
                    (Utilities.checkWordAndCheckWithlength(nombreCurso, 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nombreCurso");
            }

            if (idCodigoDocente_Docente == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idCodigoDocente_Docente");
            }

            if ((idCodigoDocente_Docente != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idCodigoDocente_Docente, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idCodigoDocente_Docente");
            }

            if (idCodigoMateria_Materia == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idCodigoMateria_Materia");
            }

            if ((idCodigoMateria_Materia != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idCodigoMateria_Materia, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idCodigoMateria_Materia");
            }

            if (idPeriodoAcademico_PeriodoAcademico == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idPeriodoAcademico_PeriodoAcademico");
            }

            if ((idPeriodoAcademico_PeriodoAcademico != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idPeriodoAcademico_PeriodoAcademico, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idPeriodoAcademico_PeriodoAcademico");
            }

            Docente docenteClass = logicDocente1.getDocente(idCodigoDocente_Docente);
            Materia materiaClass = logicMateria2.getMateria(idCodigoMateria_Materia);
            PeriodoAcademico periodoAcademicoClass = logicPeriodoAcademico3.getPeriodoAcademico(idPeriodoAcademico_PeriodoAcademico);

            if (docenteClass == null) {
                throw new ZMessManager().new ForeignException("docente");
            }

            if (materiaClass == null) {
                throw new ZMessManager().new ForeignException("materia");
            }

            if (periodoAcademicoClass == null) {
                throw new ZMessManager().new ForeignException(
                    "periodoAcademico");
            }

            entity = getCurso(idCurso);

            if (entity == null) {
                throw new ZMessManager(ZMessManager.ENTITY_NOENTITYTOUPDATE);
            }

            entity.setIdCurso(idCurso);
            entity.setNombreCurso(nombreCurso);
            entity.setDocente(docenteClass);
            entity.setMateria(materiaClass);
            entity.setPeriodoAcademico(periodoAcademicoClass);
            cursoDAO.update(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<CursoDTO> getDataCurso() throws Exception {
        try {
            List<Curso> curso = cursoDAO.findAll();

            List<CursoDTO> cursoDTO = new ArrayList<CursoDTO>();

            for (Curso cursoTmp : curso) {
                CursoDTO cursoDTO2 = new CursoDTO();

                cursoDTO2.setIdCurso(cursoTmp.getIdCurso());
                cursoDTO2.setNombreCurso((cursoTmp.getNombreCurso() != null)
                    ? cursoTmp.getNombreCurso() : null);

                if (cursoTmp.getDocente() != null) {
                    cursoDTO2.setIdCodigoDocente_Docente(cursoTmp.getDocente()
                                                                 .getIdCodigoDocente());
                } else {
                    cursoDTO2.setIdCodigoDocente_Docente(null);
                }

                if (cursoTmp.getMateria() != null) {
                    cursoDTO2.setIdCodigoMateria_Materia(cursoTmp.getMateria()
                                                                 .getIdCodigoMateria());
                } else {
                    cursoDTO2.setIdCodigoMateria_Materia(null);
                }

                cursoDTO2.setIdPeriodoAcademico_PeriodoAcademico((cursoTmp.getPeriodoAcademico()
                                                                          .getIdPeriodoAcademico() != null)
                    ? cursoTmp.getPeriodoAcademico().getIdPeriodoAcademico()
                    : null);
                cursoDTO.add(cursoDTO2);
            }

            return cursoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Curso getCurso(Long idCurso) throws Exception {
        Curso entity = null;

        try {
            entity = cursoDAO.findById(idCurso);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Curso");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Curso> findPageCurso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Curso> entity = null;

        try {
            entity = cursoDAO.findPageCurso(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Curso Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberCurso() throws Exception {
        Long entity = null;

        try {
            entity = cursoDAO.findTotalNumberCurso();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Curso Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Curso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Curso> list = new ArrayList<Curso>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = cursoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
