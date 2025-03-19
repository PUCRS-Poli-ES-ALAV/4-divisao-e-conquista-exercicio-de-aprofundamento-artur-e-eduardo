import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] lista = { 1, 5, 4, 6, 5, 3, 2, 8 };
        for (int num : mergeSort(lista)) {
            System.out.print(num);
        }
    }

    public static int[] mergeSort(int[] lista) {
        int tamanho = lista.length;
        if (tamanho <= 1) {
            return lista;
        } else {
            int[] A = mergeSort(Arrays.copyOfRange(lista, 0, tamanho / 2));

            int[] B = mergeSort(Arrays.copyOfRange(lista, tamanho / 2 + 1, tamanho));

            lista = merge(A, B);
            return lista;
        }
    }

    public static int[] merge(int[] A, int[] B) {
        int[] resultante = new int[A.length + B.length];
        int j = 0;
        int k = 0;

        for(int i = 0; i < resultante.length - 2; i ++){
            if(A[j] <= B[k]){
                resultante[i] = A[j];
                j++;
            }
            else{
                resultante[i] = B[k];
                k++;
            }
        }
        return resultante;
    }
}
