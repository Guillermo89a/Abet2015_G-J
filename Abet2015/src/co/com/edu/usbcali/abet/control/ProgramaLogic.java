package co.com.edu.usbcali.abet.control;

import co.com.edu.usbcali.abet.*;
import co.com.edu.usbcali.abet.dto.ProgramaDTO;
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
@Service("ProgramaLogic")
public class ProgramaLogic implements IProgramaLogic {
    /**
     * DAO injected by Spring that manages Programa entities
     *
     */
    @Autowired
    private IProgramaDAO programaDAO;

    /**
    * DAO injected by Spring that manages OutcomePorPrograma entities
    *
    */
    @Autowired
    private IOutcomePorProgramaDAO outcomePorProgramaDAO;

    /**
    * DAO injected by Spring that manages Pensum entities
    *
    */
    @Autowired
    private IPensumDAO pensumDAO;

    @Transactional(readOnly = true)
    public List<Programa> getPrograma() throws Exception {
        List<Programa> list = new ArrayList<Programa>();

        try {
            list = programaDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Programa");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void savePrograma(String descripcion)
        throws Exception {
        Programa entity = null;

        try {
            if ((descripcion != null) &&
                    (Utilities.checkWordAndCheckWithlength(descripcion, 200) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if (entity != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            entity = new Programa();
            entity.setDescripcion(descripcion);
      
            programaDAO.save(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    
    
//    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
//    public void savePrograma(String descripcion, Long idPrograma)
//        throws Exception {
//        Programa entity = null;
//
//        try {
//            if ((descripcion != null) &&
//                    (Utilities.checkWordAndCheckWithlength(descripcion, 200) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "descripcion");
//            }
//
//            if (idPrograma == null) {
//                throw new ZMessManager().new EmptyFieldException("idPrograma");
//            }
//
//            if ((idPrograma != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        idPrograma, 22, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "idPrograma");
//            }
//
//            entity = getPrograma(idPrograma);
//
//            if (entity != null) {
//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//            }
//
//            entity = new Programa();
//            entity.setDescripcion(descripcion);
//            entity.setIdPrograma(idPrograma);
//            programaDAO.save(entity);
//        } catch (Exception e) {
//            throw e;
//        } finally {
//        }
//    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deletePrograma(Long idPrograma) throws Exception {
        Programa entity = null;

        if (idPrograma == null) {
            throw new ZMessManager().new EmptyFieldException("idPrograma");
        }

        List<OutcomePorPrograma> outcomePorProgramas = null;
        List<Pensum> pensums = null;
        entity = getPrograma(idPrograma);

        if (entity == null) {
            throw new ZMessManager().new EmptyFieldException("Programa");
        }

        try {
            outcomePorProgramas = outcomePorProgramaDAO.findByProperty("programa.idPrograma",
                    idPrograma);

            if (Utilities.validationsList(outcomePorProgramas) == true) {
                throw new ZMessManager().new DeletingException(
                    "outcomePorProgramas");
            }

            pensums = pensumDAO.findByProperty("programa.idPrograma", idPrograma);

            if (Utilities.validationsList(pensums) == true) {
                throw new ZMessManager().new DeletingException("pensums");
            }

            programaDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updatePrograma(String descripcion, Long idPrograma)
        throws Exception {
        Programa entity = null;

        try {
            if ((descripcion != null) &&
                    (Utilities.checkWordAndCheckWithlength(descripcion, 200) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if (idPrograma == null) {
                throw new ZMessManager().new EmptyFieldException("idPrograma");
            }

            if ((idPrograma != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idPrograma, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idPrograma");
            }

            entity = getPrograma(idPrograma);

            if (entity == null) {
                throw new ZMessManager(ZMessManager.ENTITY_NOENTITYTOUPDATE);
            }

            entity.setDescripcion(descripcion);
            entity.setIdPrograma(idPrograma);
            programaDAO.update(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<ProgramaDTO> getDataPrograma() throws Exception {
        try {
            List<Programa> programa = programaDAO.findAll();

            List<ProgramaDTO> programaDTO = new ArrayList<ProgramaDTO>();

            for (Programa programaTmp : programa) {
                ProgramaDTO programaDTO2 = new ProgramaDTO();

                programaDTO2.setIdPrograma(programaTmp.getIdPrograma());
                programaDTO2.setDescripcion((programaTmp.getDescripcion() != null)
                    ? programaTmp.getDescripcion() : null);
                programaDTO.add(programaDTO2);
            }

            return programaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Programa getPrograma(Long idPrograma) throws Exception {
        Programa entity = null;

        try {
            entity = programaDAO.findById(idPrograma);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Programa");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Programa> findPagePrograma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Programa> entity = null;

        try {
            entity = programaDAO.findPagePrograma(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Programa Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberPrograma() throws Exception {
        Long entity = null;

        try {
            entity = programaDAO.findTotalNumberPrograma();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Programa Count");
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
    public List<Programa> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Programa> list = new ArrayList<Programa>();
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
            list = programaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
