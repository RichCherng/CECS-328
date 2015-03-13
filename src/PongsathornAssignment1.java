
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class PongsathornAssignment1 {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner reader = new Scanner(new FileReader("INPUT.txt"));
		String input = reader.nextLine();
		ArrayList<String> inputList = new  ArrayList<String>(Arrays.asList(input.split(",")));
		ArrayList<Integer> numList = new ArrayList<Integer>();
		System.out.println("Example Input:\n");
		for(String i:inputList){
			System.out.printf("%s ",i);
			numList.add(Integer.parseInt(i));
		}
		System.out.println("\n\nExample output:\n");
		double startTime = System.nanoTime();
		Collections.sort(numList);
		double end = System.nanoTime();
		for(int i: numList){
			System.out.printf("%d ", i);
		}
		System.out.printf("%n%nTime to sort: %f ms.",(end-startTime)/1000000);
	}
}
