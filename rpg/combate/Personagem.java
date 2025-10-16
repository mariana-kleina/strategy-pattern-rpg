package rpg.combate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Personagem {
    protected String nome;
    protected int vidaMax;
    protected int vidaAtual;
    protected int manaMax;
    protected int manaAtual;
    protected Map<String, Integer> atributos;
    protected Arma armaEquipada;
    protected List<StatusEffect> efeitosStatus;
    protected boolean estaAtordoado;
    protected int turnosEmCombate;
    
    protected List<Arma> inventarioArmas;

    public Personagem(String nome, int vida, int mana, Map<String, Integer> atributos) {
        this.nome = nome;
        this.vidaMax = vida;
        this.vidaAtual = vida;
        this.manaMax = mana;
        this.manaAtual = mana;
        this.atributos = atributos;
        this.efeitosStatus = new ArrayList<>();
        this.estaAtordoado = false;
        this.turnosEmCombate = 0;
        
        this.inventarioArmas = new ArrayList<>();
    }
    
    public void adicionarArmaAoInventario(Arma arma) {
        this.inventarioArmas.add(arma);
        System.out.println(arma.getNome() + " foi adicionada ao inventário de " + this.nome + ".");
    }

    public boolean trocarArma(int indiceInventario) {
        int indiceReal = indiceInventario - 1; 

        if (indiceReal < 0 || indiceReal >= this.inventarioArmas.size()) {
            System.out.println("Opção de arma inválida!");
            return false; 
        }

        Arma armaNova = this.inventarioArmas.get(indiceReal);

        Arma armaAntiga = this.armaEquipada;

        this.armaEquipada = armaNova;
        this.inventarioArmas.remove(indiceReal);
        this.inventarioArmas.add(armaAntiga);

        System.out.println(this.nome + " guardou " + armaAntiga.getNome() + " e equipou " + armaNova.getNome() + "!");
        return true; 
    }

    public void listarInventario() {
        System.out.println("--- Armas no Inventário de " + this.nome + " ---");
        if (this.inventarioArmas.isEmpty()) {
            System.out.println("Nenhuma arma no inventário.");
            return;
        }
        for (int i = 0; i < this.inventarioArmas.size(); i++) {
            System.out.println((i + 1) + ": " + this.inventarioArmas.get(i).getNome());
        }
    }
    
    public List<Arma> getInventarioArmas() {
        return inventarioArmas;
    }

    public void equiparArma(Arma arma) {
        for (Map.Entry<String, Integer> requisito : arma.getRequisitos().entrySet()) {
            if (this.atributos.getOrDefault(requisito.getKey(), 0) < requisito.getValue()) {
                System.out.println(this.nome + " não tem " + requisito.getKey() + " suficiente para equipar " + arma.getNome());
                return;
            }
        }
        this.armaEquipada = arma;
        System.out.println(this.nome + " equipou " + arma.getNome() + "!");
    }

    public void atacar(Personagem alvo) {
        if (armaEquipada == null) {
            System.out.println(nome + " não tem uma arma equipada!");
            return;
        }
        if (manaAtual < armaEquipada.getCustoMana()) {
            System.out.println(nome + " não tem mana suficiente!");
            return;
        }
        System.out.println("--- Turno de " + nome + " ---");
        armaEquipada.atacar(this, alvo);
    }

    public void receberDano(int dano) {
        vidaAtual -= dano;
        System.out.println(nome + " recebeu " + dano + " de dano! Vida restante: " + vidaAtual);
        if (vidaAtual <= 0) {
            vidaAtual = 0;
            System.out.println(nome + " foi derrotado!");
        }
    }

    public void receberDanoDireto(int dano) {
        vidaAtual -= dano;
         if (vidaAtual <= 0) {
            vidaAtual = 0;
        }
    }

    public void aplicarEfeitosInicioTurno() {
        estaAtordoado = false;
        if (!estaVivo()) return;

        System.out.println("** Início do turno de " + nome + ": Aplicando efeitos... **");
        
        var iterator = efeitosStatus.iterator();
        while (iterator.hasNext()) {
            StatusEffect efeito = iterator.next();
            efeito.aplicar(this);
            efeito.reduzirDuracao();
            if (efeito.getDuracao() <= 0) {
                System.out.println("O efeito " + efeito.getNome() + " acabou para " + nome);
                iterator.remove();
            }
        }
         if (!estaVivo()) {
            System.out.println(nome + " foi derrotado pelos efeitos de status!");
        }
    }

    public void adicionarEfeito(StatusEffect efeito) {
        efeitosStatus.add(efeito);
        System.out.println(nome + " está sob o efeito de " + efeito.getNome() + "!");
    }

    public boolean estaVivo() { return vidaAtual > 0; }
    public String getNome() { return nome; }
    public int getManaAtual() { return manaAtual; }
    public void setManaAtual(int mana) { this.manaAtual = Math.max(0, Math.min(mana, manaMax)); }
    public boolean isEstaAtordoado() { return estaAtordoado; }
    public void setEstaAtordoado(boolean atordoado) { this.estaAtordoado = atordoado; }
    public int getTurnosEmCombate() { return turnosEmCombate; }
    public void incrementarTurnoEmCombate() { this.turnosEmCombate++; }

    @Override
    public String toString() {
        String efeitos = efeitosStatus.stream().map(StatusEffect::getNome).collect(Collectors.joining(", "));
        if (efeitos.isEmpty()) efeitos = "Nenhum";
        return String.format("[%s] Vida: %d/%d | Mana: %d/%d | Efeitos: %s", nome, vidaAtual, vidaMax, manaAtual, manaMax, efeitos);
    }
}