package devandroid.moacir.desafio;

public class Pessoa {

    private String apelido;

    public Pessoa(){}

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "Seu apelido é " + apelido + '\'' +
                '}';
    }
}
