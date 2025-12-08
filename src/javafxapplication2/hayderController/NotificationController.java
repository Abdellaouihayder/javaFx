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
      // Style de base
    btnRetour.setStyle("-fx-background-color: #2b3a67;"
                     + "-fx-text-fill: white;"
                     + "-fx-padding: 6 14;"
                     + "-fx-background-radius: 6;"
                     + "-fx-font-size: 14px;"
                     + "-fx-cursor: hand;");

    // Hover effect
    btnRetour.setOnMouseEntered(e -> btnRetour.setStyle(
        "-fx-background-color: #1f2a4d;"
      + "-fx-text-fill: white;"
      + "-fx-padding: 6 14;"
      + "-fx-background-radius: 6;"
      + "-fx-font-size: 14px;"
      + "-fx-cursor: hand;"));

    btnRetour.setOnMouseExited(e -> btnRetour.setStyle(
        "-fx-background-color: #2b3a67;"
      + "-fx-text-fill: white;"
      + "-fx-padding: 6 14;"
      + "-fx-background-radius: 6;"
      + "-fx-font-size: 14px;"
      + "-fx-cursor: hand;"));
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

