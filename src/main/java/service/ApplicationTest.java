package service;

import modelo.Fabricante;
import modelo.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
public class ApplicationTest {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private FabricanteService fabricanteService;

    @Test
    public void testCadastrarEListarProdutos() {
        Fabricante novoFabricante = new Fabricante();
        novoFabricante.setNome("Novo Fabricante");
        fabricanteService.cadastrarFabricante(novoFabricante);

        Produto novoProduto = new Produto();
        novoProduto.setNome("Produto:");
        novoProduto.setDescricao("Descrição do produto:");
        novoProduto.setPreco(16);
        novoProduto.setFabricante(novoFabricante);
        produtoService.cadastrarProduto(novoProduto, novoFabricante.getId());

        List<Produto> produtos = produtoService.listarProdutos();

        assertEquals(1, produtos.size());
        Produto produtoCadastrado = produtos.get(0);
        assertEquals("Produto:", produtoCadastrado.getNome());
        assertEquals("Descrição do produto:", produtoCadastrado.getDescricao());
        assertEquals(22, produtoCadastrado.getPreco());
        assertEquals(novoFabricante.getId(), produtoCadastrado.getFabricante().getId());
    }
}
