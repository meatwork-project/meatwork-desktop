package com.meatwork.desktop.test;

import com.meatwork.core.api.di.Service;
import com.meatwork.desktop.api.Window;
import com.meatwork.desktop.api.WindowAttr;
import com.meatwork.desktop.api.IWindow;
import com.meatwork.desktop.api.WindowManager;
import jakarta.inject.Inject;

import javax.swing.JButton;

@Service
@WindowAttr(value = "main", title = "Current value")
public class MainWindowMock extends Window implements IWindow {

	private JButton button1;
	private String resultOkButtonClicked;

	@Inject
	public MainWindowMock(WindowManager windowManager) {
		super(windowManager);
	}

	@Override
	public void init() {
		button1 = new JButton("Button1");
		button1.addActionListener(_ -> resultOkButtonClicked = "button1");
	}

	public JButton getButton1() {
		return button1;
	}

	public String getResultOkButtonClicked() {
		return resultOkButtonClicked;
	}

}
