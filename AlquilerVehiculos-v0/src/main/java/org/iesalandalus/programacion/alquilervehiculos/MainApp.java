package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.vista.FactoriaFuenteVistas;
import org.iesalandalus.programacion.alquilervehiculos.vista.IFuenteVistas;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;
import org.iesalandalus.programacion.alquilervehiculos.vista.texto.VistaTexto;

public class MainApp {
	
	/* En el método main se hace uso del patrón factoría abstracta para crear una fuente de datos, en este
	 * caso con la única fuente de datos de que disponemos de momento, MEMORIA. Una vez creada, como tenemos 
	 * la clase modelo como abstracta instanciamos un nuevo modelo cascada, cuyo atributo es la interfaz 
	 * fuente de datos memoria. Para la vista hemos creado también un enum con la factoría Fuente Vistas.
	 * 
	 *  Cuando tenemos creados tanto la fuente de datos (MEMORIA) y la vistaTexto procedermos a instanciar el 
	 *  controlador y a ejecutar su método comenzar */
	
	public static void main(String[] args) throws Exception {

		@SuppressWarnings("unused")
		boolean error = false;

		try {

			error = false;

			IFuenteVistas fuenteVistas = FactoriaFuenteVistas.VISTA_TEXTO.crear();
			IFuenteDatos fuenteDatos = FactoriaFuenteDatos.MEMORIA.crear();

			Vista vistaTexto = new VistaTexto(fuenteVistas);
			Modelo modeloCascada = new ModeloCascada(fuenteDatos);

			Controlador controlador = new Controlador(modeloCascada, vistaTexto);
			controlador.comenzar();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			error = true;
		}

		/*
		 * Modelo modelo = new Modelo(); Vista vista = new Vista();
		 * 
		 * Controlador controlador = new Controlador(modelo, vista);
		 * controlador.comenzar();
		 */
	}
}
