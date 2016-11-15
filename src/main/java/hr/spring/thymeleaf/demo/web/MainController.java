package hr.spring.thymeleaf.demo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import hr.spring.thymeleaf.demo.web.form.PersonForm;
import hr.spring.thymeleaf.demo.web.form.PersonFormValidator;
import hr.spring.thymeleaf.demo.web.form.SkillForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController extends WebMvcConfigurerAdapter {

	@Autowired
	private PersonFormValidator personFormValidator;
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(PersonForm personForm, Model model) {
    	SkillForm skill = new SkillForm();
    	skill.getSkill().setValue("Java");
    	skill.getLevel().setValue("5");
    	personForm.getSkills().add(skill);

    	model.addAttribute("personForm", personForm);
        return "person_form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
    	personFormValidator.validate(personForm, bindingResult);
    	
        if (bindingResult.hasErrors()) {
            return "person_form";
        }
        
        log.info("Submitted form " + personForm);

        return "redirect:/results";
    }
}