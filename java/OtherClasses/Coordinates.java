package OtherClasses;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int findDistance(Coordinates opposite){
        int diffX = this.x - opposite.x;
        int diffY = this.y - opposite.y;
        return (int)Math.sqrt(Math.pow(diffX,2) + Math.pow(diffY, 2));
    }
}
