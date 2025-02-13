public class ProdutoNaoPerecivel extends Produto {
    public ProdutoNaoPerecivel(String desc, double precoCusto, double margemLucro){
        super(desc, precoCusto, margemLucro);
    }

    public ProdutoNaoPerecivel(String desc, double precoCusto){
        super(desc, precoCusto);
    }

    @Override 
    public double valorDeVenda(){
        return precoCusto * (1+margemLucro);
    }   
}
