package com.careydevelopment.masculex.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careydevelopment.masculex.jpa.entity.Post;

public interface ProductRepository extends BaseRepository<Post, Long> {

	@Query("SELECT p FROM Post p where p.slug=:slug")
	Post fetchBySlug(@Param("slug") String slug);
}
