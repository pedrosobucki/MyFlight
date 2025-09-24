package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class VooDireto extends Voo {

    private final Rota rota;

    public VooDireto(LocalDateTime datahora, Rota rota) {
        super(datahora);
        this.rota = Objects.requireNonNull(rota, "Rota não pode ser nula");
    }

    @Override
    public Rota getRota() {
        return rota;
    }

    @Override
    public Duration getDuracao() {
        return calcularDuracaoTrecho(rota);
    }
}