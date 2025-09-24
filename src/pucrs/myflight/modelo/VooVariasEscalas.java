package pucrs.myflight.modelo;

import java.io.StringBufferInputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class VooVariasEscalas extends VooEscalas {
    private final List<Rota> rotasIntermediarias;

    public VooVariasEscalas(
        Rota rotaInicial,
        List<Rota> rotasIntermediarias,
        Rota rotaFinal,
        LocalDateTime datahora,
        Duration duracao
    ) {
        super(rotaInicial, rotaFinal, datahora, duracao);

        Objects.requireNonNull(rotasIntermediarias, "Lista de rotas intermediárias não pode ser nula");

        if (rotasIntermediarias.isEmpty()) {
            throw new IllegalArgumentException("É necessário informar ao menos uma rota intermediária");
        }

        this.rotasIntermediarias = new ArrayList<>(rotasIntermediarias);
    }

    public List<Rota> getRotasIntermediarias() {
        return Collections.unmodifiableList(rotasIntermediarias);
    }

    @Override
    public String toString() {
        String formatado = descricaoBase();

        for (Rota rota : rotasIntermediarias) {
            formatado += (" -> " + rota);
        }

        formatado += (" -> " + getRotaFinal());

        return formatado;
    }
}