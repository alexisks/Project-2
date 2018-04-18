/************************************************************/
/* Alex Schoonover                                          */
/* Login ID: scho9419                                       */
/* CS-102, Winter 2018                                      */
/* Programming Assignment 1                                 */
/* Person Class: informatin about the people donating blood */
/************************************************************/
import java.time.LocalDate;
public class Person
{ //Person Class
   private String firstName; 
   private String lastName; 
   private String ID; 
   private String bloodType; 
   
   public Person(String ID, String lastName, String firstName, String bloodType) 
   { //Person 
      this.ID = ID;
      this.lastName = lastName; 
      this.firstName = firstName; 
      this.bloodType = bloodType; 
   }//End Person

   public String getLastName()
   {
      return lastName; 
   }
   
   public String getFirstName()
   {
      return firstName; 
   }
   
   public String getBloodType()
   {
      return bloodType;
   }
   
   public String getPersonID()
   {
      return ID; 
   }
   
   
   /*************************************************************/
/*Method: eligible                                              */
/*Purpose: Find all if a person is eligible to donate blood     */
/*Parameters:                                                   */
/*            : String                                          */
/*      Return: boolean                                         */   
/****************************************************************/

   public boolean eligible(Donation item)
   {
   
      LocalDate today = LocalDate.now();
      LocalDate lastDate = item.getDate();
      
      lastDate = lastDate.plusDays(56); 
      
      return lastDate.isBefore(today);
      
       
   }
   
   
   public String toString()
   {
      String str = ""; 
      str += firstName + " " + lastName + " " + "(" + ID + ")"; 
      str += "\nBloodtype: " + bloodType + "\n"; 
      
      return str; 
   }
}//end Person class