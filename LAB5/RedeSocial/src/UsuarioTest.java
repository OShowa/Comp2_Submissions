import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsuarioTest {

    private CalculadorIntersecao calculadorIntersecaoEsperto = new CalculadorIntersecaoEsperto();
    private CalculadorIntersecao calculadorIntersecaoViaBuscaBinaria = new CalculadorIntersecaoViaBuscaBinaria();
    private CalculadorIntersecao calculadorIntersecaoIngenuo = new CalculadorIntersecaoIngenuo();

    private Usuario usuario1 = new Usuario(1, calculadorIntersecaoEsperto);
    private Usuario usuario2 = new Usuario(2, calculadorIntersecaoViaBuscaBinaria);
    private Usuario usuario3 = new Usuario(3, calculadorIntersecaoIngenuo);
    private Usuario usuarioTeste = new Usuario(0, calculadorIntersecaoEsperto);

    @Before
    public void setUp() {

        for (int i = 4; i <= 10000; i++) {
            Usuario usuarioGenerico = new Usuario(i, calculadorIntersecaoIngenuo);
            usuario1.adicionarAmigos(usuarioGenerico);
            usuarioTeste.adicionarAmigos(usuarioGenerico);

            if ((i >= 50) && (i <= 6000)) {
                usuario2.adicionarAmigos(usuarioGenerico);
            }

            if ((i >= 400) && (i <= 6500)) {
                usuario3.adicionarAmigos(usuarioGenerico);
            }
        }

    }

    @Test
    public void testarCalculadorIntersecaoEsperto() {
        int amigosEmComum1_2 = usuario1.obterQuantidadeDeAmigosEmComum(usuario2);
        int amigosEmComum1_3 = usuario1.obterQuantidadeDeAmigosEmComum(usuario3);

        assertEquals("Quantidade de amigos em comum entre 1 e 2 está incorreta!",
                5951, amigosEmComum1_2);

        assertEquals("Quantidade de amigos em comum entre 1 e 3 está incorreta!",
                6101, amigosEmComum1_3);

    }

    @Test
    public void testarCalculadorIntersecaoViaBuscaBinaria() {
        int amigosEmComum2_1 = usuario2.obterQuantidadeDeAmigosEmComum(usuario1);
        int amigosEmComum2_3 = usuario2.obterQuantidadeDeAmigosEmComum(usuario3);

        assertEquals("Quantidade de amigos em comum entre 2 e 1 está incorreta!",
                5951, amigosEmComum2_1);

        assertEquals("Quantidade de amigos em comum entre 2 e 3 está incorreta!",
                5601, amigosEmComum2_3);

    }

    @Test
    public void testarCalculadorIntersecaoIngenuo() {
        int amigosEmComum3_1 = usuario3.obterQuantidadeDeAmigosEmComum(usuario1);
        int amigosEmComum3_2 = usuario3.obterQuantidadeDeAmigosEmComum(usuario2);

        assertEquals("Quantidade de amigos em comum entre 3 e 1 está incorreta!",
                6101, amigosEmComum3_1);

        assertEquals("Quantidade de amigos em comum entre 3 e 2 está incorreta!",
                5601, amigosEmComum3_2);

    }

    @Test
    public void testarPerformance() {

        // para usar os mesmos valores, usarei o metódo setCalculadorIntersecao, criado na classe Usuario.

        double duracao = obterDuracao(usuarioTeste, usuario3)/1000.0;
        System.out.printf("Calculador esperto durou %.3f segundos.\n", duracao);

        usuarioTeste.setCalculadorIntersecao(calculadorIntersecaoViaBuscaBinaria);
        duracao = obterDuracao(usuarioTeste, usuario3)/1000.0;
        System.out.printf("Calculador via busca binária durou %.3f segundos.\n", duracao);

        usuarioTeste.setCalculadorIntersecao(calculadorIntersecaoIngenuo);
        duracao = obterDuracao(usuarioTeste, usuario3)/1000.0;
        System.out.printf("Calculador ingênuo durou %.3f segundos.\n", duracao);

    }

    public long obterDuracao(Usuario usuarioCalculante, Usuario usuarioCalculado) {
        long inicio = System.currentTimeMillis();
        usuarioCalculante.obterQuantidadeDeAmigosEmComum(usuarioCalculado);

        return System.currentTimeMillis() - inicio;
    }
}
