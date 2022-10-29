package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class DesafioDeUsuario {
	//  FALTA comparar las muestras
	// FALTA testear los estados si funcionan (no pude implementarlos)
	
	private int puntuacion;
	private Desafio desafio;
	private List<Muestra> muestrasObtenidas = new ArrayList<Muestra>();
	private Estado estado;

	public DesafioDeUsuario(int puntuacion, Desafio desafio) {
		setPuntuacion(puntuacion);
		setEstado(new EstadoPendiente());
		muestrasObtenidas = new ArrayList<Muestra>();
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

	public void aceptarDesafio() {
		if (this.getEstado() == new EstadoPendiente()) { //no funciona :(
			this.setEstado(new EstadoAceptado());
		} else
			this.getEstado();
		
		//Lo que haría es this.getEstado().actualizar(); 

	}

	public void desafioCompletado() {
		if (muestrasObtenidas.size() == this.desafio.getCantMuestras()) {
			this.setEstado(new EstadoCompleto());
		}
	}

	public List<Muestra> getMuestrasObtenidas() {
		return muestrasObtenidas;
	}

	public void setMuestrasObtenidas(List<Muestra> muestrasObtenidas) {
		this.muestrasObtenidas = muestrasObtenidas;
	}

	public Integer cantidadDeMuestrasRecolectadas() {
		return getMuestrasObtenidas().size();
	}
	
	public Integer muestrasNecesariasParaCompletarDesafio() {
		return getDesafio().getCantMuestras(); 
	}

}
