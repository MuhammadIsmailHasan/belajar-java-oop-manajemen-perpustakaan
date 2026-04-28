package repository;

import entity.Book;
import entity.Employee;
import entity.Transaction;
import entity.TransactionStatus;

import java.util.Arrays;

public class TransactionRepositoryImpl implements TransactionRepository {

    Transaction[] transactions = new Transaction[10];

    @Override
    public void addPeminjaman(Book book, Employee employee) {
        book.setStock(book.getStock() - 1);

        int transactionNumber = getTranscationNumber();

        Transaction borrowBook = new Transaction(
                transactionNumber,
                book,
                employee,
                TransactionStatus.ACTIVE
        );

        resize();
        for (var i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = borrowBook;
                break;
            }
        }
    }

    private boolean isFull() {
        boolean full = true;
        for (var i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                full = false;
            }
        }

        return full;
    }

    private void resize() {
        if (isFull()) {
            Transaction[] transactionsTemporary = transactions;
            transactions = new Transaction[transactions.length * 2];

            for (var i = 0; i < transactionsTemporary.length; i++) {
                transactions[i] = transactionsTemporary[i];
            }
        }
    }

    private int getTranscationNumber() {
        int result = 0;
        int[] transactioNumber = new int[transactions.length];
        for (var i = 0; i < transactions.length; i++) {
            if (transactions[i] != null) {
                transactioNumber[i] = transactions[i].getTransactionNumber();
            }
        }

        Arrays.sort(transactioNumber);
        if (transactioNumber[transactioNumber.length - 1] == 0) {
            result = 5001;
        } else {
            int number = transactioNumber[transactioNumber.length - 1];
            result = number + 1;
        }
        return result;
    }

    @Override
    public boolean returnPeminjaman(Transaction transaction) {
        if (transaction.getTransactionStatus() == TransactionStatus.ACTIVE) {
            transaction.setTransactionStatus(TransactionStatus.NONACTIVE);
            Book book = transaction.getBook();
            if (book != null) {
                book.setStock(book.getStock() + 1);
                return true;
            }
        }

        return false;
    }

    @Override
    public Transaction getByNumber(int transactionNumber) {
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getTransactionNumber() == transactionNumber) {
                    return transaction;
                }
            }
        }

        return null;
    }

    @Override
    public Transaction[] getAll() {
        return transactions;
    }
}
