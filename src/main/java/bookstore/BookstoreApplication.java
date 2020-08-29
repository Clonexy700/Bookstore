package bookstore;

import bookstore.create.CreateScene;
import bookstore.overview.OverviewScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BookstoreApplication extends Application {
    private OverviewScene overviewScene = null;
    private CreateScene createScene = null;
    private Stage primaryStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Bookstore Application");
        primaryStage.setScene(getOverviewScene());
        primaryStage.show();
    }

    private OverviewScene getOverviewScene() {
        if (overviewScene == null) {
            overviewScene = new OverviewScene();
            overviewScene.addEventFilter(CustomEvent.GO_TO_OVERVIEW_SCENE, (e) -> {
                primaryStage.setScene(overviewScene);
            });
        }
        return overviewScene;
    }

    private CreateScene getCreateScene() {
        if (createScene == null) {
            createScene = new CreateScene();
            createScene.addEventFilter(CustomEvent.GO_TO_CREATE_SCENE, (e) -> {
                primaryStage.setScene(createScene);
                overviewScene.refreshData();
            });
        }
        return createScene;
    }

}
