package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Snacks;
import com.khmall.service.SnacksService;

// Service 에 작성한 기능을 종합해서 DB와 HTML을 연결해주는 연결고리
@Controller
public class SnacksController {
	@Autowired // SnacksService 작성된 모든 기능을 활용함(의존성 주입)
	private SnacksService snacksService;
	
	@GetMapping("/allSnack")
	public String getAllSancks(Model model) {
		List<Snacks> snackList = snacksService.getAllSnacks();
		// Model 은 DB에서 가져온 값을 전달해주는 전달 연결고리
		model.addAttribute("snackList", snackList);
		
		return "snackList";
	}	
}
