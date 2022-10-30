package ar.edu.unq.po2.tp.Final;

public abstract class Restricciones {
	// falta ver como se compara las restriciones del desafio con la de la muestra
	public abstract void agregarRestriccion(Restricciones restricción); 
	
	public abstract boolean isMuestraValida(Muestra muestra);
}
