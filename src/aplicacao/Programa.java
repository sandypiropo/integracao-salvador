package aplicacao;

import entidades.Metro;
import entidades.Onibus;
import entidades.OnibusUrbano;
import entidades.Usuario;

import java.util.Scanner;

import static entidades.Usuario.encontrarUsuarioPorId;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int escolha;

        System.out.println("\n" +
                "▀█▀ █▀▀▄ ▀▀█▀▀ █▀▀ █▀▀▀ █▀▀█ █▀▀█ █▀▀ █▀▀█ █▀▀█ 　 ░█▀▀▀█ █▀▀█ █── ▀█─█▀ █▀▀█ █▀▀▄ █▀▀█ █▀▀█ \n" +
                "░█─ █──█ ──█── █▀▀ █─▀█ █▄▄▀ █▄▄█ █── █▄▄█ █──█ 　 ─▀▀▀▄▄ █▄▄█ █── ─█▄█─ █▄▄█ █──█ █──█ █▄▄▀ \n" +
                "▄█▄ ▀──▀ ──▀── ▀▀▀ ▀▀▀▀ ▀─▀▀ ▀──▀ ▀▀▀ ▀──▀ ▀▀▀▀ 　 ░█▄▄▄█ ▀──▀ ▀▀▀ ──▀── ▀──▀ ▀▀▀─ ▀▀▀▀ ▀─▀▀");

        Usuario usuario = new Usuario();
        Onibus onibus = new Onibus();
        Metro metro = new Metro();
        OnibusUrbano onibusUrbano = new OnibusUrbano();

        do {
            System.out.println("Selecione uma das opções: ");
            System.out.println("[0] Comprar cartão");
            System.out.println("[1] Onibus");
            System.out.println("[2] Metro");
            System.out.println("[3] Onibus Urbano");
            System.out.println("[4] Recarregar cartão");
            System.out.println("[5] SAIR");

            escolha = sc.nextInt();

            switch (escolha) {
                case 0:
                    usuario = new Usuario();
                    Usuario.adicionarUsuario(usuario);
                    System.out.println("Cartão criado com sucesso!, ID do cartão: " + usuario.getIdCartao());
                    break;
                case 1:
                    onibus.cobrarPassagem(usuario);
                    System.out.println("Pegando ônibus, passagem cobrada: " + onibus.getPassagem());
                    System.out.println("Novo saldo: " + usuario.getCredito());
                    // valor do credito nao esta sendo atualizado
                    System.out.println(usuario);
                    break;
                case 2:
                    metro.cobrarPassagem(usuario);
                    break;
                case 3:
                    onibusUrbano.cobrarPassagem(usuario);
                    break;
                case 4:
                    System.out.println("Insira o número do seu cartão: ");
                    int idCartao = sc.nextInt();
                    Usuario usuarioParaRecarga = encontrarUsuarioPorId(idCartao);
                    if (usuarioParaRecarga != null) {
                        System.out.println("Valor recarga: ");
                        double valorRecarga = sc.nextDouble();
                        usuarioParaRecarga.recarregarCartao(valorRecarga);
                    } else {
                        System.out.println("Cartão não encontrado. Verifique o número do cartão.");
                    }
                    break;
                case 5:
                    System.out.println("SAINDO");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
            }
        } while (escolha != 5);

        System.out.println(usuario);

    }
}
