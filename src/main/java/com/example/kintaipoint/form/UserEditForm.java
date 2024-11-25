package com.example.kintaipoint.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEditForm {
	@NotNull
	private Integer id;
	
	@NotBlank(message = "氏名を入力してください")
	private String name;
	
	@NotBlank(message = "電話番号を入力してください")
	private String telephone;
	
	@NotBlank(message = "緊急連絡先を入力してください")
	private String emergencyContact;
	
	@NotBlank(message = "メールアドレスを入力してください")
	private String email;	
}
