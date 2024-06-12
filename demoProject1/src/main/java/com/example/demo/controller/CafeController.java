package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.CafeDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("cafe")
@Slf4j
public class CafeController {
	
	@GetMapping("index")
	public String cafeMainMethod() {
		return "/cafe/cafe-index";
	}
	/*
	@PostMapping("comment")
	public String cafeMainComment(
			@RequestParam("cafeCommentName") String cafeCommentName,
			@RequestParam("cafeCommentOpinion") String cafeCommentOpinion
	) {
		log.info("cafeComment 진입");
		
		log.debug("cafeCommentName : "+cafeCommentName);
		log.debug("cafeCommentOpinion : "+cafeCommentOpinion);
		
		return "redirect:/cafe/index";
	}
	*/
	
	// CafeDTO cafe-board
	@PostMapping("comment")
	public String cafeIndexComment(CafeDTO inComment) {
		CafeDTO incafe = new CafeDTO();
		incafe.setCafeCommentName(inComment.getCafeCommentName());
		incafe.setCafeCommentOpinion(inComment.getCafeCommentOpinion());
		
		log.info(incafe.toString());
		
		return "redirect:/cafe/index";
	}
}
