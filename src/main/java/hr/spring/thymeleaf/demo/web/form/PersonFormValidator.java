package hr.spring.thymeleaf.demo.web.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonFormValidator implements Validator {

	@Autowired
	private SkillFormValidator skillFormValidator;
	
	@Override
	public boolean supports(Class clazz) {
		return PersonForm.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		PersonForm form = (PersonForm) object;
		if (form.getCity().getValue() == null || !form.getCity().getValue().toString().equals("Daruvar")) {
			errors.rejectValue("city", "", "Must be Daruvar!");
		}
		
		int idx = 0;
		for (SkillForm skillForm : form.getSkills()) {
			errors.pushNestedPath("skills[" + idx + "]");
			ValidationUtils.invokeValidator(this.skillFormValidator, skillForm, errors);
			errors.popNestedPath();
			idx++;
		}
		
	}

}
