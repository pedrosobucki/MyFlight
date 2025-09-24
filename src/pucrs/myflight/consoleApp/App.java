package pucrs.myflight.consoleApp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.GerenciadorAeronaves;
import pucrs.myflight.modelo.GerenciadorAeroportos;
import pucrs.myflight.modelo.GerenciadorCias;
import pucrs.myflight.modelo.GerenciadorRotas;
import pucrs.myflight.modelo.GerenciadorVoos;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.Voo;

public class App {

    public static void main(String[] args) {
        App.testeExercicio1();
    }

    public static void testeExercicio1()
    {
        System.out.println("\n--- INICIANDO TESTE EX1 (Gerenciadores) ---");

        // gerenciadores
        GerenciadorCias gCias = new GerenciadorCias();
        GerenciadorAeronaves gAeronaves = new GerenciadorAeronaves();
        GerenciadorAeroportos gAeroportos = new GerenciadorAeroportos();
        GerenciadorRotas gRotas = new GerenciadorRotas();
        GerenciadorVoos gVoos = new GerenciadorVoos();

        // cias
        CiaAerea latam = new CiaAerea("JJ", "LATAM");
        CiaAerea gol   = new CiaAerea("G3", "GOL");
        CiaAerea azul  = new CiaAerea("AD", "Azul");
        gCias.adicionar(latam);
        gCias.adicionar(gol);
        gCias.adicionar(azul);

        System.out.println("\n[Cias - listarTodos]");
        gCias.listarTodos().forEach(System.out::println);

        System.out.println("\n[Cias - buscarCodigo(\"G3\")]");

        try {
            System.out.println(Objects.toString(gCias.buscarCodigo("G3")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n[Cias - buscarNome(\"Azul\")]");

        try {
            System.out.println(Objects.toString(gCias.buscarNome("Azul")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        // aeronaves
        Aeronave a32N = new Aeronave("A20N", "Airbus A320neo", 180);
        Aeronave b738 = new Aeronave("B738", "Boeing 737-800", 186);
        Aeronave e195 = new Aeronave("E195", "Embraer 195-E2", 136);
        gAeronaves.adicionar(a32N);
        gAeronaves.adicionar(b738);
        gAeronaves.adicionar(e195);

        System.out.println("\n[Aeronaves - listarTodos]");
        gAeronaves.listarTodos().forEach(System.out::println);

        System.out.println("\n[Aeronaves - buscarPorCodigo(\"B738\")]");

        try {
            System.out.println(Objects.toString(gAeronaves.buscarPorCodigo("B738")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // aeroportos
        Aeroporto poa = new Aeroporto("POA", "Salgado Filho", new Geo(-29.9939, -51.1711));
        Aeroporto gru = new Aeroporto("GRU", "Guarulhos",     new Geo(-23.4300, -46.4695));
        Aeroporto gig = new Aeroporto("GIG", "Galeão",        new Geo(-22.8090, -43.2506));
        gAeroportos.adicionar(poa);
        gAeroportos.adicionar(gru);
        gAeroportos.adicionar(gig);

        System.out.println("\n[Aeroportos - listarTodos]");
        gAeroportos.listarTodos().forEach(System.out::println);

        System.out.println("\n[Aeroportos - buscarPorCodigo(\"GRU\")]");

        try {
            System.out.println(Objects.toString(gAeroportos.buscarPorCodigo("GRU")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // rotas
        Rota rotaPOA_GRU_LATAM_A320 = new Rota(latam, poa, gru, a32N);
        Rota rotaGRU_GIG_GOL_737 = new Rota(gol, gru, gig, b738);
        Rota rotaPOA_GIG_AZUL_E195 = new Rota(azul, poa, gig, e195);
        
        gRotas.adicionar(rotaPOA_GRU_LATAM_A320);
        gRotas.adicionar(rotaGRU_GIG_GOL_737);
        gRotas.adicionar(rotaPOA_GIG_AZUL_E195);

        System.out.println("\n[Rotas - listarTodas]");
        gRotas.listarTodas().forEach(System.out::println);

        System.out.println("\n[Rotas - buscarPorOrigem(POA)]");
        gRotas.buscarPorOrigem(poa).forEach(System.out::println);

        // voos
        Voo voo1 = new Voo(rotaPOA_GRU_LATAM_A320, LocalDateTime.of(2025, 10, 20, 8, 15), Duration.ofMinutes(105));
        Voo voo2 = new Voo(rotaGRU_GIG_GOL_737, LocalDateTime.of(2025, 10, 20, 12, 30), Duration.ofMinutes(55));
        Voo voo3 = new Voo(rotaPOA_GIG_AZUL_E195, LocalDateTime.of(2025, 10, 21, 9, 0), Duration.ofMinutes(120));

        gVoos.adicionar(voo1);
        gVoos.adicionar(voo2);
        gVoos.adicionar(voo3);

        System.out.println("\n[Voos - listarTodos]");
        gVoos.listarTodos().forEach(System.out::println);

        System.out.println("\n[Voos - buscarData(2025-10-20)]");
        gVoos.buscarData(LocalDate.of(2025, 10, 20)).forEach(System.out::println);

        System.out.println("\n--- FIM EX1 ---");
    }
}
