package Git;

    import javax.swing.*;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.Objects;

public class ListEmpresa implements FuncionariosInterface {

        private List<Funcionario> funcionarios;
        private GravadorDeDados gravador;

        public ListEmpresa(){
            this.funcionarios = new ArrayList<>();
        }
        public void recuperarDados() throws IOException {
            this.gravador = new GravadorDeDados("Funcionarios.txt");
            List<String> textoLido = gravador.recuperaTextoDeArquivo();
            for(String linha: textoLido){
                String [] elementosLinha = linha.split(",");
                Funcionario funcio = new Funcionario(elementosLinha[0], elementosLinha[1], elementosLinha[2], elementosLinha[3], elementosLinha[4], elementosLinha[5]);
                this.funcionarios.add(funcio);
            }

        }
        public void salvarDados() throws IOException {
            List<String> texto = new LinkedList<>();
            for (Funcionario c : this.funcionarios){
            String linha = "Funcionário: " + c.getNome()+","+c.getDataDeNasc()+","+c.getCpf()+","+c.getSetor()+","+c.getDataDeAdmissao()+","+c.getCidadeNatal();
            texto.add(linha);
            }
            gravador.gravaTextoEmArquivo(texto);

        }

        @Override
        public boolean cadastrarFuncionario(Funcionario funcionario) {
            for(Funcionario func : funcionarios){
                if(func.equals(funcionario)){
                    return false;
                }
            }
            this.funcionarios.add(funcionario);
            return true;
        }

        @Override
        public boolean apagarFuncionario(String cpf) {
            for (Funcionario deletar : funcionarios){
                if(deletar.getCpf().equals(cpf)){
                    funcionarios.remove(deletar);
                    return true;
                }
            }
            return false;
        }

        @Override
        public List<Funcionario> getFuncionario() {
            return funcionarios;
        }

        @Override
        public String pesquisarFuncionarioDaEmpresa(String cpf)  {
            Funcionario encontrado = null;

            try {
                for (Funcionario func : funcionarios) {
                    if (func.getCpf().equals(cpf)) {
                        encontrado = func;
                    }
                }

                if (Objects.isNull(encontrado)) {
                    throw new FuncionarioNaoEncontradoException("Funcionário não encontrado");
                }

            } catch (FuncionarioNaoEncontradoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } finally {
                return encontrado != null ? encontrado.toString() : "Voltando ao Menu...";
            }
        }
    }
