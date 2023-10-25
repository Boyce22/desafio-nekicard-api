package br.com.nekicard.api.security.dto;

import java.util.List;

public class JwtResponseDTO {

	private String token;
	private String type = "Bearer";
	private Long id;
	private String email;
	private List<String> roles;
	private Integer loggedUserId;

	public JwtResponseDTO(String accessToken, Long id, String email, List<String> roles, Integer loggedUserId) {
		this.token = accessToken;
		this.id = id;
		this.email = email;
		this.roles = roles;
		this.loggedUserId = loggedUserId;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public Integer getLoggedUserId() {
		return loggedUserId;
	}

	public void setLoggedUserId(Integer loggedUserId) {
		this.loggedUserId = loggedUserId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}
}
