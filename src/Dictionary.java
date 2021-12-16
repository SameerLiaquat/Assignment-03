import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Dictionary {
    Tree <Words> treeWords=new Tree<>();

    public void insert(Words wr){
        treeWords.insert(wr);
    }

    public void show(){
        System.out.println("Inorder");
        System.out.println();
        treeWords.inorder();
        System.out.println("Preorder:");
        System.out.println();
        treeWords.preorder();
        System.out.println("Postorder:");
        System.out.println();
        treeWords.postorder();
    }

    public void Start() {
        try {
            File read = new File("WordList");
            Scanner reader=new Scanner(read);
            while (reader.hasNext()) {
                Words w1=new Words();
                String info=reader.nextLine();
                String[] arr =info.split(":");
                w1.setWord(arr[0]);
                w1.setMeaning(arr[1]);
                treeWords.insert(w1);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SEARCH(Words word){
        boolean flag;
        flag=treeWords.search(word);
        if (flag==false){
            System.out.println("No such word exist will try to add that");
        }
    }

}
