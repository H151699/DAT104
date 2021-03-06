/**
 * 
 */
package no.hvl.dat104.dataaccess.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat104.dataaccess.IDeltagerEAO;
import no.hvl.dat104.model.DeltagerEntity;

/**
 * @author krist
 *
 */
@Stateless
public class DeltagerEAO implements IDeltagerEAO {

	@PersistenceContext(name = "festPersistenceUnit")
	private EntityManager em;

	@Override
	public void leggTilDeltager(DeltagerEntity d) {
		em.persist(d);
	}

	@Override
	public DeltagerEntity finnDeltager(Integer id) {
		return em.find(DeltagerEntity.class, id);
	}

	@Override
	public void oppdaterDeltager(DeltagerEntity d) {
		em.merge(d);

	}

	@Override
	public void slettDeltager(DeltagerEntity d) {
		em.remove(em.find(DeltagerEntity.class, d.getMobil()));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DeltagerEntity> alleDeltagere() {
		List<DeltagerEntity> deltagere = em
				.createQuery("SELECT d FROM DeltagerEntity d ORDER BY d.fornavn, d.etternavn").getResultList();
		return deltagere;
	}

}
