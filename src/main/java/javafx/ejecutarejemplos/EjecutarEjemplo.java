package javafx.ejecutarejemplos;

import javafx.aplicacionfxml.MainApp;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.controles.Acordeon;
import javafx.controles.BarrasDesplazamiento;
import javafx.controles.BarrasIndicadoresProgreso;
import javafx.controles.Botones;
import javafx.controles.BotonesActivacion;
import javafx.controles.CajasCombinadas;
import javafx.controles.CajasEleccion;
import javafx.controles.CamposContrasena;
import javafx.controles.CamposTexto;
import javafx.controles.CasillasVerificacion;
import javafx.controles.Deslizadores;
import javafx.controles.EditorHTML;
import javafx.controles.Etiquetas;
import javafx.controles.Hiperenlaces;
import javafx.controles.InformacionContextual;
import javafx.controles.Menus;
import javafx.controles.Paginacion;
import javafx.controles.RadioBotones;
import javafx.controles.SelectorColor;
import javafx.controles.SelectorFecha;
import javafx.controles.SelectorFicheros;
import javafx.controles.Separadores;
import javafx.controles.VistaArbol;
import javafx.controles.VistaLista;
import javafx.controles.VistaTabla;
import javafx.controles.VistaTablaArbol;
import javafx.controles.VistaTablaSinPropiedades;
import javafx.event.ActionEvent;
import javafx.eventos.CampoTextoLongitudMaxima;
import javafx.eventos.DeterminarBotonPulsado;
import javafx.eventos.PulsacionesBoton;
import javafx.fxml.FXML;
import javafx.manejadores.ManejadorClase;
import javafx.manejadores.ManejadorClaseAnonima;
import javafx.manejadores.ManejadorLambda1;
import javafx.manejadores.ManejadorLambda2;
import javafx.panelesdiseno.Panel;
import javafx.panelesdiseno.PanelApilado;
import javafx.panelesdiseno.PanelBorde;
import javafx.panelesdiseno.PanelCuadricula;
import javafx.panelesdiseno.PanelFlujo;
import javafx.panelesdiseno.PanelHorizontal;
import javafx.panelesdiseno.PanelVertical;
import javafx.personalizacion.EstilosHojaExterna;
import javafx.personalizacion.EstilosNodos;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class EjecutarEjemplo {
	
	private static final ObservableList<Opcion> CONTROLES = FXCollections.observableArrayList(
			new Opcion("Acordeón", Acordeon.class), 
			new Opcion("Barras de desplazamiento", BarrasDesplazamiento.class),
			new Opcion("Barras e indicadores de progreso", BarrasIndicadoresProgreso.class), 
			new Opcion("Botones", Botones.class), 
			new Opcion("Botones de activación", BotonesActivacion.class),
			new Opcion("Botones de radio", RadioBotones.class),
			new Opcion("Cajas combinadas", CajasCombinadas.class),
			new Opcion("Cajas de elección", CajasEleccion.class), 
			new Opcion("Campo de contraseña", CamposContrasena.class),
			new Opcion("Campo de texto", CamposTexto.class), 
			new Opcion("Casillas de verificación", CasillasVerificacion.class),
			new Opcion("Deslizador", Deslizadores.class), 
			new Opcion("Editor HTML", EditorHTML.class),
			new Opcion("Etiquetas", Etiquetas.class), 
			new Opcion("Hiperenlances", Hiperenlaces.class),
			new Opcion("Información contextual", InformacionContextual.class), 
			new Opcion("Menús", Menus.class),
			new Opcion("Paginación", Paginacion.class), 
			new Opcion("Selector de color", SelectorColor.class), 
			new Opcion("Selector de fecha", SelectorFecha.class),
			new Opcion("Selector de ficheros", SelectorFicheros.class), 
			new Opcion("Separador", Separadores.class),
			new Opcion("Vista de árbol", VistaArbol.class), 
			new Opcion("Vista de lista", VistaLista.class),
			new Opcion("Vista de tabla en árbol", VistaTablaArbol.class), 
			new Opcion("Vista de tabla con propiedades", VistaTabla.class),
			new Opcion("Vista de tabla sin propiedades", VistaTablaSinPropiedades.class)
		);
	private static final ObservableList<Opcion> PANELES = FXCollections.observableArrayList(
			new Opcion("Panel", Panel.class),
			new Opcion("Panel apilado", PanelApilado.class), 
			new Opcion("Panel cuadriculado", PanelCuadricula.class), 
			new Opcion("Panel de bordes", PanelBorde.class),
			new Opcion("Panel de flujo", PanelFlujo.class),
			new Opcion("Panel horizontal", PanelHorizontal.class), 
			new Opcion("Panel vertical", PanelVertical.class)
		);
	private static final ObservableList<Opcion> PERSONALIZACION = FXCollections.observableArrayList(
			new Opcion("Estilos con hoja externa", EstilosHojaExterna.class),
			new Opcion("Estilos en nodos", EstilosNodos.class)
		);
	private static final ObservableList<Opcion> FXML = FXCollections.observableArrayList(
			new Opcion("Aplicación principal", MainApp.class)
		);
	private static final ObservableList<Opcion> MANEJADORES = FXCollections.observableArrayList(
			new Opcion("Manejador de clase", ManejadorClase.class),
			new Opcion("Manejador con clase anónima", ManejadorClaseAnonima.class),
			new Opcion("Manejador usando funciones lambda 1", ManejadorLambda1.class),
			new Opcion("Manejador usando funciones lambda 2", ManejadorLambda2.class)
		);
	private static final ObservableList<Opcion> EVENTOS = FXCollections.observableArrayList(
			new Opcion("Pulsaciones botón", PulsacionesBoton.class),
			new Opcion("Determinar el botón pulsado", DeterminarBotonPulsado.class),
			new Opcion("Campo de texto longitud máxima", CampoTextoLongitudMaxima.class)
		);
	
	@FXML ToggleGroup tgCategoria;
	@FXML RadioButton rbControles;
	@FXML RadioButton rbPaneles;
	@FXML RadioButton rbPersonalizacion;
	@FXML RadioButton rbFxml;
	@FXML RadioButton rbManejadores;
	@FXML RadioButton rbEventos;
	@FXML ListView<Opcion> lvEjemplos;
	
	@FXML
	private void initialize() {
		tgCategoria.selectedToggleProperty().addListener((observable, oldValue, newValue) -> muestraEjemplos());
		lvEjemplos.setItems(CONTROLES);
	}
	
	private void muestraEjemplos() {
		RadioButton categoria = (RadioButton)tgCategoria.getSelectedToggle();
		if (categoria.equals(rbControles)) {
			lvEjemplos.setItems(CONTROLES);
		} else if (categoria.equals(rbPaneles)) {
			lvEjemplos.setItems(PANELES);
		} else if (categoria.equals(rbPersonalizacion)) {
			lvEjemplos.setItems(PERSONALIZACION);
		} else if (categoria.equals(rbFxml)) {
			lvEjemplos.setItems(FXML);
		} else if (categoria.equals(rbManejadores)) {
			lvEjemplos.setItems(MANEJADORES);
		} else if (categoria.equals(rbEventos)) {
			lvEjemplos.setItems(EVENTOS);
		}
	}
	
    @FXML
    void ejecutar(ActionEvent event) throws Exception {
    	Opcion opcion = lvEjemplos.getSelectionModel().getSelectedItem();
    	if (opcion != null) {
    		Application app = (Application) opcion.getClase().getConstructor().newInstance();
    		app.start(new Stage());
    	}
    }
}
