package com.spring_hiber.entities;

import javax.persistence.*;
import java.util.Objects;


public class BookEntity {
    private int id;
    private String bookName;
    private String isbn;
    private Integer price;
    private Integer stock;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id &&
                Objects.equals(bookName, that.bookName) &&
                Objects.equals(isbn, that.isbn) &&
                Objects.equals(price, that.price) &&
                Objects.equals(stock, that.stock);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bookName, isbn, price, stock);
    }
}
