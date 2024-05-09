package com.meatwork.desktop.internal;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.meatwork.core.api.di.CDI;
import com.meatwork.desktop.api.ComplementTools;
import com.meatwork.desktop.api.FxConfiguration;
import com.meatwork.desktop.api.FxResources;
import com.meatwork.desktop.api.MView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Set;

import static com.gluonhq.charm.glisten.application.AppManager.HOME_VIEW;

/*
 * Copyright (c) 2016 Taliro.
 * All rights reserved.
 */
public class FxAppRunner extends Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(FxResources.class);
	private final AppManager appManager = AppManager.initialize(this::postInit);
	private final FxAppInjector fxAppInjector;

	public FxAppRunner() {
		fxAppInjector = CDI.get(FxAppInjector.class);
	}

	@Override
	public void init() throws Exception {
		boolean homeViewFinded = false;
		for (MView view : fxAppInjector.getViews()) {
			FxResources fxResources = view
					.getClass()
					.getAnnotation(FxResources.class);
			if (fxResources == null) {
				throw new MFXException("%s must be annotated with @FxResources".formatted(view.getClass().getName()));
			}

			FXMLLoader fxmlLoader = new FXMLLoader(view.getFxmlView());

			if (fxResources
					.value()
					.equals(HOME_VIEW)) {
				homeViewFinded = true;
			}

			appManager.addViewFactory(fxResources.value(), () -> {
				try {
					return fxmlLoader.load();
				} catch (IOException e) {
					LOGGER.error("Failed to load FXML view", e);
					throw new RuntimeException(e);
				}
			});
		}

		if(!homeViewFinded) {
			throw new MFXException("No home view found. Make sure there is a 'com.gluonhq.charm.glisten.application.AppManager.HOME_VIEW' in one of views.");
		}

		Set<ComplementTools> complementTools = fxAppInjector.getComplementTools();
		if(complementTools != null && !complementTools.isEmpty()) {
			complementTools.forEach(it -> it.execute(appManager));
		}
	}

	public static void run(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		appManager.start(stage);
	}

	private void postInit(Scene scene) {
		Swatch.BLUE.assignTo(scene);
		FxConfiguration fxConfiguration = fxAppInjector.getFxConfiguration();
		scene.getStylesheets().add(fxConfiguration.styleSheetResource().toExternalForm());
		if (fxConfiguration.getIconApp() != null) {
			((Stage) scene.getWindow()).getIcons().add(new Image(fxConfiguration.getIconApp()));
		}
	}
}
