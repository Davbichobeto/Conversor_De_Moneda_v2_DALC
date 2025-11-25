<h1> Conversor de moneda Back_End</h1>


Este proyecto esta hecho en Java y permite realizar las conversiones de diversas divisas tipo monedas haciendo uso de tasas de conversión actualizadas. 
El sistema toma la cantidad de la moneda de origen y la cambia a la elegida, haciendo uso de las tasas de conversión que provienen de una API externa.

// **Funcionamiento**

- Permitir la conversión entre divisas específicas: USD, ARS, BRL, COP, MXN y BOB.
- Llevar a cabo los cambios de divisa tomando como base las tasas actuales.
- Manejar fallos ante la entrada de valores erróneos o monedas no soportadas por el sistema.
- Disponer de un sistema de navegación por menús para seleccionar las monedas y completar las transacciones.

// Estructura dividida en:

// 1. **Modelos**

Esta tiene las clases de la API de conversión de moneda.

- `ApiResponse`: Clase que almacena la respuesta de la API de las tasas de conversión. 
- Esta incluye un `Map<String, Double>` llamado `conversion_rates`, con las tasas de conversión de las monedas.
  
// 2. **Servicios**

- `ConversionService`: Clase que realiza la conversión de las monedas. 
- Utiliza la información de tasas de cambio obtenidas desde la API para calcular el valor convertido. Esta clase maneja diferentes opciones para convertir entre monedas específicas, como USD a ARS, USD a BRL, etc.
  
- `ApiService`: Servicio encargado de hacer la solicitud a la API externa para obtener las tasas de conversión actuales. Esta clase maneja la comunicación con el API y devuelve los datos necesarios al `ConversionService`.

// 3. **Principal**

- Esta clase contiene la entrada de la aplicación y con ella la interacción del usuario. 
- PCon ella se selecciona la opción de conversión requerida y ejecuta el cálculo de la conversión con las tasas de cambio.

// **Funcionamiento:**

1. \\Entrada del Usuario\\: El usuario selecciona una opción de conversión.
2. \\Obtención de Tasas\\: El `ApiService` consulta la API externa y obtiene la tasa de cambio.
3. \\Cálculo de Conversión\\: El `ConversionService` adquiere la tasa de conversión desde la API y realiza el calculo del valor convertido según la cantidad digitada por el usuario.

//. **Resultado**: Este se imprime en la consola, mostrando la cantidad original y la convertida en la moneda destino.

// **Monedas Soportadas:**


1. USD a ARS
2. ARS a USD
3. USD a BRL
4. BRL a USD
5. USD a COP
6. COP a USD
7. USD a BOB
8. MXN a USD

// **Requerimientos:**

- Java 17 o superior.
- Entorno de desarrollo IntelliJ IDEA o Eclipse.
- Conexión a internet para la respuesta actulizada de las tasas de cambio.

## Uso

1. Clona este repositorio.
2. Abre el proyecto en IntelliJ IDEA o cualquier entorno de desarrollo que prefieras.
3. Configura el SDK de Java (JDK 17 o superior).
4. Ejecuta la clase `Principal` para iniciar la aplicación.

// **Manejo de Errores**

- Si ese introduce una opción no válida, el programa responderá con un mensaje de error y pedirá una nueva entrada.
- Si la API no puede proporcionar una tasa de conversión para una moneda específica, se mostrará un mensaje de error.






