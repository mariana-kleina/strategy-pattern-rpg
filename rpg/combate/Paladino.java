package rpg.combate;

import java.util.Map;

public class Paladino extends Personagem {

    private static final double CHANCE_AURA = 0.20; 

    public Paladino(String nome) {
        super(nome, 100, 80, Map.of("Força", 12, "Destreza", 6, "Inteligência", 10));
    }

    @Override
    public void receberDano(int dano) {
        if (Math.random() < CHANCE_AURA) {
            int cura = (int)(dano * 0.10);
            this.vidaAtual = Math.min(this.vidaMax, this.vidaAtual + cura);
            System.out.println(nome + " (Aura Sagrada) ativou! O ataque inimigo cura " + cura + " de vida em vez de causar dano!");
        } else {
            super.receberDano(dano);
        }
    }

    @Override
    public void aplicarEfeitosInicioTurno() {
        super.aplicarEfeitosInicioTurno();
    }
}