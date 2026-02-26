package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMailSenderService {

    private final EmailService emailService;

    public UsuarioMailSenderService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void enviarEmailBoasVindas(Usuario usuario) {
        emailService.enviarEmailBoasVindas(usuario);
    }
}
