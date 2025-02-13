import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ProdutoPerecivelTest {
    static Produto produto;

    @BeforeAll
    static public void prepare(){
        produto = new ProdutoPerecivel("Produto teste", 100, 0.1, LocalDate.now().plusDays(5));
    }

    @Test
    public void calculaPrecoCorretamente(){
        assertEquals(82.50, produto.valorDeVenda(), 0.01);
    }

    @Test
    public void naoCriaProdutoVencido(){
        Exception e = assertThrows(IllegalArgumentException.class, 
            () -> new ProdutoPerecivel("teste", 100, 0.1, LocalDate.now().minusDays(1)));
            
        assertEquals(e.getMessage(), "Produto vencido.");
    }
}
