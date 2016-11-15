package hr.spring.thymeleaf.demo.web.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SkillFormValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return SkillForm.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		SkillForm form = (SkillForm) object;
		if (form.getSkill().getValue() == null || form.getSkill().getValue().equals("")) {
			errors.rejectValue("skill", "", "You must set skill!");
		}
		if (form.getLevel().getValue() == null || form.getLevel().getValue().equals("")) {
			errors.rejectValue("level", "", "You must set level!");
		}
		
	}
	

}
