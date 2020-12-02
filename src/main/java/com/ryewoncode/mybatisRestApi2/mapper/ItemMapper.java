package com.ryewoncode.mybatisRestApi2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.ryewoncode.mybatisRestApi2.domain.Item;

@Mapper
public interface ItemMapper {
	@Insert("INSERT INTO ITEM(ITEM_NO, KIND, NAME, PRICE, STOCK) SELECT LPAD(IFNULL(MAX(ITEM_NO), 0) + 1, 5, 0), #{item.kind}, #{item.name}, #{item.price}, #{item.stock} FROM ITEM")
	int insert(@Param("item") Item item);

	@SelectKey(statement = "SELECT LPAD(IFNULL(MAX(ITEM_NO), 0) + 1, 5, 0) FROM ITEM", resultType = String.class, keyProperty = "itemNo", before = true)
	@Insert("INSERT INTO ITEM(ITEM_NO, KIND, NAME, PRICE, STOCK) VALUES( #{itemNo}, #{item.kind}, #{item.name}, #{item.price}, #{item.stock})")
	int insertReturn(@Param("item") Item item);
	
	@Select("SELECT ITEM_NO, KIND, NAME, PRICE, STOCK FROM ITEM")
	@Results({@Result(property = "itemNo", column = "ITEM_NO")})
	List<Item> getAll();
}
