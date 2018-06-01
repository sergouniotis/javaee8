package com.tns.webapp.resources;

import java.text.MessageFormat;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tns.webapp.domain.Item;
import com.tns.webapp.domain.User;
import com.tns.webapp.services.ItemService;

@Path("items/{itemId}")
public class ItemResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemResource.class);

	@EJB
	private ItemService itemService;

	@Inject
	private User user;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> findAll(@BeanParam PaginationInfo paginationInfo) {
		LOGGER.info(MessageFormat.format("Current user {0}", user));
		return itemService.findAll(paginationInfo.getPageNumber(), paginationInfo.getPageSize());
	}

	@GET
	@Path("foo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getFoo(@PathParam("itemId") Long itemId, @PathParam("id") Long id, @BeanParam PaginationInfo paginationInfo) {
		LOGGER.info(MessageFormat.format("Current user {0}", user));
		return itemService.findAll(paginationInfo.getPageNumber(), paginationInfo.getPageSize());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Item save(Item item) {
		return itemService.save(item);
	}

}
