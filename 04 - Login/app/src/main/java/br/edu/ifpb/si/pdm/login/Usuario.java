package br.edu.ifpb.si.pdm.login;

/**
 * Created by admin on 21/05/16.
 */
public class Usuario {
    private String login, senha;

    public Usuario(String login, String senha) {
        this.senha = senha;
        this.login = login;
    }

    public boolean autenticar(String login, String senha){
        return this.login.equalsIgnoreCase(login) && this.senha.equals(senha);
    }
}
