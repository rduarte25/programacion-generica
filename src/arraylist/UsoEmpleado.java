package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		listaEmpleados.add(new Empleado("Maria", 25, 2600));
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		listaEmpleados.add(new Empleado("Andres", 15, 2100));
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		listaEmpleados.add(new Empleado("Antonio", 55, 2000));
		listaEmpleados.add(new Empleado("Maria", 25, 2600));
		listaEmpleados.add(new Empleado("Jose", 35, 2200));
		listaEmpleados.add(new Empleado("Andres", 15, 2100));
		//listaEmpleados.add();
		listaEmpleados.set(0, new Empleado("Pedro", 22, 2100));
		listaEmpleados.trimToSize();
		
		//System.out.println(listaEmpleados.size());
		//System.out.println(listaEmpleados.get(4).dameDatos());
		
		/*
		Empleado[] listaEmpleados = new Empleado[3];
		listaEmpleados[0] = new Empleado("Ana", 45, 2500);
		listaEmpleados[1] = new Empleado("Antonio", 55, 2000);
		listaEmpleados[2] = new Empleado("Maria", 25, 2600);
		
		for (Empleado e : listaEmpleados) {
			System.out.println(e.dameDatos());
		}
		
		
		
		for (int i = 0; i < listaEmpleados.size(); i++) {
			Empleado e = listaEmpleados.get(i);
			System.out.println(e.dameDatos());
		}*/
		
		Iterator <Empleado> miIterator = listaEmpleados.iterator();
		
		while (miIterator.hasNext()) {
			System.out.println(miIterator.next().dameDatos());
		}
		
		//listaEmpleados.set(1, new Empleado("Abraham", 22, 2200));
		
		/*
		Empleado arrayEmpleado[] = new Empleado[listaEmpleados.size()];
		
		listaEmpleados.toArray(arrayEmpleado);
		
		for (int i = 0; i < arrayEmpleado.length; i++) {
			System.out.println(arrayEmpleado[i].dameDatos());
		}
		*/
		
		//System.out.println(listaEmpleados.get(4).dameDatos());
	}
}

class Empleado {
	
	public Empleado (String nombre, int edad, double sueldo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}
	
	public String dameDatos() {
		return "El empleado se llama " + nombre + " Tiene " + edad + " años " + " y un salario " + sueldo;
	}
	
	private String nombre;
	private int edad;
	private double sueldo;
	
}
