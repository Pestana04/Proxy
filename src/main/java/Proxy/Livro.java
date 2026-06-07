package Proxy;

import java.util.Arrays;
import java.util.List;

public class Livro implements ILivro {

    private Integer codigo;
    private String titulo;
    private String autor;
    private String historicoEmprestimo1;
    private String historicoEmprestimo2;

    public Livro(int codigo) {
        this.codigo = codigo;

        Livro objeto = BD.getLivro(codigo);

        this.titulo = objeto.titulo;
        this.autor = objeto.autor;
        this.historicoEmprestimo1 = objeto.historicoEmprestimo1;
        this.historicoEmprestimo2 = objeto.historicoEmprestimo2;
    }

    public Livro(Integer codigo, String titulo, String autor, String historicoEmprestimo1, String historicoEmprestimo2) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.historicoEmprestimo1 = historicoEmprestimo1;
        this.historicoEmprestimo2 = historicoEmprestimo2;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosLivro() {
        return Arrays.asList(this.titulo, this.autor);
    }

    @Override
    public List<String> obterHistoricoEmprestimos(Bibliotecario bibliotecario) {
        return Arrays.asList(this.historicoEmprestimo1, this.historicoEmprestimo2);
    }
}