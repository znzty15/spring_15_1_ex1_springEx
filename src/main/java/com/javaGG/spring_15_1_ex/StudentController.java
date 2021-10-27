package com.javaGG.spring_15_1_ex;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
public class StudentController {

	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/loginOk")
	public String loginOk(@Valid Student student, BindingResult result) {
		
		String page="loginOk";
		
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
		
		if(result.hasErrors()) {
			page = "login";
		}
		
		return page;
	}
	
	@InitBinder
	
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
	
}
