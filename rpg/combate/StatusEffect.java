package rpg.combate;

public abstract class StatusEffect {
    protected String nome;
    protected int duracao;

    public StatusEffect(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    public abstract void aplicar(Personagem alvo);

    public int getDuracao() { return duracao; }
    public String getNome() { return nome; }
    public void reduzirDuracao() { this.duracao--; }
}