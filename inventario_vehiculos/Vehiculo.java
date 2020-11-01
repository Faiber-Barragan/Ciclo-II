
package inventario_vehiculos;

public class Vehiculo {
    private int velocidad;
    private int pasajeros;
    private String placa;
    private String tipo;
    private static Inventario inventario = new Inventario();
    
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

    public static Inventario getInventario() {
        return inventario;
    }
}
