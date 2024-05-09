package com.meatwork.desktop.api;

import com.gluonhq.charm.glisten.application.AppManager;
import com.meatwork.core.api.di.IService;

/*
 * Copyright (c) 2016 Taliro.
 * All rights reserved.
 */
@IService(scope = IService.Scope.MULTIPLE, mandatory = false)
public interface ComplementTools {
	void execute(AppManager appManager);
}
