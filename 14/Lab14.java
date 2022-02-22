// stworzyc program który utworzy dwie macierze z losowymi liczbami całkowitymi o wymiarach które wpisuje uzytkownik na poczatku wykonywania programu
// m1 => m x p
// m2 => n x p
// następnie wykonuje operacje mnożenia macierzy
// raz bez użycia wątków
// drugi raz przy użyciu wielu wątków
// uzytkownik otrzymuje output
// jesli wynikowa macierz ma wymiar wiekszy niz 10x10 nie printujemy ani wylosowanych ani wynikowej, podajemy tylko czasy
//SINGLE THREAD:
//Matrix 1 :
//
//830  930  360
//840  140  580
//200  270  370
//
//Matrix 2 :
//
//440  600  390
//630  590  390
//830  220  530
//
//Output Matrix :
//
//1249900  1125900  877200
//939200  714200  689600
//565200  360700  379400
//
//Time taken in milli seconds: 2
//==================
//MULTIPLE THREAD
//Matrix 1 :
//
//830  930  360
//840  140  580
//200  270  370
//
//Matrix 2 :
//
//440  600  390
//630  590  390
//830  220  530
//
//Output Matrix :
//
//1249900  1125900  877200
//939200  714200  689600
//565200  360700  379400
//
//Time taken in milli seconds: 1
//==================

// Mierzenie czasu: System.currentTimeMillis()
// Liczba dostępnych procesorów: Runtime.getRuntime().availableProcessors()
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.lang.Thread;

public class Lab14 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int i1,j1,i2,j2;
        do{
            System.out.println("Porsze podac wymiary pierwszej macierzy:");
            i1=scanner.nextInt();
            j1=scanner.nextInt();
            System.out.println("Porsze podac wymiary drugiej macierzy:");
            i2=scanner.nextInt();
            j2=scanner.nextInt();
        }while(j1!=i2);
        Matrix m1=new Matrix(i1, j1);
        m1.fill();
        Matrix m2=new Matrix(i2, j2);
        m2.fill();
        Matrix m3=Matrix.multiplyST(m1, m2);
        Matrix m4=Matrix.multiplyMT(m1, m2);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    
}

class Watek implements Runnable{
    Matrix m1;
    Matrix m2;
    Matrix m3;
    int i;
    Watek(Matrix m1, Matrix m2, Matrix m3, int i){
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
        this.i=i;
    }
    public void run(){
        for(int j=0; j<m3.j; j++){
            for(int k=0; k<m2.i; k++){
                m3.arr[i][j]+=m1.arr[i][k]*m2.arr[k][j];
            }
        }
    }
}

class Matrix{
    int[][] arr;
    int i;
    int j;
    Matrix(int i, int j){
        this.i=i;
        this.j=j;
        arr=new int[i][j];
    }
    public void fill(){
        for(int k=0; k<i; k++){
            for(int l=0; l<j; l++){
                Random rnd=new Random();
                arr[k][l]=rnd.nextInt(1000);
            }
        }
    }
    public void setValue(int i, int j, int v){
        arr[i][j]=v;
    }
    public int getValue(int i, int j){
        return arr[i][j];
    }
    public int getI(){
        return i;
    }
    public int getJ(){
        return j;
    }
    @Override
    public String toString(){
        String res="";
        for(int k=0; k<i; k++){
            for(int l=0; l<j; l++){
                res+=" "+arr[k][l];
            }
            res+="\n";
        }
        return res;
    }
    public static Matrix multiplyST(Matrix m1, Matrix m2){
        long t1=System.currentTimeMillis();
        Matrix m3=new Matrix(m1.i, m2.j);
        for(int i=0; i<m3.i; i++){
            for(int j=0; j<m3.j; j++){
                for(int k=0; k<m2.i; k++){
                    m3.arr[i][j]+=m1.arr[i][k]*m2.arr[k][j];
                }
            }
        }
        long t2=System.currentTimeMillis();
        if(m3.i<10 && m3.j<10)
            System.out.println("SINGLE THREAD: \nMatrix 1:\n"+m1+"\nMatrix 2:\n"+m2+"\nOutput Matrix:\n"+m3);
        System.out.println("Time taken in milli seconds: "+t2+" - "+t1+" = "+(t2-t1));
        return m3;
    }
    public static Matrix multiplyMT(Matrix m1, Matrix m2){
        long t1=System.currentTimeMillis();
        Matrix m3=new Matrix(m1.i, m2.j);
        ArrayList<Thread> threads=new ArrayList<Thread>();
        for(int i=0; i<m3.i; i++){
            Watek tmp=new Watek(m1, m2, m3, i);
            Thread thr=new Thread(tmp);
            threads.add(thr);
            thr.start();
            if(threads.size()%4==0){
                waitForThreads(threads);
            }
        }
        long t2=System.currentTimeMillis();
        if(m3.i<10 && m3.j<10)
            System.out.println("MULTIPLE THREAD: \nMatrix 1:\n"+m1+"\nMatrix 2:\n"+m2+"\nOutput Matrix:\n"+m3);
        System.out.println("Time taken in milli seconds: "+t2+" - "+t1+" = "+(t2-t1));
        return m3;
    }
    static public void waitForThreads(ArrayList<Thread> list){
        for(Thread thr : list){
            try{
                thr.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        list.clear();
    }
}
