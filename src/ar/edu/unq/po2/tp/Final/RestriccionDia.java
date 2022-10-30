package ar.edu.unq.po2.tp.Final;

public class RestriccionDia extends Restricciones{
	private Dia dia;

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	@Override
	public Boolean validarMuestra(Muestra muestra, Desafio desafio) {
		
		return null;
	} 
	
	public boolean esDiaDeSemana(Dia dia) {
		if(dia == Dia.Lunes ) {
			 return true; 
		} else if(dia == Dia.Martes) {
			return true; 
		} else if(dia == Dia.Miercoles) {
			return true; 
		} else if (dia == Dia.Jueves) {
			return true; 
		
		} else if (dia == Dia.Viernes) {
			return true; 
		} else return false; 
		
	}
	
	
	
    

}
