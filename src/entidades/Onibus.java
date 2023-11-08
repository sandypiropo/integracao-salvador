package entidades;

public class Onibus extends Transporte {
    private double passagem = 4.90;
    private double novoCredito;
    @Override
    public void cobrarPassagem(Usuario usuario) {
        System.out.println("Pegando onibus...");
        if (usuario.getCredito() >= this.passagem) {
            novoCredito = usuario.getCredito() - this.passagem;
            usuario.setCredito(novoCredito);
            System.out.println("Passagem cobrada com sucesso. Novo saldo: " + novoCredito);
        } else {
            System.out.println("Saldo insuficiente. Recarregue o cartão para cobrar a passagem.");
        }
    } // valor da passagem nao esta sendo descontada

    public double getPassagem() {
        return passagem;
    }

}
