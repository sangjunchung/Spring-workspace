package com.kh.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.test.dto.GoodsItem;

// MapperScan은 여기서 사용하는 것이 아니라 
// @SpringBootApplication 위 아래 상관없이 
// @MapperScan(com.kh.test.mapper) 넣어줌

@Mapper 
public interface GoodsItemMapper {
	GoodsItem existByName(@Param("itemName") String itemName);
}
