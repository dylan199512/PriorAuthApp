import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PriorAuthUI extends Application {

    @Override
    public void start(Stage stage) {

        // Header
        Label header = new Label("Prior Authorization Checker");
        header.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-padding: 10 0 20 0;");

        // Dummy patients
        Patient p1 = new Patient(62, "M54.5", "MRI", "CarePlus",
                "Chronic back pain for 8 weeks.");

        Patient p2 = new Patient(39, "R51", "CT Scan", "MockHealth",
                "Headache after fall. No LOC.");

        Patient p3 = new Patient(44, "M25.50", "X-Ray", "ValueCare",
                "Joint pain and stiffness.");

        Patient p4 = new Patient(29, "S93.4", "X-Ray", "MockHealth",
                "Ankle sprain after sports injury.");

        Patient p5 = new Patient(71, "I63.9", "CT Scan", "CarePlus",
                "Possible stroke symptoms. Sudden weakness.");

        Patient p6 = new Patient(52, "M54.2", "MRI", "ValueCare",
                "Neck pain radiating to shoulder.");

        Patient p7 = new Patient(45, "R07.9", "CT Scan", "MockHealth",
                "Chest pain. Pediatric case.");

        Patient p8 = new Patient(36, "S06.0X0A", "CT Scan", "CarePlus",
                "Mild head trauma. No loss of consciousness.");

        Patient p9 = new Patient(48, "M51.26", "MRI", "ValueCare",
                "Lumbar radiculopathy. Pain radiating to leg.");

        Patient p10 = new Patient(23, "R10.9", "CT Scan", "MockHealth",
                "Abdominal pain. Rule out appendicitis.");

        // Patient dropdown
        Label patientLabel = new Label("Select Patient:");
        ComboBox<Patient> patientDropdown = new ComboBox<>();
        patientDropdown.getItems().addAll(
                p1, p2, p3, p4, p5, p6, p7, p8, p9, p10
        );

        // Load Patient button
        Button loadPatientButton = new Button("Load Patient");

        // Age
        Label ageLabel = new Label("Patient Age:");
        TextField ageField = new TextField();

        // Diagnosis
        Label diagLabel = new Label("Diagnosis Code:");
        TextField diagField = new TextField();

        // Service dropdown
        Label serviceLabel = new Label("Requested Service:");
        ComboBox<String> serviceDropdown = new ComboBox<>();
        serviceDropdown.getItems().addAll("MRI", "CT Scan", "X-Ray");
        serviceDropdown.setValue("MRI");

        // Payer dropdown
        Label payerLabel = new Label("Payer:");
        ComboBox<String> payerDropdown = new ComboBox<>();
        payerDropdown.getItems().addAll("MockHealth", "CarePlus", "ValueCare");
        payerDropdown.setValue("MockHealth");

        // Clinical notes
        Label notesLabel = new Label("Clinical Notes:");
        TextArea notesArea = new TextArea();
        notesArea.setPromptText("Enter any relevant clinical notes...");
        notesArea.setPrefRowCount(4);

        // Buttons
        Button runButton = new Button("Run Check");
        Button clearButton = new Button("Clear");
        Button saveButton = new Button("Save Audit");

        // Output area
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);

        // Load patient logic
        loadPatientButton.setOnAction(e -> {
            Patient selected = patientDropdown.getValue();
            if (selected != null) {
                ageField.setText(String.valueOf(selected.age));
                diagField.setText(selected.diagnosis);
                serviceDropdown.setValue(selected.service);
                payerDropdown.setValue(selected.payer);
                notesArea.setText(selected.notes);
            }
        });

        // Run logic
        runButton.setOnAction(e -> {
            try {
                int age = Integer.parseInt(ageField.getText());
                String diagnosis = diagField.getText();
                String service = serviceDropdown.getValue();
                String payer = payerDropdown.getValue();

                PriorAuthChecker checker = new PriorAuthChecker();
                String result = checker.evaluate(age, diagnosis, service, payer);

                outputArea.setText(result);

            } catch (NumberFormatException ex) {
                outputArea.setText("Error: Age must be a number.");
            }
        });

        // Clear logic
        clearButton.setOnAction(e -> {
            ageField.clear();
            diagField.clear();
            serviceDropdown.setValue("MRI");
            payerDropdown.setValue("MockHealth");
            notesArea.clear();
            outputArea.clear();
        });

        // Save-to-file logic
        saveButton.setOnAction(e -> {
            try {
                java.nio.file.Files.writeString(
                        java.nio.file.Path.of("audit_log.txt"),
                        outputArea.getText()
                );
                outputArea.appendText("\n\nAudit saved to audit_log.txt");
            } catch (Exception ex) {
                outputArea.setText("Error saving file.");
            }
        });

        // Layout
        VBox layout = new VBox(
                12,
                header,
                patientLabel,
                patientDropdown,
                loadPatientButton,
                ageLabel,
                ageField,
                diagLabel,
                diagField,
                serviceLabel,
                serviceDropdown,
                payerLabel,
                payerDropdown,
                notesLabel,
                notesArea,
                runButton,
                clearButton,
                saveButton,
                outputArea
        );

        layout.setStyle("-fx-padding: 20; -fx-font-size: 14;");

        Scene scene = new Scene(layout, 420, 750);

        stage.setTitle("Prior Authorization Checker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
