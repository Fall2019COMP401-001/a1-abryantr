package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//these strings are output at the end of the program
		String biggest_output;
		String smallest_output;
		String average_output;
		
		//reads the number of products from the input
		int number_of_products = scan.nextInt();
		
		//these two arrays will function similarly to a 2-dimensional array to associate products with prices
		String[] product_list = new String[number_of_products];
		double[] price_list = new double[number_of_products];
		
		//this loop adds each product and price to their respective arrays
		for(int i = 0; i<number_of_products; i++) {
			product_list[i] = scan.next();
			price_list[i] = scan.nextDouble();
		}
		
		//reads the number of customers from the input
		int number_of_customers = scan.nextInt();
		
		//these two arrays function similarly to a 2-dimensional array to associate customers with their expenditure
		String[] customer_list = new String[number_of_customers];
		double[] expenditure_list = new double[number_of_customers];
		
		//this loop adds each customer and their expenditure to their respective arrays
		for(int j = 0; j<number_of_customers; j++) {
			
			//placeholder variable to hold total expenditure until it is added to the array at the end of each loop cycle
			double customer_expenditure = 0;
			
			//adds each customer's full name to the array of customer names
			customer_list[j] = scan.next() + " " + scan.next();
			
			//reads the number of purchases each customer made from the input
			int number_of_purchases = scan.nextInt();
			
			//this loop determines the price of each purchase and adds it to the customer's expenditure (
			for(int k = 0; k<number_of_purchases; k++) {
				
				//reads the number of each item purchased from the input
				int quantity_purchased = scan.nextInt();
				
				//reads the name of each item purchased from the input
				String item_purchased = scan.next();
				
				//placeholder variable to be used to associate between product_list and price_list
				int product_price_index = 0;
				
				//searches the product_list array for the product named in item_purchased
				for(int l = 0; l<product_list.length; l++) {
					if(product_list[l].equals(item_purchased)) {
						product_price_index = l;
						break;
					}	
				}
				customer_expenditure += price_list[product_price_index] * quantity_purchased;
			}
			
			//adds each customer's expenditure to the array of customer expenditures
			expenditure_list[j] = customer_expenditure;
		}
		
		biggest_output = findBiggest(customer_list, expenditure_list);
		smallest_output = findSmallest(customer_list, expenditure_list);
		average_output = findAverage(expenditure_list);
		
		System.out.println(biggest_output);
		System.out.println(smallest_output);
		System.out.println(average_output);
		scan.close();
	}
	
	//helper method to find the customer with the largest expenditure expressed as a string
	private static String findBiggest(String[] customer_list, double[] expenditure_list) {
		
		//the saved index, eventually the index in both arrays of the biggest expenditure
		int biggest_index = 0;
		
		//searches for the biggest expenditure
		for(int i = 0; i<customer_list.length; i++) {
			//of the value of the saved index is larger than the value of the current index, change the value of the saved index to the value of the current index
			if(expenditure_list[biggest_index] < expenditure_list[i]) {
				biggest_index = i;
			}
		}		
		
		//parses results into strings appropriate for output
		String customer = customer_list[biggest_index];
		String expenditure = expressAsMoney(expenditure_list[biggest_index]);
		
		return "Biggest: " + customer + " (" + expenditure + ")";
	}
	
	//helper method to find the customer with the smallest expenditure expressed as a string
	private static String findSmallest(String[] customer_list, double[] expenditure_list) {
		
		//the saved index, eventually the index in both arrays of the smallest expenditure
			int smallest_index = 0;
			
			//searches for the smallest expenditure
			for(int i = 0; i<customer_list.length; i++) {
				//of the value of the saved index is larger than the value of the current index, change the value of the saved index to the value of the current index
				if(expenditure_list[smallest_index] > expenditure_list[i]) {
					smallest_index = i;
				}
			}
				
			//parses results into strings appropriate for output
			String customer = customer_list[smallest_index];
			String expenditure = expressAsMoney(expenditure_list[smallest_index]);
			
			return "Smallest: " + customer + " (" + expenditure + ")";
		}
	
	//helper method to find the average expenditure of all customers expressed as a string
	private static String findAverage(double[] expenditure_list) {
		
		//uses helper method to find average
		double average = averageArray(expenditure_list);
		
		//expresses average as a string with 2 decimal places
		return "Average: " + expressAsMoney(average);
	}
	
	//simple helper method to find the value of the average of all values in a double array
	private static double averageArray(double[] input_array) {
		double average;
		double array_sum = 0;
		
		//adds all values in the array into array_sum
		for(int i = 0; i<input_array.length; i++) {
			array_sum += input_array[i];
		}
		
		average = array_sum / input_array.length;
		
		return average;
	}
	
	//simple helper method to express a double as a string with two decimal places
	private static String expressAsMoney(double price) {
		return String.format("%.2f", price);
	}
}
