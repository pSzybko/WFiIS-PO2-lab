import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
//        Szyfr Cezara
//
//        Napisz program który będzie obsługiwał dwa tryby oraz przesunięcie w alfabecie niezbędne do zakodowania słowa w szyfr cezara
//
//        (tryb oraz przesunięcie przekazane jako argumenty programu):
//
//        1. Input z pliku zostaje zaszyfrowany i zapisany do pliku o tej samej nazwie + _coded_{przesuniecie}.txt (3pkt za obsługę pojedyńczych wyrazów + 2 pkt za obsługe całych
//
//        zdań ze spacjami)
//
//        2. Input z pliku zostaje odszyfrowany i zapisany do pliku o tej samej nazwie + _decoded_{przesuniecie}.txt. (3pkt za obsługę pojedyńczych wyrazów + 2 pkt za obsługe całych
//
//        zdań ze spacjami)
//
//
//        3. Argumenty programu przekazane jako:
//        java lab2 code 2 test.txt
//        java lab2 decode 2 test.txt
//
//                test.txt zawiera słowo TEST
//
//        4. Przykładowy wynik:
//                (To wypisujemy na konsole)
//        Dla alfabetu: ABCDEFGHIJKLMNOPQRSTUVWXYZ
//        Dla pliku z zawartoscia: TEST
//        Przesunięcia: 2
//        Trybu: code
//        Wynik: VGUV
//
//                (To trafia do pliku o nazwie test_coded_2.txt)
//                VGUV

public class Lab13 {
    public static void main(String[] args) {
        if(args.length<3){
            return;
        }
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n=Integer.parseInt(args[1]);
        String line="";
        String result="";
        String text="";
        switch(args[0]){
            case "code":
                try(BufferedReader reader=new BufferedReader(new FileReader(args[2]))){
                    while((line=reader.readLine())!=null){
                        text+=line+"\n";
                        for(char i : line.toCharArray()){
                            if(i==' ')
                                result+=i;
                            else
                                result+=alfabet.charAt((alfabet.indexOf(i)+n)%alfabet.length());
                        }
                        result+="\n";
                    }
                    String[] tmp=args[2].split("\\.");
                    String fileName=tmp[0]+"_coded_{"+args[1]+"}.txt";
                    PrintWriter writer=new PrintWriter(new FileOutputStream(fileName));
                    writer.print(result);
                    writer.close();
                }catch(IOException e){
                    throw new RuntimeException(e);
                }
                break;
            case "decode":
                try(BufferedReader reader=new BufferedReader(new FileReader(args[2]))){
                    while((line=reader.readLine())!=null){
                        text+=line+"\n";
                        for(char i : line.toCharArray()){
                            if(i==' ')
                                result+=i;
                            else
                                result+=alfabet.charAt((alfabet.indexOf(i)+alfabet.length()-n)%alfabet.length());
                        }
                        result+="\n";
                    }
                    String[] tmp=args[2].split("\\.");
                    String fileName=tmp[0]+"_decoded_{"+args[1]+"}.txt";
                    PrintWriter writer=new PrintWriter(new FileOutputStream(fileName));
                    writer.print(result);
                    writer.close();
                }catch(IOException e){
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("Nie rozpoznano komendy - poprawne komendy: code/decode!!!");
                return;
        }
        System.out.println("Dla alfabetu: "+alfabet);
        System.out.println("Dla pliku z zawartoscia: \n"+text);
        System.out.println("Przesuniecia: "+n);
        System.out.println("Trybu: "+args[0]);
        System.out.println("Wynik: \n"+result);
    }
}
