package com.khmall.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Pig;
import com.khmall.mapper.PigMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PigService {
	@Autowired
	private PigMapper pigMapper;
	/*
	서비스에서 추가적으로 수정된 데이터가 매퍼를 통해 db에 들어가고
	db에서 가져온 sql에 추가적으로 수정을 서비스 단계에서 진행한 다음
	컨트롤러에 전달하거나 전달받기
	*/
	
	public List<Pig> getAllPigs(){
		return pigMapper.getAllPigs();
	}
	
	public Pig getPigById(int pig_id) {
		return pigMapper.getPigById(pig_id);
	}
	
	public void uploadPig(String pig_name, int pig_age, MultipartFile inFile) {
		String inFileName = inFile.getOriginalFilename();
		String saveFolder = "C:/Users/user1/Desktop/pigImg/";
		File file = new File(saveFolder+inFileName);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		try {
			inFile.transferTo(file);
			
			Pig pig = new Pig();
			pig.setPig_name(pig_name);
			pig.setPig_age(pig_age);
			pig.setPig_image_path(saveFolder+inFileName);
			pigMapper.uploadPig(pig);
			
			log.info("Service에서 DB로 전달 성공");
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
}
