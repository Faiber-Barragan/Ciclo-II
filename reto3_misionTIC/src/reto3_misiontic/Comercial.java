
package reto3_misiontic;

public class Comercial extends Vehiculo {
    private int cargaMaxima;
    
    public Comercial(int velocidad, int pasajeros, String placa, String tipo, int cargaMaxima){
        super(velocidad, pasajeros, placa, tipo);
        this.cargaMaxima = cargaMaxima;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n \tCarga máxima: " + cargaMaxima +"kg";
    }
}
