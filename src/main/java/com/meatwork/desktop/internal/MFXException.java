package com.meatwork.desktop.internal;

/*
 * Copyright (c) 2016 Taliro.
 * All rights reserved.
 */
public class MFXException extends Exception{

	public MFXException(String message) {
		super(message);
	}

	public MFXException(String message,
	                    Throwable cause) {
		super(
				message,
				cause
		);
	}
}
