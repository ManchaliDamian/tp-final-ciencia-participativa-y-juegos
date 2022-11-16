package ar.edu.unq.po2.tp.Final;

public abstract class Restricciones {

	public void agregarRestriccion(Restricciones restricción) {
		RestriccionCompuesta  r = new RestriccionCompuesta();
		r.agregarRestriccion(restricción);
		
		<<Correcion>> Es codigo no hace nada. Instancia un objeto y nada mas. Ese objeto queda perdido en la memoria
	}
	
	public abstract boolean isMuestraValida(Muestra muestra);
}
