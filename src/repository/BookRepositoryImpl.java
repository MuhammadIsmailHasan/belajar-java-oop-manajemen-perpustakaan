package repository;

import java.util.Arrays;
import entity.Book;

public class BookRepositoryImpl implements BookRepository {

    /**
     * it's temporary, just for test
     */
    public Book[] books = new Book[3];

    @Override
    public Book[] getAll() {
        return books;
    }

    @Override
    public Book getByRegister(int registerNumber) {
        for (Book book : books) {
            if (book != null && book.getRegisterNumber() == registerNumber) {
                return book;
            }
        }
        return null;
    }

    private int getRegisterNumber() {
        int result = 0;
        int[] register = new int[books.length];
        for (var i = 0; i < books.length; i++) {
            if (books[i] != null) {
                register[i] = books[i].getRegisterNumber();
            }
        }

        Arrays.sort(register);
        if (register[register.length - 1] == 0) {
            result = 1001;
        } else {
            int reg = register[register.length - 1];
            result = reg + 1;
        }
        return result;
    }

    private boolean isFull() {
        boolean full = true;
        for (var i = 0; i < books.length; i++) {
            if (books[i] == null) {
                full = false;
            }
        }

        return full;
    }

    private void resize() {
        if (isFull()) {
            Book[] temporaryBook = books;
            books = new Book[books.length * 2];

            for (var i = 0; i < temporaryBook.length; i++) {
                books[i] = temporaryBook[i];
            }
        }
    }

    @Override
    public void save(Book book) {
        int getRegister = getRegisterNumber();
        resize();

        for (var i = 0; i < books.length; i++) {
            if (books[i] == null) {
                book.setRegisterNumber(getRegister);
                books[i] = book;
                break;
            }
        }
    }

    @Override
    public boolean remove(int number) {
        boolean isSuccess = false;
        if (books[number - 1] != null) {
            books[number - 1] = null;
            isSuccess = true;
        }
        return isSuccess;
    }

    @Override
    public int checkStock(int number) {
        int stock = books[number - 1].getStock();

        return stock;
    }
}
