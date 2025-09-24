package pucrs.myflight.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciadorVoos {
    private ArrayList<Voo> voos;

    public GerenciadorVoos()
    {
        this.voos = new ArrayList<Voo>();
    }

    public GerenciadorVoos(ArrayList<Voo> voos)
    {
        this.voos = voos;
    }

    public void adicionar(Voo voo)
    {
        this.voos.add(voo);
    }

    public ArrayList<Voo> listarTodos()
    {
        return this.voos;
    }

    public ArrayList<Voo> buscarData(LocalDate data)
    {
        ArrayList<Voo> voosFiltrados = new ArrayList<Voo>();
        Voo voo;

        for (int i=0; i<this.voos.size(); i++) {
            voo = this.voos.get(i);
            if ((voo.getDatahora().toLocalDate()).equals(data)) {
                voosFiltrados.add(voo);
            }
        }

        return voosFiltrados;
    }
}

