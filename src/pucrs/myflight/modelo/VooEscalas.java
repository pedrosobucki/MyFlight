package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class VooEscalas extends Voo {
    private final Rota rotaFinal;

    public VooEscalas(Rota rotaInicial, Rota rotaFinal, LocalDateTime datahora, Duration duracao) {
        super(rotaInicial, datahora, duracao);
        this.rotaFinal = Objects.requireNonNull(rotaFinal, "Rota final não pode ser nula");
    }

    public Rota getRotaFinal() {
        return rotaFinal;
    }

    protected String descricaoBase() {
        return super.toString();
    }

    @Override
    public String toString() {
        return descricaoBase() + " -> " + rotaFinal;
    }
}