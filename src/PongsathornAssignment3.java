import java.util.Scanner;


public class PongsathornAssignment3 {
		
	public static void main(String[] args){
		Scanner read = new Scanner(System.in);
		//boolean variable controlling the loop
		boolean stop = false, mode_insert = true, mode_search = true;
		while(!stop){
			System.out.print("Enter the size of the hash table (or type 'quit' to exit): ");
			String input = read.nextLine();
			//check if user want to quit
			if(input.equals("quit")){
				
				break;
			}
			else
			{
				//create an array
				int[] array = new int[Integer.parseInt(input)];
				System.out.print("Enter the probing type - Linear or QUADRATIC:");
				//check user prefer probing function
				String prob = read.nextLine();
				boolean linear = prob.equals("LINEAR");
				boolean quadratic = prob.equals("QUADRATIC");
				System.out.print("Enter values to be inserted into hash table. Type 'stop' when finished: ");
				//insert input into the array
				while(mode_insert){
					input = read.nextLine();
					//check user input, quit insert loop if user input 'stop'
					if(input.equals("stop")){
						mode_insert = false;
						break;
					}
					//using user preferred probing function
					if(linear){
						int i = 0;
						//linear probing formula
						int index = (Integer.parseInt(input) + i) % array.length;
						//if found collision, increment i by one
						while(array[index] != 0){
							i++;
							index  = (Integer.parseInt(input) + i) % array.length;
						}
						array[index] = Integer.parseInt(input);
					}
					else if(quadratic){
						int hash = input.hashCode();
						int i = 0;
						//quadratic probing formula
						int index = (int) ((Integer.parseInt(input) + (Math.pow(i, 2))) % array.length);
						//if found collision, increment i by one
						while(array[index] != 0){
							i++;
							index = (int) ((Integer.parseInt(input) + (Math.pow(i, 2))) % array.length);
						}
						array[index] = Integer.parseInt(input);
					}
					//print out the array
					for(int i: array){
						if(i == 0){
							System.out.print("X |");
						}
						else
							System.out.print(i + " |");
					}
					System.out.println();
				}
				
				while(mode_search){
					System.out.print("Enter value to serach for in the hash table (or type 'stop'): ");
					input = read.nextLine();
					//check user input, break loop if user want to stop
					if(input.equals("stop")){
						mode_search = false;
						break;
					}
					
					//check for used probing function
					boolean notFound = false;
					if(linear){
						int i = 0;
						int index = (int) ((Integer.parseInt(input) + i) % array.length);
						//while not found, increment i by one
						while(array[index] != Integer.parseInt(input)){
							i++;
							index = (int) ((Integer.parseInt(input) + i) % array.length);
							if(i == array.length)
							{
								notFound = true;
								break;
							}
						}
						if(notFound){
							System.out.println("Not Found");
						}
						else
							System.out.printf("Value %d found in index %d%n",Integer.parseInt(input),index);
					}
					else if(quadratic){
						int i = 0;
						int index = (int) ((Integer.parseInt(input) + (Math.pow(i, 2))) % array.length);
						//while not found, increment i by one
						while(array[index] != Integer.parseInt(input)){
							i++;
							index = (int) ((Integer.parseInt(input) + (Math.pow(i, 2))) % array.length);
							if(i == array.length)
							{
								notFound = true;
								break;
							}
						}
						if(notFound){
							System.out.println("Not Found");
						}
						else
							System.out.printf("Value %d found in index %d%n",Integer.parseInt(input),index);
					}
				
				}
				
				
			}
			
		}
		
	}
}
