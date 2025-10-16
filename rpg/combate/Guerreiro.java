package rpg.combate;

import java.util.Map;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 120, 50, Map.of("Força", 15, "Destreza", 8, "Inteligência", 5));
    }

    @Override
    public void receberDano(int dano) {
        int danoReduzido = (int) (dano * 0.80); 
        System.out.println(nome + " (Pele Dura) reduz o dano!");
        super.receberDano(danoReduzido);
    }

    @Override
    public void aplicarEfeitosInicioTurno() {
        super.aplicarEfeitosInicioTurno();
    }
}