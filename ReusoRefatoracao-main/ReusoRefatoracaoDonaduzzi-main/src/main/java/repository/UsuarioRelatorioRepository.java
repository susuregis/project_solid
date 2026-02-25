package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import java.util.List;

public interface UsuarioRelatorioRepository {
    List<Usuario> buscarPorFiltroAvancados(String nome, String email, String tipoUsuario);
    long contarUsuariosPorTipo(String tipoUsuario);
    List<Object[]> gerarRelatorioUsuariosPorTipo();
}
