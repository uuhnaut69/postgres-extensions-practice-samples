package com.uuhnaut69.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.uuhnaut69.api.model.Product;
import com.uuhnaut69.api.util.QueryUtil;

@Mapper
public interface ProductRepository {

	@SelectProvider(method = "fullTextSearch", type = QueryUtil.class)
	@Results({ @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
			@Result(property = "keywords", column = "keywords"),
			@Result(property = "shortSummary", column = "short_summary"),
			@Result(property = "longDescription", column = "long_description"),
			@Result(property = "price", column = "price"),
			@Result(property = "inventoryCount", column = "inventory_count"),
			@Result(property = "discontinued", column = "discontinued"),
			@Result(property = "availabilityDate", column = "availability_date"), })
	List<Product> fullTextSearch(String text);

	@Insert("INSERT INTO products(id, name, keywords,short_summary,long_description,price,inventory_count,discontinued,availability_date) "
			+ " VALUES (#{id}, #{name}, #{keywords}, #{shortSummary}, #{longDescription}, #{price}, #{inventoryCount}, #{discontinued}, #{availabilityDate})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insertProduct(Product product);
}
