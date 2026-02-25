package br.com.nogueiranogueira.aularefatoracao.solidproject.dto;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        String tipo,
        int idade
) {
    public Usuario toUsuario() {
        Usuario usuario = new Usuario(nome, email, tipo);
        usuario.setId(id);
        return usuario;
    }

    public static UsuarioDTO fromUsuario(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipo(),
                0
        );
    }
}
