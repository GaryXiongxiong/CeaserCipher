public class WordPlay{
    public boolean vowel(char ch){
        ch = Character.toLowerCase(ch);
        if("aeiou".indexOf(ch)==-1) return false;
        else return true;
    }
    public String replaceVowel(String str,char ch){
        StringBuilder sb1 = new StringBuilder(str);
        for(int i =0;i<sb1.length();i++){
            char currCh = sb1.charAt(i);
            if("aeiouAEIOU".indexOf(currCh)!=-1){
                sb1.setCharAt(i, ch);
            }
        }
        return sb1.toString();
    }
    public String emphasize(String phrase,char ch){
        StringBuilder sb1 = new StringBuilder(phrase);
        for(int i =0;i<sb1.length();i++){
            if(sb1.charAt(i)==Character.toUpperCase(ch)||sb1.charAt(i)==Character.toLowerCase(ch)){
                if(i%2==0) sb1.setCharAt(i, '*');
                else sb1.setCharAt(i, '+');
            }
        }
        return sb1.toString();
    }
    public static void main(String[] args) {
        WordPlay wp1 = new WordPlay();
        // System.out.println(wp1.vowel('A'));
        // System.out.println(wp1.vowel('B'));
        // System.out.println(wp1.vowel('i'));
        // System.out.println(wp1.vowel('f'));
        // System.out.println(wp1.replaceVowel("apple", '*'));
        // System.out.println(wp1.replaceVowel("An apple in a tall tree", '|'));
        System.out.println(wp1.emphasize("phrase", 'a'));
        System.out.println(wp1.emphasize("Mary Bella Abracadabra", 'a'));
    }
}