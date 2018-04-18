/*************************************************************/
/* Alex Schoonover                                           */
/* Login ID: scho9419                                        */
/* CS-102, Winter 2018                                       */
/* Programming Assignment 1                                  */
/* Database Class: Collection of Person and Donation objects */
/*************************************************************/

import java.time.LocalDate;
public class Database
{ //Database class
   public LinkedList personList; 
   public LinkedList donationList;   
   
   public Database()
   {//Database
     personList = new LinkedList(); 
     donationList = new LinkedList(); 
   }//end Database
   

/*************************************************************/
/*Method: searchBloodType                                    */
/*Purpose: Find all peope with a specific blood type         */
/*Parameters:                                               */
/*            : String                                          */
/*      Return: Person[]                                    */
/*************************************************************/
   public Person[] searchBloodType(String bloodType) 
   {//search
      int count = 0; 
      Person[] bloodMatches = new Person[personList.size()]; 
      
      for(int i=0; i < personList.size(); i++)
      {
         Person temp = (Person)personList.get(i);
         String personBlood = temp.getBloodType();
         if (personBlood.equals(bloodType))
         {
            bloodMatches[count] = temp;
            count++;
         }
      }
      return bloodMatches;
   }//search

   

/*************************************************************/
/*Method: searchID                                    */
/*Purpose: Find all instances of the ID in the donation txt file  */
/*Parameters:                                               */
/*            : String                                          */
/*      Return: Person[]                                    */
/*************************************************************/
  
   public Person[] searchID(String ID)
   {
      int count = 0; 
      Person[] IdMatches = new Person[personList.size()]; 
      
      for(int i=0; i < personList.size(); i++)
      {
         Person temp = (Person)personList.get(i);
         String personID = temp.getPersonID();
         if (personID.equals(ID))
         {
            IdMatches[count] = temp;
            count++;
         }
      }
      return IdMatches;
   }
  /*************************************************************/
/*Method: eligible                                    */
/*Purpose: Find all if a person is eligible to donate blood         */
/*Parameters:                                               */
/*            : String                                          */
/*      Return: boolean                                    */
/*************************************************************/

  //  public boolean eligible(Donation item)
//    {
//       LocalDate today = LocalDate.now();
//       LocalDate lastDate = findDate(thisID);
//       
//       lastDate = lastDate.plusDays(56); 
//       
//       return lastDate.isBefore(today);
//       
//        
//    }
   
/*************************************************************/
/*Method: print                                              */
/*Purpose: print the results of a program                    */
/*Parameters:                                                */
/*            : Person[]                                     */
/*      Return: Nothing. But will print necassary information*/
/*************************************************************/
   
   public void print(LinkedList people)
   {
         Node current = people.head; 
         Person donorTest = (Person) current.getDatum(); 
         while(current != null)
         {
            System.out.print((Person)current.getDatum()); 
            if(current.getDateNode() != null)
            {
               Donation test = (Donation) current.getDateNode().getDatum(); 
               System.out.println("Last donation date: " + test.getDate());
               //}
                
               if(test.getDate() != LocalDate.MIN)
               {
                                    if(donorTest.eligible(test))
                  System.out.println("Eligible: yes.");
                  else
                  System.out.println("Eligible: no.");
                  System.out.println("");
               }
               else 
                  System.out.println("Never donated before.\n");
            }
            else
            {
               System.out.println("Last donation date: never");
               System.out.println("Eligible: yes.");
               System.out.println("");
            }
            
            current = current.getNext(); 
         }
         
         
         // for(int i = 0; i < people.length; i++)
//          {
//             if(people[i] != null)
//             {
//                System.out.println(people[i]);
//                System.out.print("Last donation date: ");
//                if(current.getDateNode.getDatum()) != LocalDate.MIN)
//                {
//                   System.out.println(findDate(people[i].getPersonID()).toString());
//                   if(eligible(people[i].getPersonID()))
//                   System.out.println("Eligible: yes."); 
//                   else 
//                   System.out.println("Eligible: no.");
//                   System.out.println("");
//                   
//                }
//                else 
//                System.out.println("Never donated before.\n");
//             }
//          }
      
   }

/*************************************************************/
/*Method: dateFormat                                         */
/*Purpose: Takes the text from file and converts it to a LocalDate */
/*Parameters:                                                */
/*            : String date from txt file                    */
/*      Return: LocalDate                                    */
/*************************************************************/
 
   public LocalDate dateFormat(String date)
    {
      String year = date.substring(0,4);
      String month = date.substring(4,6);
      String day = date.substring(6,8); 
      
      int intYear = Integer.parseInt(year); 
      int intMonth = Integer.parseInt(month);
      int intDay = Integer.parseInt(day);
      
      LocalDate formatDate = LocalDate.of(intYear,intMonth,intDay);
      return formatDate; 
    }
/*************************************************************/
/*Method: getAllDonations                                    */
/*Purpose: Finds all the donations of one specific person    */
/*Parameters:                                                */
/*            : String of the ID                             */
/*      Return: Donation[] (All donations made in an array   */
/*************************************************************/
   
    public Donation[] getAllDonations(String thisID)
    {
      int count = 0;
      Donation[] testDonation = new Donation[donationList.size()];
      for(int i =0; i < donationList.size(); i++)
      {
         Donation temp = (Donation) donationList.get(i);
         if (temp.getID().equals(thisID))
         {
            testDonation[count] = temp;
            count++;
         }
      }
      
      return testDonation;
    }
    
    public void print(Donation[] donations)
    {
      for(int i = 0; i < donations.length; i++)
         {
            if(donations[i] != null)
            {
               System.out.println(donations[i].getDate());
            }
         }

    }
/*************************************************************/
/*Method: findDate                                           */
/*Purpose: Finds the most current date a donor donated blood */
/*Parameters:                                                */
/*            : String                                       */
/*      Return: LocalDate                                    */
/*************************************************************/
    
    public LocalDate findDate(String thisID)
    {//findDate start
      int count = 0;
      Donation[] testDonation = new Donation[donationList.size()];
      for(int i =0; i < donationList.size(); i++)
      {
         Donation temp = (Donation) donationList.get(i);
         if (temp.getID().equals(thisID))
         {
            testDonation[count] = temp;
            count++;
         }
      }
      LocalDate mostCurrent = LocalDate.MIN;
      for(int j = 0; j < testDonation.length && testDonation[j] != null; j++) 
      {
         if(testDonation[j].getDate().isAfter(mostCurrent))
         {
            mostCurrent = testDonation[j].getDate();
         }
      }
      
      
      return mostCurrent;
    }//findDate end
    
} //end Database class