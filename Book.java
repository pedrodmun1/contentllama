package com.example.springboot;

import java.util.Date;

public class Book {

    private Integer id;
    private String name;
    private String author;
    private String price;
    private String content;

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", content=" + content +
                '}';
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Book(Integer id, String name, String author, String price, String content) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
