# Unidad-3-Ejercicio-6
Programacion 3 Unidad 3 Ejercicio 6
Ejercicio 6 — Cargar datos de la BD en una JTable
Ahora que ya sabés conectarte a la base de datos, el siguiente paso es consultar datos reales y mostrarlos en una JTable. Este es uno de los patrones más frecuentes en aplicaciones de gestión.

Usando la base de datos y la tabla clientes del ejercicio anterior, insertá al menos 5 registros manualmente desde tu gestor de base de datos. Luego construí una ventana con:

Una JTable con las columnas: ID, Nombre, Email, Teléfono
Un botón con el texto "Cargar clientes"
Una etiqueta que muestre la cantidad de registros cargados
Cuando el usuario presione el botón, la aplicación debe:

Conectarse a la base de datos
Ejecutar la consulta SELECT * FROM clientes
Recorrer el ResultSet y agregar cada registro como una fila en la tabla
Actualizar la etiqueta con la cantidad de registros cargados
Cerrar todos los recursos abiertos (ResultSet, Statement, Connection)
💡 Tip: antes de cargar los datos, limpiá las filas existentes en el modelo con modelo.setRowCount(0) para evitar duplicados si el usuario presiona el botón más de una vez.

<img width="857" height="491" alt="image" src="https://github.com/user-attachments/assets/d80ad550-3411-4615-9691-1758bee3e3f6" />
<img width="858" height="490" alt="image" src="https://github.com/user-attachments/assets/f3e42ffa-d13c-49a7-a467-84ff8ca4ed50" />

