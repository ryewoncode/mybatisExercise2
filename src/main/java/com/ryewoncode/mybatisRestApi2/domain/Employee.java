package com.ryewoncode.mybatisRestApi2.domain;

import lombok.Data;

@Data
public class Employee {
	private int id;
	private int companyId;
	private String name;
	private String address;
}
