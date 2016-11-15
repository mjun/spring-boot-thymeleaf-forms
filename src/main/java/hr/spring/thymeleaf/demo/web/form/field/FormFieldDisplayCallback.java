package hr.spring.thymeleaf.demo.web.form.field;

public class FormFieldDisplayCallback {
	
	public static String getAccessibility(FormField field) {
		
		if (field.getName().equals("Name")) {
			return FormField.DISPLAY_NONE;
		} else if (field.getName().equals("Age")) {
			return FormField.DISPLAY_READONLY;
		} else if (field.getName().equals("City")) {
			return FormField.DISPLAY_NONE;
		} else {
			return FormField.DISPLAY_DISABLED;
		}
		
	}

}
