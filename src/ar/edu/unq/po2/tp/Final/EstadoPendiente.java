package ar.edu.unq.po2.tp.Final;

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


}
