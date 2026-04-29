package view;

import entity.Book;
import service.BookServiceImpl;
import utils.InputUtil;

public class BookView {

    private BookServiceImpl bookService;

    public BookView(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    public void showBookView(){

        while (true) {
            bookService.showBook();

            System.out.println("Choose by number, what do you want?");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("x. Exit");

            String userInput = InputUtil.inputUser("book service");

            if (userInput.equalsIgnoreCase("1")) {
                addBookView();
            } else if (userInput.equalsIgnoreCase("2")) {
                removeBookView();
            } else if (userInput.equalsIgnoreCase("x")) {
                break;
            } else {
                System.out.println("Please, write valid number!");
            }
        }
    }

    public void addBookView(){
        System.out.println("If you wanna cancel, write 'x'! ");
        Book book = new Book();
        var titleInput = InputUtil.inputUser("book title");
        var stockInput = InputUtil.inputUser("book stock");

        if (titleInput.equalsIgnoreCase("x") || stockInput.equalsIgnoreCase("x")) {
            showBookView();
        } else {
            book.setTitle(titleInput);
            book.setStock(Integer.parseInt(stockInput));

            bookService.addBook(book);
        }
    }

    public void removeBookView() {
        System.out.println("If you wanna cancel, write 'x'! ");
        var number = InputUtil.inputUser("number of book ");

        if (number.equalsIgnoreCase("x")) {
            showBookView();
        } else {
            try {
                bookService.removeBook(Integer.parseInt(number));
            } catch (Exception e) {
                System.out.println("Cannot convert number of " + e.getMessage());
            }
        }
    }
}
