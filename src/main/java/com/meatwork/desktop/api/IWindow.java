package com.meatwork.desktop.api;

import com.meatwork.core.api.di.IService;

@IService(scope = IService.Scope.MULTIPLE)
public interface IWindow {
	void init();
	void openWindow(Class<IWindow> window, WindowMode mode);
	void openWindow(Class<IWindow> window);
}
