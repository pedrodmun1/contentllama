package com.example.springboot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class BookDaoService {


    private static final Book booka = new Book(1, "Hyperion","Dan Simmons","20", "There was a time when...");
    private static final Book bookb = new Book(2, "A Fire Upon the Deep","Vernor Vinge","13", "There was a time when...2");
    private static final Book bookc = new Book(3, "Harry Potter and the Goblet of Fire","J. K. Rowling","31", "There was a time when...3");
    private static final Book bookd = new Book(4, "Ancillary Justice","Ann Leckie","29", "There was a time when...4");
    private static final Book booke = new Book(5, "A Deepness in the Sky","Vernor Vinge","15", "There was a time when...5");

    private static final List<Book> books = new ArrayList<Book>(){{
        add(booka);
        add(bookb);
        add(bookc);
        add(bookd);
        add(booke);
    }};
    public static int booksCount=books.size();


    //method that retrieve all books from the list
    public List<Book> findAll(){
        return books;
    }

    //method that adds a new book to the list
    public Book read(int id){
        Book finalbook=null;
        for(Book book:books) {
            if(book.getId()==id) finalbook=book;
            break;
        }
        return finalbook;
    }

    //method that adds a new book to the list
    public Book create(Book book){
        if(book.getId()==null){
            book.setId(++booksCount);
        }
        books.add(book);
        return book;
    }

    //method that uptades a book in the list
    public Book update(Book newbook){
        boolean bingo = false;
        int i = 0;
        for(Book book:books){
           if(book.getId()==newbook.getId()){
               bingo = true;
               books.set(i,newbook);
               break;
           }
           i++;
        }
        if(bingo){
            return newbook;
        }else{
            return null;
        }
    }

    //method that deletes a book in the list
    public Book delete(int id){
        int i = 0;
        Book result = null;
        for(Book book:books){
            if(book.getId()==id){
                result=book;
                books.remove(i);
                break;
            }
            i++;
        }
        return result;
    }

    //method that find a particular book from the list (by id)
    public List<String> findBooksWithHigherPrice(String price){
        List<String> strOfIds = new LinkedList<String>();

        for(Book book:books){
            if(Integer.getInteger(book.getPrice())>=Integer.getInteger(price))
                strOfIds.add(book.getId().toString());
        }
        return strOfIds;
    }

    //method that find a particular book from the list (by id)
    public List<String> findBooksWithLowerPrice(String price){
        List<String> strOfIds = new LinkedList<String>();

        for(Book book:books){
            if(Integer.getInteger(book.getPrice())<Integer.getInteger(price))
                strOfIds.add(book.getId().toString());
        }
        return strOfIds;
    }

    //method that find a particular book from the list (by id)
    public List<String>  findBooksWithAuthor(String author){
        List<String> strOfIds = new LinkedList<String>();

        for(Book book:books){
            if(book.getAuthor()==author)
                strOfIds.add(book.getId().toString());
        }
        return strOfIds;
    }

}

