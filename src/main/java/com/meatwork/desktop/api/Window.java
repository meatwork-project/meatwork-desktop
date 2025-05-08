package com.meatwork.desktop.api;

import com.meatwork.desktop.internal.WindowManagerImpl;

import javax.swing.*;
import java.awt.*;

public abstract class Window extends JFrame implements IWindow {

	protected final WindowManager windowManager;

	public Window(WindowManager windowManager) {
		this.windowManager = windowManager;
	}

	public void initialize() {
		WindowProperties window = ((WindowManagerImpl)windowManager).getWindow(this.getClass());
		WSize wSize = window.wSize();
		setTitle(window.title());
		setSize(wSize.width(), wSize.height());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
		this.init();
		SwingUtilities.updateComponentTreeUI(this);
	}

	@Override
	public void openWindow(Class<IWindow> window) {
		this.openWindow(window, WindowMode.CURRENT);
	}

	@Override
	public void openWindow(Class<IWindow> window,
	                       WindowMode mode) {
		if (mode == WindowMode.CURRENT) {
			this.dispose();
		}
		windowManager.openWindow(window, this);
	}
}
