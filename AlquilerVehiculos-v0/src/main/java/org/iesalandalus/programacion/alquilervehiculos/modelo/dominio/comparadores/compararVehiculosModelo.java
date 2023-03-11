package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.comparadores;

import java.util.Comparator;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class compararVehiculosModelo implements Comparator<Vehiculo> {

	public int compare(Vehiculo vehiculo1, Vehiculo vehiculo2) {
		
		return vehiculo1.getModelo().compareTo(vehiculo2.getModelo());
	}
}
