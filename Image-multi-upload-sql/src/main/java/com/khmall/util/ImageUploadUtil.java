package com.khmall.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

/*
	html 파일과 db가 주고 받을 때는 Service 라는 이름으로
	코드를 작성하지만 백엔드에서 단독적으로 진행하는 값이나 공통으로 설정할 때는
	util이라는 이름을 사용해서 코드를 작성
	
	util -> poatMan을 사용해서 파일 업로드가 잘 되고 있는지 테스트 진행
*/

public class ImageUploadUtil {
	public static void insertImageUpload(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
		Path uploadPath = Paths.get("C:/"+ uploadDir);
		
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try(InputStream is = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(is, filePath, StandardCopyOption.REPLACE_EXISTING);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
