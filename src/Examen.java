public class Examen {
    public boolean isPerfect(int num) {
        int r = 0;
        if (num <= 1) {
            return false;
        }
        for (int d = 1; d < num; d++) {
            if (num % d == 0)
                r += d;
        }
        return r == num;
    }
    public void printFirstPerfectNumbers(int quantityPerfects){
        int countPerfects=0;
        for (int num = 2;countPerfects < quantityPerfects;num++ ){
            if (isPerfect(num)){
                System.out.println(num);
                countPerfects++;
            }

        }
    }
}
