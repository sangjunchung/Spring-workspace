package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Pig;
import com.khmall.service.PigService;

@Controller
public class PigController {
	@Autowired
	private PigService pigService;
	
	@GetMapping("/pig-all-list")
	public String getAllPigs(Model model) {
		List<Pig> pigs = pigService.getAllPigs();
		model.addAttribute("pigs", pigs);
		return "pig-all-list";
	}
	
	@GetMapping("/pig_detail/{pig_id}")
	public String getPigById(Model model, @PathVariable int pig_id) {
		Pig pig = pigService.getPigById(pig_id);
		model.addAttribute("pig", pig);
		return "pigDetailView";
	}
	
	@GetMapping("/pig-image-upload")
	public String uploadPig(Model model) {
		model.addAttribute("p", new Pig());
		return "uploadPig";
	}
	
	@PostMapping("/uploadPig")
	public String uploadPig(Model model,
			@RequestParam("pig_name") String pig_name,
			@RequestParam("pig_age") int pig_age,
			@RequestParam("pig_imgae_path") MultipartFile inFile) {
		
		pigService.uploadPig(pig_name, pig_age, inFile);
		
		return "redirect:/pig-all-list";
	}
}
