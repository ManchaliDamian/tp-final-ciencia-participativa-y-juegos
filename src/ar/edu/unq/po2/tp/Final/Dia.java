package ar.edu.unq.po2.tp.Final;

public enum Dia {
     Lunes(true), Martes(true) , Miercoles(true) , Jueves(true) , Viernes(true) , Sabado(true) , Domingo(true);
     
     boolean diaDeSemana; 
     
     Dia (boolean esDiaDeSemana){
    	 diaDeSemana = esDiaDeSemana; 
     }
     
     public boolean isDiaDeSemana() {
    	 return diaDeSemana; 
     }
}
