package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.dto.GoodsItem;
import com.kh.test.mapper.GoodsItemMapper;

@Service
public class GoodsItemService {
	@Autowired
	private GoodsItemMapper goodsItemMapper;
	/*
	@Autowired 는 아래와 같은 표현을 가지고 있음
	public GoodsItemService(GoodsItemMapper goodsItemMapper){
		this.goodsItemMapper = goodsItemMapper;
	}
	*/
	
	public boolean existByName(String itemName) {
		GoodsItem count = goodsItemMapper.existByName(itemName);
		Integer totalCount = count != null ? count.getItemCount() : 0;
		
		return totalCount == 1 ? true : false;
	}
}
