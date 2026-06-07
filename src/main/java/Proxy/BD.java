package Proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {

    private static Map<Integer, Livro> livros = new HashMap<>();

    public static Livro getLivro(Integer codigo) {
        return livros.get(codigo);
    }

    public static void addLivro(Livro livro) {
        livros.put(livro.getCodigo(), livro);
    }
}