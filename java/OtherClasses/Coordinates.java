package OtherClasses;

public class Coordinates {
    public float x;
    public float y;

    public Coordinates(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float findDistance(Coordinates opposite){
        float diffX = this.x - opposite.x;
        float diffY = this.y - opposite.y;
        return (float)Math.sqrt(Math.pow(diffX,2) + Math.pow(diffY, 2));
    }
}
