package ar.edu.unq.po2.tp.Final;

import java.time.LocalDate;

public class RestriccionFecha extends Restricciones {
	  private LocalDate fechaInicio;
	    private LocalDate fechaFin;
	    
	public RestriccionFecha(LocalDate unaFechaInicio, LocalDate unaFechaFin) {
		this.fechaInicio = unaFechaInicio; 
		this.fechaFin = unaFechaFin; 
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
	
	@Override
	public boolean isMuestraValida(Muestra muestra) {
		   return fechaInicio.isBefore(muestra.getFecha()) && fechaFin.isAfter(muestra.getFecha()); 
	}

	@Override
	public void agregarRestriccion(Restricciones restricción) {
		RestriccionDiaYFecha  r = new RestriccionDiaYFecha();
		r.agregarRestriccion(restricción);
		
	} 
		
	
	
	
}
    