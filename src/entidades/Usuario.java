package entidades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private static int proximoIdCartao = 1;
    private int idCartao;
    private double credito;

    private double valorRecarga;

    // Lista para rastrear todos os usuários
    private static List<Usuario> usuarios = new ArrayList<>();

    public Usuario() {
        this.idCartao = novoCartao();
        this.credito = 0.0;
        this.valorRecarga = 0.0;
    }

    public Usuario(double credito) {
        this.idCartao = novoCartao(); // Gera um novo ID de cartão
        this.credito = credito;
    }

    public void recarregarCartao(double valorRecarga) {
        this.valorRecarga = valorRecarga;
        this.credito += valorRecarga;
    }
    public static Usuario encontrarUsuarioPorId(int idCartao) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdCartao() == idCartao) {
                return usuario;
            }
        }
        return null;
    }

    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    public static int novoCartao() {
        return proximoIdCartao++;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double valorPassagem) {
        this.credito = credito;
    }

    public double getValorRecarga() {
        return valorRecarga;
    }

    public void setValorRecarga(double valorRecarga) {
        this.valorRecarga = valorRecarga;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    @Override
    public String toString() {
        return "Usuario " +
                "idCartao = " + idCartao +
                ", credito = " + credito +
                ", valor Recarga =" + valorRecarga;
    }

}
