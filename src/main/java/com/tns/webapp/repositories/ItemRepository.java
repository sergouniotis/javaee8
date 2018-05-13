package com.tns.webapp.repositories;

import javax.ejb.Local;

import com.tns.webapp.domain.Item;

@Local
public interface ItemRepository extends Repository<Item, Long> {

}
