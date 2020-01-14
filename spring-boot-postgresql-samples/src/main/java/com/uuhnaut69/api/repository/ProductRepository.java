package com.uuhnaut69.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.uuhnaut69.api.model.Product;
import com.uuhnaut69.api.util.MybatisUtil;

@Mapper
public interface ProductRepository {

	@SelectProvider(method = "fullTextSearch", type = MybatisUtil.class)
	@Results({ @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
			@Result(property = "keywords", column = "keywords"),
			@Result(property = "shortSummary", column = "short_summary"),
			@Result(property = "longDescription", column = "long_description"),
			@Result(property = "price", column = "price"),
			@Result(property = "inventoryCount", column = "inventory_count"),
			@Result(property = "discontinued", column = "discontinued"),
			@Result(property = "availabilityDate", column = "availability_date"), })
	List<Product> fullTextSearch(String text);
}