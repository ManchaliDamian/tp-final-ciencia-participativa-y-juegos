package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class RestriccionDiaYFecha extends Restricciones{
	List<Restricciones> restricciones = new ArrayList<Restricciones>();public List<Restricciones> getRestricciones() {
		return restricciones;
	}

	@Override
	public void agregarRestriccion(Restricciones restricción) {
		restricciones.add(restricción); 
		
	}

	@Override
	public boolean isMuestraValida(Muestra muestra) {
		List<Restricciones> rests = restricciones; 
		for (Restricciones restriccion : rests) {
			if(restriccion.isMuestraValida(muestra)) {
				rests.remove(restriccion); 
			}
		}
		
		return rests.isEmpty();
	}

}
