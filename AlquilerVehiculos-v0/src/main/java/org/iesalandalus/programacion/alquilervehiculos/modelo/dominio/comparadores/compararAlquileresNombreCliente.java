package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.comparadores;

import java.util.Comparator;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;

public class compararAlquileresNombreCliente implements Comparator<Alquiler> {

	public int compare(Alquiler alquiler1, Alquiler alquiler2) {
		
		return alquiler1.getCliente().getNombre().compareTo(alquiler2.getCliente().getNombre());
	}
}