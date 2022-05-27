abstract public class Conta implements IConta{
    private int nroConta, nroCartao;
    private String agencia;
    protected double saldo;
    private static int sequencialConta = 1, sequencialCartao = 100;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = "0001";
        this.nroConta = sequencialConta++;
        this.saldo = 0d;
        this.nroCartao = sequencialCartao++;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        
    }
    @Override
    public void sacar(double valor) {
        saldo -= valor;
        
    }
    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);        
    }

    abstract void imprimirExtrato();

    public void imprimirInfosComuns(){
        System.out.printf("Titular: %s\nAgência: %s\nNúmero da conta: %d\nSaldo: %.2f", this.cliente,this.agencia, this.nroConta, this.saldo);
    }


    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public int getNroConta() {
        return nroConta;
    }
    public void setNroConta(int nroConta) {
        this.nroConta = nroConta;
    }
    public int getNroCartao() {
        return nroCartao;
    }
    public void setNroCartao(int nroCartao) {
        this.nroCartao = nroCartao;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    

}
