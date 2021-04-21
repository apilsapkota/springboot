package com.service;

import java.util.List;

import com.dto.EmployeeDTO;

public interface EmployeeService {
	public List<EmployeeDTO> showAllEmployee();

	public EmployeeDTO createLogin(String email, String password);

	public void registerNewUser(EmployeeDTO employeeDTO);

	public void updateEmployee(EmployeeDTO employeeDTO);

	public EmployeeDTO getEmployee(int id);

}
