package com.meatwork.desktop.internal;

import com.meatwork.core.api.di.Service;
import com.meatwork.core.api.service.ApplicationStartup;

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
	public void run(String[] args) throws Exception {
		FxAppRunner.launch(args);
	}


}
