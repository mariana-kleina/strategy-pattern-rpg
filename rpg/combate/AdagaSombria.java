package rpg.combate;

import java.util.Map;

public class AdagaSombria implements Arma {
    private static final double CHANCE_CRITICO = 0.20;
    private static final double MULTIPLICADOR_CRITICO = 1.5;

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        atacante.setManaAtual(atacante.getManaAtual() - getCustoMana());
        System.out.println(atacante.getNome() + " realiza um ataque rápido em " + alvo.getNome() + "!");
        
        int danoFinal = getDanoBase();
        
        if (alvo.getTurnosEmCombate() == 0) {
            System.out.println("Ataque Furtivo! O alvo estava desprevenido e o dano é triplicado!");
            danoFinal *= 3;
        }
        
        if (Math.random() < CHANCE_CRITICO) {
            System.out.println("ACERTO CRÍTICO!");
            danoFinal = (int) (danoFinal * MULTIPLICADOR_CRITICO);
        }

        alvo.receberDano(danoFinal);
    }
    
    @Override public String getNome() { return "Adaga Sombria"; }
    @Override public int getDanoBase() { return 10; }
    @Override public int getCustoMana() { return 10; }
    @Override public Map<String, Integer> getRequisitos() { return Map.of("Destreza", 12); }
}