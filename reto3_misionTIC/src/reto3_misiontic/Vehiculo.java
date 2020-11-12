package reto3_misiontic;

public class Vehiculo {
    private int velocidad;
    private int pasajeros;
    private String placa;
    private String tipo;
    
    public Vehiculo(int velocidad, int pasajeros, String placa, String tipo){
        this.velocidad = velocidad;
        this.pasajeros = pasajeros;
        this.placa = placa;
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return  "\tVehículo " + tipo + " - " + "Placa: " + placa + "\n" +
                "\tvelocidad: " + velocidad + " km/h" + "\n" +
                "\tpasajeros: " + pasajeros;
    }

}
