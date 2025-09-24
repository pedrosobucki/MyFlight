package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorRotas {
    private ArrayList<Rota> rotas;

    public GerenciadorRotas()
    {
        this.rotas = new ArrayList<Rota>();
    }

    public GerenciadorRotas(ArrayList<Rota> rotas)
    {
        this.rotas = rotas;
    }

    public void adicionar(Rota rota)
    {
        this.rotas.add(rota);
    }

    public ArrayList<Rota> listarTodas()
    {
        return this.rotas;
    }

    public ArrayList<Rota> buscarPorOrigem(Aeroporto orig)
    {
        ArrayList<Rota> rotasFiltradas = new ArrayList<Rota>();
        Rota rota;

        for (int i=0; i<this.rotas.size(); i++) {
            rota = this.rotas.get(i);
            if (rota.getOrigem().getCodigo().equals(orig.getCodigo())) {
                rotasFiltradas.add(rota);
            }
        }

        return rotasFiltradas;
    }
}
