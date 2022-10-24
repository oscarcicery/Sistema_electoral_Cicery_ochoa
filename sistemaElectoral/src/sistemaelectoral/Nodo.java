/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaelectoral;

/**
 *
 * @author
 */
public class Nodo {
    
    private Persona persona;
    Nodo siguiente;

    public Nodo(Persona persona) {
        this.persona = persona;
        this.siguiente=null;
    }
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
