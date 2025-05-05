module com.meatwork.desktop.test {
	requires com.meatwork.core;
	requires com.meatwork.test;
	requires com.meatwork.desktop;
	opens com.meatwork.desktop.test;
	exports com.meatwork.desktop.test to org.junit.platform.commons, com.meatwork.core;
}