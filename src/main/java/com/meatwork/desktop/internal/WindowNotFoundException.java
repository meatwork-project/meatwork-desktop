package com.meatwork.desktop.internal;

public class WindowNotFoundException extends RuntimeException {
	public WindowNotFoundException(String message) {
		super(message);
	}

	public WindowNotFoundException(String message,
	                               Throwable cause) {
		super(
				message,
				cause
		);
	}

	public WindowNotFoundException(Throwable cause) {
		super(cause);
	}
}
