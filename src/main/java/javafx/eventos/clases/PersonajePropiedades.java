package javafx.eventos.clases;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonajePropiedades {
	
	public enum Estrategia {
		RISA,
		MALHUMOR,
		ATAQUE
	}
	
	private final StringProperty nombre = new SimpleStringProperty();
	private final IntegerProperty poder = new SimpleIntegerProperty();
	private final BooleanProperty superpoder = new SimpleBooleanProperty();
	private final ObjectProperty<Estrategia> estrategia = new SimpleObjectProperty<>();
	
	public PersonajePropiedades(String nombre, int poder, boolean superpoder, Estrategia estrategia) {
		this.nombre.set(nombre);
		this.poder.set(poder);
		this.superpoder.set(superpoder);
		this.estrategia.set(estrategia);
	}

	public final String getNombre() {
		return nombre.get();
	}
	
	public final void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	
	public final StringProperty nombreProperty() {
		return nombre;
	}
	
	public final int getPoder() {
		return poder.get();
	}
	
	public final void setPoder(int poder) {
		this.poder.set(poder);
	}
	
	public final IntegerProperty poderProperty() {
		return poder;
	}
	
	public final boolean isSuperpoder() {
		return superpoder.get();
	}
	
	public final void setSuperpoder(boolean superpoder) {
		this.superpoder.set(superpoder);
	}
	
	public final BooleanProperty superpoderProperty() {
		return superpoder;
	}
	
	public final Estrategia getEstrategia() {
		return estrategia.get();
	}
	
	public final void setEstrategia(Estrategia estrategia) {
		this.estrategia.set(estrategia);
	}
	
	public final ObjectProperty<Estrategia> estrategiaProperty() {
		return estrategia;
	}

	public String toString() {
		return String.format("Nombre: %s, Poder: %d, Superpoder: %b, Estrategia: %s",
				nombre.get(), poder.get(), superpoder.get(), estrategia.get());
	}
}