package com.careydevelopment.masculex.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careydevelopment.masculex.jpa.entity.Post;

public interface PostRepository extends BaseRepository<Post, Long> {

	@Query("SELECT p FROM Post p where p.slug=:slug")
	Post fetchBySlug(@Param("slug") String slug);
	
    @Query("SELECT p FROM Post p order by p.date desc")
    Page<Post> findPosts(Pageable page);
}
