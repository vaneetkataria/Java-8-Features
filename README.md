# Java-8-Features
Q1 : Objectives of Java 8 ?
Ans :1.  To simplify programming by reducing no of line of code with Lambda expressions . As with Lambda expressions less verbose code 
      can be written by reducing to write very obvious things in code which can be understood by compiler without writing . 
     2. To take the benfits of functional programming using lambda exporessions  . 
     3. To take the benefits of parallel processing i.e. all cpu cores . 

Q2: List feautures of java 8 ? 
Ans : Lambda expression , Functional interfaces , Predicates , Functions , Consumers , Producers , Default methods and static methods in interfaces , Mehtod and constructor references by :: operator , joda and stream api  . 

Q3: which language uses lambda expression very first and what others use it . ? 
Ans : LISP was the first . C, C++ , Ruby , scala ,.Net , python are using it already . Unfotunately java is recent and one 
      of the last . 
      
Q4: Benfefits of lambda ?
Ans :  1.  To enable functional programming in java . Code and behoviour can be sent as a method argument which was only possible 
           before by using anonimous inner classes only . Like ActivityOpeartionTemplate . 
       2.  Simplicity in wiring code very less line of code is required . Readable , Maintanable and consise code . 
       3.  To enable parllel processing also lambda is used . 
       4.  To use api very easily . 
       
Q5: What is a lambda expression ?
Ans : It is an anonymous function simple . Means a function not having modifiers not having any name and return type . 

Q6: Write a simplest lambda expression ? 
Ans : public void m1()
      {
      sop("vaneet");
      }
      Now as modifiers , name and return is not applicable . Hence ()->{sop("vaneet");} Hence this dows not have 
      any modifier , return and method name . 
 
Q7:  Write a lambda expression to take two int values and print some of two ? 
Ans :public void m1(int a , int b)
     {
     sop(a+b);
     }
     
     1. Now lambda is (int a , int b)-> {sop(a+b);} Hence here also modifier , return type and method name is not applicable . 
     2. Also can be written as (int a , int b) -> sop (a+b); . It contains only one line in lambda body hence curly braces are
     optional .
     3. (a, b) -> sop(a+b); More consise code .

Q8:  Write a lambda that return lenght of the string ? 
     public int m1(String s)
     {
     return s.lentgh();
     }
     Also further simplification : (String s) -> { return s.lenght();} 
     Also further simplification : (String s) -> return s.lenght(); [As body contains only one statement]
     Also further simplification : (s) -> return Objects.isNull(s)? 0 : s.lenght();
     Also further simplification : (s)->  s.length();
     Also further simplification :  s ->  s.length();
     
Q9:  What is type reference ? 
     If the compiler can guess types automatically based on the context that is called type refrence . 
     
Q10 .     
     

       
       
       
      

