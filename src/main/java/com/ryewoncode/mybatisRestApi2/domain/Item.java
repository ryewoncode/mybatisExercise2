package com.ryewoncode.mybatisRestApi2.domain;

import lombok.Data;

//@Getter
//@Setter
@Data
public class Item {
	private String itemNo;
	private String kind;
	private String name;
	private int price;
	private int stock;
}
