package ar.edu.unq.po2.tp.Final.Restricciones;

import ar.edu.unq.po2.tp.Final.Dia;
import ar.edu.unq.po2.tp.Final.Muestra;

public class RestriccionDia extends Restricciones {
	private Dia dia;

	public RestriccionDia(Dia unDia) {
		this.dia = unDia;

	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	@Override
	public boolean isMuestraValida(Muestra muestra) {
		return muestra.getDia() == this.dia;
	}

}
