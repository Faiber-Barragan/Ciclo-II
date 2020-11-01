
package inventario_vehiculos;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    private static ArrayList<Vehiculo> vehiculos;
    
    public Inventario(){
        vehiculos = new ArrayList<>();
    }
    
    public static void agregarVehiculo(Vehiculo carro){
        vehiculos.add(carro);
    }
    
    public static void listarVehiculo(){
        System.out.println("***Inventario de vehículos***");
        for(Vehiculo carro : vehiculos){
            System.out.println(carro.toString());
        }
    }
    
    public static void procesarComandos(){
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        String comando[] = new String[6];
        
        do{
            comando = sc.nextLine().split("&");
            switch(comando[0]){
                case "1":
                    int velocidad = Integer.parseInt(comando[3]);
                    int pasajeros = Integer.parseInt(comando[2]);
                    String placa = comando[4];
                    String tipo = comando[1];

                    if(tipo.equals("Comercial")){
                        int pesoMaximo = Integer.parseInt(comando[5]);
                        Comercial comercial = new Comercial(velocidad, pasajeros, placa, tipo, pesoMaximo);
                        Vehiculo.getInventario().agregarVehiculo(comercial);
                    }

                    if(tipo.equals("Particular")){
                        String color = comando[5];
                        Particular particular = new Particular(velocidad, pasajeros, placa, tipo, color);
                        Vehiculo.getInventario().agregarVehiculo(particular);
                    }
                    break;
                case "2":
                    listarVehiculo();
                    break;
                case "3":
                    salir = true;
            }
        }while(salir == false);
        
    }
    
    
    public static void main(String[] args) {
        procesarComandos();
    }
 
}
