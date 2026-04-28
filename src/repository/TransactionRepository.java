package repository;

import entity.Book;
import entity.Employee;
import entity.Transaction;

public interface TransactionRepository {
    void addPeminjaman(Book book, Employee employee);

    boolean returnPeminjaman(Transaction transaction);

    Transaction getByNumber(int transactionNumber);

    Transaction[] getAll();
}
