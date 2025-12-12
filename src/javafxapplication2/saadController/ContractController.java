package javafxapplication2.saadController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafxapplication2.saadModel.*;
import java.time.LocalDate;

public class ContractController {

    @FXML
    private TextField clientNameField;

    @FXML
    private ComboBox<String> contractTypeBox;

    @FXML
    private TextField salaryField;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    // Initialisation du ComboBox
    @FXML
    public void initialize() {
        contractTypeBox.getItems().addAll("CDD", "CDI", "Stage");
    }

    // Méthode appelée au clic sur Valider
    @FXML
    private void validerContract() {
        String client = clientNameField.getText();
        String type = contractTypeBox.getValue();
        float salaire = Float.parseFloat(salaryField.getText());
        LocalDate debut = startDatePicker.getValue();
        LocalDate fin = endDatePicker.getValue();

        // Adaptation pour ton modèle SEDate
        SEDate debutSE = new SEDate(debut.atStartOfDay());
        SEDate finSE = new SEDate(fin.atStartOfDay());


        // Log ou persistance
        System.out.println("Contrat ajouté, client: " + client + ", type: " + type + ", salaire: " + salaire);
    }
}
