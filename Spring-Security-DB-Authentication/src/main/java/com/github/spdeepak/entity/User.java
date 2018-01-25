package com.github.spdeepak.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private int version;

	private String firstName;

	private String lastName;

	private String username;

	private String password;

	@Column(columnDefinition = "boolean default true", nullable = false)
	private boolean accountNonExpired;

	@Column(columnDefinition = "boolean default true", nullable = false)
	private boolean accountNonLocked;

	@Column(columnDefinition = "boolean default true", nullable = false)
	private boolean credentialsNonExpired;

	@Column(columnDefinition = "boolean default true", nullable = false)
	private boolean enabled;

	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	private Set<Role> roles = new HashSet();

	public User() {
	}

	protected User(User user) {
		id = user.getId();
		username = user.getUsername();
		roles = user.getRoles();
		password = user.getPassword();
		firstName = user.getFirstName();
		lastName = user.getLastName();
		accountNonExpired = user.isAccountNonExpired();
		accountNonLocked = user.isAccountNonLocked();
		credentialsNonExpired = user.isCredentialsNonExpired();
		enabled = user.isEnabled();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
