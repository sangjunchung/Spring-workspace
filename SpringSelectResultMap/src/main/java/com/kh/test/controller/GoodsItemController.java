package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.test.service.GoodsItemService;

@RestController
public class GoodsItemController {
	@Autowired
	private GoodsItemService goodsItemService;
	
	@GetMapping("/gooditem/check")
	public Map<String, Object> existByName(@RequestParam String itemName) {
		Map<String, Object> res = new HashMap<>();
		boolean isCheck = goodsItemService.existByName(itemName);
		
		// ajax는 html을 return으로 작성하지 않음
		// 왜냐하면 html 파일을 불러오는 것이 아니라
		// html 파일의 일부분만 설정하는 것이기 때문
		
		res.put("isCheck", isCheck);
		
		return res; // Map으로 전달된 key value를 다시 html 파일에서 중복체크에 전달
	}
}
