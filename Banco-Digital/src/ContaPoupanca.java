public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void renderSaldo(){
        super.saldo *= 1.2;
    }

    @Override
    void imprimirExtrato() {
        System.out.println("-=-=Extrato da Conta Poupança=-=-");
        super.imprimirInfosComuns(); 
    }
    
}
