package bookstore.create;

import bookstore.CustomEvent;
import bookstore.model.DataHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CreateBottomPane extends HBox {

    private Button cancel = null;
    private Button ok = null;
    private final CreateInputPane inputPane;

    public CreateBottomPane(CreateInputPane inputPane) {
        this.inputPane = inputPane;
        initPane();
    }

    private void initPane() {
        getChildren().addAll(getCancel(), getOk());
    }

    private Button getCancel() {
        if (cancel == null) {
            cancel = new Button("Cancel");
            cancel.setOnAction((e) -> {
                System.out.println("Cancel");
                fireEvent(new CustomEvent(CustomEvent.GO_TO_CREATE_SCENE));
            });
        }
        return cancel;
    }

    private Button getOk() {
        if (ok == null) {
            ok = new Button("Cancel");
            ok.setOnAction((e) -> {
                System.out.println("OK!");
                DataHandler.INSTANCE.createBook(inputPane.book());
                fireEvent(new CustomEvent(CustomEvent.GO_TO_CREATE_SCENE));
            });
        }
        return ok;
    }
}
