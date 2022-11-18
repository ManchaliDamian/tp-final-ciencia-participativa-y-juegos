package ar.edu.unq.po2.tp.Final.Restricciones;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

public class RestriccionCompuesta extends Restricciones {
	List<Restricciones> restricciones = new ArrayList<Restricciones>();

	public List<Restricciones> getRestricciones() {
		return restricciones;
	}

	
	public void agregarRestriccion(Restricciones restricción) {
		restricciones.add(restricción);

	}

	@Override
	public boolean isMuestraValida(Muestra muestra) {
		return restricciones.stream().allMatch(r -> r.isMuestraValida(muestra));
		
	}

}
