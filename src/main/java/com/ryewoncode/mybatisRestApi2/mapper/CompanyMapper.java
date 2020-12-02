package com.ryewoncode.mybatisRestApi2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ryewoncode.mybatisRestApi2.domain.Company;

import org.apache.ibatis.annotations.Many;

@Mapper
public interface CompanyMapper {
	@Insert("INSERT INTO COMPANY(COMPANY_NAME, COMPANY_ADDRESS) VALUES(#{company.name}, #{company.address})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(@Param("company") Company company);
	
	@Select("SELECT ID, COMPANY_NAME, COMPANY_ADDRESS FROM COMPANY")
	@Results(id="CompanyMap", value={
		@Result(property = "name", column = "COMPANY_NAME"),
		@Result(property = "address", column = "COMPANY_ADDRESS")
	})
	List<Company> getAll();
	
	@Select("SELECT ID, COMPANY_NAME, COMPANY_ADDRESS FROM COMPANY")
	@Results(id="CompanyMap2", value={
		@Result(property = "name", column = "COMPANY_NAME"),
		@Result(property = "address", column = "COMPANY_ADDRESS"),
		@Result(property = "employeeList", column = "id", many = @Many(select = "com.ryewoncode.mybatisRestApi2.EmployeeMapper.getByCompanyId"))
	})
	List<Company> getAllWithEmployee();
	
	@Select("SELECT ID, COMPANY_NAME, COMPANY_ADDRESS FROM COMPANY WHERE ID = #{id}")
	@ResultMap("CompanyMap")
	Company getById(@Param("id") int id);
	
	@Select("SELECT ID, COMPANY_NAME, COMPANY_ADDRESS FROM COMPANY WHERE ID = #{id}")
	@ResultMap("CompanyMap2")
	Company getByIdWithEmployee(@Param("id") int id);
}
