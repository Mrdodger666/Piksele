import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.channels.ScatteringByteChannel;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[][] macierz = readData();

        int g=2;
        String s=g+"";

        int najjasniejszyPiksel=findMax(macierz);
        int najciemniejszyPiksel=findMin(macierz);

        int numberOfRows=countAsymmetricRows(macierz);
        System.out.println(numberOfRows);

    }
    public static int countAsymmetricRows(int[][] matrix){
        int count=0;
        for(int[] row : matrix){
            if(!isRowSymmetric(row)){
                count++;
            }
        }
        return count;
    }

    public static boolean isRowSymmetric(int[] row){
        for (int i=0; i<row.length/2; i++){
            if (row[i]!=row[row.length-i-1]){
                return false;
            }
        }
        return true;
    }
        public static int findMax(int[][] macierz){
        int max=macierz[0][0];
        for(int i=0; i<macierz.length; i++) {
            for (int j = 0; j < macierz[i].length; j++) {
                if (macierz[i][j] > max) {
                    max = macierz[i][j];
                }
            }
        }
        return max;
    }
        public static int findMin(int[][] macierz){
        int min=macierz[0][0];
        for(int i=0; i<macierz.length; i++) {
            for (int j = 0; j < macierz[i].length; j++) {
                if (macierz[i][j] < min) {
                    min = macierz[i][j];
                }
            }
        }
        return min;
    }


        public static int[][] readData() {
        int[][] macierz=new int[200][320];

            try {
                FileReader fr = new FileReader("C:\\Users\\l0857\\IdeaProjects\\Piksele\\dane.txt");
                BufferedReader br = new BufferedReader(fr);

                String line = br.readLine();
                int wierszIndx=0;
                while (line != null) {
                    String[] liczby = line.split("");
                    int[] wierszliczby=parseRowIntoInts(liczby);
                    macierz[wierszIndx++]=wierszliczby;

                    line = br.readLine();

                }


            } catch (FileNotFoundException exc) {
                System.out.println("Plik nie istnieje");
            } catch (Exception exc) {
                System.out.println("Problem z pobieraniem pliku");
            }
            return macierz;
        }

        public static int[] parseRowIntoInts(String[] numsStr){
            int[] result=new int[320];
            for(int i=0; i<numsStr.length; i++){
                int n=Integer.parseInt(numsStr[i]);
                result[i]=n;
            }
            return result;
            }



}