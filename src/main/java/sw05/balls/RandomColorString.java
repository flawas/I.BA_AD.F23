package sw05.balls;

public class RandomColorString {

    private final static String[] colors = new String[]{"red", "black", "blue", "yellow", "green", "magenta"};

    public static String get(){
        return colors[(int) (Math.random() * 6)];
    }
}
