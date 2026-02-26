package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class GerenciadorUsuarioRepositoryImpl implements GerenciadorUsuarioRepository {

    private final UsuarioRepository usuarioRepository;

    public GerenciadorUsuarioRepositoryImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> buscarPorFiltroAvancados(String nome, String email, String tipoUsuario) {
        if (nome != null && !nome.isBlank()) {
            return usuarioRepository.findByNomeContainingIgnoreCase(nome);
        }
        return usuarioRepository.findAll();
    }

    @Override
    public long contarUsuariosPorTipo(String tipoUsuario) {
        return usuarioRepository.countByTipo(tipoUsuario);
    }

    @Override
    public List<Object[]> gerarRelatorioUsuariosPorTipo() {
        return Collections.emptyList();
    }
}


