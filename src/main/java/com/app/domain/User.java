package com.app.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.encryption.MD5;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table

public class User implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3627373002285539022L;
 	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	@Column(unique = true,length=50)
	private String username;
	
	@Column(nullable=false,length=50)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Column(nullable=false,length=20)
	private String role;
	
	private boolean enable =true;
	
	public boolean isEnable() {
		return enable;
	}
 
	public void setEnable(boolean enable) {
		this.enable = enable;
	}


	public void setUsername(String username) {
		this.username = username;
	}
 
	
	public void setPassword(String password) {
		
		this.password = MD5.getMd5(password);
	}

	@JsonIgnore
	public boolean isEnabled() {
		return enable;
	}

	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
