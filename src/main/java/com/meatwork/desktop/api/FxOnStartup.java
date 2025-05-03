package com.meatwork.desktop.api;

import com.meatwork.core.api.di.Service;
import com.meatwork.core.api.service.ApplicationStartup;
import com.meatwork.desktop.internal.FxAppRunner;

/*
 * Copyright (c) 2016 Taliro.
 * All rights reserved.
 */
@Service
public class FxOnStartup implements ApplicationStartup {

	@Override
	public int priority() {
		return 999;
	}

	@Override
	public void run(String[] args) {
		FxAppRunner.run(args);
	}


}
