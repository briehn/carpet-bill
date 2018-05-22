package CarpetBill;

import java.util.Scanner;
import java.util.Random;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class CarpetBill {

	public static void main(String[] args) {
		final double taxRate = 0.085;
		
		DecimalFormat cost = new DecimalFormat("0000.00");
		DecimalFormat per = new DecimalFormat("00.00");
		DecimalFormat measurement = new DecimalFormat("000");
		NumberFormat taxPer = NumberFormat.getPercentInstance();
		taxPer.setMinimumFractionDigits(2);
		
	    int length, width, area;
	    double pricePer, taxPrice, purePrice, totalPrice;
	    String preFirstName, preLastName, firstName, lastName, firstLetter, firstFive, customerID;
	    
	    //RNG for customer ID
	    Random rand = new Random();
	    int num = rand.nextInt(100);
	    
	    Scanner scan = new Scanner(System.in);
	    
	    //Input
	      //Refer to CarpetBillAlgorithm.txt
	      System.out.println("Enter your first name: ");
	      preFirstName = scan.next();
	      System.out.println("Enter your last name: ");
	      preLastName = scan.next();
	      System.out.println("Enter length of room (feet): ");
	      length = scan.nextInt();
	      System.out.println("Enter width of room (feet): ");
	      width = scan.nextInt();
	      System.out.println("Enter cost per square foot: ");
	      pricePer = scan.nextFloat();
	      
	      
	    //Processing
	      //Refer to CarpetBillAlgorithm.txt
	      
	      //Title Case Conversion
	      preFirstName = preFirstName.toLowerCase();
	      char a = preFirstName.charAt(0);
	      String b = new String ("" + a);
	      firstName = b.toUpperCase() + preFirstName.substring(1);
	      
	      preLastName = preLastName.toLowerCase();
	      char k = preLastName.charAt(0);
	      String x = new String ("" + k);
	      lastName = x.toUpperCase() + preLastName.substring(1);
	      
	      firstLetter = firstName.substring(0, 1);
	      firstFive = (lastName.length() < 5 ? lastName : lastName.substring(0, 5));
	      customerID = firstLetter + firstFive + num;
	      
	      //The background mathematics.
	      area = length * width;
	      purePrice = area * pricePer;
	      taxPrice = (purePrice * taxRate);
	      totalPrice = purePrice + taxPrice;
	    
	    //Output
	      //Refer to CarpetBillAlgorithm.txt
	      System.out.println("");
	      System.out.println("CUSTOMER");
	      System.out.println("Last Name 	" + lastName);
	      System.out.println("First Name	" + firstName);
	      System.out.println("ID        	" + customerID);
	      System.out.println("");
	      System.out.println("MEASUREMENT");
	      System.out.println("Length		" + measurement.format(length) + " feet");
	      System.out.println("Width 		" + measurement.format(width) + " feet");
	      System.out.println("Area  		" + measurement.format(area) + " square feet");
	      System.out.println("");
	      System.out.println("CHARGES");
	      System.out.println("Description		Cost/Sq.Ft.		Charges"); //Spacing for this is a mess :(
	      System.out.println("-----------		-----------		--------");
	      System.out.println("Carpet			" + per.format(pricePer) + "			$"  + cost.format(purePrice));
	      System.out.println("Tax			 " + taxPer.format(taxRate) + "			 "  + cost.format(taxPrice));
	      System.out.println("						--------");
	      System.out.println("Total						$"  + cost.format(totalPrice));
	      scan.close();
	}

}
