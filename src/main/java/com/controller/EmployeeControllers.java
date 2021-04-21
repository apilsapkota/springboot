package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;
import com.service.EmployeeService;

@Controller
public class EmployeeControllers {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/showAll")
	public String ShowAllEmployees(Model model) {
		List<EmployeeDTO> empList = employeeService.showAllEmployee();
		model.addAttribute("empList", empList);
		return "showAllEmployee";

	}

	@GetMapping("/login")
	public String createLogin() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/getLogin")
	public String getLogin(@RequestParam String email, String password, Model model) {
		EmployeeDTO employeeDto = employeeService.createLogin(email, password);
		if (employeeDto != null) {
			// model.addAttribute("empList",employeeDto);
			// return "sucessjsp";
			// return "showAllEmployee";
			return "redirect:/showAll";
		}
		return null;
	}

	@PostMapping("/registration")
	public String registerNewUser(@ModelAttribute EmployeeDTO employeeDTO) {
		employeeService.registerNewUser(employeeDTO);
		System.out.println(employeeDTO);
		return "redirect:/showAll";
	}

	@GetMapping("/updateEmployee")
	public String showUpdatePage(@RequestParam("employeeId") int id, Model model) {
		EmployeeDTO employeeDto = employeeService.getEmployee(id);
		System.out.println("Employee to update: " + employeeDto);
		if (employeeDto != null) {
			model.addAttribute("employeeToUpdate", employeeDto);
			return "update";
		} else {
			model.addAttribute("idNotFound", "Employee ID not found!");
			return "redirect:/showAll";
		}
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute EmployeeDTO employeeDto) {
		employeeService.updateEmployee(employeeDto);
		return "redirect:/showAll";
	}

}
