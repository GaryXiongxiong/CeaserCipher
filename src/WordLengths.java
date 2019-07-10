import edu.duke.*;

public class WordLengths{
    public void countWordLengths(FileResource file, int[] arr){
        for (String word : file.words()) {
            int length = word.length();
            if(!Character.isLetter(word.charAt(0))) length-=1;
            if(!Character.isLetter(word.charAt(word.length()-1))) length-=1;
            if(length>=arr.length) arr[arr.length-1]+=1;
            else if(length<0) arr[0] +=1;
            else arr[length]+=1;
        }
        System.out.println(indexOfMax(arr));
    }
    public int indexOfMax(int[] arr){
        int max = 0;
        int index = -1;
        for(int i = 0;i<arr.length;i++){
            if (arr[i] > max){
                index = i;
                max = arr[i];
            }
        }
        return index;
    }
    public static void main(String[] args) {
        FileResource fr = new FileResource();
        int[] arr = new int[10];
        WordLengths wl = new WordLengths();
        wl.countWordLengths(fr, arr);
    }
}