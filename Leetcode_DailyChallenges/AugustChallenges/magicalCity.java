public class magicalCity {
    
    static boolean divisor(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd <= 1;
    }
    static int check(int[] input1, int input2){
        for (int i = 0; i < input1.length - 1; i++) {
            if (input1[i] > input1[i + 1] && divisor(input1[i], input1[i + 1])) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]input1 = {4,1,3,2};
        magicalCity obj1 = new magicalCity();
        System.out.print(obj1.check(input1, input1.length));
    }
}
