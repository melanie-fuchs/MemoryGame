package gui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String english = "gui.lang_en";
	private static final String german = "gui.lang_de";

	private Messages(String language) {
		if(language == german) {
			private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(this.german);
		} else {
			private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(this.english);
		}
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
