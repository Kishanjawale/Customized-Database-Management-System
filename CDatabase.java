/*
**************************************************************
**************************************************************
************CUSTOMISED DATABASE MANAGEMENT SYSTEM************
**************************************************************
**************************************************************
*/

/*
**************************************************************
//Import Statements
**************************************************************
*/
import java.lang.*;
import java.lang.management.LockInfo;
import java.nio.channels.SelectableChannel;
import java.util.*;

import javax.imageio.ImageIO;
import javax.lang.model.util.ElementScanner14;
import javax.swing.plaf.synth.SynthMenuItemUI;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;
/*
**************************************************************
// Class Name        :      Student
// Decription        :     Class student contains Following characteristics :
                                RID, Name, Salary, City
// Author            :     Kishan Vivek Jawale
// Date              :     27/7/2022   
**************************************************************
*/
class Student
{
    public int RID;
    public String Name;
    public int Salary;
    public String City;

    private static int Generator;

    static
    {
        Generator = 0;
    }

    public Student(String str, int value,String cit)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
        this.City=cit;
    }

    public void DisplayData()
    {
        System.out.println("----------------------------------------------------");
        System.out.println("    |   " +this.RID + "    |   "  + this.Name + "    |   "  + this.Salary + "    |   "+ this.City + "    |   "  );
        System.out.println("----------------------------------------------------");
    }
}

