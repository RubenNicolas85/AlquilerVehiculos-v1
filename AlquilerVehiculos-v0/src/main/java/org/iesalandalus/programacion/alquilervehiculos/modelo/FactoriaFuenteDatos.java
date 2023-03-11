package org.iesalandalus.programacion.alquilervehiculos.modelo;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.FuenteDatosMemoria;

public enum FactoriaFuenteDatos {
	
	MEMORIA {

		@Override
		public IFuenteDatos crear() {
			
			IFuenteDatos fuenteDatosMemoria = new FuenteDatosMemoria();  
			
			return fuenteDatosMemoria;
		}
	}; 	
	
	public abstract IFuenteDatos crear(); 
}
	
	

