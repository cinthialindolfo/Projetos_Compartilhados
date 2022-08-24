package Git;

public class FuncionarioNaoEncontradoException extends Exception {

    public FuncionarioNaoEncontradoException(){

    }
    public FuncionarioNaoEncontradoException(String msg){
        super(msg);
    }
    public FuncionarioNaoEncontradoException(String msg, Throwable cod){
        super(msg, cod);
    }


}
