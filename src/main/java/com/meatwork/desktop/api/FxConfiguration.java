package com.meatwork.desktop.api;

import com.meatwork.core.api.di.IService;

import java.io.InputStream;
import java.net.URL;

/*
 * Copyright (c) 2016 Taliro.
 * All rights reserved.
 */
@IService
public interface FxConfiguration {
	String value();
	URL styleSheetResource();
	InputStream getIconApp();
}
