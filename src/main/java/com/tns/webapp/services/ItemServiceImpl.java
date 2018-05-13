package com.tns.webapp.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tns.webapp.domain.Item;
import com.tns.webapp.repositories.ItemRepository;

@Stateless
public class ItemServiceImpl implements ItemService {

	@EJB
	private ItemRepository itemRepository;

	@Override
	public List<Item> findll() {
		return new ArrayList<Item>(itemRepository.findAll());
	}

}
