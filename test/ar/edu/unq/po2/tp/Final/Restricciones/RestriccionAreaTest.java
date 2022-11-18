package ar.edu.unq.po2.tp.Final.Restricciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.geom.Area;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.AreaGeografica;

class RestriccionAreaTest {
	AreaGeografica area; 
	Restricciones restriccionArea;

	@BeforeEach
	public void setUp() throws Exception {
		area = mock(AreaGeografica.class); 
		restriccionArea = new RestriccionArea(area);
	}

}
