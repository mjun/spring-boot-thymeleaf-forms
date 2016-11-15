package hr.spring.thymeleaf.demo.web.form.field;

import java.util.HashMap;

import lombok.Data;

@Data
public class FormField {
	
	@FunctionalInterface
	public interface IFormFieldDisplay {
	    public String getFieldDisplay(FormField f);
	}
	
	public static final String DISPLAY_EDITABLE = "EDITABLE";
	public static final String DISPLAY_EDITABLE_REQUIRED = "EDITABLE_REQUIRED";
	public static final String DISPLAY_READONLY = "READONLY";
	public static final String DISPLAY_DISABLED = "DISABLED";
	public static final String DISPLAY_HIDDEN = "HIDDEN";
	public static final String DISPLAY_NONE = "NONE";
	
	private String name;
	private Object value;
	private String display = DISPLAY_EDITABLE;
	private HashMap<String,String> attributes;
	
	public FormField() {}
	
	public FormField(String name) {
		this.name = name;
		this.display = DISPLAY_EDITABLE;
	}
	
	public FormField(String name, String accessibility) {
		this.name = name;
		this.display = accessibility;
	}
	
	public FormField(String name, IFormFieldDisplay fieldDisplayCallback) {
		this.name = name;
		this.display = fieldDisplayCallback.getFieldDisplay(this);
	}
	
	@Override
	public String toString() {
		return this.value != null ? this.value.toString() : "";
	}
	

}
