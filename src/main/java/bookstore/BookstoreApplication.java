package bookstore;

import bookstore.overview.OverviewScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BookstoreApplication extends Application {
    private OverviewScene overviewScene = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bookstore Application");
        primaryStage.setScene(new Scene(new Button("Hello world")));
        primaryStage.show();
    }

    private OverviewScene getOverviewScene() {
        if (overviewScene == null) {
            overviewScene = new OverviewScene();
        }
        return overviewScene;
    }

}
