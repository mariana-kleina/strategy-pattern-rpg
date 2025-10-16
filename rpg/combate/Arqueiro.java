package rpg.combate;

import java.util.Map;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome) {
        super(nome, 90, 80, Map.of("Força", 8, "Destreza", 15, "Inteligência", 7));
    }

    @Override
    public void receberDano(int dano) {
        if (Math.random() < 0.25) { 
            System.out.println(nome + " (Esquiva) desviou completamente do ataque!");
        } else {
            super.receberDano(dano);
        }
    }

    @Override
    public void aplicarEfeitosInicioTurno() {
        super.aplicarEfeitosInicioTurno();
    }
}