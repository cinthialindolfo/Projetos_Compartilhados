package Git;

import javax.swing.*;
import java.io.IOException;

public class ProgramaFuncionarios {
    public static void main(String[] args) throws FuncionarioNaoEncontradoException {
        ListEmpresa empresa = new ListEmpresa();
        try {
            empresa.recuperarDados();
            JOptionPane.showMessageDialog(null, "Dados recuperados com sucesso!");
        } catch (IOException e1){
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar seus dados.");
        }
        System.out.println(empresa.getFuncionario());
        boolean continuar = true;
        while (continuar) {
            String opcao = JOptionPane.showInputDialog("Digite uma das opções:\n1.Cadastrar Funcionário\n2.Apagar Funcionário\n3.Pesquisar Funcionário\n4.Salvar Arquivos\n5.Exibir Todos os Funcionários\n6.Sair");
            if(opcao.equals("1")){
                String nome = JOptionPane.showInputDialog("Digite o nome do funcionário:");
                String dataDeNasc = JOptionPane.showInputDialog("Digite a data do nascimento do funcionário:");
                String cpf = JOptionPane.showInputDialog("Digite o CPF do funcionário:");
                String setor = JOptionPane.showInputDialog("Digite o Setor que o funcionário trabaha:");
                String dataDeAdmissao = JOptionPane.showInputDialog("Digite a data de admissão do Funcionário:");
                String cidadeNatal = JOptionPane.showInputDialog("Em que cidade reside o funcionário?");
                Funcionario func = new Funcionario(nome, dataDeNasc, cpf, setor, dataDeAdmissao, cidadeNatal);
                empresa.cadastrarFuncionario(func);
            } else if (opcao.equals("2")){
                String cpfApag = JOptionPane.showInputDialog("Digite o CPF do funcionário que deseja apagar:");
                empresa.apagarFuncionario(cpfApag);
                JOptionPane.showMessageDialog(null, "Funcionário Apagado com Sucesso!");
            } else if(opcao.equals("3")){
                String pesqFunc = JOptionPane.showInputDialog("Digite o CPF do Funcionário que deseja pesquisar:");
                JOptionPane.showMessageDialog(null, empresa.pesquisarFuncionarioDaEmpresa(pesqFunc));
            }
            else if(opcao.equals("4")){
                try {
                    empresa.salvarDados();
                    JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,"Problema ao salvar dados. Detalhes: " + e.getMessage());
                }

            }
            else if (opcao.equals("5")){
                JOptionPane.showMessageDialog(null, empresa.getFuncionario());
            }
            else if(opcao.equals("6")){
                continuar = false;
                JOptionPane.showMessageDialog(null, "Até logo!");

            }

        }
    }
}