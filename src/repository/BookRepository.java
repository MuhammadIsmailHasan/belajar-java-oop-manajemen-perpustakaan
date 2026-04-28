package repository;

import entity.Book;

public interface BookRepository {

    Book[] getAll();

    Book getByRegister(int registerNumber);

    void save(Book book);

    boolean remove(int number);

    int checkStock(int number);
}
