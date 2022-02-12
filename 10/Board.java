import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Board {
    private char[][] board;
    private int s;
    private double r;
    private int x_gracz;
    private int y_gracz;

    Board(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj wymiar planszy:");
        s=scanner.nextInt();
        if(s<=3){
            try{
                throw new TooSmallGameSizeException();
            }
            catch(TooSmallGameSizeException e){
                System.out.println("Zbyt mala plansza");
                return;
            }
        }
        System.out.println("Podaj prawdopodobienstwo:");
        r=scanner.nextDouble();
        if(r<=0){
            try{
                throw new TooSmallGameSizeException();
            }
            catch(TooSmallGameSizeException e){
                System.out.println("Zbyt mala plansza");
                return;
            }
        }
        board=new char[10][10];
    }
    public void fill(){
        for(int i=0; i<s; i++){
            for(int j=0; j<s; j++){
                double tmp=Math.random();
                char p='*';
                if(tmp<=r) p='W';
                board[i][j]=p;
            }
        }
        Random rnd=new Random();
        x_gracz=rnd.nextInt(s-1);
        y_gracz=rnd.nextInt(s-1);
        board[x_gracz][y_gracz]='G';
        int i=rnd.nextInt(s-1);
        int j=rnd.nextInt(s-1);
        board[i][j]='S';
    }
    @Override
    public String toString(){
        String res="";
        for(int i=0; i<s; i++){
            for(int j=0; j<s; j++)
                res+=(board[i][j]+" ");
            res+="\n";
        }
        return res;
    }
    public void startGame(){
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("Podaj kolejny ruch:");
            String tmp=scanner.nextLine();
            switch(tmp){
                case "l":{
                    try{
                        if(board[x_gracz][y_gracz-1]=='S'){
                            try{
                                throw new GameOverException();
                            }catch(GameOverException e){
                                System.out.println("Wygrales");
                                return;
                            }
                        }
                        if(board[x_gracz][y_gracz-1]=='W'){
                            try{
                                throw new GameOverException();
                            }catch(GameOverException e){
                                System.out.println("Wszedles na wode");
                                return;
                            }
                        }
                        board[x_gracz][y_gracz-1]='G';
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("Wyjscie poza plansze");
                        break;
                    }
                    
                    board[x_gracz][y_gracz]='*';
                        y_gracz--;
                    break;
                }
                case "p":{
                    try{
                        if(board[x_gracz][y_gracz+1]=='S'){
                            try{
                                throw new GameOverException();
                            }catch(GameOverException e){
                                System.out.println("Wygrales");
                                return;
                            }
                        }
                        if(board[x_gracz][y_gracz+1]=='W'){
                            try{
                                throw new GameOverException();
                            }catch(GameOverException e){
                                System.out.println("Wszedles na wode");
                                return;
                            }
                        }
                        board[x_gracz][y_gracz+1]='G';
                        
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("Wyjscie poza plansze");
                        break;
                    }
                    
                    board[x_gracz][y_gracz]='*';
                        y_gracz++;
                    break;
                }
                case "g":{
                    try{
                        if(board[x_gracz-1][y_gracz]=='S'){
                            try{
                                throw new GameOverException();
                            }catch(GameOverException e){
                                System.out.println("Wygrales");
                                return;
                            }
                        }
                        if(board[x_gracz-1][y_gracz]=='W'){
                            try{
                                throw new GameOverException();
                            }catch(GameOverException e){
                                System.out.println("Wszedles na wode");
                                return;
                            }
                        }
                        board[x_gracz-1][y_gracz]='G';
                        
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("Wyjscie poza plansze");
                        break;
                    }
                    
                        board[x_gracz][y_gracz]='*';
                        x_gracz--;
                    break;
                }
                case "d":{
                    try{
                        if(board[x_gracz+1][y_gracz]=='S'){
                            try{
                                throw new GameOverException();
                            }catch(GameOverException e){
                                System.out.println("Wygrales");
                                return;
                            }
                        }
                        if(board[x_gracz+1][y_gracz]=='W'){
                            try{
                                throw new GameOverException();
                            }catch(GameOverException e){
                                System.out.println("Wszedles na wode");
                                return;
                            }
                        }
                        board[x_gracz+1][y_gracz]='G';
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("Wyjscie poza plansze");
                        break;
                    }
                    
                    board[x_gracz][y_gracz]='*';
                        x_gracz++;
                    break;
                }
                default:{
                    try{
                    throw new CommandNotRecognisedException();
                    }catch(CommandNotRecognisedException e){
                        System.out.println("Nierozpoznano komendy");
                    }                    
                }
                    
            }
            System.out.println(this);
        }
    }
}