package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MagicDaoRepository;
import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	MagicDaoRepository magicDaoRepository;

	@Override
	public List<EmployeeDTO> showAllEmployee() {
		List<EmployeeEntity> employeeEntityList = magicDaoRepository.findAll();
		
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();
		for (EmployeeEntity employeeEntity : employeeEntityList) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			employeeDTOList.add(employeeDTO);
		}
		return employeeDTOList;
	}

	@Override
	public EmployeeDTO createLogin(String email, String password) {
		EmployeeEntity employeeEntity = magicDaoRepository.findByEmailAndPassword(email, password);
		//List<EmployeeEntity> employeeEntity = magicDaoRepository.findByEmailAndPassword(email, password);
		if (employeeEntity != null) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			return employeeDTO;
		}
		return null;
	}

	@Override
	public void registerNewUser(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDTO, employeeEntity);
		magicDaoRepository.save(employeeEntity);
		System.out.println(employeeEntity);

	}

	@Override
	public void updateEmployee(EmployeeDTO employeeDTO) {
		EmployeeEntity employee = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDTO, employee);
		System.out.println("Employee to update at Service: " + employee);
		magicDaoRepository.save(employee);

	}

	@Override
	public EmployeeDTO getEmployee(int id) {
		Optional<EmployeeEntity> tempEmployee = magicDaoRepository.findById(id);
		System.out.println("Got employee entity: " + tempEmployee);
		if (tempEmployee.isPresent()) {
			System.out.println("Inside isPresent()");
			EmployeeDTO employeeDto = new EmployeeDTO();
			BeanUtils.copyProperties(tempEmployee.get(), employeeDto);
			return employeeDto;
		}
		return null;
	}

}
