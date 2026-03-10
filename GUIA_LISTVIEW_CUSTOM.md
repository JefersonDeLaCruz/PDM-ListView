# Guía: Implementación de ListView con Layout Personalizado

Esta guía detalla los pasos seguidos en los últimos dos commits para implementar un `ListView` que utiliza un diseño propio para sus filas, en lugar del simple `android.R.layout.simple_list_item_1`.

---

## Paso 1: Crear el Modelo de Datos
Define una clase que represente la información que quieres mostrar en cada fila.

**Archivo:** `app/src/main/java/com/example/list_view/Models/Producto.java`
*   Define los atributos (ej: `nombre`, `precio`, `idImagen`).
*   Crea el constructor y los métodos *Getter* y *Setter*.

---

## Paso 2: Crear el Layout para el Item
Diseña cómo se verá una **sola fila** de tu lista.

**Archivo:** `app/src/main/res/layout/item_productos.xml`
1.  Usa un `ConstraintLayout` o `LinearLayout` como raíz.
2.  **IMPORTANTE:** El `android:layout_height` del contenedor raíz debe ser `wrap_content` para que no ocupe toda la pantalla.
3.  Agrega los elementos necesarios (`ImageView`, `TextView`, `Button`, etc.) y asígnales un `id` claro (ej: `@+id/tvNombre`).

---

## Paso 3: Crear el Adaptador Personalizado
El adaptador es el "puente" entre tus datos y la vista. Debe extender de `BaseAdapter`.

**Archivo:** `app/src/main/java/com/example/list_view/AdaptadorProductos.java`

### Componentes clave del Adaptador:
1.  **Atributos:** Una lista de tus objetos (`ArrayList<Producto>`) y el `Context`.
2.  **Constructor:** Recibe los datos y el contexto. Inicializa un `LayoutInflater`.
3.  **Métodos obligatorios:**
    *   `getCount()`: Retorna el tamaño de la lista.
    *   `getItem(int position)`: Retorna el objeto en esa posición.
    *   `getItemId(int position)`: Normalmente retorna la posición.
    *   **`getView(int position, View convertView, ViewGroup parent)`**: Es el más importante. Aquí es donde se "infla" el XML y se llenan los datos.

### Uso del ViewHolder (Optimización):
Se usa una clase estática interna llamada `ViewHolder` para guardar las referencias a los views (findViewById) y no tener que buscarlos cada vez que se hace scroll, lo que mejora mucho el rendimiento.

```java
// Ejemplo simplificado dentro de getView:
if (convertView == null) {
    convertView = inflater.inflate(R.layout.item_productos, parent, false);
    holder = new ViewHolder();
    holder.nombre = convertView.findViewById(R.id.tvNombre);
    // ... vincular los demás
    convertView.setTag(holder);
} else {
    holder = (ViewHolder) convertView.getTag();
}
// Llenar datos
Producto p = lista.get(position);
holder.nombre.setText(p.getNombre());
```

---

## Paso 4: Implementar en el Activity
Configura el `ListView` para que use tu nuevo adaptador.

**Archivo:** `app/src/main/java/com/example/list_view/MainActivity2.java`
1.  Obtén la referencia del `ListView` por su ID.
2.  Crea e inicializa tu `ArrayList` con datos de prueba.
3.  Instancia tu adaptador: `miAdaptador = new AdaptadorProductos(lista, this);`
4.  Asigna el adaptador al ListView: `miListView.setAdapter(miAdaptador);`

---

## Resumen para el Parcial:
1.  **Clase POJO** (el modelo).
2.  **XML Custom** (el diseño de la fila).
3.  **Clase Adapter** (hereda `BaseAdapter`, usa `LayoutInflater` y `ViewHolder`).
4.  **Activity** (vincular `ListView` + `ArrayList` + `Adapter`).

¡Con esto dominas cualquier lista personalizada!