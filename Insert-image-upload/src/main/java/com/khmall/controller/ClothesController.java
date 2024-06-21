package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Cloth;
import com.khmall.service.ClothService;

@Controller
public class ClothesController {
	@Autowired
	private ClothService clothService;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		List<Cloth> clothList = clothService.getAllClothes();
		model.addAttribute("clothes", clothList);
		
		return "index";
	}
	
	@GetMapping("/uploadCloth")
	public String uploadClothPage(Model model) {
		model.addAttribute("cloth", new Cloth());
		
		return "uploadCloth";
	}
	
	@PostMapping("/upload")
	public String upload(
		Model model,
		@RequestParam("clothes_name") String name,
		@RequestParam("clothes_price") int price,
		@RequestParam("clothes_category") String category,
		@RequestParam("clothes_image_path") MultipartFile inFile
		) {
		clothService.uploadCloth(name, price, category, inFile);
		
		return "redirect:/";
	}
}
