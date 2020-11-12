
package reto3_misiontic;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {
    private ArrayList<Vehiculo> vehiculos;
    
    public Inventario(){
        vehiculos = new ArrayList<>();
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

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    private static int iva(int cantParticular, int cantComercial){
        int carrosTotal = cantParticular+cantComercial;
        double totalPagar = ((cantParticular*30000000)+(cantComercial*40000000));
        double IVA=0;
        switch(carrosTotal){
            case 1:
                IVA = totalPagar*0.20;
                break;
            case 2:
                IVA = totalPagar*0.19;
                break;
            case 3:
                IVA = totalPagar*0.18;
                break;
            case 4:
                IVA = totalPagar*0.17;
                break;
            case 5:
                IVA = totalPagar*0.16;
                break;
            case 6:
                IVA = totalPagar*0.15;
                break;
            case 7:
                IVA = totalPagar*0.14;
                break;
            case 8:
                IVA = totalPagar*0.13;
                break;
            case 9:
                IVA = totalPagar*0.12;
                break;
            case 10:
                IVA = totalPagar*0.11;
                break;
            case 11:
                IVA = totalPagar*0.10;
                break;
            case 12:
                IVA = totalPagar*0.09;
                break;
            case 13:
                IVA = totalPagar*0.08;
                break;
            case 14:
                IVA = totalPagar*0.07;
                break;
            case 15:
                IVA = totalPagar*0.06;
                break;
            case 16:
                IVA = totalPagar*0.05;
                break;
            case 17:
                IVA = totalPagar*0.04;
                break;
            case 18:
                IVA = totalPagar*0.03;
                break;
            case 19:
                IVA = totalPagar*0.02;
                break;
            case 20:
                IVA = totalPagar*0.01;
                break;
        }
        
        return (int)IVA;
    }
    
    public static void comprar(int cantParticular, int cantComercial, String cedula){
        System.out.println("CONCESIONARIO UNCAR");
        System.out.println("UNCAR - UNIVA");
        System.out.println("NIT: 899.999.063");
        System.out.println("Cliente: "+cedula);
        System.out.println("Vehículo Cant Precio");
        System.out.println("Particular x"+cantParticular+"$30000000");
        System.out.println("Comercial x"+cantComercial+"$40000000");
        int iva = iva(cantParticular, cantComercial);
        System.out.println("Iva: $"+iva);
        System.out.println("Total:  $"+(((cantParticular*30000000)+(cantComercial*40000000))+iva));
    }
    
    public static void procesarComandos(){
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        Inventario inventarioParticular = new Inventario();
        Inventario inventarioComercial = new Inventario();
        for(int i=0; i<100;i++){
            inventarioParticular.agregarVehiculo(new Particular(180, 4, "FEE 000", "Particular", "Rojo"));
            inventarioComercial.agregarVehiculo(new Particular(80, 2, "FEE 222", "Comercial", "250"));
        }
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
                        inventarioComercial.agregarVehiculo(carro); 
                    }
                    else{
                        String color = comando[5];
                        carro = new Particular(velocidad, pasajeros, placa, tipo, color);
                        inventarioParticular.agregarVehiculo(carro); 
                    }
                    
                    
                    break;
                case "2":
                    inventarioParticular.listarVehiculo();
                    inventarioComercial.listarVehiculo();
                    break;
                case "3":
                    int cantParticular = Integer.parseInt(comando[2]);
                    int cantComercial = Integer.parseInt(comando[4]);
                    String cedula = comando[5];
                    if(inventarioParticular.getVehiculos().size() >= cantParticular && inventarioComercial.getVehiculos().size() >= cantComercial){
                        for(int i=0; i<cantParticular; i++){
                            inventarioParticular.getVehiculos().remove(i);
                        }
                        for(int i=0; i<cantComercial; i++){
                            inventarioComercial.getVehiculos().remove(i);
                        }
                        comprar(cantParticular, cantComercial, cedula);
                    }else{
                        System.out.println("Lo sentimos no tenemos stock suficiente");
                        System.out.println("---");
                    }
                    
                    break;
                case "4":
                    System.out.println("Particular: "+inventarioParticular.getVehiculos().size());
                    System.out.println("Comercial: "+inventarioComercial.getVehiculos().size());
                    break;
                case "5":
                    salir = true;
                    break;
            }
        }while(salir == false);
   
    }
    
    public static void main(String[] args) {
        procesarComandos();
    }
}

