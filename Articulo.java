package reto_carrito_unal;

import java.util.ArrayList;

public class Articulo {
    private String cliente;
    private ArrayList<String> productos;
    private int totalNeto;
    private float descuento;

    public Articulo(){
        productos = new ArrayList<String>();
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public void agregarProducto(String[] comando){
        String nombreArt = comando[1];
        String cant = comando[2];
        int total = Integer.parseInt(comando[2])*Integer.parseInt(comando[3]);
        productos.add(nombreArt+" x"+cant+" $"+total);
        totalNeto += total;
    }
    
    public void descuento(){
        if(totalNeto <= 150000){
            descuento = 0;
        }else if(totalNeto <= 300000){
            descuento = totalNeto * 0.10f;
        }else if(totalNeto <= 700000){
            descuento = totalNeto*0.15f;
        }else{
            descuento = totalNeto*0.20f;
        }
    }
    
    public void imprimir(){
        descuento();
        System.out.println("Centro Comercial Unaleño");
        System.out.println("Compra más y Gasta Menos");
        System.out.println("NIT: 899.999.063");
        System.out.println("Cliente: " + cliente);
        System.out.println("Art Cant Precio");
        for(String producto : productos){
            System.out.println(producto);
        }
        System.out.println("Total: $" + ((totalNeto)-(int)(descuento)));
        System.out.println("En esta compra tu descuento fue $" + (int)descuento);
        System.out.println("Gracias por tu compra");
        System.out.println("---");
    }
}
