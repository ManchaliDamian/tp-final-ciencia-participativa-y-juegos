package ar.edu.unq.po2.tp.Final;

import java.time.LocalDate;

public abstract class Restricciones {
	// falta ver como se compara las restriciones del desafio con la de la muestra

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Dia dia;
	
	public Restricciones(LocalDate fechaDeInicio, LocalDate fechaFin, Dia día) {
		this.fechaInicio = fechaDeInicio;
		this.fechaFin = fechaFin;
		this.dia = día; 
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public abstract Boolean validarMuestra(Muestra muestra, Desafio desafio);
}
