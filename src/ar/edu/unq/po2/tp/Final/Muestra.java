package ar.edu.unq.po2.tp.Final;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Muestra {
	private Coordenada cordGeografica;
	private Usuario usuario;
	private LocalDate fecha;
	private ChronoLocalDate hora; 
	
	public Muestra(Coordenada cord, Usuario unUsuario, LocalDate fecha, ChronoLocalDate hora) {
		this.cordGeografica = cord;
		this.usuario = unUsuario;
		this.fecha = fecha;
		this.hora = hora; 
	}
	
	public Coordenada getCordGeografica() {
		return cordGeografica;
	}
	public void setCordGeografica(Coordenada cordGeografica) {
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

}
