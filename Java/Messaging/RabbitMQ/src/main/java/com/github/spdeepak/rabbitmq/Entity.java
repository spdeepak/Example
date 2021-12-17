package com.github.spdeepak.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity {

	private Long id;

	private String firstName;

	private String middleName;

	private String lastName;

	private boolean set = true;

	private Entity entity;
}
