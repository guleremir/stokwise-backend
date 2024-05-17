package com.tobeto.entities.user;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = { "roles" }) // ilişkilerde döngüye girmemesi için
@EqualsAndHashCode(exclude = { "roles" }) // ilişkilerde döngüye girmemesi için
public class User {

	@Id
	@GeneratedValue
	private UUID id;

	@Column(unique = true)
	private String email;
	private String password;
	private boolean deleted = false;

	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

}
