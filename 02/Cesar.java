import java.util.Scanner;

public class Cesar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String result = "";
        String mode = args[0];
        int n = Integer.parseInt(args[1]);
        if(mode.equals("code")){
            for(char i : word.toCharArray()){
                if(i==' ')
                    result+=" ";
                else
                    result+=alfabet.charAt((alfabet.indexOf(i)+n)%(alfabet.length()));
            }
        }
        else if(mode.equals("decode")){
            for(char i : word.toCharArray()){
                if(i==' ')
                    result+=" ";
                else
                    result+=alfabet.charAt((alfabet.indexOf(i)+alfabet.length()-n)%(alfabet.length()));
            }
        }
        System.out.println("Dla alfabetu: "+alfabet);
        System.out.println("Dla slowa: "+word);
        System.out.println("Przesuniecia: "+n);
        System.out.println("Trybu: "+mode);
        System.out.println("Wynik: "+result);
	}
}
