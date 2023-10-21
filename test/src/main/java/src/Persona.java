package src;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;




public class Persona {
	String nombre;
	String fechaNacimiento;
	String dni;
	int edad;
	boolean habilitadoParaVotar;
	public Persona(String nombre, String dni, String fechaNacimiento, int edad, boolean habilitadoParaVotar) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.habilitadoParaVotar = habilitadoParaVotar;
		this.dni=dni;
		
	}
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getEdad() {
				      return edad;
				      }
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isHabilitadoParaVotar() {
		return habilitadoParaVotar;
	}
	public void setHabilitadoParaVotar(boolean habilitadoParaVotar) {
		this.habilitadoParaVotar = habilitadoParaVotar;
	}
	public String getDNI() {
		return dni;
	}




	@Override
	public String toString() {
		return "Persona: nombre='" + nombre + '\'' +
				", fechaNacimiento='" + fechaNacimiento + '\'' +
				", dni='" + dni + '\'' +
				", edad=" + edad +
				", habilitadoParaVotar=" + habilitadoParaVotar;
	}
}
