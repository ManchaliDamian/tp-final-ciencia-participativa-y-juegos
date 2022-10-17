package ar.edu.unq.po2.tp.Final;

public class Coordenada {
   private int latitud;
   private int longuitud;
   
   public Coordenada(int latitud, int longuitud) {
	   setLatitud(latitud);
	   setLonguitud(longuitud);
   }
   
public int getLatitud() {
	return latitud;
}
public void setLatitud(int latitud) {
	this.latitud = latitud;
}
public int getLonguitud() {
	return longuitud;
}
public void setLonguitud(int longuitud) {
	this.longuitud = longuitud;
} 
}
