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

	@Override
	public boolean esEstadoPendiente() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean estaAceptado() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean estaCompleto() {
		return false; 
	}


}
