package com.meatwork.desktop.api;

import com.meatwork.core.api.di.IService;

import java.net.URL;

/*
 * Copyright (c) 2016 Taliro.
 * All rights reserved.
 */
@IService(scope = IService.Scope.MULTIPLE)
public interface MView {

	default URL getFxmlView() {
		FxResources annotation = this
				.getClass()
				.getAnnotation(FxResources.class);
		return this.getClass().getResource(annotation.value() + ".fxml");
	}

}
