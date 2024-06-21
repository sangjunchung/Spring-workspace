package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Cloth;

@Mapper
public interface ClothesMapper {
	List<Cloth> getAllClothes();
	void uploadCloth(Cloth cloth);
}
