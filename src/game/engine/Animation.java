package game.engine;

import java.awt.image.BufferedImage;

/**
 * La clase Animation representa una animación que puede reproducir una
 * secuencia de imágenes en un bucle o una sola vez.
 */
public class Animation {
  /**
   * Enumeración que define las direcciones de reproducción de la animación.
   */
  public enum Direction {
    FORWARD_ONCE,
    BACKWARD_ONCE,
    FORWARD_LOOP,
    BACKWARD_LOOP;

    /**
     * Verifica si la dirección de reproducción es hacia adelante.
     * 
     * @return true si la dirección es hacia adelante, false de lo contrario.
     */
    public boolean isForward() {
      return this == FORWARD_ONCE || this == FORWARD_LOOP;
    }

    /**
     * Verifica si la animación se reproduce en bucle.
     * 
     * @return true si la animación se reproduce en bucle, false de lo contrario.
     */
    public boolean isLoop() {
      return this == FORWARD_LOOP || this == BACKWARD_LOOP;
    }
  };

  /**
   * Enumeración que define los estados de la animación.
   */
  public enum Status {
    PLAYING,
    PAUSED,
    STOPPED;
  };

  private BufferedImage[] frames;
  private int currentFrame;
  private int frameDuration;
  private int ticksCount;
  private Direction direction;
  private Status status;

  /**
   * Crea una nueva instancia de Animation con los fotogramas y la duración de
   * fotograma especificados.
   * La dirección de reproducción predeterminada es hacia adelante una sola vez.
   * 
   * @param frames        los fotogramas de la animación.
   * @param frameDuration la duración de cada fotograma en ticks.
   * @throws IllegalArgumentException si el arreglo de fotogramas está vacío.
   */
  public Animation(BufferedImage[] frames, int frameDuration) {
    this(frames, frameDuration, Direction.FORWARD_ONCE);
  }

  /**
   * Crea una nueva instancia de Animation con los fotogramas, la duración de
   * fotograma y la dirección de reproducción especificados.
   * 
   * @param frames             los fotogramas de la animación.
   * @param frameDuration      la duración de cada fotograma en ticks.
   * @param animationDirection la dirección de reproducción de la animación.
   * @throws IllegalArgumentException si el arreglo de fotogramas está vacío.
   */
  public Animation(BufferedImage[] frames, int frameDuration, Direction animationDirection) {
    if (frames.length == 0) {
      throw new IllegalArgumentException("El arreglo de fotogramas no debe estar vacío");
    }
    this.frames = frames;
    this.currentFrame = 0;
    this.frameDuration = frameDuration;
    this.ticksCount = 0;
    this.direction = animationDirection;
    this.status = Status.PLAYING;
  }

  /**
   * Inicia la reproducción de la animación desde el fotograma actual.
   * Si el fotograma actual es mayor o igual que la cantidad de fotogramas, no se
   * realiza ninguna acción.
   */
  public void start() {
    if (currentFrame < frames.length) {
      status = Status.PLAYING;
    }
  }

  /**
   * Pausa la reproducción de la animación si está en estado de reproducción.
   */
  public void pause() {
    if (status == Status.PLAYING) {
      status = Status.PAUSED;
    }
  }

  /**
   * Detiene la reproducción de la animación.
   */
  public void stop() {
    status = Status.STOPPED;
  }

  /**
   * Reinicia la animación al fotograma inicial y reinicia el contador de ticks.
   */
  public void restart() {
    currentFrame = 0;
    ticksCount = 0;
  }

  /**
   * Obtiene el fotograma actual de la animación.
   * Si la dirección de reproducción es hacia adelante, se devuelve el fotograma
   * actual.
   * Si la dirección de reproducción es hacia atrás, se devuelve el fotograma en
   * sentido inverso.
   * 
   * @return el fotograma actual de la animación.
   */
  public BufferedImage getSprite() {
    if (direction.isForward()) {
      return frames[currentFrame];
    } else {
      return frames[frames.length - currentFrame - 1];
    }
  }

  /**
   * Obtiene el estado actual de la animación.
   * 
   * @return el estado actual de la animación.
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Actualiza la animación avanzando al siguiente fotograma si corresponde.
   * Si la animación está en estado de reproducción, se incrementa el contador de
   * ticks.
   * Cuando el contador de ticks alcanza la duración de fotograma, se avanza al
   * siguiente fotograma.
   * Si la animación llega al final de los fotogramas y la dirección de
   * reproducción es en bucle, se reinicia al primer fotograma.
   * Si la animación llega al final de los fotogramas y la dirección de
   * reproducción no es en bucle, se detiene la reproducción.
   */
  public void tick() {
    if (status == Status.PLAYING) {
      ticksCount++;

      if (ticksCount >= frameDuration) {
        ticksCount = 0;
        currentFrame++;

        if (currentFrame >= frames.length) {
          if (direction.isLoop()) {
            currentFrame = 0;
          } else {
            currentFrame = frames.length - 1;
            status = Status.STOPPED;
          }
        }
      }
    }
  }
}
