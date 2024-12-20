package com.example.kintaipoint.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kintaipoint.entity.User;
import com.example.kintaipoint.repository.UserRepository;

@Controller
@RequestMapping("/employeeList")
public class EmployeeListController {
	private final UserRepository userRepository;
	
	public EmployeeListController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping
	public String index(@RequestParam(name = "keyword", required = false) String keyword, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable, Model model) {
		Page<User> userPage;
		
		if (keyword != null && !keyword.isEmpty()) {
			userPage = userRepository.findByNameLike("%" + keyword + "%", pageable);
		} else {
			userPage = userRepository.findAll(pageable);
		}
		
		model.addAttribute("userPage", userPage);
		model.addAttribute("keyword", keyword);
		
		return "companyAdmin/employeeList";
	}
}
