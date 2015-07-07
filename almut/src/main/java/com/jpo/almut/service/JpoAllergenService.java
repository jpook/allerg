package com.jpo.almut.service;

import java.util.Collection;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jpo.almut.model.Allergen;
import com.jpo.almut.model.AllergenValue;
import com.jpo.almut.model.Allergengroup;
import com.jpo.almut.model.Trial;

@ApplicationScoped
@Startup
@Singleton
public class JpoAllergenService {

	@PersistenceContext(unitName = "almut")
	EntityManager em;

	@SuppressWarnings("unchecked")
	public Collection<Allergengroup> findAllAllergenGroups() {
		Query query = em.createQuery("SELECT g FROM Allergengroup g");
		return ((Collection<Allergengroup>) query.getResultList());
	}

	public Object createAllergenGroup() {
		Allergengroup allergengroup = new Allergengroup();
		em.persist(allergengroup);
		return allergengroup;
	}

	public void deleteAllergenGroup(Allergengroup allergengroup) {
		em.remove(allergengroup);
	}

	@SuppressWarnings("unchecked")
	public Collection<Allergen> findAllAllergens() {
		Query query = em.createQuery("SELECT g FROM Allergen g");
		return ((Collection<Allergen>) query.getResultList());
	}

	public void update(Allergengroup bean) {
		em.merge(bean);
	}

	public void saveAllergenValueList(List<AllergenValue> fileList) {
		if (fileList != null) {
			for (AllergenValue av : fileList) {
				em.persist(av);
			}
		}
		// TODO : remove temp file for upload --> message, that persistence is
		// successful
	}

	@SuppressWarnings("unchecked")
	public Collection<Trial> findAllTrials() {
		Query query = em.createQuery("SELECT g FROM Trial g");
		return ((Collection<Trial>) query.getResultList());
	}

	public void updateTrial(Trial bean) {
		em.merge(bean);
	}

	public Object createTrial() {
		Trial trial = new Trial();
		em.persist(trial);
		return trial;
	}

	public Object createEntity(Class<?> clazz) {
		Object o = null;
		try {
			o = clazz.newInstance();
			em.persist(o);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return o;
	}
}
