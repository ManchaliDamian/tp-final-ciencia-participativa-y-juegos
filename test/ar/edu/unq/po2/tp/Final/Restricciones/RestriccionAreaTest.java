package ar.edu.unq.po2.tp.Final.Restricciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.geom.Area;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionAreaTest {
	Area area; 
	Restricciones restriccionArea;

	@BeforeEach
	public void setUp() throws Exception {
		area = mock(Area.class); 
		restriccionArea = new RestriccionArea(area);
	}

}
