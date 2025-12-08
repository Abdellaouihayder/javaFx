/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2.hayderController;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NotificationController {

    @FXML
    private Button btnRetour;

    private String previousPage;  // "admin" ou "responsable"

    public void setPreviousPage(String previousPage) {
        this.previousPage = previousPage;
    }

    @FXML
    public void initialize() {
        btnRetour.setOnAction(e -> handleRetour());
    }

  @FXML
private void handleRetour() {
    try {
        Parent root;

        if ("admin".equals(previousPage)) {
            root = FXMLLoader.load(getClass().getResource("/javafxapplication2/hayder/GUI/dashboard_admin.fxml"));
        } else if ("responsable".equals(previousPage)) {
            root = FXMLLoader.load(getClass().getResource("/javafxapplication2/hayder/GUI/responsable_dashboard.fxml"));
        } else {
            System.out.println("❌ previousPage non défini !");
            return;
        }

        Stage stage = (Stage) btnRetour.getScene().getWindow();
        stage.setScene(new Scene(root));

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

}

