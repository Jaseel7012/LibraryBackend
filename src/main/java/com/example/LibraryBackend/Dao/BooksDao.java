package com.example.LibraryBackend.Dao;

import com.example.LibraryBackend.Model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksDao extends CrudRepository<Books,Integer> {

}
