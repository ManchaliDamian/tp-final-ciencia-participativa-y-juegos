package ar.edu.unq.po2.tp.Final;

public class EstadoCompleto extends Estado {
 
	@Override
	public int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario) {
		return 100; 
	}

	@Override
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) {
		
	}

	@Override
	public boolean esEstadoPendiente() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estaAceptado() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean estaCompleto() {
		return true; 
	}

}
