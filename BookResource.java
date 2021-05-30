package com.example.springboot;
import java.net.URI;
import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import jdk.internal.loader.Resource;

@RestController
public class BookResource {


    @Autowired
    private BookDaoService service;

    @GetMapping("/books")
    public List<Book> retrieveAllBooks(){
        return service.findAll();
    }


    @GetMapping("/books/{id}")
    public Resource<Book> readBook(@PathVariable int id){
        Book book= service.read(id);

        Resource<Book> resource=new Resource<Book>(book);   //constructor of Resource class

        ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retrieveAllBooks());
        resource.add(linkTo.withRel("all-books"));
        return resource;
    }

    //method that delete a book resource
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id){
        Book book= service.delete(id);
    }

    //method that posts a new book detail and returns the status of the book resource
    @PostMapping("/books")
    public ResponseEntity<Object> createBook(@Valid @RequestBody Book book){
        Book savedBook=service.create(book);
        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBook.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    //method that updates a new book detail and returns the status of the book resource
    @PostMapping("/books")
    public ResponseEntity<Object> updateBook(@Valid @RequestBody Book book){
        Book savedBook=service.update(book);
        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedBook.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    //method that updates a new book detail and returns the status of the book resource
    @PostMapping("/books")
    public ResponseEntity<Object> booksWithHigherPrice(String price){
        List<String> listOfBookIds = service.findBooksWithHigherPrice(price);
        String finalstr="";
        for(String el:listOfBookIds){
            finalstr=finalstr+el;
        }
        return new ResponseEntity<Object>("The list of book ids is " + finalstr,HttpStatus.OK);
    }

    //method that updates a new book detail and returns the status of the book resource
    @PostMapping("/books")
    public ResponseEntity<Object> booksWithLowerPrice(String price){
        List<String> listOfBookIds = service.findBooksWithLowerPrice(price);
        String finalstr="";
        for(String el:listOfBookIds){
            finalstr=finalstr+el;
        }
        return new ResponseEntity<Object>("The list of book ids is " + finalstr,HttpStatus.OK);
    }

    //method that updates a new book detail and returns the status of the book resource
    @PostMapping("/books")
    public ResponseEntity<Object> booksWithAuthor(String author){
        List<String> listOfBookIds = service.findBooksWithAuthor(author);
        String finalstr="";
        for(String el:listOfBookIds){
            finalstr=finalstr+el;
        }
        return new ResponseEntity<Object>("The list of book ids is " + finalstr,HttpStatus.OK);
    }


}
