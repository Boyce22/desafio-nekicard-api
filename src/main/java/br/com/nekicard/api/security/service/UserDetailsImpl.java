package br.com.nekicard.api.security.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.nekicard.api.exception.UserBuildException;
import br.com.nekicard.api.security.domain.User;
import br.com.nekicard.api.security.enuns.RoleEnum;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String email;

	private Long loggedUserId;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Integer id, String email, String password, Long loggedUserId,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.loggedUserId = loggedUserId;
	}

	public static UserDetailsImpl build(User user) {

		try {
			List<GrantedAuthority> authorities = user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

			var userAdministrador = user.getRoles().stream()
					.anyMatch(role -> role.getName().equals(RoleEnum.ROLE_ADMINISTRATOR));
			
			if (userAdministrador) {
				return new UserDetailsImpl(user.getId(), user.getEmail(), user.getPassword(),
						user.getAdministrator().getId(), authorities);
			}

		} catch (Exception e) {
			throw new UserBuildException("Error building UserDetailsImpl from user:" + e.getMessage());
		}

		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Long getLoggedUserId() {
		return loggedUserId;
	}

	public void setLoggedUserId(Long loggedUserId) {
		this.loggedUserId = loggedUserId;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public String getUsername() {
		return email;
	}
}
