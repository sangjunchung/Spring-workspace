package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller // 요청하거나 응답제어 역활을 명시 Bean에 등록 
			// Bean = spring에서 어떤 기능을 하라 설정해놓은 값
@RequestMapping("example")
@Slf4j // lombok 라이브러리가 제공하는 로그 객체 자동생성 어노테이션
public class ExampleController {
	
	/*
		Model
		 - spring 에서 데이터 전달 역활을 하는 객체
		 - org.springframework.ui 패키지
		 - @SessionAttribute 와 함께 사용할 경우 session scope 반환
		 
		 [기본 사용법]
		 Model.addAttribute("key", value);
	*/
	
	@GetMapping("ex1")
	public String ex1(HttpServletRequest req, Model model) {
		
		// 나중에 DB에서 가져온 값을 보여줄 때 사용하는 메서드
		req.setAttribute("test1", "HttpServletRequest로 전달한 값");
		model.addAttribute("test2", "Model로 전달한 값");
		return "/example/ex1";
	}
}
