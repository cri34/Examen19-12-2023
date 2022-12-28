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
}
