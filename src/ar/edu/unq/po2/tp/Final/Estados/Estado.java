package ar.edu.unq.po2.tp.Final.Estados;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Usuario.DesafioDeUsuario;

public abstract class Estado {

	// <<Correcion>> Por comentarios en otras clases. Los Estados casi no tiene
	// comportamiento, porque no delegaron en los estados.

	public abstract int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario);

	public abstract void actualizarEstado(DesafioDeUsuario desafioDeUsuario);

	public boolean esEstadoPendiente() {
		return false;
	}

	public boolean estaAceptado() {
		return false; 
	}

	public boolean estaCompleto() {
		return false;
	}

	public void agregarSiCumpleRestriccion(Muestra muestra, DesafioDeUsuario desafioDeUsuario) {
	}

	public abstract void puntuarDesafio(int puntuacion, DesafioDeUsuario desafioDeUsuario);

}
