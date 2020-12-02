package com.ryewoncode.mybatisRestApi2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryewoncode.mybatisRestApi2.domain.Item;
import com.ryewoncode.mybatisRestApi2.mapper.ItemMapper;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemMapper itemMapper;
	
	@PostMapping("")
	public int post(@RequestBody Item item) {
		return itemMapper.insert(item);
	}
	
	@PostMapping("/insert")
	public Item post2(@RequestBody Item item) {
		itemMapper.insertReturn(item);
		return item;
	}
	
	@GetMapping("")
	public List<Item> getAll() {
		return itemMapper.getAll();
	}
}
