package com.careydevelopment.masculex.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careydevelopment.masculex.jpa.entity.Context;

public interface ContextRepository extends BaseRepository<Context, Long> {

	@Query("SELECT c FROM Context c where c.name=:name")
	Context fetchByName(@Param("name") String name);
}
