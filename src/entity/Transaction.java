package entity;

public class Transaction {
    private int transactionNumber;
    private Book book;
    private Employee employee;

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    private TransactionStatus transactionStatus;

    public Transaction(int transactionNumber, Book book, Employee employee, TransactionStatus transactionStatus) {
        this.transactionNumber = transactionNumber;
        this.book = book;
        this.employee = employee;
        this.transactionStatus = transactionStatus;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
