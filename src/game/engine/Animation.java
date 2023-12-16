package game.engine;

import java.awt.image.BufferedImage;

public class Animation {
  public enum Direction {
    FORWARD_ONCE,
    BACKWARD_ONCE,
    FORWARD_LOOP,
    BACKWARD_LOOP;

    public boolean isForward() {
      return this == FORWARD_ONCE || this == FORWARD_LOOP;
    }

    public boolean isLoop() {
      return this == FORWARD_LOOP || this == BACKWARD_LOOP;
    }
  };

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

  public Animation(BufferedImage[] frames, int frameDuration) {
    this(frames, frameDuration, Direction.FORWARD_ONCE);
  }

  public Animation(BufferedImage[] frames, int frameDuration, Direction animationDirection) {
    if (frames.length == 0) {
      throw new IllegalArgumentException("Frames array must not be empty");
    }
    this.frames = frames;
    this.currentFrame = 0;
    this.frameDuration = frameDuration;
    this.ticksCount = 0;
    this.direction = animationDirection;
    this.status = Status.PLAYING;
  }

  public void start() {
    if (currentFrame < frames.length) {
      status = Status.PLAYING;
    }
  }

  public void pause() {
    if (status == Status.PLAYING) {
      status = Status.PAUSED;
    }
  }

  public void stop() {
    status = Status.STOPPED;
  }

  public void restart() {
    currentFrame = 0;
    ticksCount = 0;
  }

  public BufferedImage getSprite() {
    if (direction.isForward()) {
      return frames[currentFrame];
    } else {
      return frames[frames.length - currentFrame - 1];
    }
  }

  public Status getStatus() {
    return status;
  }

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