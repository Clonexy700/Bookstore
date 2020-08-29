package bookstore.overview;

import bookstore.model.Book;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OverviewTableView extends TableView {

    public OverviewTableView(ObservableList<Book> items) {
        super(items);
        initTable();
    }

    private void initTable() {
        TableColumn<String, Book> tableColumnTitle = new TableColumn<>("Title");
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<String, Book> tableColumnAuthor = new TableColumn<>("Author");
        tableColumnAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Double, Book> tableColumnPrice = new TableColumn<>("Price");
        tableColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        getColumns().addAll(tableColumnTitle,
                tableColumnAuthor,
                tableColumnPrice);
    }
}
