package ar.edu.unq.po2.tp.Final.Usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ar.edu.unq.po2.tp.Final.Proyecto;
import ar.edu.unq.po2.tp.Final.EstrategiaSeleccion.EstrategiaDeSeleccion;
import ar.edu.unq.po2.tp.Final.EstrategiaSeleccion.PreferenciasDeJuego;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;


public class Usuario {

	private Preferencia preferencia;
	private EstrategiaDeSeleccion estrategia;
	private List<DesafioDeUsuario> desafios = new ArrayList<DesafioDeUsuario>();
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();

	public Usuario(Preferencia unaPreferencia) {
		this.preferencia = unaPreferencia;
		this.estrategia = new PreferenciasDeJuego(); // por default

	}

	

	public void agregarDesafio(DesafioDeUsuario desafio) {
		this.desafios.add(desafio);
	}

	public List<DesafioDeUsuario> getDesafios() {
		return desafios;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void agregarProyecto(Proyecto p) {
		this.proyectos.add(p);
	}

	public void agregarMuestra(Muestra muestra, Proyecto proyecto) {
		proyecto.agregarMuestra(muestra);
		for (DesafioDeUsuario d : desafios) {
			d.agregarMuestra(muestra);
		}

	}

	public void aceptarDesafiosPendientes() {
		for (DesafioDeUsuario d : desafios) {
			d.aceptarDesafio();
		}
	}

	public List<DesafioDeUsuario> desafiosPendientes() {
		List<DesafioDeUsuario> desafiosPendientes = desafios.stream().filter(d -> d.esDesafioPendiente()).toList();
		return desafiosPendientes;
	}
	
	public List<DesafioDeUsuario> desafiosCompletos() {
		List<DesafioDeUsuario> desafiosCompletos = desafios.stream().filter(d -> d.esDesafioCompleto()).toList();
		return desafiosCompletos;
	}
	
	
	public double getPorcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario1) {
		return desafioDeUsuario1.getPorcentajeDeCompletitud();

	}

	public void puntuarDesafio(DesafioDeUsuario desafio, int puntuacion) {
		desafio.puntuarDesafio(puntuacion); 
	}

	public void buscarMathConDesafios(List<Desafio> desafiosParaUsuario) {
		List<Desafio> desafiosDeInteres = estrategia.desafiosParaElUsuario(this, desafiosParaUsuario);
		desafiosDeInteres.stream().forEach(d -> desafios.add(d.nuevoDesafioDeUsuario())); 
	}

	public int porcentajeDeCompletitudGral() {
		int cantidadDeDesafios = desafios.size();
		return (this.desafiosCompletos().size() * 100) / cantidadDeDesafios;
	}

	public DesafioDeUsuario desafioDeUsuarioConMayorPuntaje() {
		Optional<DesafioDeUsuario> defConMayorPuntaje = desafios.stream()
				.max(Comparator.comparing(d -> d.getPuntuacion()));
		return defConMayorPuntaje.get();
	}

	public void agregarProyectos(List<Proyecto> proyectosDePreferencia) {
		for (Proyecto p : proyectosDePreferencia) {
			this.agregarProyecto(p); 
		}

	}

	public int cantMuestrasPref() {
		return preferencia.getCantidadDeMuestras();
	}

	public int dificultadPref() {
		return preferencia.getDificultad();
	}

	public int recompensaPref() {
		return preferencia.getRecompensa();
	}
}
