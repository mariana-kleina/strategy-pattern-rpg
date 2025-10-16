package rpg.combate;

import java.util.Map;

public class MachadoDeGuerra implements Arma {
    private static final double CHANCE_CRITICO = 0.20;
    private static final double MULTIPLICADOR_CRITICO = 1.5;

    @Override
    public void atacar(Personagem atacante, Personagem alvo) {
        atacante.setManaAtual(atacante.getManaAtual() - getCustoMana());
        System.out.println(atacante.getNome() + " desfere um golpe esmagador em " + alvo.getNome() + "!");
        
        int danoFinal = getDanoBase();

        if (Math.random() < CHANCE_CRITICO) {
            System.out.println("ACERTO CRÍTICO!");
            danoFinal = (int) (danoFinal * MULTIPLICADOR_CRITICO);
        }

        alvo.receberDano(danoFinal);

        if (Math.random() < 0.25) {
            System.out.println("Golpe Esmagador! O alvo está atordoado.");
            alvo.adicionarEfeito(new Atordoado());
        }
    }
    
    @Override public String getNome() { return "Machado de Guerra"; }
    @Override public int getDanoBase() { return 18; }
    @Override public int getCustoMana() { return 5; }
    @Override public Map<String, Integer> getRequisitos() { return Map.of("Força", 15); }
}