package com.khmall.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Cloth;
import com.khmall.mapper.ClothesMapper;



@Service
public class ClothService {
	@Autowired
	private ClothesMapper clothesMapper;
	
	public List<Cloth> getAllClothes(){
		return clothesMapper.getAllClothes();
	}
	
	public void uploadCloth(String name, int price, String category, MultipartFile inFile) {
		String inFileName = inFile.getOriginalFilename();
		String locationFolder = "C:/Users/user1/servlet_jsp_workspace/Insert-image-upload/src/main/resources/static/images/clothes/";
		
		File file = new File(locationFolder+inFileName);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		try {
			inFile.transferTo(file);
			
			Cloth cloth = new Cloth();
			cloth.setClothes_name(name);
			cloth.setClothes_price(price);
			cloth.setClothes_category(category);
			cloth.setClothes_image_path("/images/clothes/"+inFileName);
		
			clothesMapper.uploadCloth(cloth);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
}
