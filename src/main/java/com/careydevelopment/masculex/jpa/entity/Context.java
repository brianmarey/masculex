package com.careydevelopment.masculex.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "context")
public class Context {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="logoUrl")
	private String logoUrl;
	
	@Column(name="homeUrl")
	private String homeUrl;

	@Column(name="title")
	private String title;
	
	@Column(name="tagline")
	private String tagline;

	@Column(name="header1")
	private String header1;
	
	@Column(name="header2")
	private String header2;
	
	@Column(name="splash")
	private String splash;
	
	@Column(name="faviconUrl")
	private String faviconUrl;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getHomeUrl() {
		return homeUrl;
	}

	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getHeader1() {
		return header1;
	}

	public void setHeader1(String header1) {
		this.header1 = header1;
	}

	public String getHeader2() {
		return header2;
	}

	public void setHeader2(String header2) {
		this.header2 = header2;
	}

	public String getSplash() {
		return splash;
	}

	public void setSplash(String splash) {
		this.splash = splash;
	}

	public String getFaviconUrl() {
		return faviconUrl;
	}

	public void setFaviconUrl(String faviconUrl) {
		this.faviconUrl = faviconUrl;
	}
}
