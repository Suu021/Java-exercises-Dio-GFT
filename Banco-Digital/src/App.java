import java.util.Calendar;
import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);
    static Calendar data = Calendar.getInstance();
    static Banco DigiBank = new Banco();
    //DigiBank.setNomeBanco("DigiBank");

    public static void menuPrincipal(){
        int opcao;
        System.out.println("1- Fazer Cadastros;\n2- Entrar na conta corrente ou conta poupança\n3- Sair\nOpcao: ");
        opcao = scan.nextInt();
        switch(opcao){
            case 1:{
                menuCadastro();
                break;
            }
            case 2:{
                int nroConta;
                System.out.println("Informe o número da conta corrente ou poupança para a logar: ");
                nroConta = scan.nextInt();
                menuConta(nroConta);
                break;
            }
            case 3:{
                fecharApp();
                break;
            }
            default:
                System.out.println("opção inválida!");
        }
    }


    private static void menuConta(int nroConta) {
        System.out.println("-=-=-=Bem vindo(a) à sua conta corrente=-=-=-");
        int opcao;
        double valor;
        Conta cc;
        for(Conta conta: DigiBank.getContas()){
            if(conta.getNroConta() == nroConta){
                cc = conta;
                System.out.println("1- Fazer depósitos;\n2- Fazer saques\n3- Ver Extrato\n4- Sair\nOpcao: ");
                opcao = scan.nextInt();
                switch(opcao){
                    case 1:{
                        System.out.println("Informe o valor que deseja depositar: R$");
                        valor = scan.nextDouble();
                        cc.depositar(valor);
                        break;
                    }
                    case 2:{
                        System.out.println("Informe o valor que deseja sacar: R$");
                        valor = scan.nextDouble();
                        cc.sacar(valor);
                        break;
                    }
                    case 3:{
                        cc.imprimirExtrato();
                        break;
                    }
                    case 4:{
                        menuPrincipal();
                        break;
                    }
                    default:
                        System.out.println("opção inválida!");
                }
            }
        }
        
        
    }

    private static void menuCadastro() {
        int opcao;
        System.out.println("-=-=-=Menu de Cadastros=-=-=-");
        System.out.println("1- Casdastrar novo cliente;\n2- Cadastrar nova Conta Corrente e Conta Poupança\nOpção: ");
        opcao = scan.nextInt();
        switch(opcao){
            case 1:{
                DigiBank.setClientes(cadastrarNovoCliente());
                break;
            }
            case 2:{
                String cpf;
                Cliente cliente;
                System.out.println("Para o cadastro de contas é necessário informar o CPF do cliente: ");
                cpf = scan.nextLine();
                for(Cliente clienteCPF: DigiBank.getClientes()){
                    if(clienteCPF.getCpf() == cpf){
                        cliente = clienteCPF;
                        Conta conta = cadastrarContaCorrente(cliente);
                        System.out.println("Seu nro de conta corrente é: " + conta.getNroConta() + " guarde em algum lugar!\n");
                        DigiBank.setContas(conta);
                        conta = cadastrarContaPoupanca(cliente);
                        System.out.println("Seu nro de conta poupança é: " + conta.getNroConta() + " guarde em algum lugar!\n");
                        DigiBank.setContas(conta);
                        break;
                    }
                    else
                        System.out.println("Cliente não cadastrado no banco, falha na criação de contas!");
                }                
                break;
            }
            case 3:{
                menuPrincipal();
                break;
            }
            default:
                System.out.println("opção inválida!");
        }
    }


    private static void fecharApp() {
        System.out.println("Saindo...");
    }


    private static Conta cadastrarContaPoupanca(Cliente cliente) {
        Conta cp = new ContaPoupanca(cliente);
        return cp;
    }


    private static Conta cadastrarContaCorrente(Cliente cliente) {
        Conta cc = new ContaCorrente(cliente);
        return cc;
    }


    private static Cliente cadastrarNovoCliente() {
        System.out.println("Nome: ");
        String nome = scan.nextLine();
        System.out.println("\nCPF: ");
        String cpf = scan.nextLine();
        System.out.println("data de nascimento: ");
        String dataString = scan.nextLine();
        String[] listaData = dataString.split("/");
        data.set(Integer.parseInt(listaData[2]), Integer.parseInt(listaData[1]), Integer.parseInt(listaData[0]));
        Cliente cliente = new Cliente(nome, cpf, data);
        return cliente;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("-=-=-=-=-=Bem vindo(a) ao Banco Digital=-=-=-=-=-");

        menuPrincipal();
        
        
        //data.set(1986, Calendar.SEPTEMBER, 16);
        //Cliente Silva = new Cliente("Raimundo", "123", data);


    }
}
