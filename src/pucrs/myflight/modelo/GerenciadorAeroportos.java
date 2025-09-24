package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeroportos;

    public GerenciadorAeroportos()
    {
        this.aeroportos = new ArrayList<Aeroporto>();
    }

    public GerenciadorAeroportos(ArrayList<Aeroporto> aeroportos)
    {
        this.aeroportos = aeroportos;
    }

    public void adicionar(Aeroporto aero)
    {
        this.aeroportos.add(aero);
    }

    public ArrayList<Aeroporto> listarTodos()
    {
        return this.aeroportos;
    }

    public Aeroporto buscarPorCodigo(String cod) throws Exception
    {
        Aeroporto aeroporto;

        for (int i=0; i<this.aeroportos.size(); i++) {
            aeroporto = this.aeroportos.get(i);
            if (aeroporto.getCodigo().equals(cod)) {
                return aeroporto;
            }
        }

        throw new Exception("Aeroporto com código " + cod + " nao encontrado!");
    }
}
