package com.gratex.docs.exceptions;

public class UnexpectedDataCount extends GeneralException {

	private static final long serialVersionUID = -3638444897035311524L;

	public UnexpectedDataCount(String message, Object... arguments) {
		super(message, arguments);
	}

}
