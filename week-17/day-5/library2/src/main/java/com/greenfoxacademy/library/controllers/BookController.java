package com.greenfoxacademy.library.controllers;

import com.greenfoxacademy.library.models.Book;
import com.greenfoxacademy.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class BookController {

  @Autowired
  BookService bookService;

  //localhost:8080/books
  @GetMapping("/books")
  public String showBooks(Model model, @ModelAttribute Book book) {
    ArrayList<Book> filteredBooks;

    if (book.getTitle() != null && book.getTitle().length() != 0) {
      filteredBooks = bookService.getBooksByTitle(book.getTitle());
    } else if (book.getAuthor() != null && book.getAuthor().length() != 0) {
      filteredBooks = bookService.getBooksByAuthor(book.getAuthor());
    } else if (book.getReleaseYear() != null) {
      filteredBooks = bookService.getBooksByReleaseYear(book.getReleaseYear());
    } else {
      filteredBooks = bookService.getAllBooks();
    }

    model.addAttribute("books", filteredBooks);
    return "displaybooks";
  }

  //localhost:8080/books2
  @GetMapping("/books2")
  public String showBooks2(Model model, @RequestParam(required = false) String title,
                                        @RequestParam(required = false) String author,
                                        @RequestParam(required = false) Integer releaseYear) {
    ArrayList<Book> filteredBooks;

    if (title != null && title.length() != 0) {
      filteredBooks = bookService.getBooksByTitle(title);
    } else if (author != null && author.length() != 0) {
      filteredBooks = bookService.getBooksByAuthor(author);
    } else if (releaseYear!= null) {
      filteredBooks = bookService.getBooksByReleaseYear(releaseYear);
    } else {
      filteredBooks = bookService.getAllBooks();
    }

    model.addAttribute("books", filteredBooks);
    return "displaybooks";
  }

//  Nem működik, mert:  No primary or default constructor found for class java.lang.Integer
//  @GetMapping("/books3")
//  public String showBooks3(Model model, @ModelAttribute String title,
//                                        @ModelAttribute String author,
//                                        @ModelAttribute Integer releaseYear) {
//    ArrayList<Book> filteredBooks;
//
//    if (title != null && title.length() != 0) {
//      filteredBooks = bookService.getBooksByTitle(title);
//    } else if (author != null && author.length() != 0) {
//      filteredBooks = bookService.getBooksByAuthor(author);
//    } else if (releaseYear!= null) {
//      filteredBooks = bookService.getBooksByReleaseYear(releaseYear);
//    } else {
//      filteredBooks = bookService.getAllBooks();
//    }
//
//    model.addAttribute("books", filteredBooks);
//    return "displaybooks";
//  }


  //Ez a legtutibb megoldás, mert a keresési mező kitöltése után a submit gombra kattintva,
  //megkapjuk a leszűrt könyveket, és még a keresési mezőben is látszani fog, hogy mire szűrtünk!
  //localhost:8080/books4
  @GetMapping("/books4")
  public String showBooks4(Model model, @ModelAttribute Book book) {
    ArrayList<Book> filteredBooks;

    if (book.getTitle() != null && book.getTitle().length() != 0) {
      filteredBooks = bookService.getBooksByTitle(book.getTitle());
    } else if (book.getAuthor() != null && book.getAuthor().length() != 0) {
      filteredBooks = bookService.getBooksByAuthor(book.getAuthor());
    } else if (book.getReleaseYear() != null) {
      filteredBooks = bookService.getBooksByReleaseYear(book.getReleaseYear());
    } else {
      filteredBooks = bookService.getAllBooks();
    }

    model.addAttribute("bookToSearch", book); //itt töltjük vissza a keresési mezőbe azt, amit a felhasználó beírt (legelőször üres lesz minden mező)
    model.addAttribute("books", filteredBooks); //itt állítjuk be a leszűrt könyveket az eredmény html oldalon (legelőször az összes könyvet megjelenítjük)
    return "displaybooks2";
  }

//  //Az alábbi metódushoz meg kell írni a Book osztály üres konstruktorát, a fenti kódokban sehol nem kellett az üres konstruktor!!!
//  //localhost:8080/books5
//  @GetMapping("/books5")
//  public String showBooks5(Model model) {
//    model.addAttribute("bookToSearch", new Book()); //ezért kellett az üres konstruktor, ezt az üres könyvet töltjük bele a formba, vagyis üresen fognak megjelenni a keresési mezők
//    model.addAttribute("books", bookService.getAllBooks());
//    return "displaybooks3";
//  }

  //A fenti showbooks5 egy másik változata, de ehhez nincs szükség a Book osztály üres konstruktorára.
  //A Spring összeállít nekünk egy üres Book-ot, azt töltjük bele a form-ba, vagyis így jelenítünk meg üres keresési mezőket:
  //localhost:8080/books5
  @GetMapping("/books5")
  public String showBooks5(Model model, @ModelAttribute Book book) {
    model.addAttribute("bookToSearch", book);
    model.addAttribute("books", bookService.getAllBooks());
    return "displaybooks3";
  }

  @PostMapping("/books5")
  public String showBooks5Post(Model model, @ModelAttribute Book book) {
    ArrayList<Book> filteredBooks;

    if (book.getTitle() != null && book.getTitle().length() != 0) {
      filteredBooks = bookService.getBooksByTitle(book.getTitle());
    } else if (book.getAuthor() != null && book.getAuthor().length() != 0) {
      filteredBooks = bookService.getBooksByAuthor(book.getAuthor());
    } else if (book.getReleaseYear() != null) {
      filteredBooks = bookService.getBooksByReleaseYear(book.getReleaseYear());
    } else {
      filteredBooks = bookService.getAllBooks();
    }

    model.addAttribute("bookToSearch", book); //itt töltjük vissza a keresési mezőbe azt, amit a felhasználó beírt
    model.addAttribute("books", filteredBooks);
    return "displaybooks3";
  }

}
