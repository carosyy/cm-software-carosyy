# Aplicación de buenas prácticas y principios en Gilded-Rose-Refactoring

El siguiente ejercicio tiene como objetivo aplicar principios como DRY, SRP, KISS, bajo acoplamiento, etc. en un código legado.

### Malas prácticas identificadas en GildedRose.java

| Malas prácticas  | Descripción | Formas de solucionarlo |
| ------------- | ------------- | ------------- |
| `Clase con muchas responsabilidades` | Se maneja toda la lógica de actualización de la calidad en un solo método. Esto hace que el código viole el principio de Single Responsability de SOLID.  |  - Separar las responsabilidades. <br> - Utilizar polimorfismo, es decir, extraer la lógica y dividirla en una clase base y subclases dependiendo de cada ítem y tarea. |
| `Difícil de leer y mantener/Exceso de condicionales anidadas` | Se encuentran muchas condicionales anidadas lo cual hace el código repetitivo y, por extensión, dificulta la comprensión de la función de la clase y su futuro mantenimiento. Al contener muchos if, else, y switch se complica añadir o editar condiciones sin que se rompan otras. Esto hace que el código se convierta largo por la falta de separación y, al tener que modificar el mismo método para un nuevo ítem, se viola el principio de Open/Closed de SOLID y KISS. | - Cambiar las condiciones con el patrón de Strategy o bien aplicar polimorfismo. <br> - Evitar condiciones innecesarias en vez de usar clases simples. <br> - Como buena práctica para la documentación, se recomienda usar mapas o flujos para identificar el comportamiento adecuado de cada función. |
 | `Falta de modularidad, Baja cohesión, y Alto acoplamiento` | Toda la lógica de actualización de calidad se encuentra en un solo método. Esto hace que el código tenga baja cohesión, se dificulte la reutilización y se incremente el acoplamiento. | - Cambiar la clase para que cada una tenga una responsabilidad única y así incrementar el desacoplamiento. |
 | `Falta de abstracción` | La clase Item no tiene un comportamiento definido al solo servir para almacenar datos y generar dependencia de este ítem. Además, contiene atributos públicos lo que rompe el principio de encapsulamiento. | - Utilizar el encapsulamiento para que cada método tenga un comportamiento específico. |
  | `No se reutilizan componentes` | Al solo haber una clase que maneja toda la lógica del código, no se puede reutilizar la lógica para cada tipo de tarea e ítem.  | - Hacer distintos métodos o clases para reutilizar la lógica de la actualización de cada tipo de ítem. |
  | `Código duplicado` | Se encuentran muchas duplicaciones de código. Esto viola el principio de DRY y KISS. | - Extraer métodos auxiliares y reutilizables. <br> - Eliminar lógica repetida. |
  | `Falta de legibilidad/Nombres difíciles de entender` | Los nombres son poco descriptivos y pueden generar confusiones si hay variables con nombre similar o que tienen una función similar. | - Encapsular cada campo con su respectivo método. <br> - Dar nombres claros que expliquen el propósito del campo en el código. <br> - Evitar comentarios innecesarios y dejar que el código se explique por sí solo. |



### Malas prácticas identificadas en Item.java

| Malas prácticas  | Descripción | Formas de solucionarlo |
| ------------- | ------------- | ------------- |
| `Campos públicos/Baja cohesión y Falta de encapsulamiento` | Los campos son públicos lo cual permite que puedan ser manipulados por cualquier parte del código. No hay métodos getters y setters para controlar el acceso a los atributos.  |  -Añadir encapsulamiento. <br> - Añadir getters and setters. <br> - Cambiar los campos públicos para limitar su uso a solo las clases necesarias. |
| `Rompe el principio de Open/Closed de SOLID` | Para modificar el comportamiento de los ítems, se debe modificar la clase directamente, lo cual puede interferir con otras condiciones o atributos. | - Utilizar polimorfismo, es decir, extraer la lógica y dividirla en una clase base y subclases dependiendo de cada ítem y tarea. |
| `No hay modularidad y no hay reutilización` | No se reutiliza o se utiliza la herencia para ampliar la extensión de los ítems. | - Tener una clase por tipo de ítem donde cada clase solo tenga una función. <br> - Reutilizar la lógica existente si es necesario para evitar repeticiones. |
| `No hay validaciones` | Al no haber validaciones, se desconoce el valor exacto o rango aceptable de los atributos. Esto lo hace propenso a errores, lo cual puede generar que el código colapse en ejecución si se ingresa un valor no permitido. | - Incluir validaciones en el getter y setter de ser necesario para garantizar que los valores manipulados son válidos y van a ser procesados correctamente. |
| `Falta de legibilidad/Nombres difíciles de entender` | Los nombres son poco descriptivos y pueden generar confusión. | - Dar nombres claros que expliquen el propósito del campo en el código. |


