package com.ryewoncode.mybatisRestApi2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ryewoncode.mybatisRestApi2.domain.Company;
import com.ryewoncode.mybatisRestApi2.mapper.CompanyMapper;
import com.ryewoncode.mybatisRestApi2.mapper.EmployeeMapper;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyMapper  companyMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Company> getAllWithEmployee() {
		List<Company> companyList = companyMapper.getAll();
		if (companyList != null && companyList.size() > 0) {
			for (Company company : companyList) {
				company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
			}
		}
		return companyList;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Company add(Company company) {
		companyMapper.insert(company);
		// add company into legacy system
		if (true) {
			throw new RuntimeException("Legacy Exception");
		}
		return company;
	}
}
