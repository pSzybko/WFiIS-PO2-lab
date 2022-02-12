import java.util.Scanner;

public class Test{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.printf("Podaj promien: ");
        double r = scan.nextDouble();
        System.out.println("Pole powierzchni wynosi: " + Math.PI*Math.pow(r, 2));
        System.out.println("Obwod wynosi: " + 2*Math.PI*r);
    }
}