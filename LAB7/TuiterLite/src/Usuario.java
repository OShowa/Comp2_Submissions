import org.hamcrest.core.IsEqual;

import java.awt.*;

public class Usuario {

    private final String email;
    private String nome;
    private Image foto;


    public Usuario(String nome, String email) {
        this.email = email;
        this.nome = nome;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto() {
        return this.foto;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean equals(Object o) {

        Usuario outroUsuario = (Usuario) o;

        if (outroUsuario.email == this.email) return true;

        return false;

    }

}
