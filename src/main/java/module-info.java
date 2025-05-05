/*
 * Copyright (c) 2016 Taliro.
 * All rights reserved.
 */
module com.meatwork.desktop {

	requires com.meatwork.core;
	requires transitive java.desktop;
	requires com.formdev.flatlaf;
	exports com.meatwork.desktop.api;
	exports com.meatwork.desktop.internal to com.meatwork.core, com.meatwork.desktop.test;

}