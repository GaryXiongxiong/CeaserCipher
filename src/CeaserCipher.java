import edu.duke.*;
public class CeaserCipher{
    public static String encrypt(String massage,int key){
        StringBuilder sb = new StringBuilder(massage);
        String table = "abcdefghijklmnopqrstuvwxyz";
        String shiftTable = table.substring(key)+table.substring(0,key);
        for(int i = 0;i<sb.length();i++){
            char currChar = sb.charAt(i);
            if(Character.isLetter(currChar)){
                char replaceChar = shiftTable.charAt(table.indexOf(Character.toLowerCase(currChar)));
                if(Character.isUpperCase(currChar)) replaceChar = Character.toUpperCase(replaceChar);
                sb.setCharAt(i, replaceChar);
            }
        }
        return sb.toString();
    }
    public static String encryptTwoKeys(String massage,int key1,int key2){
        StringBuilder sb = new StringBuilder(massage);
        String table = "abcdefghijklmnopqrstuvwxyz";
        String shiftTable1 = table.substring(key1)+table.substring(0,key1);
        String shiftTable2 = table.substring(key2)+table.substring(0,key2);
        for(int i = 0;i<sb.length();i++){
            char currChar = sb.charAt(i);
            if(Character.isLetter(currChar)){
                char replaceChar;
                if(i%2==0) replaceChar = shiftTable1.charAt(table.indexOf(Character.toLowerCase(currChar)));
                else replaceChar = shiftTable2.charAt(table.indexOf(Character.toLowerCase(currChar)));
                if(Character.isUpperCase(currChar)) replaceChar = Character.toUpperCase(replaceChar);
                sb.setCharAt(i, replaceChar);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted2 = encryptTwoKeys(message, 21,8);
        String encrypted = encrypt(message, 15);
        System.out.println(encrypted2);
    }
}