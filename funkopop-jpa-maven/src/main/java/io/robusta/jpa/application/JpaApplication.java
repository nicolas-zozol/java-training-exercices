package io.robusta.jpa.application;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import io.robusta.jpa.EmFactory;
import io.robusta.jpa.entities.FunkoPop;
import io.robusta.jpa.entities.Universe;

public class JpaApplication {

	public static void main(String[] args) {
		System.out.println("ddl complete");
		// We start
		EntityManager em = EmFactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("  ========== STARTING WORK ======= ");

		Universe lotr = new Universe("LotR");

		FunkoPop funkoPop = new FunkoPop("Gandalf", lotr);

		em.persist(lotr);
		em.persist(funkoPop);

		System.out.println("  ========== COMMIT ======= ");
		em.getTransaction().commit();
		em.close();

		System.out.println("  ========== NEW QUERY ======= ");

		FunkoPop gandalf = EmFactory.transaction(e -> e.find(FunkoPop.class, 1));

		// needed to close transaction
		EmFactory.getInstance().close();

	}

}
