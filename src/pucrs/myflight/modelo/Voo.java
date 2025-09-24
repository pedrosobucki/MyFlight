package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Voo {

    public enum Status { CONFIRMADO, ATRASADO, CANCELADO }

    private static final double VELOCIDADE_MEDIA_KM_H = 805.0;
    private static final double TEMPO_DECOLAGEM_POUSO_MIN = 30.0;
    private static final double RAIO_TERRA_KM = 6371.0;

    private final LocalDateTime datahora;
    private Status status;

    protected Voo(LocalDateTime datahora) {
        this.datahora = Objects.requireNonNull(datahora, "Data e hora não podem ser nulas");
        this.status = Status.CONFIRMADO;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status novo) {
        this.status = Objects.requireNonNull(novo, "Status não pode ser nulo");
    }

    public abstract Rota getRota();

    public abstract Duration getDuracao();

    protected String descricaoRotas() {
        Rota rota = getRota();
        return rota == null ? "<sem rota>" : rota.toString();
    }

    @Override
    public String toString() {
        return String.format(
            "Voo{status=%s, data=%s, duracao=%s, rotas=%s}",
            status,
            datahora,
            getDuracao(),
            descricaoRotas()
        );
    }

    protected static Duration calcularDuracaoTrecho(Rota rota) {
        Objects.requireNonNull(rota, "Rota não pode ser nula");

        double distanciaKm = calcularDistanciaKm(
            rota.getOrigem().getLocal(),
            rota.getDestino().getLocal()
        );

        double tempoVooMin = (distanciaKm / VELOCIDADE_MEDIA_KM_H) * 60.0;
        double tempoTotalMin = tempoVooMin + TEMPO_DECOLAGEM_POUSO_MIN;

        long minutosArredondados = Math.round(tempoTotalMin);
        return Duration.ofMinutes(minutosArredondados);
    }

    private static double calcularDistanciaKm(Geo origem, Geo destino) {
        Objects.requireNonNull(origem, "Coordenada de origem não pode ser nula");
        Objects.requireNonNull(destino, "Coordenada de destino não pode ser nula");

        double lat1 = Math.toRadians(origem.getLatitude());
        double lon1 = Math.toRadians(origem.getLongitude());
        double lat2 = Math.toRadians(destino.getLatitude());
        double lon2 = Math.toRadians(destino.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.pow(Math.sin(dLat / 2), 2)
            + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RAIO_TERRA_KM * c;
    }
}