## Cambios realizados

1. **Commit #1:** Documentos añadidos al repositorio
En este primer commit, se adjuntan los documentos a refactorizar, Item.java y GildedRose.java, para aplicarles buenas prácticas y principios para hacer el código más legible. 
---

2. **Commit #2:** Item - Editar variables
En el segundo commit, se comenzó a realizar cambios en las variables del Item.java. El código original contaba con atributos públicos, lo cual hace que estos puedan ser modificados por cualquier clase. Esto puede llevar a errores y generar dificultades al controlar el estado del objeto.

      **Código original:**
       ```
       public String name;
       public int sellIn;
       public int quality;
       ```
   
      Al cambiarlos a privados, estos solo pueden ser accedidos por los métodos públicos de los getters y setters. Además, esto protege los datos y permite controlar como estos se comportan en el código.
---

3. **Commit #3:** Item - Añadir getters and setters
En el tercer commit, se realizaron cambios respecto a la validaciones y métodos de acceso. El código original no contenia validaciones al asignar valores a los atributos. Esto puede llevar a que el usuario ingrese valores no permitidos, como negativos o vacíos, lo que hace al código propenso a errores. Además, este no cuenta con métodos de acceso (get and set), lo que hace que los atributos se modifiquen directamente.

    Al añadir métodos get y set se puede modificar los atributos de forma correcta al permitir que se pueden añadir validaciones adicionales, lo cual facilita el mantenimiento. Las validaciones del set and get permiten que los campos no sean nulos o vacios. Además, otras validaciones permiten determinar el rango permitido y en caso de ingresar un valor inválido se lanza una excepción.
---

   4. **Commit #4:** Item - Editar constructor y mensaje final
En el cuarto commit, se editan el constructor y el mensaje final de acuerdo a los cambios ejecutados previamente. En el constructor se cambian los nombres de las variables y se añaden los set para inicializar los objetos correctamente. De igual manera, en método final donde se devuelven los valores se añade una descripción más detallada y legible para una mejor presentación.

       **Código original:**
       ```
       public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
      }
       @Override
       public String toString() {
          return this.name + ", " + this.sellIn + ", " + this.quality;
      }
       ```
---

5. **Commit #5:** GildedRose - Añadir switch por nombre de item
En el quinto commit, se editó el encapsulamiento del arreglo `Item` y agregar un switch sobre los nombres de item. El código original, el arreglo Item era público, lo cual lo hace que se pueda modificar desde fuera de la clase, esto rompe el principio de encapsulamiento. Al cambiarlo de público a privado los datos internos de la clase se protegen.

      **Código original:**
       ```
       Item[] items;
       ```
   
     Además, se agregó un switch de acuerdo al nombre de item para delegar la lógica de cada tipo de item y luego pasarlos a su respectivo método privado. <br>
     **NOTA:** Se comentó toda la lógica de la clase en su momento para que en el siguiente commit se pudiera ir separando las responsabilidades identificadas en el código monolítico original.
---

6. **Commit #6:** GildedRose - Separar responsabilidades por tipo de actualización del item
En el sexto commit, se procedió a separar las responsabilidades o tareas por el tipo de actualización de item. Es decir, del código original que mostraba toda la lógica de actualización en un solo método, violaba el principio de responsabilidad única, entonces se segregó en tres métodos privados separados: `updateAgedBrie`, `updateBackstagePasses`, `updateNormalItem`. Al hacer estos cambios, se remueven todas las condicionales anidadas y el código duplicado para que la lógica se despliegue de forma clara y coherente.

      Beneficios de la segregación de responsabilidades:
      * Legibilidad y mantenibilidad: se reduce la complejidad del código en métodos, el código se puede leer y modificar fácilmente, y permite agregar nuevos tipos de items en el futuro.
      * Cada tipo de item cuenta con su propio método lo que hace que se cumpla el principio de SRP y OCP.
      * Al tener la lógica para cada tipo de ítem separada, se facilita la comprensión del comportamiento de los métodos, variables, y, sobre todo, del software. 
