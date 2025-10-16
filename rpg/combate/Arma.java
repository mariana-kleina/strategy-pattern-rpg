package rpg.combate;

import java.util.Map;

public interface Arma {
    void atacar(Personagem atacante, Personagem alvo);
    String getNome();
    int getDanoBase();
    int getCustoMana();
    Map<String, Integer> getRequisitos();
}