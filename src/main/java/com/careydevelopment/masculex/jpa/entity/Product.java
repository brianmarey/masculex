package com.careydevelopment.masculex.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;
	
	@Column(name="link")
	private String link;
	
	@Column(name="imageUrl")
	private String imageUrl;
	
	@Column(name="highestPrice")
	private String highestPrice;
	
	@Column(name="lowestPrice")
	private String lowestPrice;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getHighestPrice() {
		return highestPrice;
	}

	public void setHighestPrice(String highestPrice) {
		this.highestPrice = highestPrice;
	}

	public String getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(String lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	
	public String getPriceRange() {
		String priceRange = "";
		
		if (highestPrice != null && lowestPrice != null && highestPrice.length() > 1 && lowestPrice.length() > 1) {
			priceRange = " (" + lowestPrice + " - " + highestPrice + ")";
		}
		
		return priceRange;
	}
}
