package repository;

import entity.Book;
import entity.Employee;
import entity.Transaction;

public interface TransactionRepository {
    public void addPeminjaman(Book book, Employee employee);

    public boolean returnPeminjaman(Transaction transaction);

    Transaction getByNumber(int transactionNumber);

    Transaction[] getAll();
}
