import java.util.*;

/**
 *  Esta classe implementa um sistema de mensagens curtas estilo Twitter.
 *  É preciso cadastrar um usuário, identificado pelo seu e-mail, para que tuítes possam ser feitos.
 *  Usuários começam como iniciantes, depois são promovidos a senior e a ninja, em função do número de tuítes.
 *  Existe um tamanho máximo permitido por mensagem (constante TAMANHO_MAXIMO_TUITES).
 *  As mensagens podem conter hashtags (palavras iniciadas por #), que são detectadas automaticamente.
 *  Os tuítes podem conter, além da mensagem de texto, um anexo qualquer.
 *  Há um método para retornar, a qualquer momento, qual a hashtag mais usada em toda a história do sistema.
 */
public class TuiterLite {

    public static int TAMANHO_MAXIMO_TUITES = 120;

    private static HashMap<String, Usuario> usuarioByEmail = new HashMap<>();

    private static HashMap<String, Integer> quantidadeByHashtag = new HashMap<>();

    private static String hashtagMaisComum = null;

    private static int quantidadeHashtagMaisComum = 0;

    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * @param nome O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    public Usuario cadastrarUsuario(String nome, String email) { // throws UsuarioJaExisteException {

        if (usuarioByEmail.containsKey(email)) return usuarioByEmail.get(email);

        Usuario usuario = new Usuario(nome, email);

        usuarioByEmail.put(email, usuario);

        // ToDo IMPLEMENT ME!!!
        return usuario;
    }

    /**
     *
     * @param usuario O autor do tuíte
     * @param texto O texto desejado
     * @return Um "tuíte", que será devidamente publicado no sistema
     *
     * PS.: Se o texto exceder o limite pré-definido, ou o usuário não estiver cadastrado, return null
     */
    public Tuite tuitarAlgo(Usuario usuario, String texto) {

        if (texto.length() > TAMANHO_MAXIMO_TUITES) return null;

        String[] hashtags = texto.split("#");

        Set<String> hashtagsSet = new HashSet<>(Arrays.asList(hashtags));

        hashtagsSet.remove(hashtags[0]);

        for (int i = 1; i < hashtags.length; i++) {

            String hashtagAtual = hashtags[i];

            hashtagsSet.remove(hashtagAtual);
            hashtagAtual = "#" + hashtagAtual.split("\\s")[0];
            hashtagsSet.add(hashtagAtual);

            if (quantidadeByHashtag.containsKey(hashtagAtual)) {
                quantidadeByHashtag.put(hashtagAtual, quantidadeByHashtag.get(hashtagAtual) + 1);
            } else quantidadeByHashtag.put(hashtagAtual, 1);

            if (quantidadeByHashtag.get(hashtagAtual) > quantidadeHashtagMaisComum) {
                quantidadeHashtagMaisComum = quantidadeByHashtag.get(hashtagAtual);
                hashtagMaisComum = hashtagAtual;
            }

        }

        // ToDo IMPLEMENT ME!!!
        return new Tuite(usuario, texto, hashtagsSet);
    }

    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {
        // ToDo IMPLEMENT ME!!!
        return hashtagMaisComum;
    }
}
