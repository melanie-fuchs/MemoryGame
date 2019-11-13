package gui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * The class manages different languages. The language can be set from outside.
 */
public class Messages {
	private static final String english = Messages.getString("Messages.languageFileEnglish"); //$NON-NLS-1$
	private static final String german = Messages.getString("Messages.languageFileGerman"); //$NON-NLS-1$

	private static ResourceBundle resourceBundleEnglish = ResourceBundle.getBundle(english);
	private static ResourceBundle resourceBundleGerman = ResourceBundle.getBundle(german);

	private static ResourceBundle currentResourceBundle = resourceBundleEnglish;

	/**
	 * The method sets the currentResourceBundle to the languages-bundle that belongs to
	 * the String-value that was passed as parameter. If the language does not exist,
	 * the language will be set to english as default.
	 *
	 * @param language String-value that represents the preferred language
	 */
	public static void setLanguage(String language) {
        if(language == "german") {
			currentResourceBundle = resourceBundleGerman;
        }
    }

	private Messages() {
	}

	/**
	 * The method returns the value that belongs to the requested key. Depending on which
	 * resource-bundle is set as currentResourceBundle, the language can vary.
	 *
	 * @param key String-value that represents the key
	 *
	 * @return a String that represents the value of the key, picked from a specific
	 * resourceBundle
	 */
	public static String getString(String key) {
		try {
			return currentResourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
