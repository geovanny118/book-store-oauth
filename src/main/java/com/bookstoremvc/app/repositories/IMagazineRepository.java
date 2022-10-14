package com.bookstoremvc.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bookstoremvc.app.entities.Magazine;

public interface IMagazineRepository extends CrudRepository<Magazine, Integer> {
	
	@Query(value = "SELECT * FROM magazines", nativeQuery = true)
	public List<Magazine> getAllMagazines();
}
