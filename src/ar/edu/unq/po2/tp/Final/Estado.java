package ar.edu.unq.po2.tp.Final;

public abstract class Estado {

	public abstract int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario);

	protected abstract void actualizarEstado(DesafioDeUsuario desafioDeUsuario);

}
