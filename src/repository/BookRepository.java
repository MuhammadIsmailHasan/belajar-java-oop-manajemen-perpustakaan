package repository;

import entity.Book;

public interface BookRepository {

    Book[] getAll();

    public void save(Book book);

    public boolean remove(int number);
}
