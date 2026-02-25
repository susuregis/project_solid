package br.com.nogueiranogueira.aularefatoracao.solidproject.model;

public class RegraUsuarioVIP implements RegraUsuario {
    @Override
    public int calcularDesconto(Usuario usuario) {
        if (usuario instanceof UsuarioVIP vip && !vip.isTemCartaoFidelidade()) {
            throw new IllegalStateException("Usuário VIP precisa de cartão fidelidade para receber desconto");
        }
        return 10; // 10% de desconto para VIP
    }
}
