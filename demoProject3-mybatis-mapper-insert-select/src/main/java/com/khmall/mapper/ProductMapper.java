package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Goods;

@Mapper
public interface ProductMapper {
	void insertProduct(Goods goods);
	
	List<Goods> getAllProduct();
}
