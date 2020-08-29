package bookstore.overview;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class OverviewScene extends Scene {
    private OverviewPane overviewPane = null;
    public OverviewScene() {
        super(new OverviewPane());
        OverviewPane overviewPane = (OverviewPane)getRoot();
    }

    public void refreshData() {
        overviewPane.refreshData();
    }

}
