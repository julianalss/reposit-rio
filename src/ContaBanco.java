
public class ContaBanco {
    
    //Atributos
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    private String stts;
    
    //Construtor
    public void ContaBanco() {
        this.setSaldo(0);
        this.setStatus(false);
    }
    
    //Métodos Personalizados
    public void estadoAtual() {
        if (this.getStatus() == true) {
            stts = "Aberta";
        } else {
            stts = "Fechada";
        }
        
        System.out.println("Status: " + stts);
        System.out.println("Dono: " + this.getDono());
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo da conta: " + this.getTipo());
        System.out.printf("Saldo: R$%.2f", this.getSaldo());
        System.out.println("");
        
    }
    
    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if (t == "CC") {
            this.setSaldo(50);
        } else if (t == "CP") {
             this.setSaldo(150);             
        }
        System.out.println("Conta aberta com sucesso!");
        System.out.println("-------------------------");
    }
    
    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.printf("A conta não pode ser fechada pois ainda há dinheiro nela");
            System.out.println("");
        } else if (this.getSaldo() < 0) {
            System.out.printf("A conta não pode ser fechada pois ainda há um débito de R$%.2f.", this.getSaldo());
            System.out.println("");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }
    
    public void depositar(float v) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + v);
            System.out.printf("Depósito de R$%.2f realizado com sucesso.", v);
            System.out.println("");
        } else {
            System.out.println("Impossível depositar em uma conta fechada.");
        }
        
    }
    
    public void sacar(float v) {
        if (this.getStatus()) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.printf("Saque de R$%.2f realizado com sucesso.", v);
                System.out.println("");
            } else {
                System.out.printf("Saldo insuficiente para realizar o saque de R$%.2f." , v);
                System.out.println("");
            }
        } else {
            System.out.println("Impossível realizar o saque de uma conta fechada.");
        }
    } 
    
    public void pagarMensal() {
        int v = 0;
        if (this.getTipo() == "CC") {
            v = 12;
        } else if (this.getTipo() == "CP") {
            v = 20;
        }
       
        if (this.getStatus()) {
            if (this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.printf("Mensalidade de R$%.2f paga com sucesso!",v);
                System.out.println("");
            } else {
                System.out.printf("Saldo insuficiente para realizar o saque. Seu saldo é de R$%.2f.",v);
                System.out.println("");
            }
        } else {
                System.out.println("Impossível realizar o pagamento em uma conta fechada.");
            }
        
    }
    
    //Métodos Especiais             
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int n) {
        this.numConta = n;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String d) {
        this.dono = d;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float s) {
        this.saldo = s;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean s) {
        this.status = s;
    }
    
    
}
