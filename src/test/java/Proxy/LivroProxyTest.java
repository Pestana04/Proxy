package Proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LivroProxyTest {

    @BeforeEach
    void setUp() {
        BD.addLivro(new Livro(
                1,
                "Dom Casmurro",
                "Machado de Assis",
                "Emprestado para João em 01/05",
                "Devolvido por João em 10/05"
        ));

        BD.addLivro(new Livro(
                2,
                "O Hobbit",
                "J. R. R. Tolkien",
                "Emprestado para Ana em 03/06",
                "Devolvido por Ana em 12/06"
        ));
    }

    @Test
    void deveRetornarDadosPublicosDoLivro() {
        LivroProxy livro = new LivroProxy(1);

        assertEquals(
                Arrays.asList("Dom Casmurro", "Machado de Assis"),
                livro.obterDadosLivro()
        );
    }

    @Test
    void deveRetornarHistoricoEmprestimosParaBibliotecarioAdministrador() {
        LivroProxy livro = new LivroProxy(1);
        Bibliotecario bibliotecario = new Bibliotecario("Carlos", true);

        assertEquals(
                Arrays.asList(
                        "Emprestado para João em 01/05",
                        "Devolvido por João em 10/05"
                ),
                livro.obterHistoricoEmprestimos(bibliotecario)
        );
    }

    @Test
    void naoDeveRetornarHistoricoParaBibliotecarioNaoAdministrador() {
        try {
            LivroProxy livro = new LivroProxy(1);
            Bibliotecario bibliotecario = new Bibliotecario("Marina", false);

            livro.obterHistoricoEmprestimos(bibliotecario);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Bibliotecário não autorizado", e.getMessage());
        }
    }
}