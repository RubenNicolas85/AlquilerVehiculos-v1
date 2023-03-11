package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public interface IAlquileres {

	ArrayList<Alquiler> get();

	ArrayList<Alquiler> get(Cliente cliente);

	ArrayList<Alquiler> get(Vehiculo vehiculo);

	int getCantidad();

	void insertar(Alquiler alquiler) throws Exception;

	void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws Exception;

	Alquiler buscar(Alquiler alquiler);

	void borrar(Alquiler alquiler) throws Exception;
}