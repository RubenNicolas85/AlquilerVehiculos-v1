package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.List;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IAlquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria.Vehiculos;

public abstract class Modelo {

	protected IClientes clientes;
	protected IAlquileres alquileres;
	protected IVehiculos vehiculos; 
	protected IFuenteDatos fuenteDatos; 
	
	protected void setFuenteDatos(IFuenteDatos fuenteDatos) {
		
		this.fuenteDatos=fuenteDatos; 
	}
	
	public void comenzar() throws Exception{
		
		clientes = new Clientes(); 
		alquileres = new Alquileres(); 
		vehiculos = new Vehiculos(); 
	}
	
	public void terminar() {
		
		System.out.println("El modelo ha terminado."); 
	}
	
	public abstract void insertar(Cliente cliente)  throws Exception;
	
	public abstract void insertar(Vehiculo vehiculo) throws Exception; 
	
	public abstract void insertar(Alquiler alquiler) throws Exception; 
	
	public abstract Cliente buscar(Cliente cliente); 
	
	public abstract Vehiculo buscar(Vehiculo vehiculo); 

	public abstract Alquiler buscar(Alquiler alquiler); 
	
	public abstract void modificar(Cliente cliente, String nombre, String Telefono) throws Exception; 
	
	public abstract void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws Exception; 
	
	public abstract void borrar(Cliente cliente) throws Exception; 
	
	public abstract void borrar(Vehiculo vehiculo) throws Exception; 
	
	public abstract void borrar(Alquiler alquiler) throws Exception; 
	
	public abstract List<Cliente> getClientes(); 
	
	public abstract List<Vehiculo> getVehiculos(); 
	
	public abstract List<Alquiler> getAlquileres(); 
	
	public abstract List<Alquiler> getAlquileres(Cliente cliente); 
	
	public abstract List<Alquiler> getAlquileres(Vehiculo vehiculo); 
}
