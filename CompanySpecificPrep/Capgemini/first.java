import java.util.*;

class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        if(sc.hasNext()){
            s = sc.nextLine();
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c=='#'){
                sb1.append("#");
            }else{
                sb2.append(c);
            }
        }
        String res = sb1.toString()+sb2.toString();
        for(char c: res.toCharArray()){
            System.out.print(c+ "");
        }
    }
}
