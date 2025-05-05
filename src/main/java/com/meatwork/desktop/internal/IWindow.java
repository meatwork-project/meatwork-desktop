package com.meatwork.desktop.internal;

import com.meatwork.core.api.di.IService;
import com.meatwork.desktop.api.WindowMode;

@IService(scope = IService.Scope.MULTIPLE)
public interface IWindow {
	void init();
	void openWindow(Class<IWindow> window, WindowMode mode);
	void openWindow(Class<IWindow> window);
}
