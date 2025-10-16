package rpg.main;

import rpg.combate.*;

public class Main {
    public static void main(String[] args) {
        // --- Criação dos Personagens para a batalha ---
        Personagem ryze = new Mago("Ryze, o Mago Rúnico");
        Personagem uther = new Paladino("Uther, o Arauto da Luz");

        // --- Criação das Armas necessárias ---
        Arma espada = new EspadaLonga();
        Arma cajado = new CajadoArcano();
        
        System.out.println("--- EQUIPANDO E PREPARANDO PERSONAGENS ---");
        
        // Uther, o Paladino, pode usar tanto espada quanto cajado
        uther.equiparArma(espada);
        uther.adicionarArmaAoInventario(cajado);
        
        // Ryze, seu oponente
        ryze.equiparArma(cajado);

        System.out.println("-----------------------------------------\n");
        
        // --- Iniciar a Batalha ---
        System.out.println("### BATALHA DE TESTE: PALADINO VS MAGO ###");
        Batalha batalhaFinal = new Batalha(uther, ryze);
        batalhaFinal.iniciar();
    }
}