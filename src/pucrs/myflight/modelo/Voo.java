package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Voo {
	
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };
	
	private LocalDateTime datahora;
	private Duration duracao;
	private Rota rota;
	private Status status;
	
	public Voo(Rota rota, LocalDateTime datahora, Duration duracao) {
		this.rota = rota;
		this.datahora = datahora;
		this.duracao = duracao;
		this.status = Status.CONFIRMADO; // default é confirmado
	}
	
	public Rota getRota() {
		return rota;
	}
	
	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public Duration getDuracao() {
		return duracao;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status novo) {
		this.status = novo;
	}

	@Override
	public String toString() {
		// ISO local e duração legível
		return String.format("Voo{%s %s->%s, dt=%s, dur=%s}",
				rota.getCia().getCodigo(),
				rota.getOrigem().getCodigo(),
				rota.getDestino().getCodigo(),
				datahora,                      // LocalDateTime.toString() já é ISO-8601
				duracao);
	}
}
