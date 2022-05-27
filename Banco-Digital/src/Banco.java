import java.util.List;

public class Banco {
    private String nomeBanco;
    private List<Conta> contas;
    List<Cliente> clientes;
    
    
    public List<Conta> getContas() {
        return contas;
    }
    public void setContas(Conta conta) {
        this.contas.add(conta);
    }
    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }
    public String getNomeBanco() {
        return nomeBanco;
    }
    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }  
}