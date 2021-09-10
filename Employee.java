/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author ulyss
 */
public class Employee extends Person
{
    
    private String employee_nb;
    
    
    Employee(String nom,String prenom,String email,String password,String employee_nb)
    {
        super(nom,prenom,email,password);
        this.employee_nb = employee_nb;
  
    }    
    
    public String getEmployeeNb()
    {
        return employee_nb;
    }
}
