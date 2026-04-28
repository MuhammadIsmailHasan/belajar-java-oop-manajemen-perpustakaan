package repository;

import entity.Book;

public interface BookRepository {

    Book[] getAll();

    Book getByRegister(int registerNumber);

    public void save(Book book);

    public boolean remove(int number);

    public int checkStock(int number);
}
