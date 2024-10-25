/*1.Panithan Kunsuntrontham 6513133 
  2. Thunyaphat Permsup 6513167 
  3.Mattana Olarikded 6513173 
  4.Suphanai chalood 6513176 */
package Project1_6513133;


class Contain {
     private String path;
     private int status;
     private boolean visit=false;
     private int x,y;
     public Contain(String s,int st,int x,int y){
         this.path=s;
         this.status=st;
         this.x=x;
         this.y=y;
     }
     @Override
     public String toString(){
         
         String Text = String.format("%s",this.path);
         return Text;
     }
     public int get_status(){
         return this.status;
     }
     public void set_String_Status(String s,int st){
          this.path=s;
          this.status=st;
     }
     public int get_x(){
         return this.x;
     }
     public int get_y(){
         return this.y;
     }
     public String get_coordinate(){
         return String.format("[%d,%d]",this.x,this.y);
     }
     public boolean get_visit(){
         return this.visit;
     }
     public void set_visit(boolean v){
         this.visit = v;
     }
}
