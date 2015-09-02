package co.com.edu.usbcali.abet.control;

import co.com.edu.usbcali.abet.*;
import co.com.edu.usbcali.abet.dto.OutcomeDTO;
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
@Service("OutcomeLogic")
public class OutcomeLogic implements IOutcomeLogic {
    /**
     * DAO injected by Spring that manages Outcome entities
     *
     */
    @Autowired
    private IOutcomeDAO outcomeDAO;

    /**
    * DAO injected by Spring that manages Evaluacion entities
    *
    */
    @Autowired
    private IEvaluacionDAO evaluacionDAO;

    /**
    * DAO injected by Spring that manages OutcomePorCurso entities
    *
    */
    @Autowired
    private IOutcomePorCursoDAO outcomePorCursoDAO;

    /**
    * DAO injected by Spring that manages OutcomePorPrograma entities
    *
    */
    @Autowired
    private IOutcomePorProgramaDAO outcomePorProgramaDAO;

    @Transactional(readOnly = true)
    public List<Outcome> getOutcome() throws Exception {
        List<Outcome> list = new ArrayList<Outcome>();

        try {
            list = outcomeDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Outcome");
        } finally {
        }

        return list;
    }

//    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
//    public void saveOutcome(String detalle, Long idOutcome)
//        throws Exception {
//        Outcome entity = null;
//
//        try {
//            if (detalle == null) {
//                throw new ZMessManager().new EmptyFieldException("detalle");
//            }
//
//            if ((detalle != null) &&
//                    (Utilities.checkWordAndCheckWithlength(detalle, 100) == false)) {
//                throw new ZMessManager().new NotValidFormatException("detalle");
//            }
//
//            if (idOutcome == null) {
//                throw new ZMessManager().new EmptyFieldException("idOutcome");
//            }
//
//            if ((idOutcome != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        idOutcome, 22, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "idOutcome");
//            }
//
//            entity = getOutcome(idOutcome);
//
//            if (entity != null) {
//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//            }
//
//            entity = new Outcome();
//            entity.setDetalle(detalle);
//            entity.setIdOutcome(idOutcome);
//            outcomeDAO.save(entity);
//        } catch (Exception e) {
//            throw e;
//        } finally {
//        }
//    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveOutcome(String detalle)
        throws Exception {
        Outcome entity = null;

        try {
            if (detalle == null) {
                throw new ZMessManager().new EmptyFieldException("detalle");
            }

            if ((detalle != null) &&
                    (Utilities.checkWordAndCheckWithlength(detalle, 100) == false)) {
                throw new ZMessManager().new NotValidFormatException("detalle");
            }

         

            if (entity != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            entity = new Outcome();
            entity.setDetalle(detalle);
  
            outcomeDAO.save(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteOutcome(Long idOutcome) throws Exception {
        Outcome entity = null;

        if (idOutcome == null) {
            throw new ZMessManager().new EmptyFieldException("idOutcome");
        }

        List<Evaluacion> evaluacions = null;
        List<OutcomePorCurso> outcomePorCursos = null;
        List<OutcomePorPrograma> outcomePorProgramas = null;
        entity = getOutcome(idOutcome);

        if (entity == null) {
            throw new ZMessManager().new EmptyFieldException("Outcome");
        }

        try {
            evaluacions = evaluacionDAO.findByProperty("outcome.idOutcome",
                    idOutcome);

            if (Utilities.validationsList(evaluacions) == true) {
                throw new ZMessManager().new DeletingException("evaluacions");
            }

            outcomePorCursos = outcomePorCursoDAO.findByProperty("outcome.idOutcome",
                    idOutcome);

            if (Utilities.validationsList(outcomePorCursos) == true) {
                throw new ZMessManager().new DeletingException(
                    "outcomePorCursos");
            }

            outcomePorProgramas = outcomePorProgramaDAO.findByProperty("outcome.idOutcome",
                    idOutcome);

            if (Utilities.validationsList(outcomePorProgramas) == true) {
                throw new ZMessManager().new DeletingException(
                    "outcomePorProgramas");
            }

            outcomeDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateOutcome(String detalle, Long idOutcome)
        throws Exception {
        Outcome entity = null;

        try {
            if (detalle == null) {
                throw new ZMessManager().new EmptyFieldException("detalle");
            }

            if ((detalle != null) &&
                    (Utilities.checkWordAndCheckWithlength(detalle, 100) == false)) {
                throw new ZMessManager().new NotValidFormatException("detalle");
            }

            if (idOutcome == null) {
                throw new ZMessManager().new EmptyFieldException("idOutcome");
            }

            if ((idOutcome != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idOutcome, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idOutcome");
            }

            entity = getOutcome(idOutcome);

            if (entity == null) {
                throw new ZMessManager(ZMessManager.ENTITY_NOENTITYTOUPDATE);
            }

            entity.setDetalle(detalle);
            entity.setIdOutcome(idOutcome);
            outcomeDAO.update(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<OutcomeDTO> getDataOutcome() throws Exception {
        try {
            List<Outcome> outcome = outcomeDAO.findAll();

            List<OutcomeDTO> outcomeDTO = new ArrayList<OutcomeDTO>();

            for (Outcome outcomeTmp : outcome) {
                OutcomeDTO outcomeDTO2 = new OutcomeDTO();

                outcomeDTO2.setIdOutcome(outcomeTmp.getIdOutcome());
                outcomeDTO2.setDetalle((outcomeTmp.getDetalle() != null)
                    ? outcomeTmp.getDetalle() : null);
                outcomeDTO.add(outcomeDTO2);
            }

            return outcomeDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Outcome getOutcome(Long idOutcome) throws Exception {
        Outcome entity = null;

        try {
            entity = outcomeDAO.findById(idOutcome);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Outcome");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Outcome> findPageOutcome(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Outcome> entity = null;

        try {
            entity = outcomeDAO.findPageOutcome(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Outcome Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberOutcome() throws Exception {
        Long entity = null;

        try {
            entity = outcomeDAO.findTotalNumberOutcome();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Outcome Count");
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
    public List<Outcome> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Outcome> list = new ArrayList<Outcome>();
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
            list = outcomeDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
