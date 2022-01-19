package localization;

import java.util.Locale;
import java.util.ResourceBundle;

import view.window.MyMainFrame;

public class Language {

	private ResourceBundle resourceBundle;
	private static Language instance;
	
	public static Language getInstance() {
		if (instance == null) {
			instance = new Language();
		}
		return instance;
	}
	
	private Language() {
		Locale.setDefault(new Locale("sr","RS"));
		//Locale.setDefault(new Locale("en","US"));
		resourceBundle = ResourceBundle.getBundle("localization.MessageResources",Locale.getDefault());
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void changeLanguage() {
		
		resourceBundle = ResourceBundle.getBundle("localization.MessageResources",Locale.getDefault());
	}
	
}
