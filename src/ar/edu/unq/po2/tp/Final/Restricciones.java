package ar.edu.unq.po2.tp.Final;

public abstract class Restricciones {

	public void agregarRestriccion(Restricciones restricción) {
		RestriccionCompuesta  r = new RestriccionCompuesta();
		r.agregarRestriccion(restricción);
	}
	
	public abstract boolean isMuestraValida(Muestra muestra);
}
