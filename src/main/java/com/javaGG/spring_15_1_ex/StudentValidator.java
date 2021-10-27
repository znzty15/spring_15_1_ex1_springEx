package com.javaGG.spring_15_1_ex;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {	// 검증할 객체의 클레스 타입정보
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Student student = (Student) target;
		
		String studentId = student.getId();
		int studentPw = student.getPw();
		
		if(studentId == null || studentId.trim().isEmpty()) {
			errors.rejectValue("id", "trouble");
		}
		
		if(studentPw == 0) {
			errors.rejectValue("pw", "trouble");
		}
	}

}
