package table;

public class BubbleSort {

    public static int[] getas(String teks, int jumlah){
        int num, i, j, temp;
        num = jumlah;
        int array[] = new int[num];
        String[] ult = teks.split(",");
        int a = 0;
        for (String s : ult){
            array[a] = Integer.parseInt(s.trim());
            a++;
        }
        for (i = 0; i < ( num - 1 ); i++) {
            for (j = 0; j < (num - i - 1); j++) {
                if (array[j] > array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] getdes(String teks, int jumlah){
        int num, i, j, temp;
        num = jumlah;
        int array[] = new int[num];
        String[] ult = teks.split(",");
        int a = 0;
        for (String s : ult){
            array[a] = Integer.parseInt(s.trim());
            a++;
        }
        for (i = 0; i < ( num - 1 ); i++) {
            for (j = 0; j < num - i - 1; j++) {
                if (array[j] < array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
