package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescontoService {

    public int calculaDesconto(Usuario usuario) {
        if (usuario == null) {
            return 0;
        }
        return usuario.getDesconto();
    }

    public int calculaDescontoTotal(List<Usuario> usuarios) {
        if (usuarios == null || usuarios.isEmpty()) return 0;

        return usuarios.stream()
                .mapToInt(this::calculaDesconto)
                .sum();
    }
}
