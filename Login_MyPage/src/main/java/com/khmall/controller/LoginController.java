package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khmall.dto.Member;
import com.khmall.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
// @RestController -> 추후 리액트를 사용할 때 사용할 예정
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("mem", new Member());
		return "login";
	}
	
	@PostMapping("/login")
	public String getLogin(Model model,
			@RequestParam("member_name") String member_name,
			@RequestParam("member_phone") String member_phone,
			HttpSession session) {
		
		Member member = loginService.getLogin(member_name, member_phone);
		
		if(member != null) {
			session.setAttribute("loginSession", member);
			return "redirect:/";
		} else {
			model.addAttribute("error", "일치하는 아이디 비밀번호가 없습니다.");
			model.addAttribute("mem", new Member());
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session /* SessionStatus 시간지나면 자동 로그아웃 */) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/myPage")
	public String showMyPage(HttpSession session, Model model) {
		// 현재 로그인된 세션의 정보를 가지고 와서 멤버 정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
		
		// 만약에 로그인이 되어있지 않은데 접촉하려하면 로그인 페이지로 돌려보냄
		if(member == null) {
			return "redirect:/login";
		}
		// 만약에 모델에 정보가 담겨있으면 보여줄 멤버 객체
		model.addAttribute("member", member);
		
		return "myPage";
	}
	
	@GetMapping("/modifyProfile")
	public String modifyMypage(HttpSession session, Model model) {
		Member member = (Member) session.getAttribute("loginSession");
		model.addAttribute("member", member);
		
		return "modifyProfile";
	}
	
	@PostMapping("/modifyProfile")
	public String updateMember(Member updateMember, HttpSession session) {
		Member member = (Member) session.getAttribute("loginSession");
		
		if(member == null) {
			return "redirect:/login";
		}
		
		updateMember.setMember_id(member.getMember_id());
		loginService.updateMember(updateMember);
		session.setAttribute("loginSession", updateMember);
		
		return "redirect:/myPage";
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(HttpSession session) {
		Member member = (Member) session.getAttribute("loginSession");
		
		if(member == null) {
			return "redirect:/login";
		}
		
		loginService.deleteMember(member.getMember_id());
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/search")
	public String showSearch() {
		return "search";
	}
	
	/*
		@RequestParam("input이나 태그에 작성한 name 또는 th로 작성된 변수명")
	*/
	
	@PostMapping("/search")
	public String searchMembers(Model model,
			@RequestParam("keyword") String keyword) {
		
		List<Member> memList = loginService.searchMembers(keyword);
		model.addAttribute("results", memList);
		
		return "search";
	}
}
