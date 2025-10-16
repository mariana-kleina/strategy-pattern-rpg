package rpg.combate;

import java.util.Map;

public class EspadaLonga implements Arma {
    private static final double CHANCE_CRITICO = 0.20; 
    private static final double MULTIPLICADOR_CRITICO = 1.5; 

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " ataca " + alvo.getNome() + " com a " + getNome() + "!");
        
        int danoFinal = getDanoBase();

        if (Math.random() < CHANCE_CRITICO) {
            System.out.println("ACERTO CRÍTICO!");
            danoFinal = (int) (danoFinal * MULTIPLICADOR_CRITICO);
        }

        alvo.receberDano(danoFinal);

        if (Math.random() < 0.30) {
            System.out.println("Corte Profundo! O alvo está sangrando.");
            alvo.adicionarEfeito(new Sangramento());
        }
    }

    @Override public String getNome() { return "Espada Longa"; }
    @Override public int getDanoBase() { return 15; }
    @Override public int getCustoMana() { return 0; }
    @Override public Map<String, Integer> getRequisitos() { return Map.of("Força", 10); }
}