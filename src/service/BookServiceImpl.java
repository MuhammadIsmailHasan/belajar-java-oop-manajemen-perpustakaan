package service;

import entity.Book;
import repository.BookRepositoryImpl;

public class BookServiceImpl implements BookService {

    private BookRepositoryImpl bookRepository;

    public BookServiceImpl(BookRepositoryImpl bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void showBook() {
        int nomor = 1;
        Book[] books = bookRepository.getAll();
        System.out.println("-- LIST BOOK --");
        for (var i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(nomor + ". " + books[i].getTitle() + " (" + books[i].getRegisterNumber() + "); " + books[i].getStock() + " pcs");
                nomor++;
            }
        }
        System.out.println();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    private int booksLength() {
        int length = 0;
        for (Book book : bookRepository.getAll()) {
            if (book != null) {
                length++;
            }
        }

        return length;
    }

    @Override
    public void removeBook(int number) {
        if (number <= booksLength() && number > 0) {
            boolean result = bookRepository.remove(number);
            if (result) {
                System.out.println("Successes delete with number: " + number);
            } else {
                System.out.println("Failed! on number: " + number);
            }
        } else {
            System.out.println("Number is not valid!");
        }
    }

    @Override
    public void checkStock(int number) {
        if (number <= booksLength() && number > 0) {
            int stock = bookRepository.checkStock(number);
            System.out.println("Current stock is: " + stock);
        } else {
            System.out.println("Number is not valid!");
        }
    }
}
