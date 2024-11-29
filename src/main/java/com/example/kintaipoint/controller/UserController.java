package com.example.kintaipoint.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.kintaipoint.entity.User;
import com.example.kintaipoint.form.UserEditForm;
import com.example.kintaipoint.repository.UserRepository;
import com.example.kintaipoint.security.UserDetailsImpl;
import com.example.kintaipoint.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserRepository userRepository;
	private final UserService userService;
	
	public UserController(UserRepository userRepository, UserService userService) {	
		this.userRepository = userRepository;
		this.userService = userService;
	}
	
	@GetMapping
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		
		model.addAttribute("user", user);
		
		return "accountDetails";
	}
	
	@GetMapping("/edit")
	public String edit(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		UserEditForm userEditForm = new UserEditForm(user.getId(), user.getName(), user.getTelephone(), user.getEmergencyContact(), user.getEmail());
		
		model.addAttribute("userEditForm", userEditForm);
		
		return "accountEdit";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute UserEditForm userEditForm, RedirectAttributes redirectAttributes) {
		userService.update(userEditForm);
		redirectAttributes.addFlashAttribute("successMessage", "アカウント情報を更新しました");
		
		return "redirect:/user";
	}
}