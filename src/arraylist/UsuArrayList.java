package arraylist;

import java.io.File;

public class UsuArrayList {
	
	public static void main(String[] args) {
		ArrayList archivos = new ArrayList(5);
		
		
		archivos.add("Rafael");
		archivos.add("Abraam");
		archivos.add("Luis");
		archivos.add("David");
		archivos.add(new File("gestion_pedidos.accdb"));
		
		File nombrePersona = (File) archivos.get(4);
		
		
		
		//archivos.add(new File("gestion_pedidos.accdb"));
		//File nombreFile = (File) archivos.get(0);
		System.out.println(nombrePersona);
	}
}
