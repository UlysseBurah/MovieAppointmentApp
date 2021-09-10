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
public class User extends Person
{
    
    private String discount;
    
    User(String nom,String prenom,String email,String password,String discount)
    {
        super(nom,prenom,email,password);
        this.discount = discount;
        
        
    }    
    
    public String getDiscount()
    {
        return discount;
    }
}
