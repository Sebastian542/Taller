import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
	
	public static void main(String[] args) throws FileNotFoundException {
	
		System.out.println(System.getProperty("user.dir"));
		
		//ruta del archivo
		Scanner sc = new Scanner(new File(System.getProperty("user.dir")+ "\\src\\archivo-1.txt"));
	
		while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

	}
}
	

