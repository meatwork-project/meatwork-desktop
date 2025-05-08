package com.meatwork.desktop.internal;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.meatwork.core.api.di.Service;
import com.meatwork.core.api.service.ApplicationStartup;
import com.meatwork.desktop.api.IWindow;
import com.meatwork.desktop.api.ThemeConfiguration;
import com.meatwork.desktop.api.WindowManager;
import jakarta.inject.Inject;

import javax.swing.*;
import java.util.Optional;
import java.util.Set;

@Service
public class SwingOnStartup implements ApplicationStartup {

	private final WindowManager windowManager;
	private final Set<IWindow> windowSet;
	private final ThemeConfiguration themeConfiguration;

	@Inject
	public SwingOnStartup(WindowManager windowManager,
	                      Set<IWindow> windowSet,
	                      ThemeConfiguration themeConfiguration) {
		this.themeConfiguration = themeConfiguration;
		this.windowManager = windowManager;
		this.windowSet = windowSet;
	}

	@Override
	public int priority() {
		return 9999;
	}

	@Override
	public void run(Class<?> applicationCls, String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(Optional
				                         .ofNullable(themeConfiguration)
				                         .map(ThemeConfiguration::getLookAndFeel)
				                         .orElse(new FlatIntelliJLaf()));
		try {
			SwingUtilities.invokeLater(() -> ((WindowManagerImpl) windowManager).init(windowSet));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
