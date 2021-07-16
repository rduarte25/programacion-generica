package clases_propias;

public class UsoPareja {
	
	public static void main (String[] args) {
		
		Pareja<String> pareja = new Pareja<String>();
		
		pareja.setPrimero("Rafael");
		System.out.println(pareja.getPrimero());
		
		Persona persona1 = new Persona("Andrea");
		Pareja<Persona> parejap1 = new Pareja<Persona>();
		parejap1.setPrimero(persona1);
		System.out.println(parejap1.getPrimero());
		
	}
}


class Persona {
	
	public Persona (String nombre) {
		
		this.nombre = nombre;
	}
	
	private String nombre;
}