import java.lang.*;
import java.util.*;

//create table student(RID int, Name varchar(255), Salary int)
//Database table : schema
class Student
{
    public int RID;
    public String Name;
    public int Salary;

    private static int Generator;
    static
    {
        Generator = 0;
    }

    public Student(String str, int value)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
    }

    public void DisplayData()
    {
        System.out.println(this.RID + "\t" + this.Name + "\t" +this.Salary);
    }
}

class DBMS
{
    public LinkedList<Student> lobj;

    DBMS()
    {
        lobj = new LinkedList<>();
    }

    public void StartDBMS()
    {
        Scanner scanobj = new Scanner(System.in);

        System.out.println("Marvellous Customized DBMS started successfully!");
        String query = "";

        while(true)
        {
            System.out.print("Marvellous DBMS console >");
            query = scanobj.nextLine();

            String tokens[] = query.toLowerCase().split(" ");

            int querySize = tokens.length;

            if(querySize == 1)
            {
                if("help".equals(tokens[0]))
                {
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("This application is used to demonstrates the customized DBMS");
                    System.out.println("Description : Terminate customized DBMS console");
                    System.out.println("Command : Exit");
                    System.out.println();
                    System.out.println("Description : Display all students data");
                    System.out.println("Query : select * from student");
                    System.out.println();
                    System.out.println("Description : Insert student data");
                    System.out.println("Query : insert into student name salary");
                    System.out.println();
                    System.out.println("Description : Display student data from rid");
                    System.out.println("Query : select * from student where rid = enter_rid");
                    System.out.println();
                    System.out.println("Description : Display student names and salaries from rid");
                    System.out.println("Query : select name salary from student where rid = enter_rid");
                    System.out.println();
                    System.out.println("Description : Display student data from name");
                    System.out.println("Query : select * from student where name = enter_name");
                    System.out.println();
                    System.out.println("Description : Display student data from salary");
                    System.out.println("Query : select * from student where salary = enter_salary");
                    System.out.println();
                    System.out.println("Description : Display all student names");
                    System.out.println("Query : select name from student");
                    System.out.println();
                    System.out.println("Description : Display all student salaries");
                    System.out.println("Query : select salary from student");
                    System.out.println();
                    System.out.println("Description : Display all student rids");
                    System.out.println("Query : select rid from student");
                    System.out.println();
                    System.out.println("Description : Display all student names and salaries");
                    System.out.println("Query : select name salary from student");
                    System.out.println();
                    System.out.println("Description : Delete student data from name");
                    System.out.println("Query : delete from student where name = enter_name");
                    System.out.println();
                    System.out.println("Description : Delete student data from salary");
                    System.out.println("Query : delete from student where salary = enter_salary");
                    System.out.println();
                    System.out.println("Description : Delete student data from name and salary");
                    System.out.println("Query : delete from student where name = enter_name and salary = enter_salary");
                    System.out.println();
                    System.out.println("Description : Aggregate function - MAX");
                    System.out.println("Query : select max salary from student");
                    System.out.println();
                    System.out.println("Description : Aggregate function - MIN");
                    System.out.println("Query : select min salary from student");
                    System.out.println();
                    System.out.println("Description : Aggregate function - AVG");
                    System.out.println("Query : select avg salary from student");
                    System.out.println();
                    System.out.println("Description : Aggregate function - SUM");
                    System.out.println("Query : select sum salary from student");
                    System.out.println();
                    System.out.println("Description : Aggregate function - COUNT");
                    System.out.println("Query : select count salary from student");
                    System.out.println();
                    System.out.println("Description : Update student name from rid");
                    System.out.println("Query : update student set name = enter_new_name where rid = enter_rid");
                    System.out.println();
                    System.out.println("Description : Update student salary from rid");
                    System.out.println("Query : update student set salary = enter_new_salary where rid = enter_rid");
                    System.out.println("-------------------------------------------------------------------");
                }
                else if("exit".equals(tokens[0]))
                {
                    System.out.println("Thank you for using Marvellous Customized DBMS");
                    break;
                }
                else
                {
                    System.out.println("Invalid Query");
                }
            }
            else if(querySize == 4)
            {
                if("select".equals(tokens[0]))
                {
                    if("*".equals(tokens[1]))
                    {
                        DisplayAll();
                    } 
                    else if("name".equals(tokens[1]))
                    {
                        DisplayNames();
                    }
                    else if("rid".equals(tokens[1]))
                    {
                        DisplayRids();
                    }
                    else if("salary".equals(tokens[1]))
                    {
                        DisplaySalaries();
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
            else if(querySize == 5)
            {
                if("insert".equals(tokens[0]))
                {
                    InsertData(tokens[3],Integer.parseInt(tokens[4]));
                    System.out.println("Record inserted successfully!");
                }
                else if("select".equals(tokens[0]))
                {
                    if("max".equals(tokens[1]))
                    {
                        AggregateMax();
                    }
                    else if("min".equals(tokens[1]))
                    {
                        AggregateMin();
                    }
                    else if("avg".equals(tokens[1]))
                    {
                        AggregateAvg();
                    }
                    else if("sum".equals(tokens[1]))
                    {
                        AggregateSum();
                    }
                    else if("count".equals(tokens[1]))
                    {
                        AggregateCount();
                    }
                    else if(("name".equals(tokens[1])) && ("salary".equals(tokens[2])))
                    {
                        DisplayNameSalary();
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
            else if(querySize == 7)
            {
                if("rid".equals(tokens[4]))
                {
                    DeleteSpecific(Integer.parseInt(tokens[6]));
                    System.out.println("Record deleted successfully!");
                }
                else if("name".equals(tokens[4]))
                {
                    DeleteSpecific(tokens[6]);
                    System.out.println("Record deleted successfully!");
                }
                else if("salary".equals(tokens[4]))
                {
                    DeleteBySalary(Integer.parseInt(tokens[6]));
                    System.out.println("Record deleted successfully!");
                }
                else
                {
                    System.out.println("Invalid Query");
                }
            }
            else if(querySize == 8)
            {
                if("rid".equals(tokens[5]))
                {
                    DisplaySpecific(Integer.parseInt(tokens[7]));
                }
                else if("name".equals(tokens[5]))
                {
                    DisplaySpecific(tokens[7]);
                }
                else if("salary".equals(tokens[5]))
                {
                    DisplaySalaries(Integer.parseInt(tokens[7]));
                }
                else
                {
                    System.out.println("Invalid Query");
                }
            }
            else if(querySize == 9)
            {
                if("rid".equals(tokens[6]))
                {
                    DisplaySpecificNameSalary(Integer.parseInt(tokens[8]));
                }
                else
                {
                    System.out.println("Invalid Query");
                }
            }
            else if(querySize == 10)
            {
                if("update".equals(tokens[0]))
                {
                    if("name".equals(tokens[3]))
                    {
                        UpdateSpecific(Integer.parseInt(tokens[9]),tokens[5]);
                        System.out.println("Record updated successfully!");
                    }
                    else if("salary".equals(tokens[3]))
                    {
                        UpdateSpecific(Integer.parseInt(tokens[9]),Integer.parseInt(tokens[5]));
                        System.out.println("Record updated successfully!");
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
            else if(querySize == 11)
            {
                if("delete".equals(tokens[0]))
                {
                    if(("name".equals(tokens[4])) && ("salary".equals(tokens[8])))
                    {
                        DeleteSpecific(tokens[6],Integer.parseInt(tokens[10]));
                        System.out.println("Record deleted successfully!");
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
    }
    //Insert student data
    public void InsertData(String str,int value)
    {
        Student sobj = new Student(str,value);
        lobj.add(sobj);
    }

    //Display all students data
    public void DisplayAll()
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("RID\tNAME\tSALARY");
            System.out.println("-------------------------------------------------------------------");
            for(Student sref : lobj)
            {
                sref.DisplayData();
            }
            System.out.println("-------------------------------------------------------------------");
        }
    
    //Display student data by RID
    public void DisplaySpecific(int rid)
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("RID\tNAME\tSALARY");
        System.out.println("-------------------------------------------------------------------");
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.DisplayData();
                break;
            }
        }
        System.out.println("-------------------------------------------------------------------");
    }

     //Display name and salary from RID
    public void DisplaySpecificNameSalary(int rid)
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("NAME\tSALARY");
        System.out.println("-------------------------------------------------------------------");
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                System.out.println(sref.Name+"\t"+sref.Salary);
                break;
            }
        }
        System.out.println("-------------------------------------------------------------------");
    }

   //Display student data by name
    public void DisplaySpecific(String name)
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("RID\tNAME\tSALARY");
        System.out.println("-------------------------------------------------------------------");
        for(Student sobj : lobj)
        {
            if(name.equals(sobj.Name))
            {
                sobj.DisplayData();
            }
        }
        System.out.println("-------------------------------------------------------------------");
    }

    //Display student data by salary
    public void DisplaySalaries(int salary)
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("RID\tNAME\tSALARY");
        System.out.println("-------------------------------------------------------------------");
        for(Student sobj : lobj)
        {
            if(salary == sobj.Salary)
            {
                sobj.DisplayData();
            }
        }
        System.out.println("-------------------------------------------------------------------");
    }

    //Display only names of students
    public void DisplayNames()
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("NAME");
        System.out.println("-------------------------------------------------------------------");
        for(Student sobj : lobj)
        {
            System.out.println(sobj.Name);
        } 
        System.out.println("-------------------------------------------------------------------");
    }

    //Display only rid of students
    public void DisplayRids()
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("RID");
        System.out.println("-------------------------------------------------------------------");
        for(Student sobj : lobj)
        {
            System.out.println(sobj.RID);
        } 
        System.out.println("-------------------------------------------------------------------");  
    }

    //Display only salaries of students
    public void DisplaySalaries()
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("SALARY");
        System.out.println("-------------------------------------------------------------------");
        for(Student sobj : lobj)
        {
            System.out.println(sobj.Salary);
        }
        System.out.println("-------------------------------------------------------------------");
    }
    
    //Display names and salaries  of students
    public void DisplayNameSalary()
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("NAME\tSALARY");
        System.out.println("-------------------------------------------------------------------");
        for(Student sobj : lobj)
        {
            System.out.println(sobj.Name+"\t"+sobj.Salary);
        }
        System.out.println("-------------------------------------------------------------------");
    }

