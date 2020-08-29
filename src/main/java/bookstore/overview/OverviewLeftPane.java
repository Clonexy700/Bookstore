package bookstore.overview;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OverviewLeftPane extends VBox {

    private Button buttonCreateBook = null;
    private Button buttonDeleteBook = null;

    public OverviewLeftPane() {
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
                log.info("Create book clicked");
            });
        }
        return buttonCreateBook;
    }

    private Button getButtonDeleteBook() {
        if (buttonDeleteBook == null){
            buttonDeleteBook = new Button("Delete book");
            buttonCreateBook.setOnAction((e) -> {
                log.info("Delete book");
            });
        }
        return buttonDeleteBook;
    }
}
