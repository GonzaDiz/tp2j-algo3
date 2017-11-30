package controlador;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import modelo.jugador.Jugador;
import vista.Aplicacion;

public class BotonIniciarHandler implements EventHandler<ActionEvent> {

	private TextField nameField;
	private TextField nameField2;
	private TextField nameField3;
	private GridPane gridPane;
	private Aplicacion aplicacion;
	private Stage stage;

	public BotonIniciarHandler(TextField nameField, GridPane gridPane, TextField nameField2, TextField nameField3, Aplicacion aplicacion, Stage primaryStage) {
		this.nameField = nameField;
		this.gridPane = gridPane;
		this.nameField2 = nameField2;
		this.nameField3 = nameField3;
		this.aplicacion = aplicacion;
		this.stage = primaryStage;
	}

	@Override
	public void handle(ActionEvent event) {
		if (nameField.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!",
					"Por favor ingresar nombre de jugador 1");
			return;
		}

		showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registro Exitoso",
				"Bienvenidos " + nameField.getText() + "   " + nameField2.getText() + "    "
						+ nameField3.getText());

		ArrayList<Jugador> jugadores = new ArrayList<>();
		if (!nameField.getText().isEmpty()) {

			Jugador jugador1 = new Jugador(nameField.getText());
			jugadores.add(jugador1);
		}
		if (!nameField2.getText().isEmpty()) {

			Jugador jugador2 = new Jugador(nameField2.getText());
			jugadores.add(jugador2);
		}
		if (!nameField3.getText().isEmpty()) {

			Jugador jugador3 = new Jugador(nameField3.getText());
			jugadores.add(jugador3);
		}

		aplicacion.mostarContenedor2(jugadores);
		this.stage.hide();

	}
	
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(this.stage);
		alert.show();
	}

}
