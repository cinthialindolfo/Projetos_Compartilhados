package Git;

import java.util.Objects;

public class Funcionario {
    private String nome;
    private String dataDeNasc;
    private String cpf;
    private String setor;
    private String dataDeAdmissao;
    private String cidadeNatal;

    public Funcionario(String nome, String dataDeNasc, String cpf, String setor, String dataDeAdmissao, String cidadeNatal) {
        this.nome = nome;
        this.dataDeNasc = dataDeNasc;
        this.cpf = cpf;
        this.setor = setor;
        this.dataDeAdmissao = dataDeAdmissao;
        this.cidadeNatal = cidadeNatal;
    }

    public Funcionario() {
        this("", "", "", "", "", "");
    }


    @Override
    public String toString() {
        return "O funcionário " + this.nome + ", nasceu na data "+ this.dataDeNasc + " é portador do CPF n° " + this.cpf + " trabalha no setor " + this.setor + " onde está na empresa desde a data: " + this.dataDeAdmissao + " e reside na cidade de " + this.cidadeNatal + '\n';
    }



    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataDeNasc() {
        return dataDeNasc;
    }
    public void setDataDeNasc(String dataDeNasc) {
        this.dataDeNasc = dataDeNasc;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public String getDataDeAdmissao() {
        return dataDeAdmissao;
    }
    public void setDataDeAdmissao(String dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }
    public String getCidadeNatal() {
        return cidadeNatal;
    }
    public void setCidadeNatal(String cidadeNatal) {
        this.cidadeNatal = cidadeNatal;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(nome, that.nome) && Objects.equals(dataDeNasc, that.dataDeNasc) && Objects.equals(cpf, that.cpf) && Objects.equals(setor, that.setor) && Objects.equals(dataDeAdmissao, that.dataDeAdmissao) && Objects.equals(cidadeNatal, that.cidadeNatal);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome, dataDeNasc, cpf, setor, dataDeAdmissao, cidadeNatal);
    }
}