package com.khmall.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

// 파일 업로드를 위해서 설정
public class FileUploadUtil {
	public static void saveFile(String uploadDir, String fileName, MultipartFile mpFile) throws IOException {
		// 폴더에 파일을 업로드하기 위해서 경로 설정
		// C:/Users/user1/servlet_jsp_workspace/Image-multi-upload/src/main/resources/static/imgFolder
		
		// 내가 지금 실행하고 있는 자바 파일 위치의 주소 가져오기
		Path uploadPath = Paths.get("C:/Users/user1/Desktop/"+ uploadDir);
		
		// 만약에 이미지를 저장할 폴더가 존재하지 않다면 폴더 생성
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		/*
		1. 전통적은 try 구문 (메모리 사용이 아래 코드보다 많음)
		try{
		 InputStream inputStream = mpFile.getInputStream() 
		 	- try문 실행 중일 경우 같이 계속 실행됨
		 
		2. 자바 7버전 이후 사용하는 try 구문 (메모리 사용이 위 코드보다 절감됨)
		try(InputStream inputStream = mpFile.getInputStream()){
			- 위 구문 실행 후 결과가 남아있음
			
		1번과 2번 사용의 차이점
		코드 1줄 실행하고 전달만 하는지?
		
		stream -> buffer 이미지들을 사용자 눈에 바로바로 보일수 있게 모아놓은 공간
		Stream 의 경우 다른 코드 줄보다 메모리 사용량이 높으므로
		처리하고 전달해주는 것이 가장 이상적임(필수는 X)
		*/
		
		// 1. InputStream을 사용해서 파일을 실제로 저장할 때 사용하기 위해 작성한 객체
		// 파일 데이터를 가지고 옴
		try(InputStream inputStream = mpFile.getInputStream()){
			
			// 2. uploadPath = 파일을 저장할 폴더 위치를 나타내는 것
			// resolve = 해결하다 - 풀거나 결합 결단
			// Path 계의 +, 경로와 파일명을 붙여서 한번에 작성할 수 있게 도와주는 것
			Path filePath = uploadPath.resolve(fileName); // 파일 경로 + 파일명
			
			// 3. Files.copy
			// inputStream 의 내용을 filePath 에 복사
			
			// 3-1. StandardCopyOption.REPLACE_EXISTING
			// 만약에 동일한 이름의 파일이 존재할 경우 덮어쓰기로 필수로 작성하는 것은 아님
			// 추후에 파일 업로드 할 때 동일한 파일명으로 
			// 에러가 발생할 수 있을 경우를 대비하여 작성한 것
			// 선택 1) 덮어쓰기를 해서 에러 발생하지 않게 설정
			// 선택 2) 기존에 파일이 존재하면 업로드 못하게 설정
			// 선택 3) 만약에 동일한 파일명이 존재하면 숫자나 업로드 날짜를 추가로 작성
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch(Exception e) {
			e.printStackTrace(); // 에러 출력
		}
	}
}
