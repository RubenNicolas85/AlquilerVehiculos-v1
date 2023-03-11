package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.comparadores;

import java.util.Comparator;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class compararClientesNombre implements Comparator<Cliente> {

	public int compare(Cliente cliente1, Cliente cliente2) {
		
		return cliente1.getNombre().compareTo(cliente2.getNombre());
	}
}