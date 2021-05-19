package com.reactbackend.exception;
@SuppressWarnings("serial")
public class NonUniquenameException extends Exception {
	
	public NonUniquenameException () {
		super("The requested username is taken.");
	}

}
