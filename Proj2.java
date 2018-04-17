/*******************************************/
/* Alex Schoonover                         */
/* Login ID: scho9419                      */
/* CS-102, Winter 2018                     */
/* Programming Assignment 2                */
/* Main method                             */
/*******************************************/

import java.util.*;
import java.io.*;
import java.lang.*;
import java.time.LocalDate;

public class Proj2
{// begin Proj1 class
   public static void main (String [] args)
   {//main
      
      int numPeople; //number of people in a text file. 
      int donorCount = 0;    //counts number of donors.  
      int donationCount = 0; //counts number of donations in donation file. 
      
      Database data = new Database();
      //LinkedList bloodSource = new LinkedList(); //the linked list for donors
      
      
      
      final int PRINT_ALL = 1; 
      final int SEARCH_DONOR = 2; 
      final int SEARCH_BLOOD_TYPE =3; 
      final int EXIT = 9; 
      
      if (args.length != 2)
      {
         System.out.println("You need to pass two arguments.");
         System.exit(1);
      }
      
      File donorList = null; 
      Scanner donorScan = null;
       try
       {
         donorList = new File(args[0]);
         donorScan = new Scanner(donorList);
       }
       catch (ArrayIndexOutOfBoundsException exc)
       {
         System.out.println("No arguments given to program.");
         System.exit(2); 
       }
       
       catch (FileNotFoundException exc)
       {
          System.out.println("File could not be opened.");
          System.exit(3);
       }
       
      File donationList = null; 
      Scanner donationScan = null; 
       try
       {
         donationList = new File (args[1]);
         donationScan = new Scanner(donationList);
       }
       catch (ArrayIndexOutOfBoundsException exc)
       {
         System.out.println("No arguments given to program.");
         System.exit(4); 
       }
       
       catch (FileNotFoundException exc)
       {
          System.out.println("File could not be opened.");
          System.exit(5);
       }

   while (donorScan.hasNextLine())
   {//while1 start
      donorCount++;
      donorScan.nextLine(); 
   }//while1 end
   try
   {
      donorScan = new Scanner(donorList); 
   }
   catch(FileNotFoundException exc)
   {
      System.out.println("File not found");
      System.exit(6);
   }
   
   
   
   //Making a Person
   int tempCount = 0;
   
   while ((donorCount >= 0) && (donorScan.hasNext()))
   {//while2 start
      donorCount--; 
  //    donorScan.useDelimiter("/|\n");
//       
//          Person person1= new Person(donorScan.next(), donorScan.next(), 
//                                 donorScan.next(), donorScan.next());
         String line = donorScan.nextLine(); 
         
         
         String[] pieces = line.split("/");
         
         for(int index=0; index < pieces.length; index++){
            pieces[index] = pieces[index].replaceAll("/"," ");
            pieces[index] = pieces[index].replaceAll("/n", " ");  
         }
         

         
         Person person1 = new Person(pieces[0],pieces[1],pieces[2],pieces[3]); //the person object
         Node temp = new Node(); 
         
         temp.setDatum(person1);
         //data.personList[tempCount] = person1; 
         
         data.personList.add(temp); 
         
         tempCount++;
      
 
   }//while2 end   
   
   while (donationScan.hasNextLine())
   {
      donationCount++;
      donationScan.nextLine();
   }
   
   try
   {
      donationScan = new Scanner(donationList); 
   }
   catch(FileNotFoundException exc)
   {
      System.out.println("File not found");
      System.exit(7);
   }
   
   //Start making donation dates and adding them to Donors
   //data.donationList = new Donation[donationCount];
   tempCount = 0;
   
   while ((donationCount >= 0) && (donationScan.hasNext()))
   {//while3 start
      donationCount--; 
     // donationScan.useDelimiter("/|\n");
     
      String line = donationScan.nextLine();
      String[] piecesDonation = line.split("/");
      
      for(int index=0; index < piecesDonation.length; index++){
            piecesDonation[index] = piecesDonation[index].replaceAll("/"," ");
            piecesDonation[index] = piecesDonation[index].replaceAll("/n", " ");  
         }

      
      
      Donation donation1 = new Donation(piecesDonation[0], data.dateFormat(piecesDonation[1]));
      
      Node temp = new Node(); 
      temp.setDatum(donation1);
      
      data.personList.addDonation(temp);
      
      
         
 //     data.donationList[tempCount] = donation1; 
      tempCount++;
      
 
   }//while3 end 
   
   LocalDate today = LocalDate.now();
     
   System.out.print("Welcome to the CS-102 Blood Donor Database Program. \nToday's date is: "); 
   System.out.println(today);
   System.out.print("Current available commands:\n1 --> Print all donors\n2 --> Search for a donor"
                       +"\n3 --> Search for a blood type\n9 --> Exit\nYour choice?");
   
   Scanner choiceScan = new Scanner(System.in);
   int choice = 0;
   do{
         try
         { 
            choice = choiceScan.nextInt();
         } 
         catch (InputMismatchException exc)
         {
            System.out.println("Only use integers: 1,2,3, or 9.");
         }
         choiceScan.nextLine(); 
      }
   while(choice < 0 && choice >= 9);
   
   
   while(choice != EXIT)
   {//while interface
      if(choice == PRINT_ALL) //1
      {
 //        data.print(data.personList); 
            
            
            System.out.println("");
        
      }   
      else if(choice == SEARCH_DONOR)//2
      {
         System.out.print("Donor ID number: "); 
         Scanner scan = new Scanner(System.in);
         String testID = scan.next();
  //       Person[] matchID = new Person[data.personList.length];
  //       matchID = data.searchID(testID); 
         
      //    if(matchID[0] != null)
//          {
//             data.print(matchID);
//             System.out.println("All donation dates: ");
//             data.print(data.getAllDonations(matchID[0].getPersonID()));
//             System.out.println("");
//             }
//          else
//          {
//              System.out.println("No matches found for that ID");
//          }
//          
         
      }
      else if(choice == SEARCH_BLOOD_TYPE)//3
      {
         System.out.print("Bloodtype: " ); 
         Scanner scan = new Scanner(System.in); 
         String testBlood = scan.next();
     //    Person[] matchBlood = new Person[data.personList.length];
     //    matchBlood = data.searchBloodType(testBlood); 
         
     //    if(matchBlood[0] == null)
         System.out.println("No matches found for that bloodtype.");
         
      //   data.print(matchBlood); 
         System.out.println("");
         
      }
      else 
      {
         System.out.print("Please choose from the current available commands. \n\n");
      }
      
      System.out.print("Current available commands:\n1 --> Print all donors\n2 --> "
                     + "Search for a donor" + "\n3 --> Search for a blood type\n"
                     + "9 --> Exit\nYour choice?"); 
      do{
      choice = 0;
            try
            { 
               choice = choiceScan.nextInt();
            } 
            catch (InputMismatchException exc)
            {
               System.out.println("Only use integers: 1,2,3, or 9.");
            }
            choiceScan.nextLine(); 
            }
         while(!(choice > 0) && !(choice <= 9));
   }// while interface end
   
   }//end main   
}//end Proj1 Class