package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller // 응답/요청에 대한 제어 역활 명시 + Bean으로 등록
// Bean : 스프링이 알아서 만들고 관리한다는 것
@RequestMapping("param") // 여기 및에 작성하는 모든 주소앞에 param이 기본으로 붙음
@Slf4j // Simple logging facade 4(for) Java 의 약자 
	   // -> Systemp.out.println 과 비슷한 종류
	   // -> System 출력에 비해 logging을 사용하는게 메모리 부담이 적음
	   // -> log를 이용한 메세지 출력시 자주 사용
public class ParameterController {
	@GetMapping("main") // param/main 주소로 GET 방식 요청 만듬
	public String paramMain() {
		return "param/param-main";
		// return 할 때 폴더명/파일명 작성
		// param-main.html 의 위치는 템플릿 밑의 파람이라는 폴더에 존재
		// html 파일을 바라볼 때 기본으로 템플릿이라는 폴더를 바라보고
		// templates/param/param.html 파일을 바라본다는 표시를 작성
	} 
	
	@PostMapping("test1") // param/test1 POST 방식 요청
	public String paramTest1(HttpServletRequest req) {
		String inputName = req.getParameter("inputName");
		// form 밑에 input 에서 name이 inputName에 존재하는 값 가져오기
		
		String inputAddress = req.getParameter("inputAddress");
		// form 밑에 input 에서 name이 inputAddress에 존재하는 값 가져오기
		
		// -> 기본으로 가져오는 값이 String 이기 때문에 숫자 값인 Int로 변환
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		// form 밑에 input 에서 name이 inputAge에 존재하는 값 가져오기
		
		// inputName 과 inputAddress 와 inputAge 가 제대로 작성됐는지 확인하기
		System.out.println("이름 확인 : "+inputName);
		System.out.println("나이 확인 : "+inputAge);
		System.out.println("주소 확인 : "+inputAddress);
		
		// -> System 대신 log.debug 를 활용해서 출력하는 것이 메모리 부담이 적음
		// -> 코드 오류를 해결하기 위한 로그
		// -> 코드 오류는 없는데 정상적으로 수행이 안되거나
		// -> 값이 잘못된 경우 값 추적해줌
		log.info("정보확인하기");
		log.debug("로그로 이름 확인 : "+inputName);
		log.debug("로그로 나이 확인 : "+inputAge);
		log.debug("로그로 주소 확인 : "+inputAddress);
		
		/*
			spring 에서 Redirect(재요청) 하는 방법
			controller 메서드 반환 값에
			redirect:요청주소 작성
			되돌아가짐
		*/
		return "redirect:/param/main";
	}
}