---

7. **Commit #7:** GildedRose - Separar responsabilidades de aumento y disminución
En el séptimo commit, al separar las responsabilidades extraídas del código original, se procedió a añadir métodos auxiliares (`lowerSellIn`, `increaseQuality`, `decreaseQuality`,  y `setItemQuality` ) para nuevamente evitar repeticiones de lógica, añadir validaciones, y fomentar la reutilización. En el código original, se encontraron multiples repeticiones de lógica lo cual obstaculizaba la mantenibilidad y legibilidad del código.
---

8. **Commit #8:** GildedRose y Item - Aplicar buenas prácticas y principios
En el octavo commit, se generaron todos los cambios necesarios en base al código extraído del código original. A continuación se detallan los cambios generados por documento:

      **GildedRose.java**
   * Se añadieron dos constantes con los valores 0 y 50 al ser valores que se notaron repetidamente en el código original. Al utilizar constantes estáticas se evitan errores y se facilita los cambios de los valores a futuro: `MAX_QUALITY` y `MIN_QUALITY`.
   * En el método de `updateAgedBrie`, se modificó el código extraído para que este fuera más legible: se añadió el método de `lowerSellIn` en conjunto a dos if con condiciones para llamar `getItemQuality` para comprobar si estaba dentro del `MAX_QUALITY` y `MIN_QUALITY` para luego incrementar su calidad `increaseQuality` si pasaban la validación.
   * En el método de `updateBackstagePasses`, se modificó el código extraído para que este fuera más legible: se añadió el método de `lowerSellIn` en conjunto a cuatro if con condiciones para llamar `getItemQuality` para comprobar si estaba dentro del `MAX_QUALITY` y `MIN_QUALITY` para luego incrementar su calidad `increaseQuality` o establecer la calidad `setItemQuality` si pasaban la validación.
   * En el método, `updateNormalItem` se modificó el código extraído para que este fuera más legible: se añadió el método de `lowerSellIn` en conjunto a dos if con condiciones para llamar `getItemQuality` para comprobar si estaba dentro del `MAX_QUALITY` y `MIN_QUALITY` para luego disminuir su calidad `decreaseQuality` si pasaban la validación.
   * En el método auxiliar `lowerSellIn` se modificó el código extraído para que este fuera más legible para que vaya acorde al operador aritmético identificado en el código original: se utiliza `setItemSellIn` menos el valor indicado (-1).
   * En el método auxiliar `increaseQuality` se modificó el código extraído para que este fuera más legible para que vaya acorde al operador aritmético identificado en el código original: se agregó un if, if que se encontraba duplicado varias veces, con la condición `getItemQuality` para comprobar si estaba dentro del `MAX_QUALITY` y luego utilizar `setItemQuality` si el valor pasaba la validación con `getItemQuality` más el valor indicado (+1).
   * En el método auxiliar `decreaseQuality` se modificó el código extraído para que este fuera más legible para que vaya acorde al operador aritmético identificado en el código original: se agregó un if, if que se encontraba duplicado varias veces, con la condición `getItemQuality` para comprobar si estaba dentro del `MIN_QUALITY` y luego utilizar `setItemQuality` si el valor pasaba la validación con `getItemQuality` más el valor indicado (-1).
   * En el método auxiliar `setItemQuality`, utilizado múltiples veces en todo el código, para establecer el valor de la calidad del item.

      **Item.java**
**NOTA:** A pesar de haber editado este código anteriormente, se identificaron unas inconsistencias al hacer la comparación y comprobación en conjunto con GildedRose.java. Entre los cambios están:
* Modificar el nombre de los setters y getters para que sean iguales a los inicializados en el constructor. Esto se hace para que haya uniformidad de nombres entre todos los setters and getters. 















 
