public class TestExamen {
    public static void main(String[] args) {
        Examen e = new Examen();
        System.out.println(e.isPerfect(2));
        e.printFirstPerfectNumbers(5);
        int [][]a={{1,0,0},{3,4,2}};
        int [][]b={{2,1},{0,3},{1,0}};
        e.printArray(e.multiplicar(a,b));

    }
}
