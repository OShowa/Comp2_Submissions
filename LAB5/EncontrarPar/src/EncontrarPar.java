import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class EncontrarPar {

    // uma lista para testar o método.
    private static List<Integer> lista = Arrays.asList(1, 5, -10, 56, 44, 12, 18);

    public static void encontrarPar(List<Integer> lista, int k) {

        HashSet<Integer> setInteiros = new HashSet<>();

        for (int n : lista) {
            setInteiros.add(n);
        }

        for (int n : lista) {
            int diferenca = k - n;
            if (setInteiros.contains(diferenca)) {
                System.out.printf("%d, %d", n, diferenca);
                break;
            }
        }

    }

    public static void main(String[] args) {

        encontrarPar(lista, 46);

    }


}
