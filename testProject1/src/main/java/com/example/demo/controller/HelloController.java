package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/test")
	public String testMethod() {
		System.out.println("test 페이지로 제대로 연결됐는지 확인 출력 메서드");
		
		/*
		@RequestMapping 을 쓰면 기본으로 return 할 때 
		html 파일을 바라보겠다 설정이 들어있음
		
		classpath :src/main/resources
		기본경로가 앞에 붙여진 /templates/ 폴더가 html을 담는 공간
		파일명 마지막에는 항상 .html 이 붙는다
		
		*/
		
		// src/main/resources/templates/test.html 로 이동하겠다 라는 표시
		return "test";
		// return "html파일명";
		// 돌아가기 "html 파일명";
	}
}
