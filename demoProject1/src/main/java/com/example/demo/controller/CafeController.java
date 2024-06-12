package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("cafe")
@Slf4j
public class CafeController {
	
	@GetMapping("index")
	public String cafeMainMethod() {
		return "/cafe/cafe-index";
	}
	
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
}
