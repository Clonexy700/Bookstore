package bookstore.create;

import bookstore.model.Book;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class CreateInputPane extends GridPane {
    private TextField title;
    private TextField author;
    private TextField price;
    private Text txtTitle;
    private Text txtAuthor;
    private Text txtPrice;

    public CreateInputPane() {
        initPane();
    }

    private void initPane() {
        getChildren().addAll(
                getTxtTitle(), getTitle(),
                getTxtPrice(), getPrice(),
                getTxtAuthor(), getAuthor()
        );
        ColumnConstraints c1 = new ColumnConstraints(200);
        ColumnConstraints c2 = new ColumnConstraints(300);
        c2.getHgrow();
        getColumnConstraints().addAll(c1, c2);
        int row = 0;
        int column = 0;
        setRowIndex(getTxtTitle(), row);
        setRowIndex(getTitle(), row++);
        setColumnIndex(getTxtTitle(), column++);
        setColumnIndex(getTitle(), column);
        column = 0;
        setRowIndex(getTxtAuthor(), row);
        setRowIndex(getAuthor(), row++);
        setColumnIndex(getTxtAuthor(), column++);
        setColumnIndex(getAuthor(), column);
        column = 0;
        setRowIndex(getTxtPrice(), row);
        setRowIndex(getPrice(), row++);
        setColumnIndex(getTxtPrice(), column++);
        setColumnIndex(getPrice(), column);

    }

    public Text getTxtTitle() {
        if (txtTitle == null) {
            txtTitle = new Text("Title");
        }
        return txtTitle;
    }

    public Text getTxtAuthor() {
        if (txtAuthor == null) {
            txtAuthor = new Text("Author");
        }
        return txtAuthor;
    }
    public Text getTxtPrice() {
        if (txtPrice == null) {
            txtPrice = new Text("Price");
        }
        return txtPrice;
    }

    public TextField getTitle() {
        if (title == null) {
            title = new TextField("NOT_SET");
        }
        return title;
    }

    public TextField getAuthor() {
        if (author == null) {
            author = new TextField("NOT_SET");
        }
        return author;
    }

    public TextField getPrice() {
        if (price == null) {
            price = new TextField("NOT_SET");
        }
        return price;
    }

    public Book book() {
        return new Book(getTitle().getText(), getAuthor().getText(), Double.parseDouble(getPrice().getText()));
    }
}
