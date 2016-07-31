package interfaces;

/**
 * Created by PetyoPetrov on 31.07.2016 г..
 */
public interface Moveable {
    public boolean isMovingLeft();

    public void setMovingLeft(boolean isMovingLeft);

    public boolean isMovingRight();

    public void setMovingRight(boolean isMovingRight);

    public boolean isMovingUp();

    public void setMovingUp(boolean isMovingUp);

    public boolean isMovingDown();

    public void setMovingDown(boolean isMovingDown);
}
