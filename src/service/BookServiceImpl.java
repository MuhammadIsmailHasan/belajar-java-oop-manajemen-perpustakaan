package service;

import entity.Book;
import repository.BookRepository;
import repository.BookRepositoryImpl;

public class BookServiceImpl implements BookService {

    private BookRepositoryImpl bookRepository;

    public BookServiceImpl(BookRepositoryImpl bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void showBook() {
        int nomor = 1;
        Book[] books = bookRepository.getAll();
        System.out.println("-- LIST BOOK --");
        for (var i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println(nomor + ". " + books[i].getTitle() + " (" + books[i].getRegisterNumber() + "); " + books[i].getStock() + " pcs");
                nomor++;
            }
        }
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void removeBook(int number) {
        boolean result = bookRepository.remove(number);
        if (result) {
            System.out.println("Berhasil menghapus dengan urutan: " + number);
        } else {
            System.out.println("Gagal! menghapus urutan: " + number);
        }
    }
}
