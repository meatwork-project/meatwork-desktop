/*
 * Copyright (c) 2016 Taliro.
 * All rights reserved.
 */
module com.meatwork.desktop {

	requires com.meatwork.core;
	requires org.slf4j;
	requires jakarta.inject;
	requires javafx.graphics;
	requires com.gluonhq.charm.glisten;
	requires javafx.fxml;

	exports com.meatwork.desktop.api;
	exports com.meatwork.desktop.internal to com.meatwork.core, javafx.graphics;

}