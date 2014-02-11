import java.util.*;
public class MainTestLinkedList {

	public static void main(String[] args) {
		LinkedList<String> lista = new LinkedList<String>();
		lista.add("alfa");
		System.out.print(lista.indexOf("alfa"));
		
		lista.add("beta");
		lista.add(0, "gamma");
		for (Iterator<String> iterator = lista.iterator(); iterator.hasNext();) {
			String parola = (String) iterator.next();
			System.out.print(parola + "\n");
		}
		
		
	}

}
