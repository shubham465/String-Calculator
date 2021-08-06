import java.util.*;
import java.io.*;

class UserDefinedException extends Exception{
public UserDefinedException(String s){
    super(s);
}
}

class Calculator {

    int  Add(String numbers){
        if(numbers.contains("//"))
        {
          String s[]=   numbers.split("\n");
          String delimiter = s[0].substring(2);

            String num[]= s[1].split(delimiter);
            long su=0;

            for(String a:num )
            su+= Long.parseLong(a);

             System.out.println(su);

            return 0;

        }
       String n[]=  numbers.split("[,\n]");
  

        long sum=0,flag=0;
        for(String a:n)
        {
            if(Long.parseLong(a) >0)
            {     sum+= Long.parseLong(a);  
            }
            else
            {
             try{   flag=1;
                 throw new UserDefinedException("negatives not allowed" +" - "+ a); 
             }
             catch(UserDefinedException e){
                        System.out.println(e);
             }
                 
            }
        }
            if(flag==0)
        System.out.println(sum);

        return 0;
    }

    public static void main(String[] arg){
     Calculator c=new Calculator();

     c.Add("1,2");
      c.Add("24454534357,12432696");
     c.Add("1\n2,3");
   
     //  input format :  "//[delimiter]\n[numbers...]"
     //first line is optional i.e. before \n
      c.Add("//;\n1;100");

     // throw exception for negative if multiple show excp messege for all of them
       c.Add("-1,-1,-1000");
       
        
    }

    
}