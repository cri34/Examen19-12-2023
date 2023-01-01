public class TestExamen {
    public static void main(String[] args) {
        Examen e = new Examen();
        System.out.println(e.isPerfect(2));
        e.printFirstPerfectNumbers(2);
        int [][]a={{1,0,0},{3,4,2}};
        int [][]b={{2,1},{0,3},{1,0}};
        e.printArray(e.multiplicar(a,b));
        NumerosRomanos nr = new NumerosRomanos();
        System.out.println(nr.convertRomanNumberToDecimalNumber("MDCLVI"));
        String frase="Watch “Jeopardy!”, Alex Trebek’s fun TV quiz game.";
        System.out.println(e.isPanagrama(frase));

    }
}
