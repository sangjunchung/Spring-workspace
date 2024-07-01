package com.khmall.controller;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.util.FileUploadUtil;

/*
	1. SQL -> 백엔드 -> CSS
	개발 흐름 순서 : 기획 -> 백엔드 -> 프론트엔드
	
	Mapping 작성하고 Mapping("/주소=api")
	
	@Controller
		주로 html(view 화면)을 반환하기 위해 사용
		
	@RestController
		@Controller와 @ResponseBody 가 합쳐진 형태로 
		json 형태의 객체 데이터를 반환
		
		백엔드 개발자가 보이는 화면(view, html)이 없을 때 
		데이터가 무사히 들어오고 나오는지 확인하기 위해 사용하는 컨트롤러
		
		React에 프론트엔드를 작성할 때 사용하기도 함
*/

@RequestMapping("api/v2/img")
@RestController
public class ImageUploadController {
	
	@GetMapping("/upload") // get api 1개 생성 = api/v2/img/upload
	public void get() {
		
	}
	
	@PostMapping("/upload") // post api 1개 생성 = api/vs/img/upload
	public void saveImage(@RequestParam("files") MultipartFile[] files) {
		String uploadFileLocation = "imgFolder"; // static 밑에 imgFolder를 만들어서 업로드 예정
		
		// 배열로 이미지를 담아서 한번에 전송
		Arrays.asList(files).stream().forEach(file->{
			// 파일 이름을 깔끔하게 정리
			// StringUtils 에서 cleanPath 기능 = 파일 이름에 포함될 수 있는 잠재적인 악의적인 값을
			// file 에서 가져오기 = getOriginalFilename
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
			System.out.println(fileName);
			
			try{
				// 파일 올리기 -> 업로드할 파일
				FileUploadUtil.saveFile(uploadFileLocation, fileName, file);
				
			} catch (Exception e) {
				
			}
		});
	}
}
