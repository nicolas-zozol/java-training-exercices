package io.robusta.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import feign.Feign;
import io.robusta.jpa.EmFactory;
import io.robusta.jpa.entities.FunkoPop;

public class FunkoPopDao {

	EntityManager em;

	public FunkoPopDao() {

	}

	public FunkoPop findFunkoPopById(int funkoPopId) {
		return EmFactory.transaction(e -> e.find(FunkoPop.class, funkoPopId));
	}

	public FunkoPop findFunkoPopById(EntityManager em, int funkoPopId) {
		return em.find(FunkoPop.class, funkoPopId);
	}

	public List<FunkoPop> findAll() {
		return EmFactory.transaction(em -> em.createQuery("SELECT f FROM FunkoPop f", FunkoPop.class).getResultList());
	}

	public void delete(int id) {
		EmFactory.voidTransaction(em -> {
			FunkoPop f = this.findFunkoPopById(em, id);
			if (f != null) {
				em.remove(f);
			}

		});
	}

	public FunkoPop createOrUpdate(FunkoPop pop) {
		System.out.println("pop is " + pop);
		return EmFactory.transaction(em -> {

			if (pop.getId() != null) {
				FunkoPop existing = this.findFunkoPopById(em, pop.getId());

				if (existing != null) {
					// update
					existing.setName(pop.getName());
					existing.setUniverse(pop.getUniverse());
					existing.setWaterproof(pop.isWaterproof());
					existing.setLongitude(pop.getLongitude());
					existing.setLatitude(pop.getLatitude());

					return existing;
				}

			}

			pop.setId(null);
			em.persist(pop);
			return pop;

		});
	}

	public List<FunkoPop> search(String name, String universe) {
		List<FunkoPop> result = new ArrayList<>();

		return result;
	}

	private boolean isValid(String value, String criteria) {
		return criteria == null || (value != null && value.contains(criteria));
	}
}
