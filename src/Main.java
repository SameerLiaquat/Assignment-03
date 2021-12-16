import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Dictionary dictionary=new Dictionary();
        Scanner sc=new Scanner(System.in);
        boolean flag=false;
        int opt;

        System.out.println();
        System.out.println("Welcome to Sameer's Dictionary:");
        System.out.println("Reading from file.................... ");
        dictionary.Start();

        do{
            try{
            System.out.println("Press 1 to see the whole dictionary");
            System.out.println("Press 2 to search a word from a dictionary");
            System.out.println("Press 3 to end");
            opt=sc.nextInt();


            if (opt==1){
                dictionary.show();
            }

            else if (opt==2){
                System.out.println("Enter the word: ");
                String word=sc.next();
                Words wobj=new Words(word);
                dictionary.SEARCH(wobj);
            }

            else if (opt==3){
                flag=true;
                System.exit(0);
            }

            else{
                System.out.println("What ya doing it is not the option? -.-");
                flag=true;
            }


    }catch (InputMismatchException e){
                String str=sc.next();
                System.out.println("Str: "+str);
                System.out.println("Invalid entry: Enter again");
            }
        }while (!flag);

    }
}
