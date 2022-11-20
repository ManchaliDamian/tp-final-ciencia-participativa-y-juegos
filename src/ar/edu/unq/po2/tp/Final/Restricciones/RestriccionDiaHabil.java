package ar.edu.unq.po2.tp.Final.Restricciones;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

public class RestriccionDiaHabil extends Restricciones {


	@Override
	public boolean isMuestraValida(Muestra muestra) {
		return muestra.valorDeDiaDeSemana() > 6; 
	}

}
