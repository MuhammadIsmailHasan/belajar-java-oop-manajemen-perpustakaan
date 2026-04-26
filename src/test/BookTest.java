package test;

import entity.Book;
import repository.BookRepository;
import repository.BookRepositoryImpl;
import service.BookService;
import service.BookServiceImpl;

public class BookTest {

    public static void main(String[] args) {
//        testShowBook();
//        testAddBook();
        testRemoveBook();

    }
    public static void testShowBook() {
        Book php = new Book();
        php.setTitle("Belajar php dasar");
        php.setStock(100);
        php.setRegisterNumber(1001);

        Book java = new Book();
        java.setTitle("Belajar java dasar");
        java.setStock(50);
        java.setRegisterNumber(2001);


        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        bookRepository.books[0] = php;
        bookRepository.books[1] = java;
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);

        bookService.showBook();
    }

    public static void testAddBook() {
        Book java = new Book();
        java.setTitle("Belajar pemrograman java");
        java.setStock(15);

        Book js = new Book();
        js.setTitle("Belajar pemrograman js");
        js.setStock(16);

        Book pyton = new Book();
        pyton.setTitle("Belajar pemrograman pyton");
        pyton.setStock(17);

        Book cplus = new Book();
        cplus.setTitle("Belajar pemrograman cplus");
        cplus.setStock(18);

        Book css = new Book();
        css.setTitle("Belajar pemrograman css");
        css.setStock(19);

        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);
        bookService.addBook(java);
        bookService.addBook(js);
        bookService.addBook(pyton);
        bookService.addBook(css);
        bookService.showBook();
    }

    public static void testRemoveBook() {

        Book java = new Book();
        java.setTitle("Belajar pemrograman java");
        java.setStock(15);

        Book js = new Book();
        js.setTitle("Belajar pemrograman js");
        js.setStock(16);

        Book pyton = new Book();
        pyton.setTitle("Belajar pemrograman pyton");
        pyton.setStock(17);

        Book cplus = new Book();
        cplus.setTitle("Belajar pemrograman cplus");
        cplus.setStock(18);

        Book css = new Book();
        css.setTitle("Belajar pemrograman css");
        css.setStock(19);

        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);
        bookService.addBook(java);
        bookService.addBook(js);
        bookService.addBook(pyton);
        bookService.addBook(css);

        bookService.showBook();
        bookService.removeBook(3);

        bookService.showBook();
    }

}
