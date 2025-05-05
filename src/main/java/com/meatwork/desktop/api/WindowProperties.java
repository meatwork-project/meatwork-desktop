package com.meatwork.desktop.api;

import com.meatwork.desktop.internal.IWindow;

public record WindowProperties(IWindow window, String name, String title, WSize wSize) {}
