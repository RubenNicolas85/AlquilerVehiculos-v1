package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public abstract class Vehiculo {

	private static final String ER_MARCA="Seat|Land Rover|KIA|Rolls-Royce|SsangYong|Ford|Renault|"
			+ "Opel|Hyundai|Toyota|Volkswagen|Citroën|BMW|Mercedes-Benz|Fiat|Irizar|Iveco|MAN|Volvo";
	protected static final String ER_MATRICULA="^[0-9]{4}[B-Z]{3}$";
	
	private String marca; 
	private String modelo; 
	protected String matricula;
	
	protected Vehiculo(String marca, String modelo, String matricula) {
		
		setMarca(marca); 
		setModelo(modelo); 
		setMatricula(matricula); 
	}
	
	protected Vehiculo(Vehiculo vehiculo) {
		
		setMarca(vehiculo.getMarca()); 
		setModelo(vehiculo.getModelo()); 
		setMatricula(vehiculo.getMatricula()); 
	}
	
	protected abstract Vehiculo copiar (Vehiculo vehiculo); 
	
	protected abstract Vehiculo getVehiculoConMatricula(String matricula);
	
	protected abstract int getFactorPrecio(); 
	
	public String getMarca() {
		
		return marca;
	}
	
	protected void setMarca(String marca) {
		
		if(marca==null) {
			
			throw new NullPointerException("ERROR: La marca no puede ser nula."); 
			
		}else if(!marca.matches(ER_MARCA)) {
			
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido."); 
		}
		
		else if(marca.matches(ER_MARCA)) {
			
			this.marca = marca;
		}
	}
	
	public String getModelo() {
		
		return modelo;
	}
	
	protected void setModelo(String modelo) {
		
		if(modelo==null) {
			
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
			
		}else if(modelo.trim().isEmpty()) {
			
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco."); 
			
		}else{
			
			this.modelo = modelo;
		}
	}
	
	public String getMatricula() {
		
		return matricula;
	}

	protected void setMatricula(String matricula) {
		
		if(matricula==null) {
			
			throw new NullPointerException("ERROR: La matrícula no puede ser nula."); 
			
		}else if(!matricula.matches(ER_MATRICULA)) {
			
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido."); 
		}else if(matricula.matches(ER_MATRICULA)) {
			
			this.matricula = matricula;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	// Implementamos llamada al método instance of en el método equals, según el enunciado: 
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vehiculo))
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}
}
