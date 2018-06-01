package com.tns.webapp.repositories;

import java.util.List;

import javax.ejb.Local;

import com.tns.webapp.domain.Item;

@Local
public interface ItemRepository extends Repository<Item, Long> {

	List<Item> findAll(int pageNumber, int pageSize);

}
