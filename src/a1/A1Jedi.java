package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//reads input describing number of products being sold
		int number_of_products = scan.nextInt();
		
		//these arrays function together as a matrix
		//this array will contain the names of each product
		String[] product_names = new String[number_of_products];
		//this array will contain the number of each product purchased
		int[] number_purchases = new int[number_of_products];
		//this array will contain the number of customers who purchased each product
		int[] distinct_purchases = new int[number_of_products];
		
		//prepopulates number_purchased and distinct_purchases to avoid weird nonsense
		for(int h = 0; h < number_of_products; h++) {
			number_purchases[h] = 0;
			distinct_purchases[h] = 0;
		}
		
		//this loop will add each product name to the array
		for(int i = 0; i<number_of_products; i++) {
			
			//reads the product name from the input
			String product_name = scan.next();
			
			//reads the price of each product
			//this information is not used in this program
			scan.nextDouble();
			
			//adds the product name into the array
			product_names[i] = product_name;
		}
		
		//reads the number of customers from the input
		int number_of_customers = scan.nextInt();
		
		//this loop cycles through each customer and determines how many of each product they purchased
		for(int j = 0; j < number_of_customers; j++) {
			
			//reads the customer's name
			//this information is not used in this program
			scan.next();
			scan.next();
			
			//reads the number of products the customer purchased
			int number_customer_purchased_total = scan.nextInt();
			
			//cycles through each product the customer purchased
			for(int k = 0; k < number_customer_purchased_total; k++) {
				
				//reads the number of this product the customer purchased
				int number_customer_purchased = scan.nextInt();
				
				//reads the name of the product the customer purchased
				String product_name_customer_purchased = scan.next();
				
				//finds the appropriate index for each product in the output arrays and increments the values in those arrays
				for(int l = 0; l < number_of_products; l++) {
					if(product_names[l].equals(product_name_customer_purchased)) {
						number_purchases[l] += number_customer_purchased;
						distinct_purchases[l]++;
						break;
					}
				}
			}
		}
		
		//this array contains strings for each output value
		String[] output_strings = new String[number_of_products];
		
		//cycles through each product to generate an appropriate string for output
		for(int m = 0; m < output_strings.length; m++) {
			if(number_purchases[m]==0) {
				output_strings[m] = "No customers bought " + product_names[m];
			} else {
				output_strings[m] = distinct_purchases[m] + " customers bought " + number_purchases[m] + " " + product_names[m];
			}
		}
		
		//outputs each index of the output array on its own line
		for(int n = 0; n < output_strings.length; n++) 
			System.out.println(output_strings[n]);
		
		scan.close();
	}
}
