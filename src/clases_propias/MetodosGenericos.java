package clases_propias;

import java.util.GregorianCalendar;

public class MetodosGenericos {

	public static void main(String[] args) {
		String [] nombres = new String[] {"Rafael", "Luis", "Abraham"};
		String elementos = MisMatrices.<String>getElementos(nombres);
		System.out.println(elementos);
		
		
		/*
		Empleado listaEmpleado[] = {
				new Empleado("Rafael", 25, 2000),
				new Empleado("Rafael", 25, 2000),
				new Empleado("Rafael", 25, 2000),
				new Empleado("Rafael", 25, 2000),
				new Empleado("Rafael", 25, 2000),
				};
		
		System.out.println(MisMatrices.getElementos(listaEmpleado));
		
		*/
		
		GregorianCalendar fechas[] = {
				new GregorianCalendar(2015, 07, 12),
				new GregorianCalendar(2015, 06, 12),
				new GregorianCalendar(2015, 05, 12),
				new GregorianCalendar(2015, 04, 12),
				};
		
		System.out.println(MisMatrices.getElementos(fechas));
	}
}

class MisMatrices{
	
	public static <T extends Comparable> T getElementos(T[]array) {
		
		if (array == null || array.length == 0) {
			return null;
		}
		
		T elementoMenor = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (elementoMenor.compareTo(array[i]) > 0) {
				elementoMenor = array[i];
			}
		}
		
		return elementoMenor;
	}
}
