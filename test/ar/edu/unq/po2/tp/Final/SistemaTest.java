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
   Preferencia preferecia; 
   PreferenciasDeJuego preJuego; 

   Desafio desafio1; 
   Desafio desafio2;
   List<Usuario> usuarios = new ArrayList<Usuario>(); 
   List<Desafio> desafios = new ArrayList<Desafio>(); 
   @BeforeEach
   public void setUp() throws Exception {
	   
	   
	   sistema = new Sistema();
	   preferecia = new Preferencia(4, 10, 6);
	   desafio1 = new Desafio(null, null, 10, 4, 15); 
	   desafio2 = new Desafio(null, null, 5, 10, 6); 
	   usuario1 = new Usuario(preferecia); 
	   preJuego = new PreferenciasDeJuego();
	   
	   usuarios.add(usuario1);
	   desafios.add(desafio1);
	   desafios.add(desafio2);

   }
   
   @Test
   void testElSistemaRecomiendaDesafiosALosUsuariosDelSistema() {
	   usuario1.setEstrategia(preJuego);

	   sistema.recomendarDesafios(usuarios, desafios);
	   
	   assertEquals(usuario1.getDesafiosInteres().get(0), desafio2); 
	   assertEquals(usuario1.getDesafiosInteres().get(1), desafio1); 

	   assertTrue(usuario1.getDesafiosInteres().containsAll(desafios)); 
   }
    
   
}
