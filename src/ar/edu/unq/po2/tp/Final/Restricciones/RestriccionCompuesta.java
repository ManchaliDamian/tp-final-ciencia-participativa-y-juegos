package ar.edu.unq.po2.tp.Final.Restricciones;

import java.util.ArrayList;
import java.util.List;

public class RestriccionCompuesta extends Restricciones {
	List<Restricciones> restricciones = new ArrayList<Restricciones>();

	public List<Restricciones> getRestricciones() {
		return restricciones;
	}

	@Override
	public void agregarRestriccion(Restricciones restricción) {
		restricciones.add(restricción);

	}

	@Override
	public boolean isMuestraValida(Muestra muestra) {
		List<Restricciones> rests = restricciones;
		while (!rests.isEmpty() && rests.get(0).isMuestraValida(muestra)) {
			rests.remove(0);
		}
		
		<<Correcion>>
		Esta es una manera muy rebuscada. Busque en como funciona el mensaje anyMatch y vean de aplicarlo con el booleano que devuelve isMuestraValida

		return rests.isEmpty();
	}

}
