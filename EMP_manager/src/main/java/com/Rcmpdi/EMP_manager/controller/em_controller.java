package com.Rcmpdi.EMP_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Rcmpdi.EMP_manager.entity.Employee;
import com.Rcmpdi.EMP_manager.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class em_controller {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m){
		List<Employee> emp = service.getAllEmp();
		m.addAttribute("emp",emp);
		return"index";
	}
	@GetMapping("/addemp")
	public String addemployee() {
		
		return"add_emp";
	}
	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute Employee emp, HttpSession session) {
	    service.addEmp(emp);
	    session.setAttribute("msg", "Employee details saved successfully!");
	    return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		
		Employee e = service.getEMpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Employee Updated Succesfully..");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {
		service.deleteEMp(id);
		session.setAttribute("msg", "Employee Deleted Succesfully..");
		return "redirect:/";
	}
	@GetMapping("/view/{id}")
	public String viewDetail(@PathVariable int id, Model m) {
		Employee e = service.getEMpById(id);
		m.addAttribute("emp",e);
		return "views";
		
	}
}
