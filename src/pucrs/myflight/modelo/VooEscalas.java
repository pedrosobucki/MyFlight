package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class VooEscalas extends Voo {

    private final List<Rota> rotas;

    public VooEscalas(LocalDateTime datahora, List<Rota> rotas) {
        super(datahora);
        Objects.requireNonNull(rotas, "Lista de rotas não pode ser nula");
        if (rotas.isEmpty()) {
            throw new IllegalArgumentException("É necessário informar ao menos uma rota");
        }
        this.rotas = new ArrayList<>(rotas);
    }

    public void adicionaRota(Rota rota) {
        rotas.add(Objects.requireNonNull(rota, "Rota não pode ser nula"));
    }

    public List<Rota> getRotas() {
        return Collections.unmodifiableList(rotas);
    }

    @Override
    public Rota getRota() {
        return rotas.get(0);
    }

    public Rota getRotaFinal() {
        return rotas.get(rotas.size() - 1);
    }

    @Override
    public Duration getDuracao() {
        Duration total = Duration.ZERO;
        for (Rota rota : rotas) {
            total = total.plus(calcularDuracaoTrecho(rota));
        }
        return total;
    }

    @Override
    protected String descricaoRotas() {
        StringJoiner joiner = new StringJoiner(" -> ");
        for (Rota rota : rotas) {
            joiner.add(rota.toString());
        }
        return joiner.toString();
    }
}