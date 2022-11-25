package ar.edu.unq.po2.tp.Final.Muestra;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public class Muestra {
	private CoordenadaGeografica cordGeografica;
	private Usuario usuario;
	private LocalDate fecha;
	private LocalTime hora;

	public Muestra(CoordenadaGeografica cord, Usuario unUsuario, LocalDate fecha, LocalTime hora) {
		this.cordGeografica = cord;
		this.usuario = unUsuario;
		this.fecha = fecha;
		this.hora = hora;
	}

	public CoordenadaGeografica getCordGeografica() {
		return cordGeografica;
	}

	public void setCordGeografica(CoordenadaGeografica cordGeografica) {
		this.cordGeografica = cordGeografica;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean seEncuentraDentroDeLasFechasDeDesafio(LocalDate fechaInicio, LocalDate fechaFin) {
		return fecha.isAfter(fechaInicio) && fecha.isBefore(fechaFin);
	}

	public DayOfWeek diaDeLaSemana() {
		return fecha.getDayOfWeek();
	}

	public int valorDeDiaDeSemana() {
		// TODO Auto-generated method stub
		return diaDeLaSemana().getValue();
	}
}
