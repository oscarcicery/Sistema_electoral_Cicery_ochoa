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
public class Main {
     public static void main(String[] args) {
        /*SistemaElectoral s = new SistemaElectoral();
        s.menu();
        */
        Boque b=new Boque(0);
        b.addVoto(1);
        b.addVoto(2);
        b.addVoto(0);
        b.addVoto(1);
        b.addVoto(3);
        b.addVoto(2);
         System.out.println("");
    }
}
