package service;

import entity.Book;

public interface BookService {

    public void showBook();

    public void addBook(Book book);

    public void removeBook(int number);
}
