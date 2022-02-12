import java.lang.reflect.Method;
import java.util.Arrays;
import java.lang.reflect.*;
import java.util.Scanner;

public class Lab11 {
    public static String[] getArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]"))
                .filter(w -> !w.isEmpty())
                .toArray(String[]::new);
    }
   // Celem dzisiejszych zajęć jest skorzystanie z mechanizmu refleksji
//    Na początku wypisujemy wszystkie możliwe metody z klasy Math które maja 1 lub 2 argumenty
    // Następnie użytkownik wpisuje funkcję matematyczną do wywołania, np. tan(1.0), należy obsłużyc wszystkie funkcje z klasy Math, które zawierają 1 lub 2 argumenty
    // Metodę w klasie Math należy znaleźć przy użyciu metody "getMethod" z klasy Class
    // Następnie wypisujemy wynik równania i kończymy program
    // Oczywiście program musi obsługiwać wyjątki takie jak: wywołanie metody która nie istnieje w klaie Math, Wywoałenie metody ze złą liczbą argumentów, czy podaniem do funkcji typu argumentu innego niz int/float/double
    // Mamy napisaną metodę getArgs do której podajemy np: "sin(4.12)" i otrzymujemy tablicę: [sin, 4.12]
    public static void main(String[] args){
        Method[] m = Math.class.getMethods();
        for(int i=0; i<m.length; i++){
            String mn=m[i].getName();
            Type[] tt=m[i].getGenericParameterTypes();
            if(tt.length==1 || tt.length==2){
                System.out.println(m[i]);
            }
        }
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj funkcje do wywolania: ");
        String fun=scanner.nextLine();
        String[] arr=Lab11.getArgs(fun);
        if(arr.length!=2 && arr.length!=3){
            try{
                throw new IllegalArgumentException();
            }catch(IllegalArgumentException e){
                System.out.println("zla ilosc argumentow");
                return;
            }
        }
        String funName=arr[0];
        double[] arguments=new double[arr.length-1];
        try{
           arguments[0]=Double.parseDouble(arr[1]);
        }catch(NumberFormatException e){
            System.out.println("Podano argument zlego typu");
            return;
        }
        if(arguments.length==2){
            try{
            arguments[1]=Double.parseDouble(arr[2]);
            }catch(NumberFormatException e){
                System.out.println("Podano argument zlego typu");
                return;
            }
            try{
                Class[] tab=new Class[]{double.class, double.class};
                Method metoda=Math.class.getMethod(funName, tab);
                System.out.println(funName+"("+arguments[0]+","+arguments[1]+")="+metoda.invoke(null, arguments[0], arguments[1]));
            }catch(NoSuchMethodException e){
                Class[] tab=new Class[]{double.class, double.class};
                try{
                for(Method i:m)
                    if(i.equals(Math.class.getMethod(funName, double.class))){
                        System.out.println("zla ilosc argumentow ale dobra funkcja");
                        return;
                    }
                }catch(Exception e2){
                System.out.println("zla funkcja");
                return;
                }
            }
            catch(Exception e){
                System.out.println(e);
        };
        }
        else{
            try{
                Method metoda=Math.class.getMethod(funName, double.class);
                System.out.println(funName+"("+arguments[0]+")="+metoda.invoke(null, arguments[0]));
            }catch(NoSuchMethodException e){
                Class[] tab=new Class[]{double.class, double.class};
                try{
                for(Method i:m)
                    if(i.equals(Math.class.getMethod(funName, tab))){
                        System.out.println("zla ilosc argumentow ale dobra funkcja");
                        return;
                    }
                }catch(Exception e2){
                System.out.println("zla funkcja");
                return;
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
