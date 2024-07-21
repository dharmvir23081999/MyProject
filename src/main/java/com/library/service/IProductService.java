package com.library.service;

import java.util.List;
import java.util.Optional;

import com.library.entity.Book;




public interface IProductService {
	public List<Book> getAllProducts();
	public void Delete(Integer id);
	Optional<Book> getoneproduct(Integer id);
	Integer saveProduct(Book p);
	

}
