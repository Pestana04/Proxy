package Proxy;

import java.util.List;

public interface ILivro {

    List<String> obterDadosLivro();

    List<String> obterHistoricoEmprestimos(Bibliotecario bibliotecario);
}