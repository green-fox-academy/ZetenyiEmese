package com.greenfoxacademy.library.services;

import com.greenfoxacademy.library.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

  private ArrayList<Book> books;

  public BookService() {
    this.books = new ArrayList<>();
    books.add(new Book("Cat's Cradle", "Kurt Vonnegut", 1963));
    books.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1968));
    books.add(new Book("Így lettem", "Michelle Obama", 2018));
    books.add(new Book("Így lettem Második Kiadás", "Michelle Obama", 2018));
    books.add(new Book("Rumini", "Berg Judit", 2007));
    books.add(new Book("Rumini és a négy jogar", "Berg Judit", 2009));
    books.add(new Book("Rumini datolyaparton", "Berg Judit", 2010));
    books.add(new Book("Rumini kapitány", "Berg Judit", 2012));
  }

  public ArrayList<Book> getAllBooks() {
    return books;
  }

  public void save(Book book) {
    books.add(book);
  }

  public Book getBookById(int id) {
    for(Book book : books) {
      if (book.getId() == id) {
        return book;
      }
    }
    return null;
  }

  public ArrayList<Book> getBooksByAuthor(String author) {
    ArrayList<Book> filteredBooks = new ArrayList<>();

    for(Book book : books) {
      if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
        filteredBooks.add(book);
      }
    }
    return filteredBooks;
  }

  public ArrayList<Book> getBooksByTitle(String title) {
    ArrayList<Book> filteredBooks = new ArrayList<>();

    for(Book book : books) {
      if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
        filteredBooks.add(book);
      }
    }
    return filteredBooks;
  }

  public ArrayList<Book> getBooksByReleaseYear(Integer year) {
    ArrayList<Book> filteredBooks = new ArrayList<>();

    for(Book book : books) {
      if (book.getReleaseYear().equals(year)) {
        filteredBooks.add(book);
      }
    }
    return filteredBooks;
  }

}
