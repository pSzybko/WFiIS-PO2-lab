public class Lab8 {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.Inner instance1 = outerClass.instantiateFirst(); // Tworze klase wewnetrzna pierwsza
        OuterClass.Inner instance2 = outerClass.new InnerClassFirst(); // Tworze klase wewnetrzna pierwsza

        OuterClass.Inner instance3 = outerClass.instantiateSecond(); // Tworze klase wewnetrzna druga
        OuterClass.Inner instance4 = new OuterClass.InnerClassSecond(); // Tworze klase wewnetrzna druga

        System.out.println(instance1.getName()); //first
        System.out.println(instance2.getName()); //first
        System.out.println(instance3.getName()); //second
        System.out.println(instance4.getName()); //second
        instance1.saySomething(); //Say something first
        instance2.saySomething(); //Say something first
        instance3.saySomething(); //Say something second
        instance4.saySomething(); //Say something second

        OuterClass.Inner innerClassThird=new OuterClass.Inner(){
            public String getName(){
                return "third";
            }
            public void saySomething(){}
        };
        System.out.println(innerClassThird.getName());

        // kolory enum
        ColourPrinter.printColours();
        /*Kolor red po polsku: czerwony
        Kolor green po polsku: zielony
        Kolor yellow po polsku: zolty
        Kolor blue po polsku: niebieski*/
        ColourPrinter.printGetNameColours();
        /*czerwony
        zielony
        zolty
        niebieski*/
        ColourPrinter.printSaySomethingColours();
        /* Kolor to czerwony
           Kolor to zielony
           Kolor to zolty
           Kolor to niebieski*/
    }
    
}
