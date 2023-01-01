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
    public Boolean matrizValid(int [][] a,int [][]b){
        final int  rowAL=a.length;
        final int  colAL=a[0].length;
        final int  rowBL=b.length;
        final int  colBL=b[0].length;
        return rowAL==colBL && rowBL==colAL;
    }
    public int  [][] multiplicar(int [][] a,int [][]b){
        final int  rowAL=a.length;
        final int  colAL=a[0].length;
        final int  rowBL=b.length;
        final int  colBL=b[0].length;
         if (!matrizValid(a,b)){
          System.out.println("matrizesInvalidas");
          return null;
         }
         int [][]r=new int [rowAL][colBL];
         for (int rowA=0;rowA < rowAL;rowA++) {
             for (int colB = 0; colB < colBL; colB++) {
                 for (int i = 0; i < colAL; i++) {
                     r[rowA][colB] += a[rowA][i] * b[i][colB];
                 }
             }
         }
            return r;
    }
    public void printArray(int [][]array){
        for (int i = 0;i < array.length;i++){
            for (int k = 0;k < array[0].length;k++){
                System.out.print(" "+array[i][k]);
            }
            System.out.println();
        }
    }
    private boolean checkABCViewed( boolean []abcViewed){
        for (int i=0; i < abcViewed.length;i++){
            if (!abcViewed[i])
                return false;
        }
        return true;
    }
    public boolean isPanagrama(String frase){
        boolean [] abcViewed= new boolean[26];
        String fraseLoCase = frase.toLowerCase();
        char firstLetter='a';
        char lastLetter='z';
        int dif;
        for (int i = 0 ;i < frase.length(); i++){
            dif=fraseLoCase.charAt(i)-firstLetter;
            if (fraseLoCase.charAt(i) < firstLetter || fraseLoCase.charAt(i) > lastLetter || abcViewed[dif])
                continue;
            abcViewed[dif] = true;
        }
        return checkABCViewed(abcViewed);
    }


}
