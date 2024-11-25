//会員登録機能
package com.example.kintaipoint.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupForm {		
	@NotBlank(message = "氏名を入力してください")
	private String name;
	
	@NotBlank(message = "電話番号を入力してください")
	private String telephone;
	
	@NotBlank(message = "緊急連絡先を入力してください")
	private String emergencyContact;
	
	@NotBlank(message = "メールアドレスを入力してください")
	private String email;
	
	@NotBlank(message = "パスワードを入力してください")
	@Length(min = 8, message = "パスワードは8文字以上で入力してください")
	private String password;
	
	@NotBlank(message = "パスワード（確認用）を入力してください")
	private String passwordConfirmation;
}
