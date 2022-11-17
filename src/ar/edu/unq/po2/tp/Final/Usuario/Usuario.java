package ar.edu.unq.po2.tp.Final.Usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ar.edu.unq.po2.tp.Final.Proyecto;
import ar.edu.unq.po2.tp.Final.Estados.Estado;
import ar.edu.unq.po2.tp.Final.EstrategiaSeleccion.EstrategiaDeSeleccion;
import ar.edu.unq.po2.tp.Final.EstrategiaSeleccion.PreferenciasDeJuego;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;


public class Usuario {

	private Preferencia preferencia;
	private EstrategiaDeSeleccion estrategia;
	private List<Desafio> desafiosInteres = new ArrayList<Desafio>();

	private List<DesafioDeUsuario> desafios = new ArrayList<DesafioDeUsuario>();
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();

	public Usuario(Preferencia unaPreferencia) {
		this.preferencia = unaPreferencia;
		this.estrategia = new PreferenciasDeJuego(); // por default

	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	public EstrategiaDeSeleccion getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(EstrategiaDeSeleccion estrategia) {
		this.estrategia = estrategia;
	}

	public void agregarDesafio(DesafioDeUsuario desafio) {
		this.desafios.add(desafio);
	}

	public void eliminarDesafio(DesafioDeUsuario desafio1) {
		desafios.remove(desafio1);

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

	public void eliminarProyecto(Proyecto proyecto) {
		proyectos.remove(proyecto);

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
		List<DesafioDeUsuario> desafiosPendientes = new ArrayList<DesafioDeUsuario>();
		for (DesafioDeUsuario d : desafios) {
			if (d.esDesafioAceptado()) {
//<<Correcion>> Rompen encapsulamiento del desafio obteniendo su Estado. No delegan en la clase desafioDelUsuario.
				desafiosPendientes.add(d);
			}

		}
		return desafiosPendientes;
	}
	// <<Correcion>> Codigo repetido para el filtrado de de desafios pendientes y
	// compeltos.

	public List<DesafioDeUsuario> desafiosCompletos() {
		List<DesafioDeUsuario> desafiosCompletos = new ArrayList<DesafioDeUsuario>();
		for (DesafioDeUsuario d : desafios) {
			if (d.esDesafioCompleto()) {
				desafiosCompletos.add(d);
			}
		}
		return desafiosCompletos;
	}

	public double getPorcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario1) {

		return desafioDeUsuario1.getPorcentajeDeCompletitud();

	}

	public void puntuarDesafio(DesafioDeUsuario desafio, int puntuacion) {
		desafio.puntarSiEsDesafioAceptado(puntuacion);
	}

	public void buscarMathConDesafios(List<Desafio> desafios) {
		this.desafiosInteres.addAll(estrategia.desafiosParaElUsuario(this, desafios));
	}

	public void agregarDesafiosDeIntereses() {
		for (Desafio d : desafiosInteres) {
			<<Correcion>> Este mensaje rompe el principio de OpenClose.
			desafios.add(new DesafioDeUsuario(d));
		}
	}

	public List<Desafio> getDesafiosInteres() {
		return desafiosInteres;
	}

	public int porcentajeDeCompletitudGral() {
		int cantidadDeDesafios = desafios.size();
		return (this.desafiosCompletos().size() * 100) / cantidadDeDesafios;
	}

	public Desafio desafioDeUsuarioConMayorPuntaje() {
		Optional<DesafioDeUsuario> defConMayorPuntaje = desafios.stream()
				.max(Comparator.comparing(d -> d.getPuntuacion()));
		return defConMayorPuntaje.get().getDesafio();
	}

	public void agregarProyectos(List<Proyecto> proyectosDePreferencia) {
		for (Proyecto p : proyectosDePreferencia) {
			this.agregarProyecto(p);
		}

	}

	public int cantMuestrasPref() {
		// TODO Auto-generated method stub
		return preferencia.getCantidadDeMuestras();
	}

	public int dificultadPref() {
		// TODO Auto-generated method stub
		return preferencia.getDificultad();
	}

	public int recompensaPref() {
		// TODO Auto-generated method stub
		return preferencia.getRecompensa();
	}
}
