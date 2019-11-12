package gui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String english = "gui.lang_en";
	private static final String german = "gui.lang_de";

	private static ResourceBundle resourceBundleEnglish = ResourceBundle.getBundle(english);
	private static ResourceBundle resourceBundleGerman = ResourceBundle.getBundle(german);

	private static ResourceBundle currentResourceBundle = resourceBundleEnglish;

	public static void setLanguage(String language) {
        if(language == "german") {
			currentResourceBundle = resourceBundleGerman;
        } else {
			currentResourceBundle = resourceBundleEnglish;
        }
    }

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return currentResourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
