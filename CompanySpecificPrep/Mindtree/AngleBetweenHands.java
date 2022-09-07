// You are using Java
import java.util.*;
class MyClass{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = "";
        if(sc.hasNext()){
            s = sc.nextLine();
        }
        float hour = Float.parseFloat(s.substring(0,2));
        float min = Float.parseFloat(s.substring(3));
        float hour_angle = (float)(0.5*(hour*60 + min));
        float minute_angle = (float)(6*min);
        float angle = Math.abs(hour_angle - minute_angle);
        angle = Math.min(360-angle, angle);
        System.out.println(angle);
    }
}
