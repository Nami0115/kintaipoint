package com.example.kintaipoint.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.kintaipoint.form.SignupForm;
import com.example.kintaipoint.service.UserService;

@Controller
public class AuthController {
	private final UserService userService;
	
	public AuthController (UserService userService) {
		this.userService = userService;		
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/loggedIn")
	public String index() {
		return "afterLoggedIn";
	}
	
	//会員登録機能
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("SignupForm", new SignupForm());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute @Validated SignupForm signupForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		//パスワードとパスワード（確認用）の入力値が一致しなければ、BindingResultオブジェクトにエラー内容を追加する
		if (!userService.isSamePassword(signupForm.getPassword(), signupForm.getPasswordConfirmation())) {
			FieldError fieldError = new FieldError(bindingResult.getObjectName(), "password", "パスワードが一致しません");
			bindingResult.addError(fieldError);
		}
		
		if (bindingResult.hasErrors()) {
			return "signup";
		}
		
		userService.create(signupForm);
		redirectAttributes.addFlashAttribute("successMessage", "会員登録が完了しました");
		
		return "redirect:/login";
	}
}
