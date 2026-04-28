package test;

import entity.Book;
import entity.Employee;
import repository.BookRepositoryImpl;
import repository.EmployeeRepositoryImpl;
import repository.TransactionRepositoryImpl;
import service.BookServiceImpl;
import service.EmployeeServiceImpl;
import service.TransactionServiceImpl;

public class TransactionTest {
    public static void main(String[] args) {
//        testBorrowBook();
//        testShowTransaction();
//        testReturnBookTransaction();
    }

    public static void testBorrowBook() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        Book book = new Book();
        book.setTitle("belajar memahani ica");
        book.setStock(25);

        Book book1 = new Book();
        book1.setTitle("belajar mencintai ica");
        book1.setStock(99);
        bookRepository.save(book);
        bookRepository.save(book1);
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);
        bookService.showBook();

        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
        Employee ismail = new Employee();
        ismail.setName("ismail");
        ismail.setNip(19960422);

        Employee rizka = new Employee();
        rizka.setName("rizka");
        rizka.setNip(19971107);
        employeeRepository.save(ismail);
        employeeRepository.save(rizka);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);
        employeeService.showEmployee();

        TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();
        TransactionServiceImpl transactionService = new TransactionServiceImpl(bookRepository, employeeRepository, transactionRepository);
        transactionService.borrowBook(1002, 19971107);
        bookService.showBook();

        transactionService.borrowBook(1003, 199711000);
        bookService.showBook();
    }

    public static void testShowTransaction() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        Book book = new Book();
        book.setTitle("belajar memahani ica");
        book.setStock(25);

        Book book1 = new Book();
        book1.setTitle("belajar mencintai ica");
        book1.setStock(99);
        bookRepository.save(book);
        bookRepository.save(book1);
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);
        bookService.showBook();

        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
        Employee ismail = new Employee();
        ismail.setName("ismail");
        ismail.setNip(19960422);

        Employee rizka = new Employee();
        rizka.setName("rizka");
        rizka.setNip(19971107);
        employeeRepository.save(ismail);
        employeeRepository.save(rizka);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);
        employeeService.showEmployee();

        TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();
        TransactionServiceImpl transactionService = new TransactionServiceImpl(bookRepository, employeeRepository, transactionRepository);
        transactionService.borrowBook(1002, 19971107);

        transactionService.showTransaction();

        transactionService.borrowBook(1005, 19971107);
        transactionService.borrowBook(1001, 20001107);

        bookService.showBook();
    }

    public static void testReturnBookTransaction() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        Book book = new Book();
        book.setTitle("belajar memahani ica");
        book.setStock(25);

        Book book1 = new Book();
        book1.setTitle("belajar mencintai ica");
        book1.setStock(99);
        bookRepository.save(book);
        bookRepository.save(book1);
        BookServiceImpl bookService = new BookServiceImpl(bookRepository);
        bookService.showBook();

        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
        Employee ismail = new Employee();
        ismail.setName("ismail");
        ismail.setNip(19960422);

        Employee rizka = new Employee();
        rizka.setName("rizka");
        rizka.setNip(19971107);
        employeeRepository.save(ismail);
        employeeRepository.save(rizka);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);
        employeeService.showEmployee();

        TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();
        TransactionServiceImpl transactionService = new TransactionServiceImpl(bookRepository, employeeRepository, transactionRepository);
        transactionService.borrowBook(1002, 19971107);
        transactionService.borrowBook(1001, 19971107);

        transactionService.showTransaction();

        bookService.showBook();

        transactionService.returnBook(5005);
        transactionService.returnBook(5001);
        transactionService.returnBook(5001);

        transactionService.showTransaction();
        bookService.showBook();


    }
}
