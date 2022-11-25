package ar.edu.unq.po2.tp.Final.Usuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tp.Final.Estados.Estado;
import ar.edu.unq.po2.tp.Final.Estados.EstadoPendiente;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

public class DesafioDeUsuario {

	private Integer puntuacion;
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

	public Integer getPuntuacion() {
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
		return  muestrasObtenidas.size();
	}

	public int cantMuestrasParaCumplirDesafio() {
		return desafio.getCantMuestras();
	}

	public void agregarMuestra(Muestra muestra) { 
		estado.agregarSiCumpleRestriccion(muestra, this);
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

	public void puntuarDesafio(int puntuacion) {
		estado.puntuarDesafio(puntuacion, this); 
	}

	public boolean esDesafioAceptado() {
		return estado.estaAceptado();
	}

	public boolean esDesafioCompleto() {
		return estado.estaCompleto();
	}
	
	public boolean esDesafioPendiente() {
		return estado.esEstadoPendiente();
	}
	
}
