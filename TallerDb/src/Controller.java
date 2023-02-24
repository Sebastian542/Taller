import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Controller {
	
	public static void main(String[] args) throws FileNotFoundException {

		File archivo = new File(System.getProperty("user.dir")+ "\\src\\archivo-1.txt");
		

		double tam =archivo.length();
		DecimalFormat formato = new DecimalFormat("#.00");
		System.out.println("El tamaño es : "+formato.format(tam)+" bytes");
		double kb=tam/1000;
		System.out.println("El tamaño es : "+formato.format(kb)+" kb");
		double mb=kb/1000;
		System.out.println("El tamaño es : "+formato.format(mb)+" mb");
		System.out.println("___________________________________________________");
		
		//Muestro los registros leidos
		Scanner sc = new Scanner(archivo);
		String dato;
		ArrayList elementos=new ArrayList();
		ArrayList separados=new ArrayList();
		ArrayList genero=new ArrayList();
	
		while (sc.hasNextLine()) {
			
			elementos.add(sc.nextLine());
          
		}
		
		for (int i=0;i<elementos.size();i++) {
			   String separador = ",";
			   //obtengo la fila
			   String palabra=(String) elementos.get(i);
			   //separo dentro de un arreglo de string por comas la fila
			   String[] elemento=palabra.split(separador);
		
			   //Recorro elemento por elemnto del arreglo para añadir cada elemento por separado
			   for (String caracter:elemento) {
				   separados.add(caracter);

		        }
		}
		System.out.println("Por  : "+separados.get(8));
		
		for (int b=8;b<separados.size();) {
			
			genero.add(separados.get(b+8));
			System.out.println(genero);
			
		}
		
		//System.out.println("Almacene : "+separados.size());

		//Delitos por genero 8-
		
		
      
	}
}
	

