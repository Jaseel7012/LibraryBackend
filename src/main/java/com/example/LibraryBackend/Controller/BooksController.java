package com.example.LibraryBackend.Controller;

import com.example.LibraryBackend.Dao.BooksDao;
import com.example.LibraryBackend.Model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;

@RestController
public class BooksController {
    @Autowired
    private BooksDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String add(@RequestBody Books b){
        dao.save(b);
        return "added";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/view")
    public List<Books> view(){
        return (List<Books>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Books> Search(@RequestBody Books b){
        String title=b.getTitle();
        System.out.println(title);

        return (List<Books>) dao.SearchBook(b.getTitle()) ;
    }

    @PostMapping(path ="/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> del(@RequestBody Books b){
        String id=String.valueOf(b.getId());
        dao.deleteBook(b.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }

}
