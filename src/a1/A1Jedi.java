package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//reads number of products from input
		int number_of_products = scan.nextInt();
		
		//array holding the names of each product
		String[] product_names = new String[number_of_products];
		
		//reads names of products into the array
		for(int i = 0; i < number_of_products; i++) {
			//reads each product name
			product_names[i] = scan.next();
			//skips the price of each product
			scan.nextDouble();
		}
		
		//array for holding the number of each product sold, indexed to product_names
		int[] number_sold = new int[number_of_products];
		//array for holding the distinct instances of each product being sold, indexed to product_names
		int[] distinct_sold = new int[number_of_products];
		
		//reads the total number of customers
		int number_of_customers = scan.nextInt();
		
		for(int j = 0; j < number_of_customers; j++) {
			//skips the name of each customer
			scan.next();
			scan.next();
			
			//reads the number of sale entries this customer has
			int number_of_entries = scan.nextInt();
			
			//array holding quantity sold from each entry
			int[] quantity_sold_customer = new int[number_of_entries];
			//array holding item name from each entry
			String[] product_name_customer = new String[number_of_entries];
			
			//cycles through each customer to populate quantity_sold_customer and product_name_customer
			for(int k = 0; k < number_of_entries; k++) {
				//reads quantity sold for each entry
				quantity_sold_customer[k] = scan.nextInt();
				//reads product name for each entry
				product_name_customer[k] = scan.next();
			}
			
			//cycles through quantity_sold_customer and product_name_customer to add to number_sold
			for(int l = 0; l < number_of_entries; l++) {
				//finds the location in the product_names array where each product appears
				int name_index = findInArray(product_name_customer[l], product_names);
				number_sold[name_index] += quantity_sold_customer[l];
			}
			
			//removes duplicates from the list of products
			product_name_customer = removeDuplicates(product_name_customer);
			
			//cycles through product_name_customer to add to distinct_sold
			for(int m = 0; m < product_name_customer.length; m++) {
				//finds the location in the product_names array where each product appears
				int name_index = findInArray(product_name_customer[m], product_names);
				if(name_index!=-1)
					distinct_sold[name_index]++;
			}
		}
		
		//prints the inputs for each product using product_names, number_sold, and distinct_sold
		for(int n = 0; n < product_names.length; n++) {
			if(number_sold[n]==0) {
				System.out.println("No customers bought " + product_names[0]);
			} else {
				System.out.println(distinct_sold[n] + " customers bought " + number_sold[n] + " " + product_names[n]);
			}
		}
		
		scan.close();
	}
	
	//helper method to find a specific string in an array
	//returns the first index where the specified string appears
	//if the string does not appear, returns -1
	private static int findInArray(String search_for, String[] search_in) {		
		for(int i = 0; i < search_in.length; i++) {
			if(search_for.equals(search_in[i])) {
				return i;
			}
		}
		return -1;
	}
	
	//helper method to remove duplicates from a string array and replace them with "dummy"
	private static String[] removeDuplicates(String[] input_array) {
		for(int i = 1; i < input_array.length; i++) {
			for(int j = 0; j < i; j++) {
				if(input_array[i].equals(input_array[j])) {
					input_array[j] = "dummy";
				}
			}
		}
		return input_array;
	}
}
