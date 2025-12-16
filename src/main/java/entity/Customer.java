/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 *
 * @author Gokhan
 */
public class Customer 
{
    private int ID;
    private String firstName;
    private String lastName;
    
    public Customer(int ID, String firstName, String lastName)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Customer(int ID, String firstName)
    {
        this.ID = ID;
        this.firstName = firstName;
    }

    public Customer() {
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Customer{" + "ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


