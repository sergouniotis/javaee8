package com.tns.webapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "itemIdGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "itemIdGenerator", sequenceName = "items_pk_seq")
	private Long id;

	@Column(name = "title")
	private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
