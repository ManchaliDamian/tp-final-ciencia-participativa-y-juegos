package ar.edu.unq.po2.tp.Final;

public class EstadoCompleto extends Estado {
 
	@Override
	public int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario) {
		return 100; 
	}

	@Override
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) {
		
	}

	public boolean estaCompleto() {
		return true; 
	}

}
