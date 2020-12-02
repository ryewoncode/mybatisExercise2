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

import com.ryewoncode.mybatisRestApi2.domain.Employee;

@Mapper
public interface EmployeeMapper {
	@Insert("INSERT INTO EMPLOYEE(COMPANY_ID, EMPLOYEE_NAME, EMPLOYEE_ADDRESS) VALUES(#{employee.companyId}, #{employee.name}, #{employee.address})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(@Param("employee") Employee employee);
	
	@Select("SELECT ID, EMPLOYEE_NAME, EMPLOYEE_ADDRESS FROM EMPLOYEE")
	@Results(id="EmployeeMap", value={
		@Result(property = "companyId", column = "COMPANY_ID"),
		@Result(property = "name", column = "EMPLOYEE_NAME"),
		@Result(property = "address", column = "EMPLOYEE_ADDRESS")
	})
	List<Employee> getAll();
	
	@Select("SELECT ID, EMPLOYEE_NAME, EMPLOYEE_ADDRESS FROM EMPLOYEE WHERE ID = #{id}")
	@ResultMap("EmployeeMap")
	Employee getById(@Param("id") int id);
	
	@Select("SELECT ID, EMPLOYEE_NAME, EMPLOYEE_ADDRESS FROM EMPLOYEE WHERE COMPANY_ID = #{companyId}")
	@ResultMap("EmployeeMap")
	List<Employee> getByCompanyId(@Param("companyId") int companyId);
}
