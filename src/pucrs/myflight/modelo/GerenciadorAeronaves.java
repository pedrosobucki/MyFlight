package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeronaves {
    private ArrayList<Aeronave> aeronaves;

    public GerenciadorAeronaves()
    {
        this.aeronaves = new ArrayList<>();
    }

    public GerenciadorAeronaves(ArrayList<Aeronave> aeronaves)
    {
        this.aeronaves = aeronaves;
    }

    public void adicionar(Aeronave aviao)
    {
        this.aeronaves.add(aviao);
    }

    public ArrayList<Aeronave> listarTodos()
    {
        return this.aeronaves;
    }

    public Aeronave buscarPorCodigo(String cod) throws Exception
    {
        Aeronave aeronave;

        for (int i=0; i<this.aeronaves.size(); i++) {
            aeronave = this.aeronaves.get(i);
            if (aeronave.getCodigo().equals(cod)) {
                return aeronave;
            }
        }

        throw new Exception("Aeronave com código " + cod + " nao encontrada!");
    }
}
