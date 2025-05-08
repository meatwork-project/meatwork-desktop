package com.meatwork.desktop.api;

import com.meatwork.core.api.di.IService;

@IService
public interface WindowManager {
	void openWindow(Class<IWindow> windowsToOpen,
	                  IWindow currentIWindow);
}
