package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.BlogDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("blog")
@Slf4j
public class BlogController {
	@GetMapping("index")
	public String blogMainMethod() {
		return "/blog/blog-index";
	}
	
	@PostMapping("comment")
	public String blogComment(BlogDTO inBlog) {
		BlogDTO blog = new BlogDTO();
		blog.setCommentName(inBlog.getCommentName());
		blog.setCommentOpinion(inBlog.getCommentOpinion());
		
		log.info("Comment 잘 전달했는지 확인");
		
		log.debug("commentName : "+blog.getCommentName());
		log.debug("commentOpinion : "+blog.getCommentOpinion());
		
		log.info("comment 정보 : "+blog.toString());
		
		return "redirect:/blog/index";
	}
}
