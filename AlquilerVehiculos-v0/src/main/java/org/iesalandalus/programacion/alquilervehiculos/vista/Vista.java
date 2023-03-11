package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public abstract class Vista {

	protected IFuenteVistas fuenteVistas; 
	protected Controlador controlador; 
	
	protected void setFuenteVistas(IFuenteVistas fuenteVistas) {
		
		this.fuenteVistas=fuenteVistas; 
	}
	
	public void setControlador(Controlador controlador) {
		
		if(!(controlador==null)) {
			
			this.controlador=controlador; 
		}
	}
	
	public abstract void comenzar() throws Exception; 
	
	public abstract void terminar(); 
}
