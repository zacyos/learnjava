enum Color {
    RED, BlUE, GREEN
}

enum Color2 {
    RED, BlUE, GREEN
}


public class Enum {

    public static void main(String[] args) {


        Color c1 = Color.BlUE;
        Color2 c2 = Color2.BlUE;

        switch (c2) {
            case RED -> System.out.println("RED");
            case BlUE -> System.out.println("BLUE");
            case GREEN -> System.out.println("GREEN");
            default -> System.out.println("default");
        }
    }
}
