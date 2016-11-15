package hr.spring.thymeleaf.demo.web.form;

import hr.spring.thymeleaf.demo.web.form.field.FormField;
import lombok.Data;

@Data
public class SkillForm {

    private FormField skill = new FormField("Skill name");
    private FormField level = new FormField("Level");
    
    @Override
    public String toString() {
    	return "Skill(Name: " + this.skill + " Level: " + this.level + " )";
    }
    
}
