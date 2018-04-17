/************************************************************/
/* Alex Schoonover                                          */
/* Login ID: scho9419                                       */
/* CS-102, Winter 2018                                      */
/* Programming Assignment 1                                 */
/* Person Class: informatin about the people donating blood */
/************************************************************/

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
   
   public String toString()
   {
      String str = ""; 
      str += firstName + " " + lastName + " " + "(" + ID + ")"; 
      str += "\nBloodtype: " + bloodType; 
      
      return str; 
   }
}//end Person class