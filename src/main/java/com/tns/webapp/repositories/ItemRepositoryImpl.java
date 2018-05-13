package com.tns.webapp.repositories;

import javax.ejb.Stateless;

import com.tns.webapp.domain.Item;

@Stateless
public class ItemRepositoryImpl extends AbstractRepository<Item, Long> implements ItemRepository {

	protected ItemRepositoryImpl() {
		super(Item.class);
	}

}
