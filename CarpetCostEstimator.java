
/**
 * Write a description of class CarpetCostEstimator here.
 * Answer to TMA01 Question 1
 * @author (Alexandru Tanase) 
 * @version (05/12/2019)
 */
public class CarpetCostEstimator
{  
   //Instance variables
   double price; //in £ per square meter
   double labourCharge; //in £ per square meter
   String postCode;
   
   /**
    * Constructor for class CarpetCostEstimator takes single double argument and assigns it to the instance variable labourCharge
    * Initializes price to 1.0 and postCode to "XXX XXX"
    */
   public CarpetCostEstimator(double aCharge)
   {
      labourCharge = aCharge;
      price = -1.0;
      postCode = "XXX XXX";
   }
   //The three getter methodes
   /**
    * Returns the price of the receiver.
    */
   public double getPrice()
   {
      return this.price;
   }
   
    /**
    * Returns the labourCharge of the receiver.
    */
   public double getLabourCharge()
   {
      return this.labourCharge;
   }
   
    /**
    * Returns the postCode of the receiver.
    */
   public String getPostCode()
   {
      return this.postCode;
   }
   //The three setter methods
   /**
    * Sets the price of the receiver to the value of the argument aPrice.
    */
   public void setPrice (double aPrice)
   {
      this.price = aPrice;
   }
   
   /**
    * Sets the labourCharge of the receiver to the value of the argument aCharge.
    */
   public void setLabourCharge (double aCharge)
   {
      this.labourCharge = aCharge;
   }
   
    /**
    * Sets the postCode of the receiver to the value of the argument aPostCode.
    */
   public void setPostCode (String aPostCode)
   {
      this.postCode = aPostCode;
   }
   
   /**
    * Calculates the local variable cost by using the instance variable price and the two arguments aWith and aLength
    * Returns the value of the local variable cost
    */
   public double calculateCarpetCost(int aWith, int aLength)
   {
      int area = aWith * aLength;
      double cost = price * area;
      return cost;
   }
   
   /**
    * Calculates the local variable fitting by using the instance variable labourCharge and the two arguments aWith and aLength
    * Returns the value of the local variable fitting after multiplying with the value of costMultiplier method
    */
   public double calculateFittingCost(int aWith, int aLength)
   {
      int area = aWith * aLength;
      double fitting = labourCharge * area;
             fitting = fitting * this.costMultiplier();
      return fitting;
   }
   
   /**
    * The method returns 1.2 if the value of the string posCodes begins with "WC1A" or "EC1A" and 1.0 otherwise
    */
   public double costMultiplier()
   {
      double multiplier = 1.0;
      String wCode = "WC1A";
      String eCode = "EC1A";
      if ((postCode.substring(0, 4).equals(wCode)) || (postCode.substring(0, 4).equals(eCode)))
      {
         multiplier = 1.2;
      }
      return multiplier;
   }
   
   /**
    * Takes four integer arguments representing the with, length, start price and end price 
    * Returns a table containing the price, carpet cost and fitting cost
    */
   public void printCostTable(int aWidth, int aLength, int startPrice, int endPrice)
   {
      String tab = "\t";
      price = startPrice;
      double cValue = this.calculateCarpetCost(aWidth, aLength);
      double fValue = this.calculateFittingCost(aWidth, aLength);
      String carpet = Double.toString(cValue);
      String fitting = Double.toString(fValue);
      String sPrice = Double.toString(price);
      System.out.println("price" + tab + "carpet" + tab + "fitting"); // the header of the table
      System.out.println( price + tab + carpet + tab +  fitting);     // first line of the table

      while (price < endPrice) // loop for the number of outputs for the table
      {
         price = price + 4;
         cValue = this.calculateCarpetCost(aWidth, aLength);
         fValue = this.calculateFittingCost(aWidth, aLength);
         carpet = Double.toString(cValue);
         fitting = Double.toString(fValue);
         sPrice = Double.toString(price);
         if (price < endPrice)
         {
         System.out.println( price + tab + carpet + tab +  fitting);
         }
      }        
   }
}
     


