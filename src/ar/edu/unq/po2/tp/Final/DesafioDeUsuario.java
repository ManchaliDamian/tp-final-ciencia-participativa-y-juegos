package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class DesafioDeUsuario {

	private int puntuacion;
	private Desafio desafio;
	private String nombre; 
	private List<Muestra> muestrasObtenidas = new ArrayList<Muestra>();
	private Estado estado;

	public DesafioDeUsuario (Desafio desafio) {
		this.puntuacion = 0;
		this.desafio = desafio;
		this.nombre = desafio.getNombre(); 
		setEstado(new EstadoPendiente());

	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public void setDesafio(Desafio desafio) {
		this.desafio = desafio;
	}
 
	public Desafio getDesafio() {
		return desafio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Muestra> getMuestrasObtenidas() {
		return muestrasObtenidas;
	}

	public void aceptarDesafio() {
		estado.actualizarEstado(this);

	}
 
	public int cantidadDeMuestrasRecolectadas() {
		return getMuestrasObtenidas().size();
	}

	public int cantMuestrasParaCumplirDesafio() {
		return getDesafio().getCantMuestras();
	}

	public void agregarMuestra(Muestra muestra) {
		if (estado.estaAceptado()) {
			this.agregarSiCumpleRestriccion(muestra);
		}
	} 

	public void agregarSiCumpleRestriccion(Muestra muestra) {
		if (desafio.cumpleConRestriccion(muestra)) {
			this.muestrasObtenidas.add(muestra);
			this.estado.actualizarEstado(this);
		} 
	}

	public double getPorcentajeDeCompletitud() {
		return estado.porcentajeDeCompletitud(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
