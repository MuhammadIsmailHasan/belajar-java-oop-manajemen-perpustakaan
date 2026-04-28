package service;

import entity.Book;
import entity.Employee;
import entity.Transaction;
import repository.BookRepositoryImpl;
import repository.EmployeeRepositoryImpl;
import repository.TransactionRepositoryImpl;

public class TransactionServiceImpl implements TransactionService {

    BookRepositoryImpl bookRepository;
    EmployeeRepositoryImpl employeeRepository;
    TransactionRepositoryImpl transactionRepository;

    public TransactionServiceImpl(BookRepositoryImpl bookRepository, EmployeeRepositoryImpl employeeRepository, TransactionRepositoryImpl transactionRepository) {
        this.bookRepository = bookRepository;
        this.employeeRepository = employeeRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void borrowBook(int bookRegisterNumber, int employeeNip) {
        Book book = bookRepository.getByRegister(bookRegisterNumber);
        Employee employee = employeeRepository.getByNip(employeeNip);

        if (book == null || employee == null) {
            System.out.println("Book or Employee not found!");
            return;
        }

        assert book != null;
        if (book.getStock() <= 0) {
            System.out.println("Book is out of stock!");
            return;
        }

        transactionRepository.addPeminjaman(book, employee);
    }

    @Override
    public void returnBook(int transactionNumber) {
        Transaction transaction = transactionRepository.getByNumber(transactionNumber);
        if (transaction != null) {
            boolean returnBook = transactionRepository.returnPeminjaman(transaction);
            if (returnBook) {
                System.out.println("Successes return this book");
            } else {
                System.out.println("Failed! return this book");
            }
        } else {
            System.out.println("Transaction number not found!");
        }
    }

    @Override
    public void showTransaction() {
        Transaction[] transactions = transactionRepository.getAll();
        int number = 1;

        System.out.println("-- LIST TRANSACTION --");
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                System.out.println(number + ". " + transaction.getTransactionNumber() + "; " + transaction.getBook().getTitle() + " dipinjam oleh: " + transaction.getEmployee().getName() + " dengan status: " + transaction.getTransactionStatus().toString());
                number++;
            }
        }
        System.out.println();
    }
}
