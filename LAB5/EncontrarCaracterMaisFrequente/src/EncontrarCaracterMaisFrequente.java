import java.util.Collections;
import java.util.HashMap;

public class EncontrarCaracterMaisFrequente {

    private static final String inputString = "abcdefghijklmnopqrstuvwxyz";

    private static HashMap<Character, Integer> quantidadeByCaracter = new HashMap<>();

    public static void main(String[] args) {
        encontrarCaracterMaisFrequente(inputString);
    }

    public static void encontrarCaracterMaisFrequente(String string) {

        int maiorQuantidade = 1;
        char caracterMaisComum = inputString.charAt(0);

        for (int i = 0; i < inputString.length(); i++) {
            char caracter = inputString.charAt(i);
            if (quantidadeByCaracter.containsKey(caracter)) {
                int quantidade = quantidadeByCaracter.get(caracter) + 1;
                if (quantidade > maiorQuantidade) {
                    maiorQuantidade = quantidade;
                    caracterMaisComum = caracter;
                }
                quantidadeByCaracter.put(caracter, quantidade);
            } else quantidadeByCaracter.put(caracter, 1);
        }

        System.out.printf("%c, %d", caracterMaisComum, maiorQuantidade);


    }

}
