/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contact;

/**
 *
 * @author Kamilė
 */
public class ContactFactory implements AbstractFactory<Contact>{
    @Override
    public Contact create(Contact object) {
        return new Contact(object);
    }
}
