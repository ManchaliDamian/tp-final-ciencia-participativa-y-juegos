package ar.edu.unq.po2.tp.Final;

public abstract class Estado {
	
	// public no hacer nada y si esta aceptado y cumple restriccion y lo 
	//agrega a la lista de muestras

	public abstract int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario);

	public abstract void actualizarEstado(DesafioDeUsuario desafioDeUsuario);

	public abstract boolean esEstadoPendiente();


}
