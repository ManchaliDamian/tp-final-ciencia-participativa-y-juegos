package ar.edu.unq.po2.tp.Final;

public abstract class Estado {
	
	<<Correcion>> Por comentarios en otras clases. Los Estados casi no tiene comportamiento, porque no delegaron en los estados.

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



}
