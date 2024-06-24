package com.khmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khmall.dto.Members;
import com.khmall.service.MembersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MembersController {
	@Autowired
	private MembersService membersService;
	
	@GetMapping("/")
	public String mainPage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("mem", new Members());
		return "/login";
	}
	
	@PostMapping("/loginform")
	public String getLogin(Model model,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session) {
		
		Members loginMember = membersService.getLoginInfo(username, password);
		
		if(loginMember != null) {
			session.setAttribute("loginSession", loginMember);
			return "redirect:/";
		} else {
			model.addAttribute("mem", new Members());
			model.addAttribute("loginFail", "로그인 실패, 이름과 비밀번호 다시 입력해주세요.");
			return "/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
