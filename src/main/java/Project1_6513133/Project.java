/*1.Panithan Kunsuntrontham 6513133 
  2. Thunyaphat Permsup 6513167 
  3.Mattana Olarikded 6513173 
  4.Suphanai chalood 6513176 */
package Project1_6513133;

import java.util.Scanner;

public class Project {
    private Input cal;
    private final String path     = "src/main/java/Project1_6513133/";
    private String fileName = "maize_0.txt";
    private MAIZE maize;
    private Scanner Kscan,Kscan2,Kscan3;
    private String select,select2,select3;
    private int input=0;
    private boolean no_sol = false;
    public static void main(String Args[]){
        Project proj = new Project();
        do{
        proj.Init();
        }while(!proj.get_select2().equalsIgnoreCase("n"));
         
    }
    public void Init(){
         this.Kscan = new Scanner(System.in);
         cal = new Input(path,fileName,this);
         maize = new MAIZE();
         //cal.Newtry(maze);
         cal.Newtry(this.maize.get_maze(),this.maize);
         do{ 
                if(!this.no_sol&&this.maize.get_num_food()>0){
                this.maize.print();
                this.select();
             }
             if(this.maize.get_num_food()==0||no_sol){
             break;
             }
          
      }while(true);
       do{  
         try{
         this.restart();
         }catch(Exception e){ System.out.println(e); }
          }while(!(this.select2.equalsIgnoreCase("n")||this.select2.equalsIgnoreCase("y")));
    }
     
   
    public void select(){
        System.out.printf("Remain Food = %d , Input = %d ",this.maize.get_num_food(),this.input);
        System.out.printf("\nSELECT:\n");
        System.out.printf("(C) Check Rat's Coordinate\n");
        System.out.printf("(L) LEFT\n");
        System.out.printf("(R) RIGHT\n");
        System.out.printf("(U) UP\n");
        System.out.printf("(D) DOWN\n");
        System.out.printf("(A) Auto\n");
       try{
        this.input();
       }catch(Exception e){
       }
        this.input++;
    }
    
    public void input() throws Exception{
        this.select= this.Kscan.next();
        try{
        switch (this.select.toLowerCase()){
            case"l":
               this.maize.Left();
               break;
               case"r":
               this.maize.Right();
               break;
               case"u":
               this.maize.UP();
               break;
               case"d":
               this.maize.DOWN();
               break;
            case"c":
                this.maize.Coordinate();
                break;
                case"a": 
                    int i=1;
                    while(this.maize.get_num_food()>0){
                      
                        System.out.printf(" ++ Finding Food %d ++ \n",i);
                        this.maize.print();
                         if(this.maize.auto(this.maize.Get_rat_row(), this.maize.Get_rat_col(),"Start")){
                    this.print_auto();
                    Contain R = (Contain)this.maize.get_maze().get(this.maize.Get_rat_row()).get(this.maize.Get_rat_col());
                    Contain F = (Contain)this.maize.get_maze().get(this.maize.Get_food_row()).get(this.maize.Get_food_col());
                    this.maize.is_food(F);
                    this.maize.Change_Coordinate(F, R);
                    this.maize.get_auto_path().clear();
                    this.maize.get_current_path().clear();
                    this.maize.reset_visited();
                }else{
                    System.out.printf("No Solution!\n");
                    this.no_sol=true;
                    break;
                } 
                     i++;    
                 }
                 break;
            default:
                throw new Exception("Invaild Input");     
        }
        }catch(Exception e){
                System.out.println(e);
          }
                
                
    }
    public void restart() throws Exception{
         this.Kscan2 = new Scanner(System.in);
        
        System.out.printf("\nRESTART?:\n");
        System.out.printf("(Y) YES\n");
        System.out.printf("(N) NO\n");
         this.select2= this.Kscan2.next();
         switch(select2.toLowerCase()){
              
             case"y":
                 do{
                try{
        System.out.printf("Another Maize?:\n");
        System.out.printf("(Y) YES\n");
        System.out.printf("(N) NO\n");
        this.Kscan3 = new Scanner(System.in);
                 this.select3= this.Kscan3.next();
                 switch(this.select3.toLowerCase()){
                  
                         case"y":
                  this.input=0;
                  this.no_sol=false;
                  System.out.println("Enter new Filename -->");
                   this.fileName = Kscan2.next();
                         break;
                         case"n":
                       this.input=0;
                  this.no_sol=false;
                         break;
                         default:
                             throw new Exception("Invaild Input");
                 }
                 }catch(Exception e){
                         
                         }
                 }while(!(this.select3.equalsIgnoreCase("n")||this.select3.equalsIgnoreCase("y")));
                
             break;
             case"n":
             break;
             default:
                 throw new Exception("Invaild input");
         }
       
        
    }
   public String get_select2(){
       return this.select2;
       
    }
   public void print_auto(){
          for(String S : this.maize.get_auto_path()){
              System.out.printf("%s\n",S);
          } 
   }
   public void set_filename(String s){
          this.fileName =s;  
   } 
    
}
