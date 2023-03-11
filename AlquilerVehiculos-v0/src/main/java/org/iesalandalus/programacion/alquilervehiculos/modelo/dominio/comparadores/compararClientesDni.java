package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.comparadores;

import java.util.Comparator;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class compararClientesDni implements Comparator<Cliente> {

	public int compare(Cliente cliente1, Cliente cliente2) {
		
		return cliente1.getDni().compareTo(cliente2.getDni());
	}
}