package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo extends Vehiculo {
	
	private static final int FACTOR_CILINDRADA=10; 
	
	private int cilindrada; 
	
	
	public Turismo(String marca, String modelo, int cilindrada, String matricula) {
		
		super(marca, modelo, matricula); 
		setCilindrada(cilindrada); 
	}
	
	public Turismo(Turismo turismo) {
		
		super(turismo);
		setCilindrada(turismo.getCilindrada()); 
	}
	
	public int getCilindrada() {
		
		return cilindrada;
	}
	
	private void setCilindrada(int cilindrada) {
		
		if(cilindrada<1 || cilindrada>5000) {
			
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta."); 
		}else {
		
			this.cilindrada = cilindrada;
		}
	}
	
	@Override
	protected int getFactorPrecio() {
		
		return getCilindrada()/FACTOR_CILINDRADA;
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
			
			return new Turismo("Seat", "León", 1990, matricula);
			
		}else
		
		return null; 
	}

	@Override
	protected Vehiculo copiar(Vehiculo vehiculo) {
		
		return new Turismo(vehiculo.getMarca(), vehiculo.getModelo(), getCilindrada(), vehiculo.getMatricula()); 
	}
	
	/* Se crea el método de clase que se indica en el diagrama, que dada una matrícula correcta 
	 * nos devuelva un turismo válido con dicha matrícula y que será utilizado en las futuras 
	 * búsquedas */
	
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
		return String.format("%s %s (%s CC) - %s",getMarca(), getModelo(), getCilindrada(), getMatricula());
	}
}
