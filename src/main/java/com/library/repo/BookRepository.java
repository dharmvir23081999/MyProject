package com.library.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.library.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
	
	public List<Book> findByName(String name);

}
