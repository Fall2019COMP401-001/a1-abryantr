package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		//read number of customers from input
		int number_of_customers = scan.nextInt();

		//array to contain strings representing the first initial and last name of each customer
		String[] customer_list;
		customer_list = new String[number_of_customers];

		//array to contain doubles representing the total expenditure of each customer, corresponding to their index in customer_list
		double[] expenditure_list;
		expenditure_list = new double[number_of_customers];

		//loops through each customer using number_of_customers
		for(int i = 0; i<number_of_customers; i++) {

			//identifies the customer's first and last names
			String customer_first_name = scan.next();
			String customer_last_name = scan.next();

			//creates a single string using the customer's first initial and last name and adds it to the customer_list array
			String customer_name = customer_first_name.substring(0,1) + ". " + customer_last_name;
			customer_list[i] = customer_name;

			//reads the number of items purchased from the input
			int items_bought = scan.nextInt();

			//loops through each item bought by each customer
			for(int j = 0; j<items_bought; j++) {

				//reads the number of items bought in this case
				int item_quantity = scan.nextInt();

				//skips the name of the item purchased (not used)
				scan.next();

				//reads the price of items bought in this case
				double item_price = scan.nextDouble();

				//determines total expenditure for each item and adds it to expenditure_list
				expenditure_list[i] += ((double)item_quantity) * item_price;
			}
		}

		//prints output in format "First Initial Last Name: Total Expenditure" for each customer
		for(int k = 0; k<number_of_customers; k++){
			System.out.println(customer_list[k] + ": " + String.format("%.2f", expenditure_list[k]));
		}
		scan.close();
	}
}
