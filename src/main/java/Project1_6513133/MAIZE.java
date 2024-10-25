/*1.Panithan Kunsuntrontham 6513133 
  2. Thunyaphat Permsup 6513167 
  3.Mattana Olarikded 6513173 
  4.Suphanai chalood 6513176 */
package Project1_6513133;

import java.util.ArrayList;

 class MAIZE {
    private ArrayList<ArrayList<Contain>>maze;
    private int num_food;
    private int Rat_row,Rat_Col,Food_Row,Food_Col;
    private ArrayList<String> auto_path,current_path;
    public MAIZE(){
         this.maze = new ArrayList();
         this.auto_path = new ArrayList();
         this.current_path = new ArrayList();
    }
    public ArrayList<ArrayList<Contain>> get_maze(){
        return this.maze;
    }
     public void print(){
        this.print_Col();
        System.out.printf("\n");
        int row=0;
        for (ArrayList<Contain> maze1 : this.maze) {
            System.out.printf("Row_%d ",row);
            for(Contain C: maze1){
                if(C.get_status()==2){Rat_Col= C.get_x(); Rat_row=C.get_y();}
                System.out.printf("%5s ",C.toString());
            }
            System.out.printf("\n");
            row++;
        }
       
    }
    public int get_num_food(){
        return this.num_food;
    }
    public void print_Col(){
        for(int i=0; i<this.maze.get(0).size(); i++){
            if(i==0){System.out.printf("Row/Col "); System.out.printf("Col_%d ",i);}
            else{System.out.printf("Col_%d ",i);}
        }
    }
    public void Coordinate(){
        System.out.printf("Rat's Coordinate is (%d,%d) \n",this.Rat_Col,this.Rat_row);  
    }
    
    public void Left(){
                     if(this.Rat_Col-1<0||this.maze.get(this.Rat_row).get(this.Rat_Col-1).get_status()==0){
                         System.out.printf("Cannot Move\n"+"=".repeat(24)+"\n");
                     }else if(this.maze.get(this.Rat_row).get(this.Rat_Col-1).get_status()==1
                             ||this.maze.get(this.Rat_row).get(this.Rat_Col-1).get_status()==3){
                         Contain P = (Contain)this.maze.get(this.Rat_row).get(this.Rat_Col); 
                         Contain C = (Contain)this.maze.get(this.Rat_row).get(this.Rat_Col-1);
                        this.is_food(C);
                         this.Change_Coordinate(C, P);
                     }
        }
    public void Right(){
        if(this.Rat_Col+1>this.maze.get(this.Rat_row).size()-1||this.maze.get(this.Rat_row).get(this.Rat_Col+1).get_status()==0){
                         System.out.printf("Cannot Move\n"+"=".repeat(24)+"\n");
                     }else if(this.maze.get(this.Rat_row).get(this.Rat_Col+1).get_status()==1||
                             this.maze.get(this.Rat_row).get(this.Rat_Col+1).get_status()==3){
                         Contain P = (Contain)this.maze.get(this.Rat_row).get(this.Rat_Col); 
                         Contain C = (Contain)this.maze.get(this.Rat_row).get(this.Rat_Col+1);
                       
                           this.is_food(C);
                         this.Change_Coordinate(C, P);
                     }
    }
     public void UP(){
      if(this.Rat_row-1<0||this.maze.get(this.Rat_row-1).get(this.Rat_Col).get_status()==0){
                         System.out.printf("Cannot Move\n"+"=".repeat(24)+"\n");
                     }else if(this.maze.get(this.Rat_row-1).get(this.Rat_Col).get_status()==1
                             ||this.maze.get(this.Rat_row-1).get(this.Rat_Col).get_status()==3){
                         Contain P = (Contain)this.maze.get(this.Rat_row).get(this.Rat_Col); 
                         Contain C = (Contain)this.maze.get(this.Rat_row-1).get(this.Rat_Col);
                           this.is_food(C);
                         this.Change_Coordinate(C, P);
                     }
    }
      public void DOWN(){
       if(this.Rat_row+1>this.maze.size()-1||this.maze.get(this.Rat_row+1).get(this.Rat_Col).get_status()==0){
                         System.out.printf("Cannot Move\n"+"=".repeat(24)+"\n");
                     }else if(this.maze.get(this.Rat_row+1).get(this.Rat_Col).get_status()==1
                             ||this.maze.get(this.Rat_row+1).get(this.Rat_Col).get_status()==3){
                         Contain P = (Contain)this.maze.get(this.Rat_row).get(this.Rat_Col); 
                         Contain C = (Contain)this.maze.get(this.Rat_row+1).get(this.Rat_Col);
                            this.is_food(C);
                         this.Change_Coordinate(C, P);
                     }
    }
   public void Change_Coordinate(Contain C, Contain P){
                         int status_temp = C .get_status();
                         int Pre_status_temp = P.get_status();
                         String path_temp = C.toString();
                         String Pre_path = P.toString();
                         
                         
                         C.set_String_Status(Pre_path , Pre_status_temp);
                         P.set_String_Status(path_temp, status_temp);
    }
   public boolean auto(int r,int c,String s){
       if(r < 0||c<0||r >= this.maze.size()|| c >= this.maze.get(r).size()|| this.maze.get(r).get(c).get_visit()||this.maze.get(r).get(c).get_status()==0){
           return false;
       }
       this.maze.get(r).get(c).set_visit(true);
       this.current_path.add(String.format("\n%-1s --> (row %d,col %d),path = %s \n",s,r,c, this.maze.get(r).get(c).toString()));
       
       if(this.maze.get(r).get(c).get_status()==3){
           this.auto_path.addAll(this.current_path);
           this.Food_Row=this.maze.get(r).get(c).get_y();
           this.Food_Col=this.maze.get(r).get(c).get_x();
          // System.out.printf("%d,%d\n",this.Get_food_col(),this.Get_food_row());
           return true;
       }
       if(auto(r - 1, c,"Up")) return true; // Up
       if (auto(r + 1, c,"Down")) return true; // Down
       if (auto(r, c - 1,"Left")) return true; // Left
       if (auto(r, c + 1,"Right")) return true; // Right
       
       // Backtrack: if none of the adjacent cells lead to food
        this.current_path.remove(this.current_path.size() - 1);
        return false;
       
   }
  
   public void is_food(Contain C){
       if(C.get_status()==3){
                             C.set_String_Status("1", 1);
                             System.out.println("+".repeat(5)+" Find Food "+"+".repeat(5)
                             +"\n");
                             this.num_food--;
                         }
   }
   public int Get_rat_row(){
       return this.Rat_row;
   }
   public int Get_rat_col(){
       return this.Rat_Col;
   }
   public ArrayList<String> get_auto_path(){
       return this.auto_path;
   }
   public ArrayList<String> get_current_path(){
       return this.current_path;
   }
     public int Get_food_row(){
       return this.Food_Row;
   }
   public int Get_food_col(){
       return this.Food_Col;
   }
   public void reset_visited(){
        for (ArrayList<Contain> maze1 : this.maze) {
            for(Contain C: maze1){
                if(C.get_visit()){
                    C.set_visit(false);
                }  
            }
        }
   }
   public void add_num_food(int i){
       this.num_food+=i;
   }
    
}
