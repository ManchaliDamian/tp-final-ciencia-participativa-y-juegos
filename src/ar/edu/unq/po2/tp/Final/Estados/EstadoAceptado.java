package ar.edu.unq.po2.tp.Final.Estados;

import ar.edu.unq.po2.tp.Final.DesafioDeUsuario;

public class EstadoAceptado extends Estado {
 
	@Override
	public int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario) {
		  return (desafioDeUsuario.cantidadDeMuestrasRecolectadas() * 100) / desafioDeUsuario.cantMuestrasParaCumplirDesafio(); 

	}

	@Override
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) {
		if (this.porcentajeDeCompletitud(desafioDeUsuario) == 100) {
			desafioDeUsuario.setEstado(new EstadoCompleto());
	
		}
		
	} 

	@Override
	public boolean estaAceptado() {
		return true;
	}

	

 
}
