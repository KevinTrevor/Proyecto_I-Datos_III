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

Para Pasos: Los pasos tienen la estructura 'valor_total_pasos' ydeben estar separados por un ",".
	
	PASOS
	dia_inicio, dia_fin
	valor_total_pasos1 valor_total_pasos2 ... valor_total_pasosN  

Para Sueño: Los sueños tienen la estructura 'tiempo_inicio-tiempo_fin-tipo_sueño' y se separan con un " ".

	SUENO
	Día_inicio, Día_fin
	minuto_inicio-minuto-fin-tipo_sueño1 minuto_inicio-minuto-fin-tipo_sueño2 ... minuto_inicio-minuto-fin-tipo_sueñoN

Para BMP: Los BMP tienen la estructura 'valor_bmp' y se separan por un " ".

	BMP
	dia, minuto_inicio, minuto_fin 
	valor_bmp1 valor_bmp2 ... valor_bmpN
# Salida del proyecto

PASOS
Dia1, Total de pasos por dia1, mejor_dia_anterior1
Dia2, Total de pasos por dia2, mejor_dia_anterior2
...
DiaN, Total de pasos por diaN, mejor_dia_anteriorN

SUENO
Dia1, duracion_total1, total_ligero1, total_pesado1, total_rem1, duración_ultimo_registro_enviado1
Dia2, duracion_total2, total_ligero2, total_pesado2, total_rem2, duración_ultimo_registro_enviado2
...
DiaN, duracion_totalN, total_ligeroN, total_pesadoN, total_remN, duración_ultimo_registro_enviadoN

BMP
[Valor1,Valor2,..., ValorN]