package model.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public ValidationException(String msg) {
		super(msg);
	}
	
	private Map<String, String> erros = new HashMap<>();
	
	public Map<String, String> getErros(){
		return erros;
	}
	
	public void addErro(String fieldName, String erroMessage) {
		erros.put(fieldName, erroMessage);
	}

}
