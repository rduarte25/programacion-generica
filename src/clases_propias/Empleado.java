package clases_propias;

import java.util.Date;
import java.util.GregorianCalendar;

import poo.Trabajadores;

public class Empleado {
	public Empleado(String nom, int edad, double sue) {
		nombre = nom;
		sueldo = sue;
		this.edad = edad;
	}
	
	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes -1, dia);
		altaContrato = calendario.getTime();
		
	}
	
	public Empleado(String nom) {
		this(nom, 30000, 2000,01,10);
	}
	
	public String dame_nombre() {
		return nombre;
	}
	
	public double dame_sueldo() {
		return sueldo;
	}
	
	public Date dame_fecha_contrato() {
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;
	}
	
	public int compareTo(Object miObjeto) {
		Empleado otroEmpleado = (Empleado) miObjeto;
		if ( this.sueldo < otroEmpleado.sueldo ) {
			return -1;
		} else if ( this.sueldo > otroEmpleado.sueldo ) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public double establece_bonus(double gratificacion) {
		return Trabajadores.bonus_base + gratificacion;
	}
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	private int edad;
	
}
