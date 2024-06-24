package com.khmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khmall.dto.Member;
import com.khmall.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String indexPage() {
		return "/index";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("m", new Member());
		return "/login";
	}
	
	@PostMapping("/login")
	public String getLogin(Model model,
			@RequestParam("member_name") String member_name,
			@RequestParam("member_phone") String member_phone,
			HttpSession session) {
		return "redirect:/";
	}
	
	/*
		HttpSession session
		사용자와 서버 간의 상태를 유지하는데 사용되는 객체
		상태를 유지하고, 식별하고, 데이터를 저장하고, 수명을 관리할 수 있음
		로그인을 하는 상태를 유지
		데이터를 전달받은 값이 일치하는지 식별
		일정한 기간동안 데이터를 저장하고
		일정 시간이 지나면 수명이 다하도록 수명을 관리할 수 있음(로그인 시간 유지)
	*/
}
