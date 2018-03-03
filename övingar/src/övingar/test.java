package övingar;

import java.io.*;

public class test{
   public static void main(String args[]){
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.substring(9,11) );

      System.out.print("Return Value :" );
      System.out.println(Str.substring(10, 15) );
   }
}