package com.example.LibraryBackend.Dao;

import com.example.LibraryBackend.Model.Books;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BooksDao extends CrudRepository<Books,Integer> {

    @Query(value = "SELECT `id`, `imageurl`, `price`, `publisher`, `title` FROM `books` WHERE `title` =:title",nativeQuery = true)
    List<Books> SearchBook(@Param("title") String title);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `books` WHERE `id`=:id",nativeQuery = true)
    void deleteBook(@Param("id") Integer id);

}
