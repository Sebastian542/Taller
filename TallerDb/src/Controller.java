import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Controller {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		String texto="";
		File archivo = new File(System.getProperty("user.dir")+ "\\src\\archivo-1.txt");
		

		double tam =archivo.length();
		DecimalFormat formato = new DecimalFormat("0.00");
		System.out.println("El tamaÃ±o es : "+formato.format(tam)+" bytes");
		double kb=tam/1000;
		System.out.println("El tamaÃ±o es : "+formato.format(kb)+" kb");
		double mb=kb/1000;
		System.out.println("El tamaÃ±o es : "+formato.format(mb)+" mb");
		System.out.println("___________________________________________________");
		
		//Muestro los registros leidos
		Scanner sc = new Scanner(archivo);
		String dato;
		ArrayList elementos=new ArrayList();
		ArrayList<String> separados=new ArrayList();
		ArrayList genero=new ArrayList();
		ArrayList Zona = new ArrayList();
		ArrayList mes = new ArrayList();
		ArrayList departamento = new ArrayList();
		ArrayList edad = new ArrayList();
		ArrayList<ArrayList> lista = new ArrayList<>();
		ArrayList<String> fila = new ArrayList<>();
		while (sc.hasNextLine()) {
			
			elementos.add(sc.nextLine());
          
		}
		
		
		for (int i=0;i<elementos.size();i++) {
			   
			   //obtengo la fila
			   String palabra=(String) elementos.get(i);
			   //separo dentro de un arreglo de string por comas la fila
			   String[] elemento=palabra.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
		
			   //Recorro elemento por elemnto del arreglo para aÃ±adir cada elemento por separado
			   for (String caracter:elemento) {
				  // System.out.println(caracter);
				   separados.add(caracter);
		        }
			   
		}
		
		System.out.println("El total de elementos almacenados es :"+separados.size());
		System.out.println("___________________________________________________");

	//Esto se encarga de tomar los registros de genero-------Toco do while porque el for se puso violento
		int b=8;
		do {
			genero.add(separados.get(b));
			b+=13;
			
			
		}while(b<=separados.size());
		
		System.out.println("El total de generos es : "+(genero.size()-1));
		System.out.println("El total de hombres  : "+Collections.frequency(genero, "MASCULINO") );
		System.out.println("El total de mujeres  : "+Collections.frequency(genero, "FEMENINO") );

		b=7;
		do {
			Zona.add(separados.get(b));
			b+= 13;
			
		}while(b<=separados.size());
		System.out.println("El total de Zonas es : "+(Zona.size()-1));
		System.out.println("El total de Rural  : "+Collections.frequency(Zona, "RURAL") );
		System.out.println("El total de Urbano  : "+Collections.frequency(Zona, "URBANA") );

		/*b=7;
		do {
			mes.add(separados.get(b));
			b+= 13;
			
		}while(b<=separados.size());
		System.out.println("El total de mes es : "+(mes.size()-1));
		System.out.println("El total de mes  : "+Collections.frequency(Zona, "RURAL") );
		System.out.println("El total de mes  : "+Collections.frequency(Zona, "URBANA") );*/
		b=0;
		do {
			departamento.add(separados.get(b));
			b+=13;
			
			
		}while(b<separados.size());
		System.out.println("El total de departamento es : "+(departamento.size()-1));
		System.out.println("El total de ANTIOQUIA  : "+Collections.frequency(departamento, "ANTIOQUIA") );
		System.out.println("El total de CALDAS  : "+Collections.frequency(departamento, "CALDAS") );
		System.out.println("El total de ATLANTICO  : "+Collections.frequency(departamento, "ATLÃ�NTICO") );
		System.out.println("El total de BOLIVAR  : "+Collections.frequency(departamento, "BOLÃ�VAR") );
		System.out.println("El total de CUNDINAMARCA  : "+Collections.frequency(departamento, "CUNDINAMARCA") );
		System.out.println("El total de QUINDIO  : "+Collections.frequency(departamento, "QUINDÃ�O") );
		System.out.println("El total de GUAJIRA  : "+Collections.frequency(departamento, "GUAJIRA") );
		System.out.println("El total de HUILA  : "+Collections.frequency(departamento, "HUILA") );
		System.out.println("El total de MAGDALENA  : "+Collections.frequency(departamento, "MAGDALENA") );
		System.out.println("El total de META  : "+Collections.frequency(departamento, "META") );
		System.out.println("El total de SAN ANDRES  : "+Collections.frequency(departamento, "SAN ANDRÃ‰S") );
		System.out.println("El total de SUCRE  : "+Collections.frequency(departamento, "SUCRE") );
		System.out.println("El total de VALLE  : "+Collections.frequency(departamento, "VALLE") );
		System.out.println("________________________________________________________");
		System.out.println(separados.get(0)+" - "+separados.get(1)+" - "+separados.get(2)+" - "+separados.get(3)+" - "
						  +separados.get(4)+" - "+separados.get(5)+" - "+separados.get(6)+" - "+separados.get(7)+" - "
						  +separados.get(8)+" - "+separados.get(9)+" - "+separados.get(10)+" - "+separados.get(11)+" - "+separados.get(12)+" - ");

		// Aca va el d en proceso 
	
		for (int c =18;c<separados.size();c++) {
	
				if(separados.get(c).equals("HALADO")) {
					
					System.out.println("Encontre la palabra "+separados.get(c));
					
					for (int d=1;d<=13;d++) {
						
						separados.remove(c-5);
					
					}
				}
				c=c+6;
			}
			
		System.out.println("Quitando los elementos de halado quedan : "+separados.size()+" elementos");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		 LocalDateTime now = LocalDateTime.now(); 
		String nombre = dtf.format(now)+".txt";		
		
		for(int i=0;i<separados.size();i++) {
					fila.add(separados.get(i));
					if(fila.size()>12) {
					lista.add(fila);	 
					texto = Arrays.toString(lista.toArray()).replace(" ", "").replace("[", "").replace("]", "");
					try(FileWriter fw = new FileWriter(System.getProperty("user.dir")+ "\\src\\"+nombre, true);
						    BufferedWriter bw = new BufferedWriter(fw);
						    PrintWriter out = new PrintWriter(bw))
						{
						    out.println(texto);
						    //more code
						    //more code
						} catch (IOException e) {
						    //exception handling left as an exercise for the reader
						}
					fila =new ArrayList<String>();
					lista=new ArrayList<ArrayList>();
					texto="";
					}
				}

				 

				  try {
			      File myObj = new File(nombre);
			      if (myObj.createNewFile()) {
			        System.out.println("File created: " + myObj.getName());
			      } else {
			        System.out.println("File already exists.");
			      }
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
	 
	
	





//System.out.println("Aca vamos :"+separados.get(12+6));
//if () {
//	
//	
//}

		
		/*b =11;
		do {
			edad.add(separados.get(b));
			b+= 13;
			
		}while(b<=separados.size());
		System.out.println("El total de Zonas es : "+(edad.size()-1));
		System.out.println("El total de Rural  : "+Collections.frequency(edad, "RURAL") );
		System.out.println("El total de Urbano  : "+Collections.frequency(edad, "URBANA") );*/
		
		
		//Elimine del archivo los delitos registrados que tengan por modalidad: â€œHaladoâ€�.-
		
	}
}

