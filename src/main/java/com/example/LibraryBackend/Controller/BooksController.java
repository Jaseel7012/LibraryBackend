package com.example.LibraryBackend.Controller;

import com.example.LibraryBackend.Dao.BooksDao;
import com.example.LibraryBackend.Model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
    @Autowired
    private BooksDao dao;

    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String add(@RequestBody Books b){
        dao.save(b);
        return "added";
    }

}
