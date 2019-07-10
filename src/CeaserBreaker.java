public class CeaserBreaker{
    public static int countLetter(String str){
        int[] letterTable = new int[26];
        for(int i = 0;i<str.length();i++){
            char currChar = str.charAt(i);
            currChar = Character.toLowerCase(currChar);
            int indexOfLetter = "abcdefghijklmnopqrstuvwxyz".indexOf(currChar);
            if(indexOfLetter != -1) letterTable[indexOfLetter] +=1;
        }
        return maxIndex(letterTable);
    }
    public static int maxIndex(int[] arr){
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
    public static int getKey(String str){
        int indexOfE = countLetter(str);
        int key = indexOfE-4;
        if(key < 0) key = 26+key;
        return key;
    }
    public static String[] getDividedStr(String str){
        StringBuilder strFirst = new StringBuilder("");
        StringBuilder strSecond = new StringBuilder("");
        for(int i = 0;i<str.length();i++){
            if(i%2==0) strFirst.append(str.charAt(i));
            else strSecond.append(str.charAt(i));
        }
        String[] dividedStr = {strFirst.toString(),strSecond.toString()};
        return dividedStr;
    }
    public static int[] getTwoKeys(String str){
        String[] dividedStr = getDividedStr(str);
        int indexOfE1 = countLetter(dividedStr[0]);
        int indexOfE2 = countLetter(dividedStr[1]);
        int key1 = indexOfE1-4;
        if(key1 < 0) key1 = 26+key1;
        int key2 = indexOfE2-4;
        if(key1 < 0) key2 = 26+key2;
        int[] keys = {key1,key2};
        return keys;
    }
    public static String decrypt(String encrypted, int key){
        String message = CeaserCipher.encrypt(encrypted, 26-key);
        return message;
    }
    public static String decrypt2Keys(String encrypted, int key1,int key2){
        String message = CeaserCipher.encryptTwoKeys(encrypted, 26-key1, 26-key2);
        return message;
    }
    public static void main(String[] args) {
        // String encrypted = "Brx vkrxog vwduw eb zulwlqj wkh ghfubswlrq phwkrg hasodlqhg lq wkh ohvvrq wkdw ghfubswv d phvvdjh wkdw zdv hqfubswhg zlwk rqh nhb, xvlqj vwdwlvwlfdo ohwwhu iuhtxhqflhv ri Hqjolvk whaw. Wkhq brx zloo dgg frgh wr eh deoh wr ghfubsw d phvvdjh wkdw zdv hqfubswhg zlwk wzr nhbv, xvlqj lghdv iurp wkh vlqjoh nhb ghfubswlrq phwkrg dqg wkh hqfubswlrq zlwk wzr nhbv phwkrg iurp wkh surjudp brx zurwh lq wkh odvw ohvvrq.Lghd iru wzr nhbv ghfubsw phwkrg. Uhfdoo wkdw lq xvlqj wzr nhbv, nhb1 dqg nhb2, nhb1 zdv xvhg wr hqfubsw hyhub rwkhu fkdudfwhu, vwduwlqj zlwk wkh iluvw, ri wkh Vwulqj, dqg nhb2 zdv xvhg wr hqfubsw hyhub rwkhu fkdudfwhu, vwduwlqj zlwk wkh vhfrqg. Lq rughu wr ghfubsw wkh hqfubswhg Vwulqj, lw pdb eh hdvlhu wr vsolw wkh Vwulqj lqwr wzr Vwulqjv, rqh Vwulqj ri doo wkh ohwwhuv hqfubswhg zlwk nhb1 dqg rqh Vwulqj ri doo wkh ohwwhuv hqfubswhg zlwk nhb2. Wkhq xvh wkh dojrulwkp iurp wkh ohvvrq wr ghwhuplqh wkh nhb iru hdfk Vwulqj, dqg wkhq xvh wkrvh nhbv dqg wkh wzr nhb hqfubswlrq phwkrg wr ghfubsw wkh ruljlqdo hqfubswhg phvvdjh.Iru hadpsoh, li wkh hqfubswhg phvvdjh zdv “Tenp Cjlv”, wkhq brx zrxog vsolw wklv Vwulqj lqwr wzr Vwulqjv: “Tn jv”, uhsuhvhqwlqj wkh fkdudfwhuv lq wkh rgg qxpehu srvlwlrqv dqg “epCl” uhsuhvhqwlqj wkh fkdudfwhuv lq wkh hyhq qxpehu srvlwlrqv. Wkhq brx zrxog jhw wkh nhb iru hdfk kdoi Vwulqj dqg xvh wkh wzr nhb hqfubswlrq phwkrg wr ilqg wkh phvvdjh. Qrwh wklv hadpsoh lv vr vpdoo lw olnhob zrq’w ilqg wkh nhbv, exw lw looxvwudwhv krz wr wdnh wkh Vwulqjv dsduw.";
        // int key = getKey(encrypted);
        // String decrypted = decrypt(encrypted, key);
        // System.out.println(decrypted);
        String encrypted2Keys = "Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin，Sei sw klv deec lrpcqrvbw sw fyi jytgvwj yej sivr jiyzxwyc tscprffvrxzsew edsek hzjwiiiex kisltj nmklzr xyi hvtrvkqvrk, azxy iijirvtl kisltj zr sklvv hvtrvkqvrkw ek Uybi, nmkl sklvv mewkmkykij, eeh azxy zruyjxic. Rw av dsmi mexf klv zrwsiqrxzse rkv, xyi jfglw sw jgziegv zw wymwxzrx wvfq xyi hzwtsmiic sw ein zrwsiqrxzse ks xyi gfqgykekmfrrpcc mexvrjmmi xrwb fj tistijwzrx rru rrrppdzrx zrwsiqrxzse.Ni lrzv fykwkeehzrx gvfkiedw me xifqvximt tsdtlxzrx; mexvveik jcjxvqj, rvxnsiozrx, eeh wvglvzxp; fzscsxmtec tsdtlxzrx; qvqfvp jcjxvqj rru dejwzzv ueke qrrrkvqvrk; eeh pveirzrx rru dsuicmek. Klv iijirvtl mexvvvwkw sw fyi wetycxp fzvvceg nmkl xyiji eiirw eeh azxy iijirvtlvv eiirw me fxyii umjgztcmeij jytl ej smfpfkp, iekzrviimek, eeeskitlescsxc, rru vrmmiseqvrkec jgziegvw.GJ Uigx Tysks Av rpjs hf nsio me r eydfvv sw fxyii zqgsixrrk rvvej zrtplhzrx tsdtlxvv kieglzgj rru mmjyrpzdrxzse, wvrjsi eikafvbw, eydiimtec rrrppwzw, jswxneii iekzrviimek, tsdtciomkc xyifvp, eeh vfffxzgj.Klv uigeixdiex mj rvxyrfcc yemhyv zr xyi wpqsmfwzw xyek vbzwkw fvxnivr xyi iuytekmfr kislt eeh xyi vvwveigy wetycxp. Xyi wprvvxc fvxnivr xyid yej sivr e ovc xf klv jytgvwj zr gfrkmeyrpcc vvjfvdmek xyi glvimtycyd rru zrkixvrxzrx iijirvtl eeh iuytekmfr. Klv uigeixdiex mj lwzrx r uyrp egtisrgy ks gfqsmei vvwveigy rru vhlgrxzse. Fimekzrx iijirvtl mexf klv tyivzglplq mj klv sijx arc xf kvrme jxlhvrkw esslx xyi qfwk rhmeegvh xvgyrfpfkp rru ks hzwjidmeeki xyi prxvwk uimicsgqvrkw sw tsdtlxzrx kitlescsxc me jstmvxp.TW Hvtk Glfxf Ni iegfyiexi yehvvxvrhleki wkyuiexj ks kvx mezfpmiu nmkl sekfmek qrnfv vvwveigy gvfnvgkw xyvfyxl xyi G-WLVW gvfkied, yehvvxvrhleki xyijij, Vvwveigy Vbgiimvrti jfv Yehvvxvrhlekij (VVY) jygtfvk, mehvtvruiex wkyumvw, vxt. Wfqv fj slv iogvtkmfrrp jzvjx qrnfvj xvrhleki azxy umjxzrtxzse, aymtl mezfpmij r jmxrzjzgrrk iijirvtl gfqgseiex, rru zr qrrp tejij klv iijirvtl lrw vvwlpkiu zr tlfcmtekmfrj zr pveumek gfrwiiiegvw.Xyi idmeiegv fj slv vvwveigy rru kirgymek jrglpkc mj klv smxkvwk jxiiekkl sw klv uigeixdiex. Deec jrglpkc qvqsiiw lrzv sivr vvgfkemqiu sskl ek lrzzvvjmkc eeh rrxzseec cimicw jfv xyizv iogvpciegv zr vvwveigy, iuytekmfr, rru jiizzgv. Lzkypp mmjmspv, qlpkmumjgztcmeeic tisaitxj rvv sizrx tsehlgkiu, wgsewfvvh fp meimfyj wyehzrx rkvrtmvw.Xyi hvtrvkqvrk gvfzzhvw ee vbkvvqvpp jxzqlprxzrx, tisuytxzzv, eeh jimvrupp vrmmiseqvrk zr xyi jfvd fj gcejwisfq, fjwmti, rru ces jtrgv; gfqgykmek mejiejxiytxlvv; xvetlzrx jygtfvk; eeh kieuyrxv wicpfajlztj rru rwjmjxrrkwymgw. Zx ieespvw jrglpkc eeh wkyuiexj ks etgfqgpzwy klvmi wycp tfxvrkmrp. Klv uigeixdiex mj tsewkvlgkiu ks iegfyiexi merfzrxzzv tscprffvrxzsew edsek xyi wtmvrtij, iekzrviimek, vrmmiseqvrkec jxlhzij, eeh qvhzgzrv.";
        int[] keys = getTwoKeys(encrypted2Keys);
        String decrypted2Keys = decrypt2Keys(encrypted2Keys, keys[0], keys[1]);
        // String decrypted2Keys = decrypt2Keys("Hfs cpwewloj loks cd Hoto kyg Cyy.", 14, 24);
        System.out.println(keys[0]);
        System.out.println(keys[1]);
        System.out.println(decrypted2Keys);

    }
}