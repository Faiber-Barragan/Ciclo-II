
package reto_carrito_unal;

import java.util.Scanner;

public class Carrito {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Articulo factura = new Articulo();
        String comando[] = new String[3];
        boolean salir = false;
        
        do{
            comando = sc.nextLine().split("&");
            switch(comando[0]){
                case "1":
                    factura.agregarProducto(comando);
                    break;
                case "2":
                    factura.setCliente(comando[1]);
                    factura.imprimir();
                    factura = new Articulo();
                    break;
                case "3":
                    salir = true;
                    break;
            }
        }while(salir == false);
        
    }
    
}
