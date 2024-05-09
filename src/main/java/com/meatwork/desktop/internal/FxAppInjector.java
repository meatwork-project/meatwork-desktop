package com.meatwork.desktop.internal;

import com.gluonhq.charm.glisten.application.AppManager;
import com.meatwork.core.api.di.Service;
import com.meatwork.desktop.api.ComplementTools;
import com.meatwork.desktop.api.FxConfiguration;
import com.meatwork.desktop.api.MView;
import jakarta.inject.Inject;

import java.util.Set;

/*
 * Copyright (c) 2016 Taliro.
 * All rights reserved.
 */
@Service
public class FxAppInjector {

	private final Set<MView> views;
	private final FxConfiguration fxConfiguration;
	private final Set<ComplementTools> complementTools;

	@Inject
	public FxAppInjector(Set<MView> views,
	                     FxConfiguration fxConfiguration,
	                     Set<ComplementTools> complementTools) {
		this.views = views;
		this.fxConfiguration = fxConfiguration;
		this.complementTools = complementTools;
	}

	public Set<MView> getViews() {
		return views;
	}

	public FxConfiguration getFxConfiguration() {
		return fxConfiguration;
	}

	public Set<ComplementTools> getComplementTools() {
		return complementTools;
	}
}
