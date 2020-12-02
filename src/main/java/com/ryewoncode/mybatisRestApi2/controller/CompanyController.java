package com.ryewoncode.mybatisRestApi2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryewoncode.mybatisRestApi2.domain.Company;
import com.ryewoncode.mybatisRestApi2.mapper.CompanyMapper;
import com.ryewoncode.mybatisRestApi2.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("")
	public Company post(@RequestBody Company company) throws Exception {
		// companyMapper.insert(company);
		companyService.add(company);
		return company;
	}
	
	@GetMapping("")
	public List<Company> getAll() {
		return companyMapper.getAll();
	}
	
	@GetMapping("/withEmployee1")
	public List<Company> getAllWithEmployee1() {
		return companyService.getAllWithEmployee();
	}
	
	@GetMapping("/withEmployee2")
	public List<Company> getAllWithEmployee2() {
		return companyMapper.getAllWithEmployee();
	}
	
	@GetMapping("/withEmployee1/{id}")
	public Company getbyIdWithEmployee1(@PathVariable("id") int id) {
		return companyMapper.getByIdWithEmployee(id);
	}
	
	@GetMapping("/withEmployee2/{id}")
	public Company getbyIdWithEmployee2(@PathVariable("id") int id) {
		return companyMapper.getByIdWithEmployee(id);
	}
}
