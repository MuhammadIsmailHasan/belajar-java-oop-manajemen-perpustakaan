package service;

public interface TransactionService {

    void borrowBook(int bookRegisterNumber, int employeeNip);
    void returnBook(int transactionNumber);
    void showTransaction();

}
