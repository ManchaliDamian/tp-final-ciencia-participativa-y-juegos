package ar.edu.unq.po2.tp.Final.Muestra;

public class CoordenadaGeografica {

	private int latitud;
	private int longitud;
	
	public CoordenadaGeografica(int latitud, int longitud) {
		this.latitud = latitud;
		this.longitud = longitud; 
	}

	public int getLatitud() {
		return latitud;
	}


	public int getLongitud() {
		return longitud;
	}


	public boolean seEncuentraDentroDelRadio(AreaGeografica areaGeografica) {
		// TODO Auto-generated method stub
		return distanciaSobreElArea(areaGeografica) <= areaGeografica.getRadio();
	}
	
	public double distanciaSobreElArea(AreaGeografica area) {
		int resultado = diferenciaYMultEntre(area.longitudDeCoordenada(), longitud)
				+ diferenciaYMultEntre(area.latitudDeCoordenada(), latitud);

		return Math.sqrt(resultado); //Raíz cuadrada
	}

	public int diferenciaYMultEntre(int unNumero, int otroNumero) {
		int dif = unNumero - otroNumero;
		int mult = dif * dif; 
		return mult;
	}

	
	
}
