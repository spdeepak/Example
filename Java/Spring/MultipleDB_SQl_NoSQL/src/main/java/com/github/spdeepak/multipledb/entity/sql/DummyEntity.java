package com.github.spdeepak.multipledb.entity.sql;

import com.github.spdeepak.multipledb.entity.Dummy;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = "multiple")
public class DummyEntity extends Dummy {

	@Id
	@GeneratedValue
	private Long id;

	public DummyEntity(String description) {
		super(description);
	}

}
