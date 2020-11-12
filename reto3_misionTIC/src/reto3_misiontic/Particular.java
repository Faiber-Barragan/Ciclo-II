package reto3_misiontic;

public class Particular extends Vehiculo {
    private String color;
    
    public Particular(int velocidad, int pasajeros, String placa, String tipo, String color){
        super(velocidad, pasajeros, placa, tipo);
        this.color = color;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n \tcolor: " + color;
    }
}