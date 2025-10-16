package rpg.combate;

import java.util.Map;

public class CajadoArcano implements Arma {
    private static final double CHANCE_CRITICO = 0.20;
    private static final double MULTIPLICADOR_CRITICO = 1.5;

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        atacante.setManaAtual(atacante.getManaAtual() - getCustoMana());
        System.out.println(atacante.getNome() + " lança uma Bola de Fogo em " + alvo.getNome() + "!");

        int danoFinal = getDanoBase();

        if (Math.random() < CHANCE_CRITICO) {
            System.out.println("ACERTO CRÍTICO!");
            danoFinal = (int) (danoFinal * MULTIPLICADOR_CRITICO);
        }

        alvo.receberDano(danoFinal);

        System.out.println("A bola de fogo causa queimaduras!");
        alvo.adicionarEfeito(new Queimadura());
    }
    
    @Override public String getNome() { return "Cajado Arcano"; }
    @Override public int getDanoBase() { return 8; }
    @Override public int getCustoMana() { return 25; }
    @Override public Map<String, Integer> getRequisitos() { return Map.of("Inteligência", 12); }
}