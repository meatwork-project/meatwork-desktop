package com.meatwork.desktop.api;

import com.meatwork.core.api.di.IService;

import javax.swing.LookAndFeel;

@IService(mandatory = false)
public interface ThemeConfiguration {
	LookAndFeel getLookAndFeel();
}
