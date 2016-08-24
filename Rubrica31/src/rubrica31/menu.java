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
 public class menu {
    public BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    ListaCircular lista=new ListaCircular();
    
     public void Menu()throws IOException{
       System.out.println("\n\n\t\t\t=========Menú Lista  doblemente enlazada circular =============");
       System.out.println("\t\t\t=                                             =");
       System.out.println("\t\t\t= 1- Insertar Dato a la lista                 =");
       System.out.println("\t\t\t= 2- Eliminar Dato a la lista                 =");
       System.out.println("\t\t\t= 3- Recorrido datos de la lista                =");
       System.out.println("\t\t\t= 4- Visualizar datos de la Lista             =");
       System.out.println("\t\t\t= 5- Buscar                                   =");
       System.out.println("\t\t\t= 6- Salir                                    =");
       System.out.println("\t\t\t================================              =");
       System.out.print("\t\t\tOpción: ");
       int op1 = Integer.parseInt(entrada.readLine());
       
           Opciones(op1);
    }
       
      public void Opciones(int op1)throws IOException{
         
        switch(op1){
           
			case 1: lista.Insertar();
                                Menu();
			        break;
			case 2: lista.Eliminar();
                                Menu();
			        break;
			case 3: lista.Recorrido();
                                Menu();
			        break;
			case 4: lista.Visualizar();
                                Menu();
			        break;
                        case 5: lista.Buscar();
                                Menu();
                                break;
                        case 6: System.exit(1);
			        break;
			default:Menu();
			        break;
                            
	}
    }
      
      
}

    

