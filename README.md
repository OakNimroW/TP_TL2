# Taller de Lenguajes II — Segunda Evaluación

[Enunciado](./Trabajo%20final%20-%202023.pdf).

> Autores: Juan Martín Seery, Tomás Badenes y Lorenzo Majoros.

## Detalles sobre las soluciones

### Consigna 1

#### Nuevos Monstruos

Eliminado Spartan, modificados IceBeast y EvilBeast. Se agregan 10 personajes nuevos y se clasifican en paquetes equipo bueno / equipo malo.

##### Equipo bueno

- Swordsman
- IceBeast
- Monk (Overrides `move()`)
- Pikeman (Overrides `onDamageReceive()`)
- Wolfrider
- Deer (Overrides `onDamageReceive()`)

##### Equipo malo

- Evilbeast
- DeathKnight
- Ghost
- Skeleton
- Spider
- Vampire

#### Nuevas habilidades

- Bite
- FlameThrower
- Kick
- MultiSlice
- Punch
- Spell

### Consigna 2

Se agregan los siguientes criterios de ordenamiento:

- Alfabéticamente por nombre
- Por tipo de personaje (ascendente/descendiente)
- Por vida máxima (ascendente/descendiente)

### Consigna 3

Se agrega la excepción `NoMonsterException` para cuando termina el juego y no hay monstruos en niguno de los equipos ni en el mapa. El manejador de esta excepción lanza el mensaje de empate, que también es mostrado cuando la cantidad de rondas llega a 100 y ninguno de los jugadores ganó.

Cuando alguno del los jugadores gana, se muestra un mensaje mostrando el resutlado de la partida.

### Extras

Además de las consignas propuestas en el enunciado, se agregaron las siguientes funcionalidades:

- Personajes gráficos y animados.
- Escenario con distinción entre equipo "bueno" y equipo "malo".
- Un menú gráfico que permite seleccionar los monstruos de cada equipo.

## Recursos utilizados

- Los sprites se basan en aquellos creados por [Aleksandr Makarov](https://iknowkingrabbit.itch.io/) para su _Heroic Asset Series_.
- La tipografía utilizada es [Nico Fonts](https://emhuo.itch.io/nico-pixel-fonts-pack) creada por `emhuo`.
- Varios de los conceptos más avanzados de Java Swing se obtuvieron del video de Bro Code [Java GUI: Full Course ☕ (FREE)](https://www.youtube.com/watch?v=Kmgo00avvEw).
- Para hacer el escenario, se utilizó el editor [Tiled Map Editor](https://www.mapeditor.org/).
