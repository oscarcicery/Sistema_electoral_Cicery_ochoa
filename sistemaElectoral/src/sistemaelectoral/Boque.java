/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaelectoral;

/**
 *
 * @author green
 */
public class Boque {

    private int number=0;
    private int voto;
    private String signature;
    
    private Boque next;

    
    public Boque(int voto){
        this.voto=voto;
        signature=getHash(voto, number, "null");
    }
    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the voto
     */
    public int getVoto() {
        return voto;
    }

    /**
     * @param voto the voto to set
     */
    public void setVoto(int voto) {
        this.voto = voto;
    }

    /**
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature the signature to set
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * @return the next
     */
    public Boque getNext() {
        return next;
    }

    public void addVoto(int voto){
        if(this.next==null){
            this.next=new Boque(voto);
            this.next.number=number+1;
            this.next.signature=getHash(voto, number+1, signature);
        }else{
            this.next.addVoto(voto);
        }
    }
    private String getHash(int voto, int number, String FirmaPrev){
        return FirmaPrev+"-"+voto+"-"+number;
    }
            
            
    
}