   //Delete data by RID
    public void DeleteSpecific(int rid)
    {
        int index = 0;
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    //Delete data  by name
    public void DeleteSpecific(String str)
    {
        int index = 0;
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

    //Delete data by Salary
    public void DeleteBySalary(int salary)
    {
        int index = 0;
        for(Student sref : lobj)
        {
            if(salary == sref.Salary)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    //Delete data by name and salary
    public void DeleteSpecific(String name, int salary)
    {
        int index = 0;
        for(Student sref : lobj)
        {
            if((name.equals(sref.Name)) && (salary == sref.Salary))
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }
    //Update student name by rid
    public void UpdateSpecific(int rid, String str)
    {
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.Name = str;
            }
        }
    }

    //Update student salary by rid
    public void UpdateSpecific(int rid, int salary)
    {
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.Salary = salary;
            }
        }
    }
    //Maximum salary from all salaries
    public void AggregateMax()
    {
        int iMax = 0;
        Student temp = null;

        for(Student sref : lobj)
        {
            if(sref.Salary > iMax)
            {
                iMax = sref.Salary;
                temp = sref;
            }
        }
        System.out.println("Information of student with the maximum salary is :");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("RID\tNAME\tSALARY");
        System.out.println("-------------------------------------------------------------------");
        temp.DisplayData();
        System.out.println("-------------------------------------------------------------------");
    }

    //Minimum salary from all salaries
    public void AggregateMin()
    {
        int iMin = (lobj.getFirst()).Salary;
        Student temp = lobj.getFirst();

        for(Student sref : lobj)
        {
            if(sref.Salary < iMin)
            {
                iMin = sref.Salary;
                temp = sref;
            }
        }
        System.out.println("Information of student with the minimum salary is :");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("RID\tNAME\tSALARY");
        System.out.println("-------------------------------------------------------------------");
        temp.DisplayData();
        System.out.println("-------------------------------------------------------------------");
    }

    //Sum of all salaries
    public void AggregateSum()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("sum");
        System.out.println("-------------------------------------------------------------------");
        System.out.println(iSum);
        System.out.println("-------------------------------------------------------------------");
    }

    //Average of all salaries
    public void AggregateAvg()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("average");
        System.out.println("-------------------------------------------------------------------");
        System.out.println(iSum/ (lobj.size()));
        System.out.println("-------------------------------------------------------------------");
    }

    //Count the number of records
    public void AggregateCount()
    {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("count");
        System.out.println("-------------------------------------------------------------------");
        System.out.println(lobj.size());
        System.out.println("-------------------------------------------------------------------");       
    }
}

class CDBMS
{
    public static void main(String args[])
    {
       DBMS dobj = new DBMS();
       dobj.StartDBMS();
    }
}