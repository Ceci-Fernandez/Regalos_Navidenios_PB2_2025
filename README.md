# Segundo parcial de Programación Básica 2-UNLaM

# Regalos Navideños

Un importante personaje cuyo nombre prefiere permanecer en el anonimato nos pidió que modelemos un sistema que le permita definir los regalos para cada persona. Nuestro personaje siempre intenta que todas las personas estén contentas con su regalo. ¿Le gusta o no le gusta? Cada persona conoce el criterio de los regalos que le gustan.

Existen los siguientes criterios:

*   **Conformista:** cualquier regalo le gusta. Es el criterio por defecto de todas las personas.
*   **Interesado:** le gustan los regalos que cuesten más de una cierta cantidad mínima de plata.
*   **Marquero:** quieren que el regalo sea de una marca determinada. En el criterio se debe configurar la lista de marcas que le gustan (ej: "Nike", "Kodak" y "Apple").
*   **Anticuarios:** le gustan los regalos antiguos.
*   **Combinados:** combinan un conjunto de los anteriores criterios. Le gusta un regalo si le gusta a todos los criterios que combina.

## Regalos y Personas

Los regalos tienen definido un nombre, una marca, un valor y los años de antigüedad. Se define que un regalo es antiguo si tiene al menos 20 años de antigüedad. No se debe generar un regalo con valor o antigüedad negativa.

De las personas solo nos interesa conocer su DNI y el criterio de los regalos que le gustan. Cada persona puede cambiar el criterio de los regalos que le gustan cuando lo desee. Su DNI, en cambio, nunca se puede cambiar.

Por otro lado, también lleva el registro de los regalos que recibe El Regalón. El regalón es el personaje que nos encargó el sistema y quien tiene la bolsa con los regalos. Se permite agregar nuevos regalos a la bolsa siempre y cuando el nuevo regalo no genere un error.

Cuando el regalón ejecuta la acción de visitar a una persona ocurre lo siguiente:

*   Busca en la bolsa el primer regalo adecuado que encuentre para la persona.
*   En caso de que ningún regalo resulte adecuado, se debe generar un regalo con:
    *   nombre: "voucher"
    *   valor: $20000
    *   marca: "Papapp"
    *   antigüedad: 0
    Este voucher está disponible en la aplicación Papapp.
*   La persona recibe el regalo y actualiza el registro de los regalos recibidos.
*   Si el regalo era uno de la bolsa, obviamente deja de tenerlo.
*   Llevar un registro de entrega que contiene el regalo y la persona que lo recibió.

## Test Regalos y Personas

A una persona dada ¿le gusta o no le gusta unas Zapatillas Nike de $100000 nuevas?

Realizar al menos los test sobre los siguientes criterios:

### Conformista

*   `dadaUnaPersonaConCriteroConformista_leGustaCualquierRegalo`

### Interesado

*   `dadaUnaPersonaConCriteroInteresado_leGustaUnRegaloQueSuperaUnValorMinimo`

### Marquero

*   `dadaUnaPersonaConCriteroMarquero_leGustaUnRegaloDeUnaMarcaDeSuPreferencia`

### Combinado

*   `dadaUnaPersonaConCombinado_leGustaUnRegaloDeUnaMarcaDeSuPreferenciaYQueSuperaUnValorMinimo`

## Test Regalón

Generar los siguientes 3 regalos y agregarlos a la bolsa del regalón:

| Nombre    | Valor  | Marca     | Antigüedad |
| :-------- | :----- | :-------- | :--------- |
| zapatillas | 50000  | Adidas    | 0          |
| celular   | 650000 | Apple     | 0          |
| Juguete   | 35000  | PlayMovil | 5          |

Generar 2 personas con criterio Interesado:

| DNI | Criterio   | Parámetro Criterio |
| :-- | :--------- | :----------------- |
| 123 | Interesado | mínimo: 100000     |
| 456 | Interesado | mínimo: 900000     |

Realizar los siguientes Test:

*   **Test 1** - Para la Persona 1
    `dadaUnaPersonaConCriterioInteresadoDeMinimo10000_AlVisitarlaConRegalosQueSuperanElMinimo_SeLeEntregaUno`
*   **Test 2** - Para la Persona 2
    `dadaUnaPersonaConCriterioInteresadoDeMinimo900000_AlVisitarlaSinRegalosQueSuperanElMinimo_SeLeEntregaUnVoucher`

Para el Test 1 validar lo siguiente:

*   Que la cantidad de regalos recibidos de la persona sea 1.
*   Que en la lista de regalos recibidos de la persona se encuentre el celular.
*   Que la cantidad de regalos en la bolsa del regalón sea 2.
*   Que en la bolsa de regalos no esté el celular.

Para el Test 2 validar lo siguiente:

*   Que la cantidad de regalos recibidos de la persona sea 2.
*   Que la cantidad de regalos en la bolsa del regalón sea 3.

## Actividades esperadas

*   Diseño e implementación del sistema, cumpliendo los requisitos funcionales provistos en el enunciado.
*   Aplicar principios de diseño orientado a objetos: herencia, polimorfismo, composición, delegación, cohesión y bajo acoplamiento.
*   Utilizar TDD (Test-Driven Development) para validar la lógica del sistema con JUnit-4.
*   Se espera un proyecto Java tradicional, correctamente estructurado en carpetas, con uso adecuado de source folders, organización en paquetes, y aplicación correcta de las convenciones de nomenclatura: UpperCamelCase para clases e interfaces, y lowerCamelCase para variables y métodos.

## Condiciones de aprobación

*   **Diseño completo:** Implementa todas las partes del enunciado.
*   **Buen uso de OOP:** Se aplican correctamente herencia, polimorfismo y/o composición.
*   **Código probado:** Tests con JUnit cubriendo los casos centrales del sistema.
    *   Se espera un mínimo del 70% de cobertura.
*   **Código legible y organizado:** Nombres claros, métodos cortos y con responsabilidades claras, clases bien separadas por responsabilidad.




