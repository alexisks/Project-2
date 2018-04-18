/*******************************************/
/* Alex Schoonover                         */
/* Login ID: scho9419                      */
/* CS-102, Winter 2018                     */
/* Programming Assignment 2                */
/* LinkedList Class                        */
/*******************************************/
import java.time.LocalDate;
public class LinkedList 
{// Begin LinkedList class
   public Node head;
   
   public LinkedList() 
   {
      head = null; 
   }
   
   public boolean isEmpty() 
   { 
      return head == null; 
   }
   
   public int size() 
   {// begin size()
      Node current = head; 
      int count = 0; 
      while(current != null) 
      {
         count++;
         current = current.getNext();
      }
      return count; 
   }// end size()
   
   public Object get(int index)
   {// begin get()
      Node current = head; 
      while ((index != 0) && (current != null)) 
      {
         index--;
         current = current.getNext();
      }
      if(current == null)
      throw new IndexOutOfBoundsException();
      
      return current.getDatum();
   }// end get()
      
   public void add(Node item)
   {// begin add()
      Node current = head; 
      Node previous = null;
      Person spliceItem = (Person) item.getDatum(); 
      
      
      if (head == null)
      {
         head = item; 
      }     
      
      else
      { 
         while(current != null)
         {
            Person spliceCurrent = (Person) current.getDatum(); 
            
            if(previous == null && spliceItem.getLastName().compareTo(spliceCurrent.getLastName()) < 0)
            {
               item.setNext(current); 
               head = item;
               return;  
            }
            
            else if(spliceItem.getLastName().compareTo(spliceCurrent.getLastName()) < 0 )
            {
               
               item.setNext(current);
               previous.setNext(item); 
               return; 
            }
          
            else if (spliceItem.getLastName().compareTo(spliceCurrent.getLastName()) == 0)
            {
               if(previous == null && spliceItem.getFirstName().compareTo(spliceCurrent.getFirstName()) < 0)
               {
                  item.setNext(current);
                  head = item; 
                  return; 
               }
               else if(spliceItem.getFirstName().compareTo(spliceCurrent.getFirstName()) < 0)
               {
                  item.setNext(current); 
                  previous.setNext(item); 
                  return;
               }
            }
            previous = current;
            current = current.getNext();
       
         }
         
         previous.setNext(item); 
         
         }
          
           
   }//end add()
   // getID() - Donation class //getPersonID() Person class
   public void addDonation(Node item) 
   {//begin addDonation
      Node current = head; 
      Node previous = null;
      Donation spliceItem = (Donation) item.getDatum(); 
      boolean validDate = false; 
      
      
      
         while(current != null)
            {//while (current != null)
               Person spliceCurrent = (Person) current.getDatum(); 
               
               if(spliceItem.getID().compareTo(spliceCurrent.getPersonID()) == 0)
               { //if
                  Node patient = current; 
                  Node curDate = patient.getDateNode();
                  Node preDate = null;  
   
                  while(curDate != null)
                  {
                     Donation temp = (Donation) item.getDatum(); 
                     Donation temp2 = (Donation) curDate.getDatum(); 
                     validDate = temp.equalTo(temp2); 
                     if(validDate == true)
                        throw new Error(); 
                     Donation spliceCurrentDate = (Donation) curDate.getDatum();
                     Donation spliceItemComp = (Donation) item.getDatum(); 
                     if(spliceItemComp.getDate().compareTo(spliceCurrentDate.getDate()) < 0)
                     {
                        if(preDate != null)
                        {
                           item.setNextDate(curDate); 
                           preDate.setNextDate(item); 
                           return; 
                        }
                        else 
                        {
                           item.setDateNode(curDate);
                           patient.setNextDate(item);  
                           return; 
                        }
                        
                     }
                     
                     else 
                     {
                        preDate = curDate; 
                        curDate = curDate.getDateNode();
                     }
                     
                  }
                  
                  if(preDate == null)
                  {
                     patient.setDateNode(item); 
                     return; 
                  }
                  else 
                  {
                     preDate.setDateNode(item); 
                     return; 
                  }
                    
               } //end if
              
              previous = current;  
              current = current.getNext(); 
                     
            } //end while
         
   } //end addDonation
   
   public Object remove(int index)
   {
      Node current = head; 
      Node previous = null; 
      
      while((index != 0) && (current != null))
      {
         index--; 
         previous = current; 
         current = current.getNext();
      }
      
      if(current == null)
         throw new IndexOutOfBoundsException();
      if(previous == null)
         head = current.getNext();
      
      previous.setNext(current.getNext());
      
      return current.getDatum();
   }
   public void removeAll() 
   {
      head = null; 
   }
  
   
   
   public int sortPerson(Person newPerson, Node head)
   {
      int count = 0; 
      String lastName = newPerson.getLastName();
      String firstName = newPerson.getLastName(); 
      
      while(head != null)
      {
         //lastName.compareTo();
         //head = head.next() ;
         count++;
      }
      
      return 0; 
   }
}//end LinkedList class