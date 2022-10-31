package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
   Sistema sistema;
   Usuario usuario1; 
   Usuario usuario2; 

   Desafio desafio1; 
   Desafio desafio2;
   
   @BeforeEach
   public void setUp() throws Exception {
	   sistema = new Sistema();
	   usuario1 = mock(Usuario.class);
	   usuario2 = mock(Usuario.class);
	   desafio1 = mock(Desafio.class);
	   desafio2 = mock(Desafio.class);
	   
	   List<Usuario> usuarios = new ArrayList<Usuario>(); 
	   usuarios.add(usuario1);
	   usuarios.add(usuario2); 
	   
	   List<Desafio> desafios = new ArrayList<Desafio>(); 
	   desafios.add(desafio1);
	   desafios.add(desafio2);

   }
   
   @Test
   void testElSistemaRecomiendaDesafiosALosUsuariosDelSistema() {
	   List<Usuario> usuarios = new ArrayList<Usuario>(); 
	   usuarios.add(usuario1);
	   usuarios.add(usuario2); 
	   
	   List<Desafio> desafios = new ArrayList<Desafio>(); 
	   desafios.add(desafio1);
	   desafios.add(desafio2);
	   
	   sistema.recomendarDesafios(usuarios, desafios);
	   
	   verify(usuario1 , times(1)).desafiosDeInteres(desafios);
	   
   }
   
}
