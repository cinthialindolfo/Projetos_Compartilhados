package Git;

import java.util.List;

public interface FuncionariosInterface {

        boolean cadastrarFuncionario(Funcionario funcionario);
        boolean apagarFuncionario(String cpf);

        List<Funcionario> getFuncionario();

        String pesquisarFuncionarioDaEmpresa(String cpf) throws FuncionarioNaoEncontradoException;

    }
