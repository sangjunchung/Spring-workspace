package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.MemberDTO;

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
	
	/*
		책 제목 : <input type="text" name="title">
		책 저자 : <input type="text" name="writer">
		가격 : <input type="number" name="price">
		출판사 : <input type="text" name="publisher"> 
	*/
	
	@PostMapping("test2")
	public String paramTest2(
		@RequestParam(/*value=*/"title"/*, required=true*/) String title,
		@RequestParam("writer") String writer,
		@RequestParam("price") int price,
		@RequestParam(value="publisher", defaultValue="교보문고", required=false) String publisher
	) {
		log.info("문제 없이 insert 가능한지 확인");
		log.debug("title : "+title);
		log.debug("writer : "+writer);
		log.debug("price : "+price);
		log.debug("publisher : "+publisher);
		
		return "redirect:/param/main";
	}
	
	/* 3. @RequestParam 여러 개의 파라미터 */
	@PostMapping("test3")
	public String paramTest3(
			@RequestParam(value="color", required=false) String[] colorArr,
			@RequestParam(value="fruit", required=false) List<String> fruitList,
			@RequestParam Map<String, Object> paramMap
			) {
		
		log.info("colorArr : "+Arrays.toString(colorArr));
		log.info("fruitlist : "+fruitList);
		log.info("paramMap : "+paramMap);
		// -> key(name 속성값)이 중복되면 덮어쓰기가 됨
		// -> 같은 name 속성 파라미터가 String[], List로 저장이 되는 것은 힘듬
		
		return "redirect:/param/main";
	}
	
	/*
		DTO 와 VO
		
		DTO : Data Transfer Object - 데이터 캡슐화를 통해 데이터를 전달하고 관리
			 -> 한 계층에서 다른 계층으로 데이터 전송을 위해 사용
			 -> 계층이란? html에서 DB로 전송(html 계층에서 DB 계층으로 전송)
				
		VO : Value Object - 값 자체를 표현하는 객체
		 	-> 한 번 값이 생성되면 그 값을 변경할 수 없음
		 	-> 생성자를 통해 값을 설정하고 setter 메서드를 제공하지는 않음
	*/
	
	/*
		@ModelAttribute
		 - DTO(또는 VO)와 같이 사용하는 어노테이션
		 - 전달받은 파라미터(매개변수)의 name 속성 값이
		 - 같이 사용되는 DTO의 필드명과 같다면
		 - 자동으로 setter를 호출해서 필드에 값을 저장
		 
		 [주의사항]
		  - DTO에 기본 생성자가 필수로 존재해야함
		  - DTO에 setter가 필수로 존재해야함
		  
		  어노테이션이 자동으로 생략 가능
		  
		  @ModelAttribute 이용해 값이 필드에 저장된 객체를 커맨트 객체라고함
	 
	*/
	
	@PostMapping("test4")
	public String paramtest4(/*@ModelAttribute*/ MemberDTO inputMember){
		// lombok으로 만든 setter/getter로 값 가져오거나 설정하기
		MemberDTO mem = new MemberDTO();
		mem.getMemberAge(); // getter 를 통해 나이 가져오기		
		mem.getMemberId(); 
		mem.getMemberName();
		mem.getMemberPw();
		
		mem.setMemberAge(0); // setter 를 통해 나이 설정하기
		mem.setMemberId("010"); 
		mem.setMemberName("가나다");
		mem.setMemberPw("pass01");
		// 굳이 따로 만들지 않아도 lombok @Getter @Setter 를 만들어 가져오기 때문에
		// 사용 가능한 것
		
		log.info("inputMember에 대한 정보 가져오기 : "+inputMember);
		log.info("mem 에 대한 정보 가져오기 : " +mem);
		
		return "redirect:/param/main";
	}
}
