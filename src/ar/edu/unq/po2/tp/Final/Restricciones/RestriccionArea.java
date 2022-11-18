package ar.edu.unq.po2.tp.Final.Restricciones;
import ar.edu.unq.po2.tp.Final.Muestra.AreaGeografica;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

public class RestriccionArea extends Restricciones {
	
	private AreaGeografica area; 
	
	public RestriccionArea(AreaGeografica unArea) {
		this.area = unArea;
	}

	public AreaGeografica getAreaGeografica() {
		return area;
	}

	public void setAreaGeografica(AreaGeografica area) {
		this.area = area;
	}

	@Override
	public boolean isMuestraValida(Muestra muestra) {
		return area.esCoordenadaGeograficaValida(muestra.getCordGeografica());
		
	}

}
