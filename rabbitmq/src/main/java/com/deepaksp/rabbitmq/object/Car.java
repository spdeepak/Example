package com.deepaksp.rabbitmq.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

	private Long id;

	private String name;

	private String brandName;
}
