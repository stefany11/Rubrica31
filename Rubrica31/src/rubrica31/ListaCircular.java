/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubrica31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
/**
 *
 * @author Stefany
 */
public class ListaCircular {
    public BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));







    class CNodo {
	int dato;
	CNodo siguiente;
	CNodo anterior;

	public CNodo(){
            anterior = null;
            siguiente = null;
	}
    }

    
        CNodo cabeza;
        CNodo actual;
	public ListaCircular(){
            cabeza = null;
            actual = null;
	}
        

        

    public void Insertar()throws IOException{
        
        int dat;
        String sigue = "S";
        do{
            
            
        System.out.println("ingrese dato en la lista");
        dat = Integer.parseInt(entrada.readLine());

        CNodo NuevoNodo;  
        CNodo ant=null,sig=null;   
	NuevoNodo = new CNodo();
	NuevoNodo.dato=dat;
        int ban=0;
        if (Vacia()){
            NuevoNodo.siguiente=NuevoNodo; 
            NuevoNodo.anterior=NuevoNodo; 
            cabeza= NuevoNodo; 
            actual= NuevoNodo; 
        }else {
            if (dat<cabeza.dato){
                ant=cabeza.anterior;
                NuevoNodo.anterior=ant; 
                NuevoNodo.siguiente=cabeza;
                cabeza.anterior=NuevoNodo;
                ant.siguiente=NuevoNodo;
                cabeza = NuevoNodo;
                actual = NuevoNodo;
            }else {
                ant=actual;
                sig=actual;
                while (ban==0) {
                    if (dat>=sig.dato) {
                        ant=sig;
                        sig=sig.siguiente;
                        if(sig==cabeza) {
                            ban=1;
                        }                  
                    }else {
                        if (dat<sig.dato){
                            sig=ant;
                            ant=ant.anterior;
                            if(ant==cabeza) {
                                ban=1;
                            }
                        }
                    }
                    if ((dat<sig.dato)&&(ant.dato<=dat)){
                        ban=1;
                    }    
                }
                ant.siguiente=NuevoNodo;
                NuevoNodo.anterior=ant;
                NuevoNodo.siguiente=sig;
                sig.anterior=NuevoNodo;
                actual=NuevoNodo;
                
            }
            
        }
        System.out.println("\nDesea continuar S/N: ");
            sigue=entrada.readLine();
        }while (sigue.equals("S"));
    }

    public void Eliminar()throws IOException {
         int dat;
         String sigue = "S";
        do{
       System.out.println("ingrese dato a eliminar");
       dat = Integer.parseInt(entrada.readLine());
        CNodo ant=null,sig=null;
        int ban=0;
        if (Vacia()) {
            System.out.print(" \n Lista vacia");
        }else {
            if (dat<cabeza.dato){
                System.out.print(" \n El dato no existe ");}
            else if (dat==cabeza.dato){
                if(cabeza.siguiente!=cabeza){
                    ant=cabeza.anterior;
                    cabeza=cabeza.siguiente;
                    ant.siguiente=cabeza;
                    cabeza.anterior=ant;
                    actual=cabeza;
                    System.out.println("El dato eliminado es: " +dat);
                }else {
                    cabeza=null;
                    actual=null;
                    
                }
            }else {
                ant=actual;
                sig=actual;
            while (ban==0) {
                if ((ant.dato<dat)&&(dat<sig.dato))  {
                    ban=1;
                    
                }else {
                    if (dat>sig.dato) {
                        ant=sig;
                        sig=sig.siguiente;
                             if (sig==cabeza) { ban=1;}
                             
                          
                    }else 
                              if(dat<sig.dato){
                                  sig=ant;
                                  ant=ant.anterior;
                                    if(ant==cabeza) { ban=1;}
                                    
                                 }                                         
                                       if ((sig.dato==dat)||(ant.dato==dat)) {ban=1;}
                                       
                               }
                          }
                           if(dat==sig.dato) {
                             ant=sig.anterior;
                             ant.siguiente=sig.siguiente;
                             sig=sig.siguiente;
                             sig.anterior=ant;
                             actual=sig;
                             System.out.println("El dato eliminado es: " +dat);
                             
                      }
                     else  if(dat==ant.dato)  {
                        ant=ant.anterior;
                        ant.siguiente=sig;
                        sig.anterior=ant;
                        actual=sig;
                        System.out.println("El dato eliminado es: " +dat);
                        }
                else  System.out.print("\nEl dato no existe ");
                    }
                                      }
              System.out.println("Desea continuar S/N: ");
            sigue=entrada.readLine();
        }while (sigue.equals("S"));
        
    }
public void Buscar()  throws IOException  {
             
            int ban=0,dat;
            CNodo Nodo;
            Nodo=actual;
            System.out.print("Que dato desea buscar: ");
            dat=Integer.parseInt(entrada.readLine());
            if(!Vacia())
            {
                 
                do {
                System.out.print(" "+Nodo.dato+" ");
                            Nodo = Nodo.siguiente;  
                            Nodo = Nodo.anterior;
                            if(Nodo.dato==dat)
                    {
                        ban=1;
                    }
                    
                    Nodo=Nodo.anterior;
                } 
                  while(Nodo!=actual);
                 {
                    
                    
                }
                if(ban==1)
                     System.out.println("\nEl dato "+dat+" se encuentra en la Lista");    
                else
                    System.out.println("\nEl dato "+dat+" no se encuentra en la Lista"); 
                
            }
            
                else System.out.println("\nEl dato no se encuentra porque la lista esta vacìa");
            
        }   
   
 
      public boolean Vacia()
        {    return(cabeza==null);
        }

    public  void Recorrido() throws IOException{
       CNodo Nodo;
       String sigue = "S";
        do{
            System.out.println("Recorrido");
                Nodo=cabeza;
                if (!Vacia()) {
                do
                {	System.out.print(" " + Nodo.dato+" ");
                        Nodo = Nodo.siguiente;
                }while (Nodo!=cabeza);
                }
                else {System.out.println("");
                      System.out.print("\n La Lista se encuentra vacía");
                }
                 System.out.println("\n Desea continuar S/N: ");
            sigue=entrada.readLine();
        }while (sigue.equals("S"));
    }

    public void Visualizar() throws IOException {
        CNodo Nodo;
                Nodo=cabeza;
                String sigue = "S";
                do{
            System.out.print("\nDesea ver su lista : ");
                if (!Vacia()) {
                    System.out.println("\nLa lista contiene los siguientes datos: ");
                    do
                    {	System.out.print(" " + Nodo.dato +" ");
                            Nodo = Nodo.siguiente;
                    }while (Nodo!=cabeza);
                    }else System.out.print("\nLa lista se encuentra vacía");
                 System.out.println("\nDesea continuar S/N: ");
            sigue=entrada.readLine();
        }while (sigue.equals("S"));
                        
        }
    
     
    
    public  static void main(String[] args)throws IOException {
         menu m=new menu();
        m.Menu();
    
    
}
}