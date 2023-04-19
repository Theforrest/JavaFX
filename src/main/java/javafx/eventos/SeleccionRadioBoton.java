package javafx.eventos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.recursos.LocalizadorRecursos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SeleccionRadioBoton extends Application {
	
	private RadioButton rbCerveza;
	private RadioButton rbCaca;
	private RadioButton rbApagar;
	private ImageView ivIcono;
	private ToggleGroup grupo;
	
	private static final Image CERVEZA = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoCerveza.png"), 100, 100, true, true);
	private static final Image CACA = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoCaca.png"), 100, 100, true, true);
	private static final Image APAGAR = new Image(LocalizadorRecursos.class.getResourceAsStream("imagenes/iconoApagar.png"), 100, 100, true, true);
	
	private void mostrarIcono() {
		RadioButton seleccionado = (RadioButton)grupo.getSelectedToggle();
		if (seleccionado == rbCerveza) {
			ivIcono.setImage(CERVEZA);
		} else if (seleccionado == rbCaca) {
			ivIcono.setImage(CACA);
		} else if (seleccionado == rbApagar) {
			ivIcono.setImage(APAGAR);
		}
	}

	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			HBox raiz = new HBox(20);
			raiz.setPadding(new Insets(20));
			raiz.setAlignment(Pos.CENTER_LEFT);
			
			VBox vbOpcioes =new VBox(10);
			vbOpcioes.setPadding(new Insets(10));
			
			Label lbElige = new Label("Elige el icono a mostrar:");
			lbElige.setFont(Font.font(20));
			rbCerveza = new RadioButton("Cerveza");
			rbCaca = new RadioButton("Caca");
			rbCaca.setSelected(true);
			rbApagar = new RadioButton("Apagar");
			Insets margen = new Insets(0, 0, 0, 20);
			VBox.setMargin(rbCerveza, margen);
			VBox.setMargin(rbCaca, margen);
			VBox.setMargin(rbApagar, margen);
			grupo = new ToggleGroup();
			rbCerveza.setToggleGroup(grupo);
			rbCaca.setToggleGroup(grupo);
			rbApagar.setToggleGroup(grupo);
			grupo.selectedToggleProperty().addListener((observable, oldValue, newValue) -> mostrarIcono());
			vbOpcioes.getChildren().addAll(lbElige, rbCerveza, rbCaca, rbApagar);
			
			ivIcono = new ImageView();
			ivIcono.setImage(CACA);
			
			raiz.getChildren().addAll(vbOpcioes, ivIcono);
			
			Scene escena = new Scene(raiz, 470, 170);
			escenarioPrincipal.setTitle("Elige un icono");
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
