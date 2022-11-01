package ar.edu.unq.po2.tp.Final;

public class EstadoAceptado extends Estado {
 
	@Override
	public int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario) {
		  return (desafioDeUsuario.cantidadDeMuestrasRecolectadas() * 100) / desafioDeUsuario.cantMuestrasParaCumplirDesafio(); 

	}

	@Override
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) {
		if (this.porcentajeDeCompletitud(desafioDeUsuario) == 100) {
			desafioDeUsuario.setEstado(new EstadoCompleto());
		} else {throw new RuntimeException("no se puede actualizar porque no hay muestras necesarias"); }
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

	
	public boolean estaCompleto() {
		return false; 
	}

 
}
