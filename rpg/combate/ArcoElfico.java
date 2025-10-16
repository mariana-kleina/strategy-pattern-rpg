package rpg.combate;

import java.util.Map;

public class ArcoElfico implements Arma {
    private static final double CHANCE_CRITICO = 0.20;
    private static final double MULTIPLICADOR_CRITICO = 1.5;

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        atacante.setManaAtual(atacante.getManaAtual() - getCustoMana());
        System.out.println(atacante.getNome() + " dispara uma Chuva de Flechas com o " + getNome() + "!");
        System.out.println("O ataque atinge " + alvo.getNome() + "!");
        
        int danoFinal = getDanoBase();

        if (Math.random() < CHANCE_CRITICO) {
            System.out.println("ACERTO CRÍTICO!");
            danoFinal = (int) (danoFinal * MULTIPLICADOR_CRITICO);
        }
        
        alvo.receberDano(danoFinal);
    }

    @Override public String getNome() { return "Arco Élfico"; }
    @Override public int getDanoBase() { return 12; }
    @Override public int getCustoMana() { return 15; }
    @Override public Map<String, Integer> getRequisitos() { return Map.of("Destreza", 8); }
}