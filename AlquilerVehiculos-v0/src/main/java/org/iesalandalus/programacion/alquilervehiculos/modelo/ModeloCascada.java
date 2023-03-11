package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.*;

public class ModeloCascada extends Modelo {

	public ModeloCascada(IFuenteDatos fuenteDatos){
		
		setFuenteDatos(fuenteDatos); 
	}
	
	public void insertar(Cliente cliente) throws Exception {
		
		clientes.insertar(cliente);
	}
	
	public void insertar(Vehiculo vehiculo) throws Exception{

		vehiculos.insertar(vehiculo);
	}
	
	public void insertar(Alquiler alquiler) throws Exception  {
		
		if(alquiler == null) {
			
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		
		alquileres.insertar(alquiler);
	}
	
	public Cliente buscar(Cliente cliente) {
		
		return clientes.buscar(cliente); 
	}
	
	public Vehiculo buscar(Vehiculo vehiculo) {
		
		return vehiculos.buscar(vehiculo); 
	}

	public Alquiler buscar(Alquiler alquiler) {
	
		return alquileres.buscar(alquiler); 
	}
	
	public void modificar(Cliente cliente, String nombre, String Telefono) throws Exception {
		
		clientes.modificar(cliente, nombre, Telefono);
	}
	
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws Exception {
		
		if(alquileres.buscar(alquiler) == null) {
			
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
			
		}else {
			
			alquileres.devolver(alquiler, fechaDevolucion); 
		}
	}
	
	public void borrar(Cliente cliente) throws Exception {
		
		clientes.borrar(cliente);
	}
	
	public void borrar(Vehiculo vehiculo) throws Exception {
		
		vehiculos.borrar(vehiculo);
	}
	
	public void borrar(Alquiler alquiler) throws Exception {
		
		alquileres.borrar(alquiler);
	}
	
	public List<Cliente> getClientes() {
		
		return clientes.get();
	}
	
	public List<Vehiculo> getVehiculos() {
		
		return vehiculos.get();
	}
	
	public List<Alquiler> getAlquileres() {
		
		return alquileres.get();
	}
	
	public List<Alquiler> getAlquileres(Cliente cliente) {
		
		return alquileres.get(cliente);
	}
	
	public List<Alquiler> getAlquileres(Vehiculo vehiculo) {
	
		return alquileres.get(vehiculo);
	}
}
