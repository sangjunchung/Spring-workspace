package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.test.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/")
	public String mainPage() {
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/itemCheck")
	public Map<String, Object> getGoods(@RequestParam("checkName") String item_name){
		boolean isCheck = goodsService.getGoods(item_name);
		
		Map<String, Object> res = new HashMap<>();
		res.put("isCheck", isCheck);
		
		return res;
	}
}
