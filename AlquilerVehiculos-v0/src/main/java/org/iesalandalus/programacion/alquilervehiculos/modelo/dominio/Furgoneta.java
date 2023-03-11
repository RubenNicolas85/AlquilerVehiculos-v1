package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Furgoneta extends Vehiculo {

	private static final int FACTOR_PMA=100; 
	private static final int FACTOR_PLAZAS=1; 
	
	private int pma; 
	private int plazas;
	
	public Furgoneta(String marca, String modelo, int pma, int plazas, String matricula) {
		
		super(marca, modelo, matricula);
		setPma(pma); 
		setPlazas(plazas); 
	}
	
	public Furgoneta(Furgoneta furgoneta) {
		
		super(furgoneta);
		setPma(furgoneta.getPma()); 
		setPlazas(furgoneta.getPlazas()); 
	}
	
	public int getPma() {
		return pma;
	}
	
	private void setPma(int pma) {
		
		if(pma<1 || pma>1500) {
			
			throw new IllegalArgumentException("ERROR: El PMA debe estar entre 1 y 1500 Kg."); 
		}else {
		
			this.pma = pma;
		}
	}
	
	public int getPlazas() {
		return plazas;
	}
	
	private void setPlazas(int plazas) {
		
		if(plazas<1 || plazas>10) {
			
			throw new IllegalArgumentException("ERROR: El número de plazas no es correcto."); 
		}else {
		
			this.plazas = plazas;
		}
	}
	
	@Override
	protected int getFactorPrecio() {
		
		int factorPrecio=(getPma() / FACTOR_PMA) + (getPlazas() * FACTOR_PLAZAS); 
		
		return factorPrecio;  
	}
	
	@Override
	protected Vehiculo copiar(Vehiculo vehiculo) {
		
		return new Furgoneta(vehiculo.getMarca(), vehiculo.getModelo(), getPma(), getPlazas(), vehiculo.getMatricula()); 
	}
	
	@Override
	public Vehiculo getVehiculoConMatricula(String matricula) {
		
		if(matricula==null) {
			
			throw new NullPointerException("ERROR: La matrícula no puede ser nula."); 
			
		}
		
		if(!matricula.matches(ER_MATRICULA)) {
			
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido."); 
			
		}
		
		if(matricula.matches(ER_MATRICULA)) {
			
		return new Furgoneta("Seat", "León", 2000, 10, matricula); 
			
		}else
		
		return null; 
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

	@Override
	public String toString() {
		return String.format("%s %s - %s - (%s Kg. PMA) (%s Plazas)", getMarca(), getModelo(), getMatricula(), getPma(), getPlazas()); 
	}
}
