/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaelectoral;

import java.util.Scanner;

/**
 *
 * @author
 */
public class SistemaElectoral {

    private Nodo votacion;
    private int[] candidatos;
    private Scanner lectura;

    //contructor, se inicializan las variables
    public SistemaElectoral() {
        lectura = new Scanner(System.in);
        votacion = null;
        candidatos = new int[4];
        for (int i = 0; i < candidatos.length; i++) {
            candidatos[i] = 0;
        }
    }

    //menu inicial 
    public void menu() {
        boolean salir = false;
        System.out.println("                 Sistema Electoral");
        while (salir == false) {
            System.out.println("            Seleccione el Candidato    ");
            System.out.println("__________________________");
            System.out.println("1 Para el Candidato 1");
            System.out.println("2 Para el Candidato 2");
            System.out.println("3 Para el Candidato 3");
            System.out.println("4 Para el Candidato 4");
            System.out.println("5. Finalizar");
             System.out.println("__________________________");
        
            int var = lectura.nextInt();
            switch (var) {
                case 1:
                    Votar(0);
                    break;
                case 2:
                    Votar(1);
                    break;
                case 3:
                    Votar(2);
                    break;
                case 4:
                    Votar(3);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println(" opcion incorrecta intente nuevamente");
                    break;
            }
           
        }
        resultados();
        ordenar();
    }

    //registro de voto 
    public void Votar(int candidato) {
        System.out.println("digite su cedula");
        int cc = lectura.nextInt();
        lectura.nextLine();
        System.out.println("Digite su Apellido");
        String apellido = lectura.nextLine();

        if (buscar(cc) == false) {//se valida que la persona no haya votado 
            Persona p = new Persona(cc, apellido);
            agregarLista(p);
            candidatos[candidato] ++; //se cuenta el voto 
            System.out.println("voto registrado");
        } else {
            System.out.println(" votante ya ingresado, voto NO registrado");
        }
    }

    //se crea un nuevo registro de la persona que voto 
    public void agregarLista(Persona p) {
        Nodo a = this.votacion;
        if (a == null) {// si a la lista enlazada no se an metido datos
            this.votacion = new Nodo(p);
        } else {
            while (a.siguiente != null) { //se recorre la lista para llegar al ultumo dato
                a = a.siguiente;
            }
            Nodo n = new Nodo(p);
            a.siguiente = n;  //se agrega un nuevo nodo a la lista 
        }
    }

    //se busca los datos cc y apellido en la lista para saber si la persona ya votó
    public boolean buscar(int cc) {
        Nodo a = this.votacion;
        boolean res = false;

        while (a != null) { //se recorre la lista 
            if (cc == a.getPersona().getCc()) {
                res = true;
                break;
            }
           
            a = a.siguiente;
        }
        return res;
    }

    //se cuentan votos para saber que candidato gano o si hay empate
    public void resultados() {
        int ganador = 0, cant = 0;
        String res="";
        System.out.println("\n\n      RESULTADO DE VOTACION");
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println(" Candidato" + (i + 1) + " :" + candidatos[i]);
            if (cant < candidatos[i]) {
                ganador = i;
                cant=candidatos[i];
            }
        }
        res="\n\nGANADOR CANDIDATO " + (ganador + 1);
        //validar empate
        for (int i = 0; i < candidatos.length; i++) {
            if(cant==candidatos[i] && i!=ganador){
                res="Empate ";
            }
        }
        System.out.println(""+res);

    }

    //se imprime la lista de votantes 
    public void imprimirLista() {
        Nodo a = this.votacion;
        System.out.printf("%-20s%-20s\n", "Cedula", "Apellido");
        System.out.println("------------------------------------------------");

        while (a != null) {
            System.out.printf("%-20s%-20s\n", a.getPersona().getCc(), a.getPersona().getApellido());
            a = a.siguiente;
        }
    }

    //menu ordenar 
    public void ordenar() {
        imprimirLista();
        boolean error = true;
        while (error == true) {
            System.out.println("     ordenar datos por");
            System.out.println("1. cedula");
            System.out.println("2. apellido");
            int var = lectura.nextInt();
            if (var == 1) {
                this.votacion = ordenarCc(this.votacion);
                error = false;
            } else if (var == 2) {
                this.votacion = ordenarAp(this.votacion);
                error = false;
            }
        }
        imprimirLista();
    }

    //ordenar lista enlazada por cedula 
    public Nodo ordenarCc(Nodo a1) {
        Nodo aux1, aux2;
        aux2 = a1;
        while (aux2 != null) {
            aux1 = aux2.siguiente;
            while (aux1 != null) {
                if (aux1.getPersona().getCc() < aux2.getPersona().getCc()) { 
                    Persona aux = aux2.getPersona();
                    aux2.setPersona(aux1.getPersona());
                    aux1.setPersona(aux);

                }
                aux1 = aux1.siguiente;
            }
            aux2 = aux2.siguiente;
        }
        return a1;
    }

    //ordenar lista enlazada por Apellido 
    public Nodo ordenarAp(Nodo a1) {
        Nodo aux1, aux2;
        aux2 = a1;
        while (aux2 != null) {
            aux1 = aux2.siguiente;
            while (aux1 != null) {
                if (aux1.getPersona().getApellido().compareTo(aux2.getPersona().getApellido()) < 0) {
                    Persona aux = aux2.getPersona();
                    aux2.setPersona(aux1.getPersona());
                    aux1.setPersona(aux);
                }
                aux1 = aux1.siguiente;
            }
            aux2 = aux2.siguiente;
        }
        return a1;
    }

}
