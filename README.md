# TP_TL2

Los puntos del código que debe modificarse en el proyecto JAVA están marcados con un comentario etiquetado con TODO.

**Todos los grupos deben implementar en sus juegos:**
- [ ] Agregar 2 nuevos monstruos y sobreescribir, en al menos uno de ellos, los métodos move() y onDamageReceive().
- [ ] Al menos 5 nuevas habilidades.
- [ ] Agregar al menos 5 nuevos tipos de monstruos y relacionarlos con los monstruos creados.

**Para grupos de 2 y 3 integrantes:**

En la versión original, el orden de salida de los monstruos está dado por el orden de la lista: el primero de la lista es el primero en salir a la batalla.

Los grupos de 2 y 3 integrantes deben implementar al menos: 2 criterios de ordenamiento para la lista de monstruos
- 1. por vida (el que más vida tiene sale primero a la batalla)
- 2. Por Nombre
- 3. Por tipo
- [-] por ataque (el que más poder de daño tiene sale primero) o por tipo.

**Para grupos de 3 integrantes:**

La versión original finaliza el juego cuando las vidas de uno de los jugadores llegan a cero
cuando la cantidad de rondas llega a 100.

Los grupos de 3 integrantes deben implementar:
- [ ] Una excepción en situación de “empate”: la excepción se dispara cuando ambos jugadores no tienen monstruos disponibles para atacar pero ninguno perdió.
- [ ] Implementar una ventana popup que informe el resultado del juego.
