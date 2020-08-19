package com.test.testspring.web.rest.errors;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class TestException extends AbstractThrowableProblem{

	 private static final long serialVersionUID = 1L;
	    private final String entityName;
	    private final String errorKey;
	    
	    /**
	     * Constructor de la clase que recibe una excepción.
	     *
	     * @param excepcion, con la excepción generada.
	     */
	    public TestException(Exception excepcion) {
	        this(ErrorConstants.DEFAULT_TYPE, excepcion.getMessage(), "", "");
	    }
	    /**
	     *
	     * Método constructor de la clase.
	     *
	     * @param defaultMessage
	     * @param entityName
	     * @param errorKey
	     */
	    public TestException(String defaultMessage, String entityName, String errorKey) {
	        this(ErrorConstants.DEFAULT_TYPE, defaultMessage, entityName, errorKey);
	    }
	    /**
	     *
	     * Método constructor de la clase.
	     *
	     * @param type
	     * @param defaultMessage
	     * @param entityName
	     * @param errorKey
	     */
	    public TestException(URI type, String defaultMessage, String entityName, String errorKey) {
	        super(type, defaultMessage, Status.BAD_REQUEST, null, null, null, getAlertParameters(entityName, errorKey));
	        this.entityName = entityName;
	        this.errorKey = errorKey;
	    }
	    public String getEntityName() {
	        return entityName;
	    }
	    public String getErrorKey() {
	        return errorKey;
	    }
	    /**
	     *
	     * Método que se encarga de formar el map con los parámetros con la alerta.
	     *
	     * @author SW-CONSULTING - Jhispter
	     *
	     * @date 13/11/2018
	     *
	     * @param entityName Nombre de la entidad donde se genera el error.
	     * @param errorKey   Key del error generado.
	     * @return Map<String,Object>
	     */
	    private static Map<String, Object> getAlertParameters(String entityName, String errorKey) {
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("message",  errorKey);
	        parameters.put("params", entityName);
	        return parameters;
	    }	
}
