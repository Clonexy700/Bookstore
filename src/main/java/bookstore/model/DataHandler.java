package bookstore.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public enum DataHandler {
    INSTANCE;
    private List<Book> books = null;

    public List<Book> getBooks() {
        if (books == null) {
            books = new ArrayList<>();
            books.add(new Book("Space is interesting", "Mike", 200.5));
            books.add(new Book("Gardening for beginners", "John", 200.5));
            books.add(new Book("Cars and how to tune", "Jane", 330.1));
            books.add(new Book("Cats and dogs", "Susan", 120.5));

        }
        return books;
    }

    public void createBook(Book book) {
        getBooks().add(book);
    }

    public void deleteBook(Book book) {
        getBooks().remove(book);
    }

    public ObservableList<Book> booksAsObservableList() {
        return FXCollections.observableList(getBooks());
    }
}
