package ar.edu.unq.po2.tp.Final;

public abstract class Estado {

	public abstract int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario);

	public abstract void actualizarEstado(DesafioDeUsuario desafioDeUsuario);

	public abstract boolean esEstadoPendiente();

	public abstract boolean estaAceptado();
	
	public abstract boolean estaCompleto(); 



}
