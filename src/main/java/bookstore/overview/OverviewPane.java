package bookstore.overview;

import bookstore.model.DataHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class OverviewPane extends BorderPane {
    private OverviewLeftPane overviewLeftPane = null;
    private OverviewTableView overviewTableView = null;
    public OverviewPane() {
        initStuff();
    }

    private void initStuff() {
        this.setTop(new Text("In the table we can see the books for sale."));
        this.setLeft(getOverviewLeftPane());
        this.setCenter(getOverviewTableView());
        this.setPrefHeight(800);
        this.setPrefWidth(600);
    }

    private OverviewLeftPane getOverviewLeftPane() {
        if (overviewLeftPane == null) {
            overviewLeftPane = new OverviewLeftPane(getOverviewTableView());
        }
        return overviewLeftPane;
    }

    public OverviewTableView getOverviewTableView() {
        if (overviewTableView == null){
            overviewTableView  = new OverviewTableView(DataHandler.INSTANCE.booksAsObservableList());
        }
        return overviewTableView;
    }

    public void refreshData() {
        getOverviewTableView().setItems(DataHandler.INSTANCE.booksAsObservableList());
    }

}
