package br.com.cursoapirest.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {
	public static String gerarByCript(String senha) {
		if(senha == null) {
			return senha;
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(senha);
	}
	
	public static boolean validarSenha(String senha,String senhaEncript){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(senha, senhaEncript);
	}
}
