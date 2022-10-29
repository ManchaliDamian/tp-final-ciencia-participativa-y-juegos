package ar.edu.unq.po2.tp.Final;

public class EstadoAceptado extends Estado {


	@Override
	public int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario) {
		  return (desafioDeUsuario.cantidadDeMuestrasRecolectadas() * desafioDeUsuario.muestrasNecesariasParaCompletarDesafio()) / 100; 

	}

	@Override
	protected void actualizarEstado(DesafioDeUsuario desafioDeUsuario) {
		if (this.porcentajeDeCompletitud(desafioDeUsuario) == 100) {
			desafioDeUsuario.setEstado(new EstadoCompleto());
		}
	}
	
	

}
