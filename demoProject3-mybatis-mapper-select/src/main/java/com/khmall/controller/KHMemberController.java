package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.khmall.dto.KHMember;
import com.khmall.service.KHMemberService;

@Controller
public class KHMemberController {
	@Autowired
	private KHMemberService KHMS;
	
	@GetMapping("/register")
	public String registerMember(Model model) {
		model.addAttribute("member", new KHMember());
		
		return "registerMember";
	}
	
	@PostMapping("/result")
	public String insertMember(KHMember KHMember) {
		KHMS.insertMember(KHMember);
		
		return "resultMember";
	}
	
	@GetMapping("/allKHMember")
	public String getAllMember(Model model) {
		List<KHMember> KHMList = KHMS.getAllMember();
		model.addAttribute("KHMList", KHMList);
		
		return "khmemberList";
	}
	
}
