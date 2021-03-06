package com.tns.webapp.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.tns.webapp.domain.Item;
import com.tns.webapp.repositories.ItemRepository;

@Stateless
public class ItemServiceImpl implements ItemService {

	@Inject
	private Validator validator;

	@EJB
	private ItemRepository itemRepository;

	@Override
	public List<Item> findAll(int pageNumber, int pageSize) {
		return itemRepository.findAll(pageNumber, pageSize);
	}

	@Override
	public Item save(Item item) {

		Set<ConstraintViolation<Item>> constraintViolations = validator.validate(item);

		Optional<RuntimeException> error = constraintViolations.stream().map(ConstraintViolation::getMessage).findFirst().map(RuntimeException::new);

		if (error.isPresent()) {
			throw error.get();
		}

		return itemRepository.save(item);
	}

}
