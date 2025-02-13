import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProdutoNaoPerevicelTest {
    static Produto produto;
        
    @BeforeAll
    static public void prepare(){
        produto = new ProdutoNaoPerecivel("Produto teste", 100, 0.1);
    }
    
    @Test
    public void calculaPrecoCorretamente(){
        assertEquals(110.0, produto.valorDeVenda(), 0.01);
    }

    @Test
    public void stringComDescricaoEValor(){
        String desc = produto.toString();
        assertTrue(desc.contains("Produto teste") && desc.contains("R$ 110,00"));
    }

    @Test
    public void naoCriaProdutoComPrecoNegativo(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> new ProdutoNaoPerecivel("teste", -5, 0.5));
        assertEquals(e.getMessage(), "Valores inválidos para o produto");
    }
    
    @Test
    public void naoCriaProdutoComMargemNegativa(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> new ProdutoNaoPerecivel("teste", 5, -1));
        assertEquals(e.getMessage(), "Valores inválidos para o produto");
    }
}
