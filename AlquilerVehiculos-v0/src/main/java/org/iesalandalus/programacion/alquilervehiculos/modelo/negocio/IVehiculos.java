package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public interface IVehiculos {

	List<Vehiculo> get();

	int getCantidad();

	void insertar(Vehiculo vehiculo) throws Exception;

	Vehiculo buscar(Vehiculo vehiculo);

	void borrar(Vehiculo vehiculo) throws Exception;

}