package pucrs.myflight.modelo;

public class Rota {
	private CiaAerea cia;
	private Aeroporto origem;
	private Aeroporto destino;
	private Aeronave aeronave;
	
	public Rota(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave) {
		this.cia = cia;
		this.origem = origem;
		this.destino = destino;
		this.aeronave = aeronave;		
	}	
	
	public CiaAerea getCia() {
		return cia;
	}
	
	public Aeroporto getDestino() {
		return destino;
	}
	
	public Aeroporto getOrigem() {
		return origem;
	}
	
	public Aeronave getAeronave() {
		return aeronave;
	}

	@Override
	public String toString() {
		// mostra origem->destino, cia e aeronave de forma compacta
		return String.format("Rota{%s->%s, cia=%s(%s), aeronave=%s(%s)}",
				origem.getCodigo(),
				destino.getCodigo(),
				cia.getCodigo(), cia.getNome(),
				aeronave.getCodigo(), aeronave.getDescricao());
	}
}
