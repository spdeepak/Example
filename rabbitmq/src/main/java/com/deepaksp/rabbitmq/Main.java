package com.deepaksp.rabbitmq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		Entity entity1 = new Entity();
		entity1.setId(1L);
		entity1.setFirstName("Deepak1");
		entity1.setMiddleName("Sunanda");
		entity1.setLastName("Prabhakar");

		Entity entity2 = new Entity();
		entity2.setId(2L);
		entity2.setFirstName("Deepak1");
		entity2.setMiddleName("Sunanda");
		entity2.setLastName("Prabhakar");
		entity2.setEntity(entity1);

		List<Entity> entities = new ArrayList<>();
		//		entities.add(entity1);
		entities.add(entity2);
		process(entities);

		entities.stream()
				.forEach(System.out::println);
	}

	private static void process(final List<Entity> entities) {
		entities.stream()
				.forEach(e -> {
					e.setId(e.getId() + 2);
					if (e.getId() % 2 == 0) {
						e.setSet(false);
					}
					e.getEntity().setId(e.getEntity().getId() + 2);
				});
	}
}
