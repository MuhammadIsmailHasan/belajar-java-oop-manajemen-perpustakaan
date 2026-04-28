package service;

public interface TransactionService {

    public void borrowBook(int bookRegisterNumber, int employeeNip);
    public void returnBook(int transactionNumber);
    public void showTransaction();

}
