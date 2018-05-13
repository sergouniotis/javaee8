package com.tns.webapp.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tns.webapp.domain.Item;
import com.tns.webapp.services.ItemService;

@Path("items")
public class ItemResource {

	@EJB
	private ItemService itemService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> findAll() {
		return itemService.findll();
	}

}
