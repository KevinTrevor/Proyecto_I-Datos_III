# ProyectoI-Datos_III: Colas, Pilas y Dipolos
Hecho por Kevin Rojas (C.I: 29.582.382) y Nestor Aguilar (C.I: 28.316.308)

# Funcionamiento del proyecto
Este proyecto analiza un documento ('data.txt') mediante funciones específicas para cada una de los datos que se atrapan en el documento.

Para Sueño: primero se toman los datos pertenecientes al bloque de Sueño (mediante lecturas secuenciales al archivo, siempre que pertenezcan a SUENO), acto seguido se guardan en una cola para su posterior analisis en el sistema.

Para Pasos: primero se toman los datos pertenecientes del bloque de Pasos (mediante lecturas secuenciales al archivo, siempre que pertenezcan a PASOS), acto seguido se guardan en una cola para su posterior analisis en el sistema.

Para BMP:primero se toman los datos pertenecientes del bloque de Pasos (mediante lecturas secuenciales al archivo, siempre que pertenezcan a BMP), acto seguido se guardan en una cola para su posterior analisis en el sistema.

Cuando el documento lee #, significa que se tomará 5 minutos para parar y procesar algunos datos en los bloques previamente leídos.

Cuando el documento lee 0 0, significa que ha llegado al fin del archivo y se analizan todos los datos que quedaron guardados en las colas de espera. 

# Reglas del documento de entrada

# Salida del proyecto