package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler{
	
	protected static final DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int PRECIO_DIA=20; 
	
	private Cliente cliente; 
	private Vehiculo vehiculo; 
	private LocalDate fechaAlquiler; 
	private LocalDate fechaDevolucion; 
	
	public Alquiler(Cliente cliente, Vehiculo vehiculo, LocalDate fechaAlquiler) {
		
		setCliente(cliente); 
		setVehiculo(vehiculo); 
		setFechaAlquiler(fechaAlquiler);
	}
	
	public Alquiler(Alquiler alquiler) {
		
		if(alquiler==null) {
			
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo."); 
			
		}else {
			
			setCliente(alquiler.getCliente()); 
			setVehiculo(alquiler.getVehiculo()); 
			setFechaAlquiler(alquiler.getFechaAlquiler()); 
		} 
	}

	public Cliente getCliente() {
		
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		
		if(cliente==null) {
			
			throw new NullPointerException("ERROR: El cliente no puede ser nulo."); 
		}else {
			
			this.cliente = cliente;
		}
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	private void setVehiculo(Vehiculo vehiculo) {
		
		if(vehiculo==null) {
			
			throw new NullPointerException("ERROR: El vehículo no puede ser nulo."); 
		}else {
			
			this.vehiculo = vehiculo;
		}
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	private void setFechaAlquiler(LocalDate fechaAlquiler) {
		
		if(fechaAlquiler==null) {
			
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula."); 
			
		}else if(fechaAlquiler.isAfter(LocalDate.now())) {
			
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura."); 
			
		}else if(fechaAlquiler.isBefore(LocalDate.now()) || fechaAlquiler.isEqual(LocalDate.now())){
			
			this.fechaAlquiler = fechaAlquiler;
		}
	}

	public LocalDate getFechaDevolucion() {
		
		return fechaDevolucion;
	}

	private void setFechaDevolucion(LocalDate fechaDevolucion) throws Exception {

		if (fechaDevolucion == null) {
			
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		
		if (fechaDevolucion.isAfter(LocalDate.now())) {
			
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		
		if (!fechaDevolucion.isAfter(fechaAlquiler)) {
			
			throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}
		
		this.fechaDevolucion=fechaDevolucion; 
	}
	
	public void devolver(LocalDate fechaDevolucion) throws Exception {
		
		if (getFechaDevolucion() != null) {
			
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		}
		setFechaDevolucion(fechaDevolucion); 
	}
	
	/* El precio que cobra por alquiler un turismo es el siguiente: 
	 * (precioDia + factorCilindrada) * numDias. El precioDia es 20, el factorCilindrada 
	 * depende de la cilindrada del turismo alquilada y es igual a la cilindrada del turismo / 10, 
	 * y numDias son los días transcurridos entre la fecha de alquiler y la de devolución */
	
	public int getPrecio() {
		
		if(getFechaDevolucion() == null){
            
			return 0;
        }
        
        int factorPrecio = vehiculo.getFactorPrecio();
        int numDias = (int) ChronoUnit.DAYS.between(getFechaAlquiler(), getFechaDevolucion());
        
        return (PRECIO_DIA + factorPrecio) * numDias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, vehiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(vehiculo, other.vehiculo);
	}

	@Override
	public String toString() {
		return String.format("%s <---> %s, %s - %s ("+getPrecio()+"€)",
                getCliente(), getVehiculo(), getFechaAlquiler().format(FORMATO_FECHA), 
                (getFechaDevolucion() == null) ? "Aún no devuelto" : fechaDevolucion.format(FORMATO_FECHA), 
                (getFechaDevolucion() == null) ? LocalDate.now().format(FORMATO_FECHA) : "",
                getPrecio());
	}
}
