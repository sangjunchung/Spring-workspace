package com.khmall.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.mapper.ImageUploadMapper;
import com.khmall.util.ImageUploadUtil;

@Controller
public class ImageController {
	@Autowired
	private ImageUploadMapper imageUploadMapper;
	
	/*
		@RequsetMapping("/api/v1/img")
		public class Imagecontroller{
			@PostMapping("/upload")
			메서드명
		}
	*/
	
	@GetMapping("/api/v1/img/upload")
	public String showUploadForm(Model model) {
		return "upload";
	}
	
	@PostMapping("/api/v1/img/upload")
	public String insertImageUpload(@RequestParam("files") MultipartFile[] files, Model model) {
		String uploadDir = "imgDir";
		Arrays.asList(files).stream().forEach(file->{
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

			try {
				ImageUploadUtil.insertImageUpload(uploadDir, fileName, file);
				
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("file_name", fileName);
				paramMap.put("upload_dir", uploadDir);
				
				imageUploadMapper.insertImageUpload(paramMap);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		return "index";
	}
	
}
