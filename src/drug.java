/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class drug {
       private int Did;
    private String name;
    private int price;
    private String type;
     
    public drug(int did,String Name,int Price,String Type)
    {
      this.Did=did;
      this.name=Name;
      this.price=Price;
      this.type=Type;
    }


    
     public int getdid()
     {
         return Did;
     }
      public int getprice()
     {
         return price;
     }
       public String getname()
     {
         return name;
     }
        public String gettype()
     {
         return type;
     }
    
}
