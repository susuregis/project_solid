package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class GerenciadorUsuarioService implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMailSenderService usuarioMailSenderService;

    public GerenciadorUsuarioService(
            UsuarioRepository usuarioRepository,
            UsuarioMailSenderService usuarioMailSenderService
    ) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMailSenderService = usuarioMailSenderService;
    }

    @Override
    public Usuario criarUsuario(UsuarioDTO dto) {
        validarNome(dto.nome());
        validarEmail(dto.email());
        validarTipo(dto.tipo());

        if (usuarioRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }

        String tipo = dto.tipo().trim().toUpperCase(Locale.ROOT);
        if ("VIP".equals(tipo)) {
            validarIdade(dto.idade());
        }

        Usuario usuario = new Usuario(dto.nome(), dto.email(), tipo);
        usuario.setPontos("VIP".equals(tipo) ? 100 : 0);

        Usuario salvo = usuarioRepository.save(usuario);
        usuarioMailSenderService.enviarEmailBoasVindas(salvo);
        return salvo;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
    }

    private void validarEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }

    private void validarTipo(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("Tipo inválido");
        }

        String tipoNormalizado = tipo.trim().toUpperCase(Locale.ROOT);
        if (!"COMUM".equals(tipoNormalizado) && !"VIP".equals(tipoNormalizado)) {
            throw new IllegalArgumentException("Tipo inválido");
        }
    }

    private void validarIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("Usuário deve ser maior de idade");
        }
    }
}
