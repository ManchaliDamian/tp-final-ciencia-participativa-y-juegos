package ar.edu.unq.po2.tp.Final;

import java.time.LocalDate;

public abstract class Restricciones {
	// falta ver como se compara las restriciones del desafio con la de la muestra

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Dia dia;

	public abstract Boolean validarMuestra(Muestra muestra, Desafio desafio);
}
