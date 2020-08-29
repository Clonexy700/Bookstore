package bookstore.overview;

import bookstore.CustomEvent;
import bookstore.model.Book;
import bookstore.model.DataHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class OverviewLeftPane extends VBox {

    private Button buttonCreateBook = null;
    private Button buttonDeleteBook = null;
    private final OverviewTableView overviewTableView;
    public OverviewLeftPane(OverviewTableView overviewTableView) {
        this.overviewTableView = overviewTableView;
        initStuff();
    }

    private void initStuff() {
        this.setSpacing(10);
        this.setPadding(new Insets(5));
        this.getChildren().add(getButtonCreateBook());
        this.getChildren().add(getButtonDeleteBook());
    }

    private Button getButtonCreateBook() {
        if (buttonCreateBook == null) {
            buttonCreateBook = new Button("Create book");
            buttonCreateBook.setOnAction((e) -> {
                System.out.println("Create book clicked");
                fireEvent(new CustomEvent(CustomEvent.GO_TO_CREATE_SCENE));
            });
        }
        return buttonCreateBook;
    }

    private Button getButtonDeleteBook() {
        if (buttonDeleteBook == null){
            buttonDeleteBook = new Button("Delete book");
            buttonCreateBook.setOnAction((e) -> {
                Book selectedBook = (Book) overviewTableView
                        .getSelectionModel().getSelectedItem();
                if (selectedBook == null) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    System.out.println("No book selected");
                    alert.setContentText("No book selected");
                    return;
                }


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Are you sure you want to delete the book?");
                alert.setHeaderText(selectedBook.toString());
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get() == ButtonType.OK) {
                    DataHandler.INSTANCE.deleteBook(selectedBook);
                    overviewTableView.setItems(DataHandler.INSTANCE.booksAsObservableList());
                    System.out.println("Delete book");
                } else {
                    System.out.println("Delete canceled");
                }

            });
        }
        return buttonDeleteBook;
    }
}
