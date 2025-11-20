package javafxapplication2.hayderController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ProfileController {

    // Store which dashboard we came from
    private String originDashboard = "admin"; // default

    public void setOriginDashboard(String origin) {
        this.originDashboard = origin;
    }

    @FXML
    private void onSave(ActionEvent event) {
        System.out.println("Save clicked");
        // You can add save logic here
        navigateBack(event);
    }

    @FXML
    private void onCancel(ActionEvent event) {
        System.out.println("Cancel clicked");
        navigateBack(event);
    }

    private void navigateBack(ActionEvent event) {
        String fxmlPath = "/javafxapplication2/hayder/GUI/";
        String title = "";

        if ("admin".equalsIgnoreCase(originDashboard)) {
            fxmlPath += "dashboard_admin.fxml";
            title = "Admin Dashboard";
        } else if ("responsable".equalsIgnoreCase(originDashboard)) {
            fxmlPath += "responsable_dashboard.fxml";
            title = "Responsable Dashboard";
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

