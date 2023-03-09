import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
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
		ArrayList<String> mes = new ArrayList();
		ArrayList departamento = new ArrayList();
		ArrayList<String> edad = new ArrayList();
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

		b=2;
		String[] meses= new String[separados.size()];
		int primerosMes=0;
		int SegundosMes=0;
		do {
			mes.add(separados.get(b));
			
			b+= 13;
			
		}while(b<=separados.size());
		for(int n = 1 ; n<mes.size();n++) {
			meses = mes.get(n).split("/",-1);
				if((Integer.parseInt(meses[0])<7)) {
					primerosMes++;
				}
				else {
					SegundosMes++;
				}
		}

		
		System.out.println("El total de meses es : "+(mes.size()-1));
		System.out.println("El total de meses primera mitad de año  : "+primerosMes);
		System.out.println("El total de meses segunda mitad de año : "+SegundosMes);
		b =11;
		int segundoRango = 0;
		int primerRango = 0;
		int tercerRango = 0;
		do {
			edad.add(separados.get(b));
			b+= 13;
			
		}while(b<=separados.size());
		for(int n = 1 ; n<edad.size();n++) {
				if((Integer.parseInt(edad.get(n))<30)) {
					primerRango++;
				}
				if((Integer.parseInt(edad.get(n))>=30&&Integer.parseInt(edad.get(n))<=50)) {
					segundoRango++;
				}
				if((Integer.parseInt(edad.get(n))>50)) {
					tercerRango++;
				}
		}
		System.out.println("El total de edades es : "+(edad.size()-1));
		System.out.println("El total de menores de 30  : "+primerRango);
		System.out.println("El total de 30 - 50  : "+segundoRango );
		System.out.println("El total de mas de 50  : "+tercerRango );
		b=0;
		do {
			departamento.add(separados.get(b));
			b+=13;
		}while(b<separados.size());
		System.out.println("El total de departamento es : "+(departamento.size()-1));
		System.out.println("El total de ANTIOQUIA  : "+Collections.frequency(departamento, "ANTIOQUIA") );
		System.out.println("El total de CALDAS  : "+Collections.frequency(departamento, "CALDAS") );
		System.out.println("El total de ATLANTICO  : "+Collections.frequency(departamento, "ATLÁNTICO") );
		System.out.println("El total de BOLIVAR  : "+Collections.frequency(departamento, "BOLÍVAR") );
		System.out.println("El total de CUNDINAMARCA  : "+Collections.frequency(departamento, "CUNDINAMARCA") );
		System.out.println("El total de QUINDIO  : "+Collections.frequency(departamento, "QUINDÍO") );
		System.out.println("El total de GUAJIRA  : "+Collections.frequency(departamento, "GUAJIRA") );
		System.out.println("El total de HUILA  : "+Collections.frequency(departamento, "HUILA") );
		System.out.println("El total de MAGDALENA  : "+Collections.frequency(departamento, "MAGDALENA") );
		System.out.println("El total de META  : "+Collections.frequency(departamento, "META") );
		System.out.println("El total de SAN ANDRES  : "+Collections.frequency(departamento, "SAN ANDRÉS") );
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
					try(FileWriter fw = new FileWriter(System.getProperty("user.dir")+ "\\Villarreal_Muñoz_Ramirez\\"+nombre, true);
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
				  int cantidad=1;
					for(int i=0;i<separados.size();i++) {
						fila.add(separados.get(i));
						if(fila.size()>12) {
						nombre="texto"+(cantidad);
						lista.add(fila);
						if(cantidad<=20) {
						texto += Arrays.toString(lista.toArray()).replace(" ", "").replace("[", "").replace("]", "")+"\n";
							try(FileWriter fw = new FileWriter(System.getProperty("user.dir")+ "\\Villarreal_Muñoz_Ramirez\\numero\\"+nombre,true);
								    BufferedWriter bw = new BufferedWriter(fw);
								    PrintWriter out = new PrintWriter(bw))
							
								{
								if(cantidad==1) {
								 out.println(texto);
								}
								if(cantidad>1&&cantidad<21) {
									out.println(texto);
								}
								cantidad++;
								} catch (IOException e) {
								    //exception handling left as an exercise for the reader
								}
						fila =new ArrayList<String>();
						lista=new ArrayList<ArrayList>();
						}
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

		

		
		//Elimine del archivo los delitos registrados que tengan por modalidad: â€œHaladoâ€�.-
		
	}
}

