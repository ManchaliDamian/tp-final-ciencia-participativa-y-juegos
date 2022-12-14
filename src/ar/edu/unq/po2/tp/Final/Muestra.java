package ar.edu.unq.po2.tp.Final;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Muestra {
	private CoordenadaGeografica cordGeografica;
	private Usuario usuario;
	private LocalDate fecha;
	private ChronoLocalDate hora; 
	private Dia dia; 
	 
	public Muestra(CoordenadaGeografica cord, Usuario unUsuario, LocalDate fecha, ChronoLocalDate hora, Dia dia) {
		this.cordGeografica = cord;
		this.usuario = unUsuario;
		this.fecha = fecha;
		this.hora = hora; 
		this.dia = dia; 
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
	public ChronoLocalDate getHora() {
		return hora;
	}
	public void setHora(ChronoLocalDate hora) {
		this.hora = hora;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}
	
	

}
