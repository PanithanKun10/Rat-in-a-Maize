/*1.Panithan Kunsuntrontham 6513133 
  2. Thunyaphat Permsup 6513167 
  3.Mattana Olarikded 6513173 
  4.Suphanai chalood 6513176 */
package Project1_6513133;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

class Input {
    private String path  ;
    private String fname ;
    private Scanner scan;
    private Project P;
    private int id;
    
    public Input(String p,String n,Project proj){
        this.fname=n;
        this.path=p;
        this.P = proj;
        this.scan= new Scanner(System.in);
    }
   public void Newtry(ArrayList<ArrayList<Contain>> m,MAIZE a){
      boolean opensuc = false;
      int row=0;
      while(!opensuc){
          try{
            Scanner filescan = new Scanner(new File(path+fname));  
              opensuc = true;
              
            while(filescan.hasNext()){
                ReadFile(filescan.nextLine(),m,row,a);
                row++;
            }
              
          }catch(Exception e){
              System.out.println(e);
              System.out.println("Enter new Filename -->");
              fname = scan.next();
              this.P.set_filename(this.fname);
          }
          
        
      }

  }
   public void ReadFile(String line,ArrayList<ArrayList<Contain>> m,int row,MAIZE a)throws Exception{
       ArrayList<Contain> c = new ArrayList();
       String []col = line.split(",");

       for(int i=0; i<col.length; i++){
          
        try{
           String text = col[i].trim();
           switch(text.toUpperCase()){
               case"0":
                   id=0;
                  break;
               case"1":
                   id=1;
                  break; 
               case"R":
                   id=2;
                   break;
               case"F":
                   id=3;
                   a.add_num_food(1);
                   break; 
                   default:
                      
       }
         c.add(new Contain(text,id,i,row));
            
       }catch(Exception e){
              
       }
      
   }
       m.add(c);
   }
}
