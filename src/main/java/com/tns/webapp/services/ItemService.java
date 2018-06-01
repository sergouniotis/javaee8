package com.tns.webapp.services;

import java.util.List;

import javax.ejb.Local;

import com.tns.webapp.domain.Item;

@Local
public interface ItemService {

	List<Item> findAll(int pageNumber, int pageSize);

	Item save(Item item);

}
