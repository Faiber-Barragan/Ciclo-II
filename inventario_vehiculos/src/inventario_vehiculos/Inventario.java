
package inventario_vehiculos;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    private ArrayList<Vehiculo> vehiculos;
    
    public Inventario(Vehiculo carro){
        vehiculos = new ArrayList<>();
        vehiculos.add(carro);
    }
    
    public void agregarVehiculo(Vehiculo carro){
        vehiculos.add(carro);
    }
    
    public void listarVehiculo(){
        System.out.println("***Inventario de vehículos***");
        for(Vehiculo carro : vehiculos){
            System.out.println(carro.toString());
        }
    }
    
    public void procesarComandos(){
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        Vehiculo carro;
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
                        carro = new Comercial(velocidad, pasajeros, placa, tipo, pesoMaximo);    
                        
                    }
                    else{
                        String color = comando[5];
                        carro = new Particular(velocidad, pasajeros, placa, tipo, color);
                    }
                    agregarVehiculo(carro);
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
        Vehiculo carro =  new Particular(80, 4, "FFF 444", "Particular", "Blanco");
        Inventario inventario = new Inventario(carro);
        inventario.procesarComandos();
    }
 
}
