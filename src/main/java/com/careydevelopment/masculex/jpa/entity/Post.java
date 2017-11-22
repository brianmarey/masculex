package com.careydevelopment.masculex.jpa.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="slug")
	private String slug;
	
	@Column(name="intro")
	private String intro;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="title")
	private String title;
	
	@Column(name="active")
	private int active;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="post")
	private List<Product> products;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String getDateDisplay() {
		String display = "";
		
		if (date != null) {
			DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
			display = df.format(date);
		}
		
		return display;
	}
	
	
	public String getSchemaDateDisplay() {
		String display = "";
		
		if (date != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			display = df.format(date);
		}
		
		return display;
	}
}
