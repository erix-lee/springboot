package com.app.web;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.User;
import com.app.encryption.MD5;
import com.app.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 提供登录等身份认证
 * 
 * @author liyiran
 * @date 2017年3月26日
 */
@RestController
@RequestMapping(value = "/") 
public class HomeRestController  extends AuditLogSupport{
	@Autowired 
	private UserRepository userRepository;

	@RequestMapping("/user")
	public User user(Principal principal) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUsername = auth.getName();
		return userRepository.findOneByUsername(loggedUsername);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> login(@RequestParam String username, @RequestParam String password,
			HttpServletResponse response) throws IOException {
		String token = null;
		User ligUser = userRepository.findOneByUsername(username);
		Map<String, Object> tokenMap = new HashMap<String, Object>();
		if (ligUser != null && ligUser.getPassword().equals(MD5.getMd5(password)) &&ligUser.isEnable()) {
			token = Jwts.builder().setSubject(username).claim("roles", ligUser.getRole()).setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
			tokenMap.put("token", token);
			tokenMap.put("user", ligUser);
			log(username, "登录","成功");
			return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.OK);
		} else {
			tokenMap.put("token", null);
			log(username, "登录","失败");
			return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.UNAUTHORIZED);
		}

	}
	@RequestMapping(value = "/logout1", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> logout() throws IOException {
		Map<String, String> tokenMap = new HashMap<String, String>();
		tokenMap.put("success","ok");

			log("退出","成功");
			return new ResponseEntity<Map<String, String>>(tokenMap, HttpStatus.OK);
	

	}
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> getRoles() {
		Map<String, String> m = new HashMap<String, String>();
		m.put("ADMIN", "管理员");
		m.put("OP", "操作员");
		m.put("USER", "用户");

		return new ResponseEntity<Map<String, String>>(m, HttpStatus.OK);

	}

}
