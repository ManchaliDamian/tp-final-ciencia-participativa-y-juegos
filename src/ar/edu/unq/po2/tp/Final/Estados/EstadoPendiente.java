package ar.edu.unq.po2.tp.Final.Estados;

import ar.edu.unq.po2.tp.Final.Usuario.DesafioDeUsuario;

public class EstadoPendiente extends Estado {

	@Override
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) {
		desafioDeUsuario.setEstado(new EstadoAceptado());
	}

	@Override
	public int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario) {
		return 0;
	}

	public boolean esEstadoPendiente() {
		return true;
	}

	public void puntuarDesafio(int puntuacion, DesafioDeUsuario desafioDeUsuario) {

	}

}
