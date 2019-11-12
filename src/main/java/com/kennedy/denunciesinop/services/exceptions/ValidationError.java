package com.kennedy.denunciesinop.services.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.kennedy.denunciesinop.resourses.exceptions.FieldMessage;
import com.kennedy.denunciesinop.resourses.exceptions.StandardError;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {

		errors.add(new FieldMessage(fieldName, message));
	}
}