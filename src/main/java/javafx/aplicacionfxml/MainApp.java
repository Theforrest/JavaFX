package javafx.aplicacionfxml;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.recursos.LocalizadorRecursos;


public class MainApp extends Application {
	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = FXMLLoader.load(LocalizadorRecursos.class.getResource("vistas/Ejemplo.fxml"));
			Scene escena = new Scene(raiz);
			escena.getStylesheets().add(LocalizadorRecursos.class.getResource("estilos/aplicacion.css").toExternalForm());
			escenarioPrincipal.setTitle("Ejemplo FXML");
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
