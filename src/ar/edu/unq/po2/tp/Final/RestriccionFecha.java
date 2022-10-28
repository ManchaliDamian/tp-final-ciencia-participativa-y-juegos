package ar.edu.unq.po2.tp.Final;

import java.time.LocalDate;

public class RestriccionFecha extends Restricciones {
	  private LocalDate fechaInicio;
	    private LocalDate fechaFin;
	
	@Override
	public Boolean validarMuestra(Muestra muestra, Desafio desafio) {
		   muestra.getFecha() 
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
		
	
	
	
}
    
	
<<<<<<< HEAD
=======
	
}
>>>>>>> 154b7b74123081a7c56f829157473bfa6f5f32a2
