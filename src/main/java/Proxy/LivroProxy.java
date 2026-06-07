package Proxy;

import java.util.List;

public class LivroProxy implements ILivro {

    private Livro livro;
    private Integer codigo;

    public LivroProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDadosLivro() {
        if (this.livro == null) {
            this.livro = new Livro(this.codigo);
        }
        return this.livro.obterDadosLivro();
    }

    @Override
    public List<String> obterHistoricoEmprestimos(Bibliotecario bibliotecario) {
        if (!bibliotecario.isAdministrador()) {
            throw new IllegalArgumentException("Bibliotecário não autorizado");
        }

        if (this.livro == null) {
            this.livro = new Livro(this.codigo);
        }

        return this.livro.obterHistoricoEmprestimos(bibliotecario);
    }
}