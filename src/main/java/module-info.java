/*
 * Copyright (c) 2016 Taliro.
 * All rights reserved.
 */
module com.meatwork.desktop {

	requires com.meatwork.core;
	requires org.slf4j;
	requires jakarta.inject;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires com.gluonhq.charm.glisten;
	requires com.gluonhq.attach.lifecycle;
	requires com.gluonhq.attach.util;
	requires com.gluonhq.attach.display;
	requires com.gluonhq.attach.storage;

	exports com.meatwork.desktop.api;
	exports com.meatwork.desktop.internal to com.meatwork.core, javafx.graphics;

}