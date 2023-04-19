package javafx.eventos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.recursos.LocalizadorRecursos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CampoTextoNumerico1 extends Application {
	
	private Label lbInfo;
	private TextField tfNumerico;
	private static final AudioClip BEEP = new AudioClip(LocalizadorRecursos.class.getResource("sonidos/beep.mp3").toExternalForm());
	
	private void compruebaNumero(String textoAntiguo, String textoNuevo) {	
		if (textoNuevo.matches("\\d*(\\.\\d*)?")) {
			lbInfo.setText("Longitud: " + textoNuevo.length() + " caracteres");
		} else {
			tfNumerico.setText(textoAntiguo);
			BEEP.play();
		}
	}

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox(20);
			raiz.setPadding(new Insets(10));
			raiz.setAlignment(Pos.CENTER);
			
			HBox hbTexto =new HBox(30);
			hbTexto.setPadding(new Insets(10));
			hbTexto.setAlignment(Pos.CENTER);
			
			Label lbTexto = new Label("Introduce un número\n(entero o decimal)");
			lbTexto.setWrapText(true);
			lbTexto.setFont(Font.font("Arial", 14));
			tfNumerico = new TextField();
			tfNumerico.textProperty().addListener((observable, oldValue, newValue) -> compruebaNumero(oldValue, newValue));
			hbTexto.getChildren().addAll(lbTexto, tfNumerico);
			
			lbInfo = new Label("Longitud: 0 caracteres");
			lbInfo.setFont(Font.font("Arial", 24));
			
			raiz.getChildren().addAll(hbTexto, lbInfo);
			
			Scene escena = new Scene(raiz, 450, 150);
			escenarioPrincipal.setTitle("Campo numérico");
			escenarioPrincipal.setScene(escena);
			escenarioPrincipal.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
