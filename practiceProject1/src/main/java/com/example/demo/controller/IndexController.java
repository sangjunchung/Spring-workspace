package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

// index 라는 이름은 기본으로 바라보는 페이지명, 보통 처음/맨 앞에 있는 페이지명은 index로 설정
@Controller
@Slf4j
public class IndexController {
	@RequestMapping("test")
	public String testMethod() {
		log.info("테스트 진입");
		
		return "test";
	}
}
