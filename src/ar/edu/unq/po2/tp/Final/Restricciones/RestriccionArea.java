package ar.edu.unq.po2.tp.Final.Restricciones;

import ar.edu.unq.po2.tp.Final.Muestra.Area;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

public class RestriccionArea extends Restricciones {
	
	private Area area; 
	
	public RestriccionArea(Area unArea) {
		this.area = unArea;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Override
	public boolean isMuestraValida(Muestra muestra) {
		// TODO Auto-generated method stub
		return area.esCoordenadaGeograficaValida(muestra.getCordGeografica());
		
	}

}
