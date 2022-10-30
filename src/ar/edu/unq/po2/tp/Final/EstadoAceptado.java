package ar.edu.unq.po2.tp.Final;

public class EstadoAceptado extends Estado {

 
	@Override
	public int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario) {
		  return (desafioDeUsuario.cantidadDeMuestrasRecolectadas() * desafioDeUsuario.cantMuestrasParaCumplirDesafio()) / 100; 

	}

	@Override
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) {
		if (this.porcentajeDeCompletitud(desafioDeUsuario) == 100) {
			desafioDeUsuario.setEstado(new EstadoCompleto());
		}
	}

	@Override
	public boolean esEstadoPendiente() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estaAceptado() {
		// TODO Auto-generated method stub
		return true;
	}

	
	

}
