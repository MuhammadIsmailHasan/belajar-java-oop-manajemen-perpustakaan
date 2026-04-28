package service;

import entity.Book;

public interface BookService {

    void showBook();
    void addBook(Book book);
    void removeBook(int number);
    void checkStock(int bookNumber);
}
