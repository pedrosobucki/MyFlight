package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	private ArrayList<CiaAerea> cias;

	public GerenciadorCias() {
		this.empresas = new ArrayList<>();
		this.cias = new ArrayList<>();
	}

    public void adicionar(CiaAerea aero)
    {
        this.cias.add(aero);
    }

    public ArrayList<CiaAerea> listarTodos()
    {
        return this.cias;
    }

    public CiaAerea buscarCodigo(String cod) throws Exception
    {
        CiaAerea cia;

        for (int i=0; i<this.cias.size(); i++) {
            cia = this.cias.get(i);
            if (cia.getCodigo().equals(cod)) {
                return cia;
            }
        }

        throw new Exception("Companhia aérea com código " + cod + " nao encontrado!");
    }

    public CiaAerea buscarNome(String nome) throws Exception
    {
        CiaAerea cia;

        for (int i=0; i<this.cias.size(); i++) {
            cia = this.cias.get(i);
            if (cia.getNome().equals(nome)) {
                return cia;
            }
        }

        throw new Exception("Companhia aérea com código " + nome + " nao encontrado!");
    }
}
