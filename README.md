<h1 align="center">
  Conversor de Moneda
</h1>

![CambioMoneda](https://github.com/JhonDVelez/Conversor-Moneda-AluraChallenge/assets/159730509/e1268452-d345-45e2-abee-42612d71b334)

## Introducción 

Este proyecto consiste en un conversor de moneda implementado en consola con Java y el uso de la API ExchangeRate, en él se pueden
realizar conversiones de dólares a otras monedas y viceversa.

![image](https://github.com/JhonDVelez/Conversor-Moneda-AluraChallenge/assets/159730509/6d1a806f-e03f-44ef-85bc-cb05b19120b4)

Por el momento solo se cuenta los dos tipos de conversiones que se observan en la imagen, aunque se tiene soporte para varias monedas.

## Como se usa 

Una vez se ejecuta el programa el la clase [Principal](src/conversorMoneda/principal/Principal.java), en consola se observa un menú que ofrece múltiples opciones de conversiones, 
una vez decida que cambio desea realizar, observe el numero que se encuentra a la izquierda de su elección y 
digítelo en la consola.

A continuación, ingrese la cantidad de dinero que desea convertir.

Ejemplo:

![image](https://github.com/JhonDVelez/Conversor-Moneda-AluraChallenge/assets/159730509/f26b9f61-7ae2-41f2-b692-0c4b07d8f2ec)

En el ejemplo se observa la elección de convertir $ 25,00 Dólares a Pesos Colombianos, a la izquierda del resultado se muestra 
la hora local en la que se realizó la conversión, a continuación se muestra la conversión realizada y su resultado, 
adicionalmente se tiene la tasa de conversión que el valor por el que se multiplica el valor de entrada para obtener 
el resultado.

Luego de realizar la conversion, se muestra el mensaje "Presione Enter para continuar..." que permitira pausar la ejecucion
del programa para observar el resultado de la operacion. Una vez se presione Enter se mostrara nuevamente el menu de seleccion.

Tenga en cuenta que la ultima seleccion siempre es Salida que permite finalizar la ejecucion del conversor. Cuando se elige 
esta ultima opcion, se mostrará el historial de conversiones que realizo durante la ejecucion.

![image](https://github.com/JhonDVelez/Conversor-Moneda-AluraChallenge/assets/159730509/23a1233c-3f6f-4d19-baed-d245fc4741e7)

## Como agregar mas monedas 

Para esto se debe dirigir a la clase [Menu](src/conversorMoneda/modelos/Menu.java), en esta se implementan dos Arraylist, 
nombreMoneda y codigoMoneda, el primero es el encargado de almacenar los nombres de las monedas para mostrar en el menu, 
el segundo permiter realizar las peticiones a la API y tambien se muestra en los resultados de conversion.

Para concocer estos dos datos puede ir a la documentacion de la API donde se indican las monedas soportadas, 
[Supported Currencies](https://www.exchangerate-api.com/docs/supported-currencies).

Es importante que sea cuidadoso al añadir nuevas monedas, esto para evitar posibles errores, tanto de ejecucion como de 
muestra y obtencion de datos. 
- Debe agregar tanto el nombre de la moneda como su codigo como se muestra a continuación, estos deben estar en la misma
posicion dentro de los arrays.

![image](https://github.com/JhonDVelez/Conversor-Moneda-AluraChallenge/assets/159730509/827606b1-7bae-43e0-a4b6-009a4346b571)

## Referencias

- [ExchangeRate API](https://www.exchangerate-api.com/)
- [HttpRequest Java](https://docs.oracle.com/en/java/javase/22/docs/api/java.net.http/java/net/http/HttpRequest.html)
- [Postman API tests](https://www.postman.com/)
- [Gson](https://central.sonatype.com/artifact/com.google.code.gson/gson/2.11.0)
