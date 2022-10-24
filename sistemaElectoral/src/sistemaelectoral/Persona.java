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
public class Persona {
    
    private int cc;
    private String apellido;        

    public Persona(int cc, String apellido) {
        this.cc = cc;
        this.apellido = apellido;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
   
}
