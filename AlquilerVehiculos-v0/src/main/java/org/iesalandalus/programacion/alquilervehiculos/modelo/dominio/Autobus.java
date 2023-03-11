package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Autobus extends Vehiculo{

	private static final int FACTOR_PLAZAS=2; 
	
	private int plazas;

	public Autobus(String marca, String modelo, int plazas, String matricula) {
		
		super(marca, modelo, matricula);
		setPlazas(plazas); 
	}

	public Autobus(Autobus autobus) {
		
		super(autobus);
		setPlazas(autobus.getPlazas()); 
	}

	public int getPlazas() {
		return plazas;
	}

	private void setPlazas(int plazas) {
		
		if(plazas<1 || plazas>50) {
			
			throw new IllegalArgumentException("ERROR: El número de plazas no es correcto."); 
		}else {
		
			this.plazas = plazas;
		}
	} 
	
	@Override
	protected int getFactorPrecio() {
		
		return getPlazas()*FACTOR_PLAZAS;
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
			
		return new Autobus("Seat", "León", 50, matricula); 
			
		}else
		
		return null; 
	}

	@Override
	protected Vehiculo copiar(Vehiculo vehiculo) {
		
		return new Autobus(vehiculo.getMarca(), vehiculo.getModelo(), getPlazas(), vehiculo.getMatricula()); 
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
		return String.format("%s %s - %s - (%s Plazas)", getMarca(), getModelo(), getMatricula(), getPlazas());
	}
}
