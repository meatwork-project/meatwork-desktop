package com.meatwork.desktop.test;

import com.meatwork.core.api.service.ApplicationStartup;
import com.meatwork.desktop.api.IWindow;
import com.meatwork.test.api.MeatworkExtension;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@ExtendWith(MeatworkExtension.class)
public class WindowsTest {

	@Inject
	private Set<ApplicationStartup> swingOnStartup;
	@Inject
	private Set<IWindow> windows;

	@Test
	public void test() throws InterruptedException, InvocationTargetException {
		swingOnStartup.stream().findFirst().ifPresent(applicationStartup -> {
			try {
				applicationStartup.run(null, null);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		IWindow window = windows
				.stream()
				.filter(it -> MainWindowMock.class.equals(it.getClass()))
				.findFirst()
				.orElseThrow(RuntimeException::new);
		MainWindowMock window1 = (MainWindowMock) window;
		SwingUtilities.invokeAndWait(() -> window1.getButton1().doClick());
		Assertions.assertEquals("button1", window1.getResultOkButtonClicked());
	}

}
