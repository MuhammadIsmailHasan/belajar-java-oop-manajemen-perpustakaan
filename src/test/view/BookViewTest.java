package test.view;

import entity.Book;
import repository.BookRepositoryImpl;
import service.BookServiceImpl;
import view.BookView;

public class BookViewTest {

    public static void main(String[] args) {
//        testShowBookView();
//        testAddBookView();
        testRemoveBookView();
    }

    public static void testShowBookView() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);

        Book java = new Book();
        java.setTitle("belajar bahasa java");
        java.setStock(26);

        Book js = new Book();
        js.setTitle("Belajar bahasa javascript");
        js.setStock(24);

        Book php = new Book();
        php.setTitle("Belajar bahasa php");
        php.setStock(10);

        bookService.addBook(php);
        bookService.addBook(java);
        bookService.addBook(js);

        BookView bookView = new BookView(bookService);
        bookView.showBookView();
    }

    public static void testAddBookView() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);

        Book js = new Book();
        js.setTitle("Belajar bahasa javascript");
        js.setStock(24);

        bookService.addBook(js);

        BookView bookView = new BookView(bookService);
        bookView.addBookView();

        bookView.showBookView();

    }

    public static void testRemoveBookView() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);

        Book java = new Book();
        java.setTitle("belajar bahasa java");
        java.setStock(26);

        Book js = new Book();
        js.setTitle("Belajar bahasa javascript");
        js.setStock(24);

        Book php = new Book();
        php.setTitle("Belajar bahasa php");
        php.setStock(10);

        bookService.addBook(java);
        bookService.addBook(js);
        bookService.addBook(php);

        BookView bookView = new BookView(bookService);
        bookService.showBook();

        bookView.removeBookView();
    }
}
