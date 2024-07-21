package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.repo.BookRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private BookRepository repo;

	@Override
	public List<Book> getAllProducts() {
		Iterable<Book> list = repo.findAll();
		return (List<Book>) list;
	}

	@Override
	public void Delete(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Optional<Book> getoneproduct(Integer id) {
		return repo.findById(id);
	}

	@Override
	public Integer saveProduct(Book p) {
		Book save = repo.save(p);
		return save.getId();
	}
}
