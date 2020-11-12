# MisionTIC UNAL Ciclo-II

Ejericicos de práctica del ciclo II en misión TIC UNAL


El Concesionario UNCar está interesado en su aplicación del inventario y le solicita el demo de la aplicación de tienda de autos con el modulo de Facturación. Las características del modelo se mantienen pero ahora debe tener en cuenta lo siguiente:

Procesar Comandos

En la clase Inventario, se debe definir la función procesarComandos() que realiza las siguientes operaciones:

Agregar vehículo: Opción 1

Se puede añadir un vehículo de tipo comercial con el siguiente comando: 
1&Comercial&numeroPasajeros&velocidadMaxima&placa&peso_maximo

Ejemplo:

1&Comercial&2&150&FFF 222&250

 Se puede añadir un vehículo de tipo particular con el siguiente comando:
1&Particular&numeroPasajeros&velocidadMaxima&placa&color

Ejemplo:

1&Particular&8&160&EEE 111&Verde

Listar ítems del inventario: Opción 2

Se debe mostrar la frase: “***Inventario de vehículos***” Seguida por los vehículos en el orden en el que fueron agregados.

Si se trata de un vehículo particular se mostrará así. Recuerde que \t implica correr el ítem unos espacios a la derecha:

\tVehiculo Particular - Placa: FFE 000
\tvelocidad: 180 km/h
\tpasajeros: 4
\tcolor: Rojo

 Si se trata de un vehículo comercial se mostrará así:

\tVehiculo Comercial - Placa: FFF 222
\tvelocidad: 150 km/h
\tpasajeros: 2
\tCarga máxima: 250kg

Facturar: Opción 3

El formato de tirilla es similar a los retos del ciclo I.

En este caso se hará con cálculo de IVA y se debe generar la misma tirilla. Dada la cantidad total de vehículos se reduce el porcentaje de impuesto a pagar con la campaña titulada "UNCAR UNIVA"

Por la compra de 1 carro se paga 20% de IVA.
Por la compra de 2 carros se paga 19% de IVA.
Por la compra de 3 carros se paga 18% de IVA.
Por la compra de 4 carros se paga 17% de IVA.
Por la compra de 5 carros se paga 16% de IVA.
Por la compra de 6 carros se paga 15% de IVA.
Por la compra de 7 carros se paga 14% de IVA.
Por la compra de 8 carros se paga 13% de IVA.
Por la compra de 9 carros se paga 12% de IVA.
Por la compra de 10 carros se paga 11% de IVA.
Así sucesivamente hasta 20 carros paga 1% de IVA. 
Mas de 20 carros no pagan IVA
Para este ejemplo los vehículos comerciales tienen un precio de 40 millones y los vehículos particulares un precio de 30 millones.

La cantidad de vehículos que la empresa tiene en el stock son 100 particulares y 100 comerciales que se van restando de cada factura. 

Por ahora no se pueden agregar al inventario esa funcionalidad se implementará con la base de datos.

Se valida el stock disponible en cada compra y si no hay suficiente se informa que no lo hay. La validación se hace por cada entrada si no hay de Particular o no hay de Comercial no se puede realizar la factura.



Ejemplo: 

Salida: Tirillas de compra de acuerdo al procesamiento del comando 3


Nota 1: Como el Concesionario debe pagar el IVA al gobierno, el valor a cobrar en caso de tener centavos se debe aproximar a techo usando la función Math.ceil() de java y convirtiéndolo a Long.

Ejemplo: 

3&Particular&4&Comercial&21&80849599

Salida:

CONCESIONARIO UNCAR
UNCAR - UNIVA
NIT: 899.999.063
Cliente: 80849599
Vehículo Cant Precio
Particular x4 $30000000
Comercial x21 $40000000
Iva: $0
Total:  $960000000
---



Ejemplo: 

3&Particular&19&Comercial&1&1022734737

Salida:

CONCESIONARIO UNCAR
UNCAR - UNIVA
NIT: 899.999.063
Cliente: 1022734737
Vehículo Cant Precio
Particular x19 $30000000
Comercial x1 $40000000
Iva: $6100000
Total: $616100000
---

Ejemplo: 

3&Particular&190&Comercial&1&1022734737

3&Particular&3&Comercial&101&1022734737

3&Particular&101&Comercial&102&1022734737

En cualquiera de estos 3 casos la salida será:

Salida:
Lo sentimos no tenemos stock suficiente
---

Si se hacen varias compras y el nuevo stock no es suficiente la salida será

Salida:

Lo sentimos no tenemos stock suficiente
---

Inventario: Opción 4

Particular: 77
Comercial: 78

Terminar: Opción 5
Nota 2: En este ejercicio se requiere subir cuatro archivos. 

Uno correspondiente a la clase Vehículo llamado Vehiculo.java,
otro correspondiente al Vehículo particular llamado Particular.java
otro correspondiente al Vehículo comercial llamado Comercial.java
otro correspondiente al Inventario llamado Inventario.java (Aquí viene el main)
