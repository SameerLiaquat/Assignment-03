public class Words implements Comparable <Words>{
   private String word;
   private String meaning;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Words(String word, String mean){
        this.word=word;
        this.meaning=mean;
    }

    public Words(String word){
        this.word=word;
    }

    Words(){

    }

    @Override
    public int compareTo(Words o) {
        if (o.word.compareToIgnoreCase(getWord())>0){
            return 1;
        }
        else if (o.word.compareToIgnoreCase(getWord())<0){
            return -1;
        }
        else
            return 0;
    }
}
