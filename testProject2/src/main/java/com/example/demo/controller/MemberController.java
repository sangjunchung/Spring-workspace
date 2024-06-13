package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberController {
	@GetMapping("info")
	public String memberInfoMethod(Model model) {
		
		List<MemberDTO> mem = new ArrayList<>();
		mem.add(new MemberDTO("홍길동","010-1111-1111",10));
		mem.add(new MemberDTO("박철수","010-2222-2222",20));
		mem.add(new MemberDTO("김영희","010-3333-3333",30));
		
		model.addAttribute("mem", mem);
		model.addAttribute("memList", mem);
		
		log.info("들어왔는지 확인");
		log.debug("문제없는지 확인");
		
		return "/member/memberInfo";
		
		/*
		org.thymeleaf.exceptions.TemplateInputException: An error happened during template
		1. 파일 위치와 이름이 제대로 된게 맞는지 확인
		2. Member 로 객체 이름을 작성할 경우
			import java.lang.reflect.Member; 주소와
			개발자가 만들어준 주소값이 나옴
			여기에서 개발자가 만들어준 주소값으로 Member 객체를 필히 가져와야함
		*/
	}
}
