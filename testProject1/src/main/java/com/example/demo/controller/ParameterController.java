package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("param")
@Slf4j
public class ParameterController {
	@GetMapping("main")
	public String paramMain() {
		return "param/param-main";
	}
	
	@PostMapping("test1")
	public String paramTest1(HttpServletRequest req) {
		String inputName = req.getParameter("inputName");
		String inputAddress = req.getParameter("inputAddress");
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		
		log.info("출력 Check!");
		log.info("이름 확인 : "+inputName);
		log.info("나이 확인 : "+inputAge);
		log.info("주소 확인 : "+inputAddress);
		
		log.info("============================");
		log.debug("이름 확인 : "+inputName);
		log.debug("나이 확인 : "+inputAge);
		log.debug("주소 확인 : "+inputAddress);
		
		return "redirect:/param/main";
	}
}
