package ar.edu.unq.po2.tp.Final.Estados;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Usuario.DesafioDeUsuario;

public class EstadoAceptado extends Estado {

	@Override
	public int porcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario) {
		return (desafioDeUsuario.cantidadDeMuestrasRecolectadas() * 100)
				/ desafioDeUsuario.cantMuestrasParaCumplirDesafio();

	}

	@Override
	public void actualizarEstado(DesafioDeUsuario desafioDeUsuario) {
		if (porcentajeDeCompletitud(desafioDeUsuario) == 100) {
			desafioDeUsuario.setEstado(new EstadoCompleto());
   
		}  

	} 

	@Override
	public boolean estaAceptado() {
		return true;
	}

	public void agregarSiCumpleRestriccion(Muestra muestra, DesafioDeUsuario desafioDeUsuario) {
		desafioDeUsuario.agregarMuestra(muestra);
	}
	
	@Override
	public void puntuarDesafio(int puntuacion, DesafioDeUsuario desafioDeUsuario) {
		
	}

}
