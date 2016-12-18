/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
class user {
       private int id_employee;
    private String name_employee;
    private int phone_no;
    private String date_of_birth;
    private String job;
    private int salary;
     
    public user(int id_employee,String name_employee,int phone_no ,String date_of_birth,String job,int salary)
    {
      this.id_employee=id_employee;
      this.name_employee=name_employee;
      this.phone_no=phone_no;
      this.date_of_birth=date_of_birth;
       this.job=job;
        this.salary=salary;
    }
    
     public int geteid()
     {
         return id_employee;
     }
      public int getSalary()
     {
         return salary;
     }
       public String getname()
     {
         return name_employee;
     }
        public String getDOB()
     {
         return date_of_birth;
     }
            public String getJob()
     {
         return job;
     }
                public int getphone()
     {
         return phone_no;
     }
    
}
