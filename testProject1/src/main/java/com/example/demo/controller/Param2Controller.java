package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("param2")
@Slf4j
public class Param2Controller {
	
	@PostMapping("test2")
	public String param2Test(
			@RequestParam("snackName") String snackName,
			@RequestParam("snackCompany") String snackCompany,
			@RequestParam("snackPrice") int snackPrice,
			@RequestParam(value="snackLike", defaultValue="snackLike", required=false) String snackLike
	) {
		log.info("param2/test2 진입 성공");
		log.info(snackName);
		log.info(snackCompany);
		log.info(""+snackPrice);
		log.info(snackLike);
		
		return "redirect:/param/main";
	}
	
	@PostMapping("likeSnackCompany")
	public String likeSnackCompany(
			@RequestParam(value="likeSnack", required=false) String[] likeSnackArr,
			@RequestParam(value="likeCompany", required=false) List<String> companyList
	) {
		log.info("과자 : "+Arrays.toString(likeSnackArr));
		log.info("회사 : "+companyList);
		
		return "redirect:/param/main";
	}
}
