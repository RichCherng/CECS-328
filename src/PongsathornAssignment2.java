import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;


public class PongsathornAssignment2 {
	
	public static void main(String[] arg){
		Scanner reader = new Scanner(System.in);
		boolean run = true;
		String input;
		ArrayList<Integer> list;
		while(run){
			System.out.println("Enter file name or type 'quit' to end the program");
			input = reader.nextLine();
			if(input.equals("quit")){
				run = false;
				break;
			}else if (input.length() > 4 && input.substring(input.length()-4).equals(".txt")){
					list = readFile(input);
					ArrayList<Integer> insertionList = new ArrayList<Integer>(list),
							radList = new ArrayList<Integer>(list);
					insertion(insertionList);
					radix(radList);
			}else{
				System.out.println("Invalid Command");
			}
		}
	}
	
	public static ArrayList<Integer> insertion(ArrayList<Integer> list){
		double startTime = System.nanoTime();
		for(int i = 1; i < list.size(); i++){
			for(int ii = i; ii >= 1; ii--){
				if(list.get(ii) < list.get(ii - 1)){
					int temp = list.get(ii - 1);
					list.set(ii-1, list.get(ii));
					list.set(ii,temp);
				}
			}
		}
		double end = System.nanoTime();
		System.out.println("\nInsertion Sort: "+list);
		System.out.printf("Time elapsed: %f ms.%n%n",(end-startTime)/1000000);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Integer> radix(ArrayList<Integer> list){
		double startTime = System.nanoTime();
		@SuppressWarnings("rawtypes")
		ArrayList[] bucket = new ArrayList[10];
		@SuppressWarnings("rawtypes")
		ArrayList[] bucket2 = new ArrayList[10];
		int power = 10;
		for(int i = 0; i < bucket.length; i++){
			bucket[i] = new ArrayList<Integer>();
			bucket2[i] = new ArrayList<Integer>();
		}
		int max = list.get(0);
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) > max)
				max = list.get(i);
			bucket[i%(bucket.length)].add(list.get(i));
		}
		
		for(int b = 0; b < Integer.toString(max).length()+1;b++){
			for(int i = 0; i<bucket.length;i++){
				for(int ii = 0; ii <bucket[i].size(); ii++){
					bucket2[( (int)bucket[i].get(ii) % power )/(power/10)].add(bucket[i].get(ii));
				}
				
				bucket[i].clear();
			}
			@SuppressWarnings("rawtypes")
			ArrayList[] temp = bucket;
			bucket = bucket2;
			bucket2 = temp;
			power *= 10;
		}
		
		/*while(bucket[0].size() != list.size()){
			for(int i = 0; i<bucket.length;i++){
				for(int ii = 0; ii <bucket[i].size(); ii++){
					bucket2[( (int)bucket[i].get(ii) % power )/(power/10)].add(bucket[i].get(ii));
				}
				bucket[i].clear();
			}
			@SuppressWarnings("rawtypes")
			ArrayList[] temp = bucket;
			bucket = bucket2;
			bucket2 = temp;
			power *= 10;
		}*/
		ArrayList<Integer> re = new ArrayList<Integer>();
		for(int i = 0; i<list.size();i++){
			re.add((Integer) bucket[0].get(i));
		}
		double end = System.nanoTime();
		System.out.println("Radix Sort: "+re);
		System.out.printf("Time elapsed: %f ms.%n%n",(end-startTime)/1000000);
		return re;
		
	}
	
	public static ArrayList<Integer> readFile(String fileName){
		Scanner readFile;
		try {
			 readFile = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
			return readFile(new Scanner(System.in).nextLine());
		}
		ArrayList<String> inputList = new  ArrayList<String>(Arrays.asList(readFile.nextLine().split(",")));
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for(String i:inputList){
			numList.add(Integer.parseInt(i));
		}
		readFile.close();
		System.out.println(numList);
		return numList;
	}

}
