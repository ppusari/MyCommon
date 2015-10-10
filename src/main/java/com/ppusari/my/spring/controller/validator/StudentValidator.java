package com.ppusari.my.spring.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0); // 검증할 객체의 클래스 타입 정보
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate()");
		Student student = (Student)obj;
		
		// name 유효성 검사
		String studentName = student.getName();
		if(studentName == null || studentName.trim().isEmpty()){
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble");
		}
		/*위 내용을 아래처럼 한줄로 요약할 수 있다."*/
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "troble");   
		
		
		
		// id 유효성 검사
		int studentId = student.getId();
		if (studentId == 0){
			System.out.println("student is 0");
			errors.rejectValue("id", "trobule");	// 값이 비정상 적이면 에러를 삽입한다.
		}
		
		
	}

	
}
