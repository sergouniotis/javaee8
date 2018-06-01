package com.tns.webapp.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.tns.webapp.domain.Item;

@Stateless
public class ItemRepositoryImpl extends AbstractRepository<Item, Long> implements ItemRepository {

	protected ItemRepositoryImpl() {
		super(Item.class);
	}

	@Override
	public List<Item> findAll(int pageNumber, int pageSize) {
		TypedQuery<Item> query = em.createQuery("From Item", Item.class);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();

	}

}
