package com.meatwork.desktop.internal;

import com.meatwork.core.api.di.Service;
import com.meatwork.desktop.api.WSize;
import com.meatwork.desktop.api.Window;
import com.meatwork.desktop.api.WindowAttr;
import com.meatwork.desktop.api.WindowProperties;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WindowManagerImpl implements WindowManager {

	private Map<String, WindowProperties> windowsMap;

	private static WindowAttr getWindowAttr(IWindow window) {
		return Optional
				.ofNullable(window
						            .getClass()
						            .getAnnotation(WindowAttr.class)
				)
				.orElseThrow(() -> new WindowNotFoundException("Annotation WindowAttr not found for window: " + window));
	}

	@Override
	public void openWindow(Class<IWindow> windowsToOpen,
	                       IWindow currentWindow) {
		WindowProperties windowProperties = windowsMap.get(windowsToOpen.getName());
		if (windowProperties == null) {
			throw new WindowNotFoundException("window not found: " + windowsToOpen);
		}
		((Window) windowProperties
				.window())
				.initialize();
	}

	public WindowProperties getWindow(Class<? extends IWindow> window) {
		return windowsMap
				.entrySet()
				.stream()
				.filter(it -> it
						.getValue()
						.window()
						.getClass()
						.equals(window))
				.findFirst()
				.map(Map.Entry::getValue)
				.orElse(null);
	}

	public void init(Set<IWindow> windows) {
		this.windowsMap = windows
				.stream()
				.map(window -> {
					WindowAttr windowAttr = getWindowAttr(window);
					return new WindowProperties(
							window,
							windowAttr.value(),
							windowAttr.title(),
							new WSize(
									windowAttr.width(),
									windowAttr.height()
							)
					);
				})
				.collect(Collectors.toMap(
						         it -> it
								         .name()
								         .toLowerCase(),
						         window -> window
				         )
				);
		Map.Entry<String, WindowProperties> mainWindow = this.windowsMap
				.entrySet()
				.stream()
				.filter(it -> it
						.getKey()
						.contains("main"))
				.findFirst()
				.orElseThrow(() -> new WindowNotFoundException("Main window not found, need to add WindowAttr with value \"main\""));
		((Window) mainWindow
				.getValue()
				.window())
				.initialize();
	}
}
