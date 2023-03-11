package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.vista.texto.FuenteVistasTexto;

public enum FactoriaFuenteVistas {

	VISTA_TEXTO {

			@Override
			public IFuenteVistas crear() {
				
				IFuenteVistas fuenteVistasVistaTexto = new FuenteVistasTexto();  
				
				return fuenteVistasVistaTexto;
			}
		};
		
		public abstract IFuenteVistas crear(); 
}

