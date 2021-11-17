package com.gratex.docs.exceptions;

public class IncompleteFormException extends GeneralException {

	private static final long serialVersionUID = 4212429227547393182L;

	public IncompleteFormException(String message, Object... messageArguments) {
		super(message, messageArguments);
	}	

}
