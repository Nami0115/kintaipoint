//既存のパスワードのハッシュ化
package com.example.kintaipoint.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
	public static void main(String[] args) {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	String rawPassword = "";
	String hashedPassword = encoder.encode(rawPassword);
	System.out.println(hashedPassword);
	}
}