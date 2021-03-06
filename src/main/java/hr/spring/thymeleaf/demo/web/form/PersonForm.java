package hr.spring.thymeleaf.demo.web.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hr.spring.thymeleaf.demo.web.form.field.FormField;
import hr.spring.thymeleaf.demo.web.form.field.FormFieldDisplayCallback;
import lombok.Data;

@Data
public class PersonForm {

    private FormField name = new FormField("Name");
    private FormField age = new FormField("Age", (f) -> FormFieldDisplayCallback.getFieldDisplay(f));
    private FormField city = new FormField("City", (f) -> FormFieldDisplayCallback.getFieldDisplay(f));
    private List<SkillForm> skills = new ArrayList<>();

    @Override
	public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + "City: " + this.city + ", " + Arrays.toString(this.skills.toArray()) + ")";
    }
}