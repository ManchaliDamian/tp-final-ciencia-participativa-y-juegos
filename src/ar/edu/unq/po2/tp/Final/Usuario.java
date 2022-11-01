package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	// FALTA asignarle desafios (strategy)

	private Preferencia preferencia;
	private EstrategiaDeSeleccion estrategia;
	private List<Desafio> desafiosInteres = new ArrayList<Desafio>(); 

	private List<DesafioDeUsuario> desafios = new ArrayList<DesafioDeUsuario>();
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();
	

	public Usuario(Preferencia unaPreferencia) {
		this.preferencia = unaPreferencia;
		

	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
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

	public void setDesafios(List<DesafioDeUsuario> desafios) {
		this.desafios = desafios;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
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
			if (d.getEstado().esEstadoPendiente()) {
				desafiosPendientes.add(d);
			}

		}
		return desafiosPendientes;
	}

	public List<DesafioDeUsuario> desafiosCompletos() {
		List<DesafioDeUsuario> desafiosCompletos = new ArrayList<DesafioDeUsuario>();
		for (DesafioDeUsuario d : desafios) {
			if (d.getEstado().estaCompleto()) {
				desafiosCompletos.add(d);
			}
		}
		return desafiosCompletos;
	}

	public double getPorcentajeDeCompletitud(DesafioDeUsuario desafioDeUsuario1) {

		return desafioDeUsuario1.getPorcentajeDeCompletitud(); 

	}

	public void desafiosDeInteres(List<Desafio> desafios) {
	   this.desafiosInteres.addAll(estrategia.desafiosParaElUsuario(desafios, this)) ;
	}
	
	public void agregarDesafiosDeIntereses() {
		for (Desafio d : desafiosInteres) {
			desafios.add(new DesafioDeUsuario(d));
		}
	}

	public void puntuarDesafio(DesafioDeUsuario desafio, int puntuacion) {
		if(desafio.getEstado().estaCompleto()) {
			desafio.setPuntuacion(puntuacion);
			System.out.print("la puntuacion es" + " " + puntuacion);
		}

	}

	public EstrategiaDeSeleccion getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(EstrategiaDeSeleccion estrategia) {
		this.estrategia = estrategia;
	}


	public List<Desafio> getDesafiosInteres() {
		return desafiosInteres;
	}

	public void setDesafiosInteres(List<Desafio> desafiosInteres) {
		this.desafiosInteres = desafiosInteres;
	}

}
