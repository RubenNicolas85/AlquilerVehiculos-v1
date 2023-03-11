package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import org.iesalandalus.programacion.alquilervehiculos.vista.IFuenteVistas;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;
import java.time.LocalDate;
import java.util.Iterator;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class VistaTexto extends Vista {

	public VistaTexto(IFuenteVistas fuenteVistas) {
		
		setFuenteVistas(fuenteVistas); 
		Accion.setVista(this);
	}
		
	public void comenzar() throws Exception {
		
		boolean salir = false;
		
		do {
			
			Consola.mostrarMenuAcciones();
			System.out.println(); 
			Accion accion = Consola.elegirAccion(); 
			System.out.println(); 
			accion.ejecutar();
			System.out.println(); 
			
		} while (!salir); 
	}

	public void terminar() {

		controlador.terminar();
	}

	protected void insertarCliente() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.INSERTAR_CLIENTE);

		try {
			Cliente cliente = new Cliente(Consola.leerCliente());
			controlador.insertar(cliente);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	protected void insertarVehiculo() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.INSERTAR_VEHICULO);

		try {
			
			controlador.insertar(Consola.leerVehiculo()); 

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	protected void insertarAlquiler() throws Exception {
		
		/* Se puede insertar un nuevo alquiler tanto con cliente y vehículo no existentes como
		 * con cliente y vehículos ya existentes e insertados anteriormente (se buscan por DNI
		 * o por matrícula): */
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.INSERTAR_ALQUILER);

		System.out.println("1. Insertar alquiler de nuevo cliente y vehículo:"
				+ " \n2. Insertar alquiler de cliente y vehículo ya existentes: ");

		int opcion = Entrada.entero();

		switch (opcion) {

		case 1:
			try {
				Alquiler alquiler = new Alquiler(Consola.leerAlquiler());
				controlador.insertar(alquiler);

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;

		case 2:
			try {
				Cliente cliente = controlador.buscar(Consola.leerClienteDni());
				Vehiculo vehiculo = controlador.buscar(Consola.leerVehiculoMatricula());

				Alquiler alquiler = new Alquiler(cliente, vehiculo, Consola.leerFechaAlquiler());
				controlador.insertar(alquiler);

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;
		}
	}

	protected void buscarCliente() {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.BUSCAR_CLIENTE);

		try {
			System.out.println(controlador.buscar(Consola.leerClienteDni()));

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	protected void buscarVehiculo() {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.BUSCAR_VEHICULO);

		try {

			System.out.println(controlador.buscar(Consola.leerVehiculoMatricula()));

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	protected void buscarAlquiler() {
		
		/* Tanto buscando por DNI de cliente como por matrícula de Vehículo, se crea un alquiler
		 * genérico cuyo único parámetro para comparar con otro a existente o no es el propio DNI
		 * o la matrícula del Vehículo: */
		
		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.BUSCAR_ALQUILER);

		System.out.println("1. Buscar por DNI de cliente :\n2. Buscar por matrícula de vehículo: ");

		int opcion = Entrada.entero();

		switch (opcion) {

		case 1:

			try {

				Cliente cliente = Consola.leerClienteDni();
				Vehiculo vehiculo = new Turismo("Seat", "León", 1900, "1440FFK");
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, vehiculo, fechaAlquiler);

				System.out.println(controlador.buscar(alquiler));

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;

		case 2:

			try {

				Cliente cliente = new Cliente("Nombre", "75722433Q", "900900900");
				Vehiculo vehiculo = Consola.leerVehiculoMatricula();
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, vehiculo, fechaAlquiler);

				System.out.println(controlador.buscar(alquiler));

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;
		}
	}

	protected void modificarCliente() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.MODIFICAR_CLIENTE);

		try {

			controlador.modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	protected void devolverAlquiler() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.DEVOLVER_ALQUILER);

		System.out.println("1. Buscar por DNI de cliente :\n2. Buscar por matrícula de vehículo: ");

		int opcion = Entrada.entero();

		switch (opcion) {

		case 1:

			try {

				Cliente cliente = Consola.leerClienteDni();
				Vehiculo vehiculo = new Turismo("Seat", "León", 1900, "1440FFK");
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, vehiculo, fechaAlquiler);

				controlador.devolver(alquiler, Consola.leerFechaDevolucion());

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;

		case 2:

			try {

				Cliente cliente = new Cliente("Nombre", "75722433Q", "900900900");
				Vehiculo vehiculo = Consola.leerVehiculoMatricula();
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, vehiculo, fechaAlquiler);

				controlador.devolver(alquiler, Consola.leerFechaDevolucion());

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;
		}
	}

	protected void borrarCliente() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.BORRAR_CLIENTE);

		try {

			controlador.borrar(Consola.leerClienteDni());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	protected void borrarVehiculo() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.BORRAR_VEHICULO);

		try {

			controlador.borrar(Consola.leerVehiculoMatricula());

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	protected void borrarAlquiler() throws Exception {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.BORRAR_ALQUILER);

		System.out.println("1. Buscar por DNI de cliente: \n2. Buscar por matrícula de vehículo: ");

		int opcion = Entrada.entero();

		switch (opcion) {

		case 1:

			try {

				Cliente cliente = Consola.leerClienteDni();
				Vehiculo vehiculo = new Turismo("Seat", "León", 1900, "1440FFK");
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, vehiculo, fechaAlquiler);

				controlador.borrar(alquiler);

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;

		case 2:

			try {

				Cliente cliente = new Cliente("Nombre", "75722433Q", "900900900");
				Vehiculo vehiculo = Consola.leerVehiculoMatricula();
				LocalDate fechaAlquiler = LocalDate.of(1990, 1, 1);

				Alquiler alquiler = new Alquiler(cliente, vehiculo, fechaAlquiler);

				controlador.borrar(alquiler);

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			break;
		}
	}

	protected void listarClientes() {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.LISTAR_CLIENTES);

		// Se cambia el bucle for:each por un Iterador para recorrer la lista

		Iterator<Cliente> iterador = controlador.getClientes().iterator();
		
		while(iterador.hasNext()){ // Mientras que haya un siguiente elemento, seguiremos en el bucle
			
		    Cliente cliente=iterador.next(); // Escogemos el siguiente elemento
		    System.out.println(cliente.toString());
		}
	}

	protected void listarVehiculos() {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.LISTAR_VEHICULOS);

		// Se cambia el bucle for:each por un Iterador para recorrer la lista

		Iterator<Vehiculo> iterador = controlador.getVehiculos().iterator();

		while (iterador.hasNext()) { // Mientras que haya un siguiente elemento, seguiremos en el bucle

			Vehiculo vehiculo = iterador.next(); // Escogemos el siguiente elemento
			System.out.println(vehiculo.toString());
		}
	}

	protected void listarAlquileres() {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.LISTAR_ALQUILERES);

		// Se cambia el bucle for:each por un Iterador para recorrer la lista

		Iterator<Alquiler> iterador = controlador.getAlquileres().iterator();

		while (iterador.hasNext()) { // Mientras que haya un siguiente elemento, seguiremos en el bucle

			Alquiler alquiler = iterador.next(); // Escogemos el siguiente elemento
			System.out.println(alquiler.toString());
		}
	}

	protected void listarAlquileresCliente() {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.LISTAR_ALQUILERES_CLIENTE);
		System.out.println(controlador.getAlquileres(Consola.leerClienteDni()));
	}

	protected void listarAlquileresVehiculo() {

		Consola.mostrarCabecera("Ha elegido la opción: " + Accion.LISTAR_ALQUILERES_VEHICULO);
		System.out.println(controlador.getAlquileres(Consola.leerVehiculoMatricula()));
	}
}

