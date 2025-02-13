import java.time.LocalDate;

public class ProdutoPerecivel extends Produto {
    private static final int PRAZO_DESCONTO = 7;
    private static final double DESCONTO = 0.25;
    private LocalDate validade;

    public static int getPrazoDesconto() {
        return PRAZO_DESCONTO;
    }

    public static double getDesconto() {
        return DESCONTO;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate validade) {
        super(desc, precoCusto, margemLucro);

        if(validade.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Produto vencido.");

        this.validade = validade;        
    }

    @Override
    public double valorDeVenda(){
        return precoCusto * (1+margemLucro) * (validade.isBefore(LocalDate.now().plusDays(PRAZO_DESCONTO)) ? 1-DESCONTO : 1 );
    }
}