/*
**************************************************************
// Class Name        :     DBMS
// Author            :     Kishan Vivek Jawale
// Date              :     27/7/2022   
**************************************************************
*/
class DBMS
{
   public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList<>();
    }

    public void StartDBMS()
    {
        Scanner scanobj= new Scanner(System.in);
        System.out.println("Marvellous customised DBMS started succesfully....");
        String Query = "";
        while(true)
        {
            System.out.print("Marvellous DBMS Console>");
            Query = scanobj.nextLine();

            //Query Tokenization
            String tokens [] = Query.split(" ");
            int QuerySize=tokens.length;

            if(QuerySize == 1)
            {
                if("Help".equals(tokens[0]))
                {
                    
                    System.out.println("---------------------------------------");
                    System.out.println("---------------------------------------");
                    System.out.println("Customised Database Management System");
                    System.out.println("---------------------------------------");
                    System.out.println("---------------------------------------");

                    System.out.println("Terminate DBMS:");
                    System.out.println("Exit");
                    
                    System.out.println("---------------------------------------");
                    
                    System.out.println("Display All Data:");
                    System.out.println("select * from student");
                    
                    System.out.println("---------------------------------------");
                    
                    System.out.println("Insert Data into Table:");
                    System.out.println("Insert into student (Name) (Salary) (City_name)");
                    
                    System.out.println("---------------------------------------");
                    
                    System.out.println("Display Specific record By RID:");
                    System.out.println("select * from student where RID = (rid)");
                    
                    System.out.println("---------------------------------------");
                    
                    System.out.println("Display Specific record By name:");
                    System.out.println("select * from student where name = (name)");
                    
                    System.out.println("---------------------------------------");
                    
                    System.out.println("Display Specific record By City:");
                    System.out.println("select * from student where city = (city)");

                    System.out.println("---------------------------------------");
                    
                    System.out.println("Delete Specific record By name:");
                    System.out.println("Delete from student where name = (name)");

                    System.out.println("---------------------------------------");
                    
                    System.out.println("Delete Specific record By RID:");
                    System.out.println("Delete from student where RID = (rid)");

                    System.out.println("---------------------------------------");
                    
                    System.out.println("Delete Specific record By city:");
                    System.out.println("Delete from student where City = (city)");
                    
                    System.out.println("---------------------------------------");

                    System.out.println("Update name in the record by RID:");
                    System.out.println("update into student set name = (name) where RID = (rid)");

                    System.out.println("---------------------------------------");

                    System.out.println("Update city in the record by RID:");
                    System.out.println("update into student set city = (city_name) where RID = (rid)");

                    System.out.println("---------------------------------------");
                    
                    System.out.println("Update salary in the record by RID:");
                    System.out.println("update into student set salary = (salary) where RID = (rid)");

                    System.out.println("---------------------------------------");

                    System.out.println("Update city in the record by RID:");
                    System.out.println("update into student set city = (city_name) where RID = (rid)");

                    System.out.println("---------------------------------------");
                    
                    System.out.println("Display Average Salary:");
                    System.out.println("select AVG (Salary) from student");

                    System.out.println("---------------------------------------");
                    
                    System.out.println("Display Minimum Salary:");
                    System.out.println("select MIN (Salary) from student");
                    
                    System.out.println("---------------------------------------");
                    
                    System.out.println("Display Maximum Salary:");
                    System.out.println("select MAX (Salary) from student");
                    
                    System.out.println("---------------------------------------");
                    
                    System.out.println("Display Summation of Salary:");
                    System.out.println("select SUM (Salary) from student");
                    
                    System.out.println("---------------------------------------");   
                }
                else if("Exit".equals(tokens[0])||"exit".equals(tokens[0])||"EXIT".equals(tokens[0]))
                {
                    System.out.println("Thank you for using Marvellous DBMS");
                    break;
                }
            }
            else if(QuerySize == 2)
            {
                System.out.println("Invalid ...");
            }
            else if(QuerySize == 4)
            {
                if("select".equals(tokens[0]) ||"Select".equals(tokens[0]))
                {
                    if("*".equals(tokens[1]))
                    {
                        if("from".equals(tokens[2]))
                        {
                            if("student".equals(tokens[3]))
                            {
                                System.out.println("    |   " +"RID"+ "    |   " +"Name " + "    |   "+"Salary"+ "  |   "+"City"+ "  |   " );
                                DisplayAll();
                            }
                            else
                            {
                                System.out.println(" Invalid Table name. Expecting 'student'..");    
                            }
                        }
                        else 
                        {
                            System.out.println(" Invalid Query...");
                        }   
                    }
                    else if(tokens[1] != "*")
                    {
                        System.out.println("ERROR: Please Enter * After  select");
                    }
                }
                else
                {
                    System.out.println(" Invalid Token at index 0. Expecting 'select' ");
                }
            }
            else if(QuerySize == 5)
            {   
                if("select".equals(tokens[0]) ||"Select".equals(tokens[0]))
                {
                    if("average".equals(tokens[1])||"AVG".equals(tokens[1]))
                    {
                        if("(salary)".equals(tokens[2]) || "(Salary)".equals(tokens[2]))
                        {   
                            if("from".equals(tokens[3]) )
                            {   
                                if("student".equals(tokens[4]) )
                                {   
                                    AggregateAverage();
                                }
                                else
                                {
                                    System.out.println("Invalid Table Name..");
                                }
                            }
                            else
                            {
                                System.out.println("Invalid Query ...'from'  is expected at token number 3");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid Query ...'(salary)'  is expected at token number 2");
                        }
                    }
                    else if("MAX".equals(tokens[1]))
                    {
                        if("(salary)".equals(tokens[2]) || "(Salary)".equals(tokens[2]))
                        {   
                            if("from".equals(tokens[3]) )
                            {   
                                if("student".equals(tokens[4]) )
                                {   
                                    AggregateMax();
                                }
                                else
                                {
                                    System.out.println("Invalid Table Name..");
                                }
                            }
                            else
                            {
                                System.out.println("Invalid Query ...'from'  is expected at token number 3");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid Query ...'(salary)'  is expected at token number 2");
                        }
                    }
                    else if("sum".equals(tokens[1])||"SUM".equals(tokens[1]))
                    {
                        if("(salary)".equals(tokens[2]) || "(Salary)".equals(tokens[2]))
                        {   
                            if("from".equals(tokens[3]) )
                            {   
                                if("student".equals(tokens[4]) )
                                {   
                                    AggregateSum();
                                }
                                else
                                {
                                    System.out.println("Invalid Table Name..");
                                }
                            }
                            else
                            {
                                System.out.println("Invalid Query ...'from'  is expected at token number 3");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid Query ...'(salary)'  is expected at token number 2");
                        }
                    }
                    else if("minimum".equals(tokens[1])||"MIN".equals(tokens[1]))
                    {
                        if("(salary)".equals(tokens[2]) || "(Salary)".equals(tokens[2]))
                        {   
                            if("from".equals(tokens[3]) )
                            {   
                                if("student".equals(tokens[4]) )
                                {   
                                    AggregateMin();
                                }
                                else
                                {
                                    System.out.println("Invalid Table Name..");
                                }
                            }
                            else
                            {
                                System.out.println("Invalid Query ...'from'  is expected at token number 3");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid Query ...'(salary)'  is expected at token number 2");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid Query");
                    }
                }
                else
                {
                    System.out.println("Invalid Query");
                }
            }
            else if(QuerySize == 6)
            {
                // Insert into student Piyush 1000 Pune;
                if("Insert".equals(tokens[0]))
                {
                    if("into".equals(tokens[1]))
                    {
                        if("student".equals(tokens[2]))
                        {
                            InsertData(tokens[3],Integer.parseInt(tokens[4]),tokens[5]);
                            System.out.println(" Record Inserted Successfully.....");
                        }
                        else
                        {
                            System.out.println(" Invalid Query...");   
                        }
                    }
                    else
                    {
                        System.out.println(" Invalid Query...");
                    }
                }
                else
                {
                    System.out.println(" Invalid Query...");
                }
            }
            else if(QuerySize == 8)
            {
                if("select".equals(tokens[0]) ||"Select".equals(tokens[0]))
                {
                    if("*".equals(tokens[1]))
                    {
                        if("from".equals(tokens[2]))
                        { //select * from RID = Rid
                            if("RID".equals(tokens[5]) ||"rid".equals(tokens[5]))
                            {   
                                if("=".equals(tokens[6]))
                                {
                                    DisplaySpecific(Integer.parseInt(tokens[7]));
                                }
                                else
                                {
                                    System.out.println("Invalid Query");         
                                }
                            }
                            else if("Name".equals(tokens[5]) ||"name".equals(tokens[5]))
                            {
                                if("=".equals(tokens[6]))
                                {
                                    DisplaySpecific(tokens[7]);
                                }
                                else
                                {
                                    System.out.println("Invalid Query");
                                }
                            }
                            else if("Salary".equals(tokens[5])||"salary".equals(tokens[5]))
                            {
                                if("=".equals(tokens[6]))
                                {
                                   if("maximum".equals(tokens[7]))
                                   {
                                        AggregateMax();
                                   }
                                   if("minimum".equals(tokens[7]))
                                   {
                                        AggregateMin();
                                   }
                                   if("Average".equals(tokens[7]))
                                   {
                                        AggregateAverage();
                                   }
                                }
                                else
                                {
                                    System.out.println("Invalid Query");
                                }
                            }
                            else if("City".equals(tokens[5]) ||"city".equals(tokens[5]))
                            {
                                if("=".equals(tokens[6]))
                                {
                                    DisplaySpecificByCity(tokens[7]);
                                }
                                else
                                {
                                    System.out.println("Invalid Query");
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Invalid Query");
                        }
                    }
                    else
                    {
                        System.out.println("ERROR: Please Enter * After  select");
                    }
                }
            }

            else if(QuerySize == 7)
            {
                if("Delete".equals(tokens[0]) ||"delete".equals(tokens[0]))
                {
                    if("from".equals(tokens[1]))
                    {
                        if("student".equals(tokens[2]))
                        {
                            if("Where".equals(tokens[3])||"where".equals(tokens[3]))
                            {
                                if("RID".equals(tokens[4])||"rid".equals(tokens[4]))
                                {   
                                    if("=".equals(tokens[5]))
                                    {       
                                        DeleteSpecific(Integer.parseInt(tokens[6]));
                                        System.out.println(" Record Successfully Deleted.....");
                                    }
                                    else
                                    {
                                        System.out.println("Invalid Query");
                                    }
                                }
                                else if("name".equals(tokens[4])||"Name".equals(tokens[4]))
                                {   
                                    if("=".equals(tokens[5]))
                                    {   
                                        DeleteSpecific(tokens[6]);
                                        System.out.println(" Record Successfully Deleted.....");
                                    }
                                    else
                                    {
                                        System.out.println("Invalid Query");
                                    }
                                }
                                else if("city".equals(tokens[4])||"City".equals(tokens[4]))
                                {   
                                    if("=".equals(tokens[5]))
                                    {   
                                        DeleteSpecificbyCity(tokens[6]);
                                        System.out.println(" Record Successfully Deleted.....");
                                    }
                                    else
                                    {
                                        System.out.println("Invalid Query...'=' expected at token number 5");
                                    }
                                }
                                else
                                {
                                    System.out.println("Invalid Query...'city' or 'City' expected at token number 4");   
                                }
                            }
                            else
                            {
                                System.out.println("Invalid Query...'where' expected at token number 3");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid Query");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid Query...'from' expected at token number 1");
                    }
                }
                else
                {
                    System.out.println("Invalid Query...'Delete' or 'delete' expected at token number 0");
                    
                }
            }
            else if( QuerySize==11)
            {
                if("update".equals(tokens[0]))
                {
                    if("into".equals(tokens[1]))
                    {
                        if("student".equals(tokens[2]))
                        {
                            if("set".equals(tokens[3]))
                            {
                                if("salary".equals(tokens[4]))
                                {
                                    if("=".equals(tokens[5]))
                                    {
                                        if("where".equals(tokens[7]))
                                        {
                                            if("RID".equals(tokens[8]) || "rid".equals(tokens[8]))
                                            {
                                                if("=".equals(tokens[9]))
                                                {
                                                    UpdateSalarybyRID(Integer.parseInt(tokens[10]), Integer.parseInt(tokens[6]));
                                                    System.out.println("Data Successfully updated.....");
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid Qurery.....Invalid RID or salary..");
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("Incorrect syntax at token number 8. Expecting 'rid' or 'RID'");
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Invalid Query...");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Incorrect syntax at token number 5. Expecting '=' ");
                                    }    
                                }
                                else if("name".equals(tokens[4])||"Name".equals(tokens[4]))
                                {
                                    if("=".equals(tokens[5]))
                                    {
                                        if("where".equals(tokens[7]))
                                        {
                                            if("RID".equals(tokens[8]) || "rid".equals(tokens[8]))
                                            {
                                                if("=".equals(tokens[9]))
                                                {
                                                    UpdateNameByRid(tokens[6],Integer.parseInt(tokens[10]));
                                                    System.out.println("Data Successfully updated.....");
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid Query..");
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("Incorrect syntax at token number 8. Expecting 'rid' or 'RID'");                 
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Invalid Query1...");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Invalid Query2...");
                                    }    
                                }
                                else if("City".equals(tokens[4])||"city".equals(tokens[4]))
                                {
                                    if("=".equals(tokens[5]))
                                    {
                                        if("where".equals(tokens[7]))
                                        {
                                            if("RID".equals(tokens[8]) || "rid".equals(tokens[8]))
                                            {
                                                if("=".equals(tokens[9]))
                                                {
                                                    UpdatCityeByRid(tokens[6],Integer.parseInt(tokens[10]));
                                                    System.out.println("Data Successfully updated.....");
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid Query..");
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("Incorrect syntax at token number 8. Expecting 'rid' or 'RID'");
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Invalid Query...");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Invalid Query...");
                                    }    
                                }
                                else
                                {
                                    System.out.println("Invalid Query...");
                                }
                            }
                            else
                            {
                                System.out.println("Invalid Query2...");
                            }  
                        }
                        else
                        {
                            System.out.println("Invalid Table name....'student' expected at token 2...");
                        }                       
                    }
                    else 
                    {
                        System.out.println("Invalid Query......'into' is expected at token number 1...");
                    }
                }
                else
                {
                    System.out.println("Invalid Query......'update' is expected at token number 0...");
                }
            }
            else 
            {
                System.out.println("Invalid Query .....");
            }
        }
    }


    /*
**************************************************************
// Function Name     :      InsertData
// Input             :      String, Integer,String
// Output            :      None
// Decription         :     Insert data into the table
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022   
**************************************************************
*/
    public void InsertData(String str, int value,String str2)
    {
        Student sobj = new Student(str,value,str2);
        lobj.add(sobj);
    }

    public void DisplayAll()
    {
        for(Student sref : lobj)
        {
           sref.DisplayData();
        }
    }

    
    /*
**************************************************************
// Function Name     :      DisplaySpecific
// Input             :      Integer
// Output            :      None
// Decription         :     Display Specific record by RID
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022  
**************************************************************
*/
    
    public void DisplaySpecific(int rid)
    {
        for(Student sref : lobj)
        {
            if(sref.RID==rid)
            {
                sref.DisplayData();
                break;
            }
        }
    }

    /*
**************************************************************
// Function Name     :      DisplaySpecific
// Input             :      String
// Output            :      None
// Decription         :     Display Specific record by Name 
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022  
**************************************************************
*/
    
    public void DisplaySpecific(String str)
    {
        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.DisplayData();
            }
        }
    }


/*
**************************************************************
// Function Name     :      DisplaySpecificByCity
// Input             :      String
// Output            :      None
// Decription         :     //Display Specific by City
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022   
**************************************************************
*/
    
    public void DisplaySpecificByCity(String str)
    {
        for(Student sref : lobj)
        {
            if(str.equals(sref.City))
            {
                sref.DisplayData();
            }
        }
    }
   
   /*
**************************************************************
// Function Name     :      DeleteSpecific
// Input             :      Integer
// Output            :      None
// Decription         :     Delete Specific record by RID     
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022   
**************************************************************
*/ 
    public void DeleteSpecific(int rid)
    {
        int index=0;
        for(Student sref : lobj)
        {
            if(sref.RID==rid)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

/*
**************************************************************
// Function Name     :      DeleyteSpecific
// Input             :      String
// Output            :      None
// Decription         :     Delete Specific record by Name
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022   
**************************************************************
*/    
    public void DeleteSpecific(String str)
    {
        int index=0;
           
        for(Student sref : lobj)
        {
           if(str.equals(sref.Name))
            {
                lobj.remove(index);
                break;
            }
            index++;
       }
    }

/*
**************************************************************
// Function Name     :      DeleteSpecificbyCit
// Input             :      String
// Output            :      None
// Decription        :     Delete Specific record by City
// Author            :     Kishan Vivek Jawale
// Date              :     27/7/2022   
**************************************************************
*/
      public void DeleteSpecificbyCity(String str)
      {
          int index=0;
             
          for(Student sref : lobj)
          {
             if(str.equals(sref.City))
              {
                  lobj.remove(index);
                  break;
              }
              index++;
         }
      }

      /*
**************************************************************
// Function Name     :      AggregateMax
// Input             :      None
// Output            :      None
// Decription         :     Display the Maximum of salaries
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022   
**************************************************************
*/
    
    public void AggregateMax()
    {
        int iMax=0;
        Student temp= null;
        for(Student sref :lobj)
        {
            if(sref.Salary>iMax)
            {
                iMax=sref.Salary;
                temp=sref;
            }
        }
        System.out.println("Informatio of student having Maximum Salary:");
       temp.DisplayData(); 
    }

 /*
**************************************************************
// Function Name     :      AggregateMin
// Input             :      None
// Output            :      None
// Decription         :     Display the Minimum of salaries
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022   
**************************************************************
*/
   
    public void AggregateMin()
    {
        int iMin = (lobj.getFirst()).Salary;
        Student temp=lobj.getFirst();
        for(Student sref :lobj)
        {
            if(sref.Salary < iMin)
            {
                iMin=sref.Salary;
                temp=sref;
            }
        }
        System.out.println("Informartion of student having Minimum Salary:");
        temp.DisplayData(); 
    }

    /*
**************************************************************
// Function Name      :     AggregateAverage
// Input              :     None
// Output             :     None
// Decription         :     Display the Average of salaries
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022   
**************************************************************
*/
    
    public void AggregateAverage()
    {
        int iSum=0;
        for(Student sref: lobj)
        {
            iSum=iSum+sref.Salary;
        }
        System.out.println("------------------------------------");
        System.out.println("Average of Salary  is:"+ iSum/lobj.size());
        System.out.println("------------------------------------");   
    }


/*
**************************************************************
// Function Name     :      AggreagateSum
// Input             :      None
// Output            :      None
// Decription         :     Display the Sum Of Salaries
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022   
**************************************************************
*/
    
    public void AggregateSum()
    {
        int iSum=0;
        for(Student sref: lobj)
        {
            iSum=iSum+sref.Salary;
        }
        System.out.println("------------------------------------");
        System.out.println("Summation of Salary  is:"+ iSum);
        System.out.println("------------------------------------");
    }   

/*
**************************************************************
// Function Name     :      UpdateSalarybyRID
// Input             :      Integer,Integer
// Output            :      None
// Decription         :     Update the Salary of given RID
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022   
**************************************************************
*/
    
    public void UpdateSalarybyRID(int Rid,int Salary)
    {
        int Index=0;
        for(Student sref:lobj)
        {
            sref.Salary=Salary;
            break;
        }
        Index++;
    }
    
/*
**************************************************************
// Function Name     :      UpdateNameByRid
// Input             :      String ,Integer
// Output            :      None
// Decription         :     Update the student name of given RID
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022   
**************************************************************
*/

    public void UpdateNameByRid(String name,int Rid)
    { int Index=0;
        for(Student sref:lobj)
        {
            sref.Name=name;
            break;
        }
        Index++;
    }

    /*
**************************************************************
// Function Name     :      UpdateCityByRid
// Input             :      String,Integer
// Output            :      None
// Decription         :     Update the City name of given RID
// Author             :     Kishan Vivek Jawale
// Date               :     27/7/2022   
**************************************************************
*/
    
    public void UpdatCityeByRid(String cityname,int Rid)
    { int Index=0;
        for(Student sref:lobj)
        {
            sref.City=cityname;
            break;
        }
        Index++;
    }
}

class CDatabase
{
    public static void main(String arg[])
    {
        DBMS dobj = new DBMS();
        dobj.StartDBMS();             
    }
}