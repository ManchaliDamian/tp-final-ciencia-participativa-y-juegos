package ar.edu.unq.po2.tp.Final.Usuario;

import ar.edu.unq.po2.tp.Final.Muestra.AreaGeografica;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Restricciones.RestriccionArea;
import ar.edu.unq.po2.tp.Final.Restricciones.Restricciones;

public class Desafio {
	private AreaGeografica area;
	private String nombre;
	private Restricciones restriccionTemp;
	private int cantMuestras;
	private int dificultad;
	private int recompensa;

	public Desafio(AreaGeografica area, int cantMuestras, int dificultad, int recompesas, String nombre) {
		this.area = area;
		this.nombre = nombre;
		this.cantMuestras = cantMuestras;
		this.dificultad = dificultad;
		this.recompensa = recompesas;
		restriccionTemp = new RestriccionArea(area);
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setRestriccion(Restricciones r) {
		this.restriccionTemp = r; 
	}


	public Restricciones getRestriccionTemp() {
		return restriccionTemp;
	}

	public int getCantMuestras() {
		return cantMuestras;
	}


	public int getDificultad() {
		return dificultad;
	}

	public int getRecompensa() {
		return recompensa;
	}

	public Integer coincidenciaPorPref(Usuario usuario) {
		int coin = this.diferenciaEntre(cantMuestras, usuario.cantMuestrasPref())
				+ diferenciaEntre(dificultad, usuario.dificultadPref())
				+ diferenciaEntre(recompensa, usuario.recompensaPref());

		return coin;
	}

	public Integer coincidenciaPorFav(Desafio desafioConMayorPuntaje) {
		int coin = this.diferenciaEntre(cantMuestras, desafioConMayorPuntaje.getCantMuestras())
				+ diferenciaEntre(dificultad, desafioConMayorPuntaje.getDificultad())
				+ diferenciaEntre(recompensa, desafioConMayorPuntaje.getRecompensa());
		return coin;
	}

	public int diferenciaEntre(int unNumero, int otroNumero) {
		return Math.abs(unNumero - otroNumero);
	}

	public boolean cumpleConRestriccion(Muestra muestra) {
		return restriccionTemp.isMuestraValida(muestra); 
	}

	public DesafioDeUsuario nuevoDesafioDeUsuario() {
		DesafioDeUsuario desafioDeUsuario= new DesafioDeUsuario(this);
		return desafioDeUsuario;
	}

}
