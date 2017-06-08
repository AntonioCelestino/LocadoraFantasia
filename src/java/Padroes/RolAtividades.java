package Padroes;

public class RolAtividades {
    private static RolAtividades rolAtividades = new RolAtividades();
    private TipoAtividadeVender tipoAtividadeVender;
    private TipoAtividadeNegociar tipoAtividadeNegociar;
    private TipoAtividadeAtender tipoAtividadeAtender;
    
    private RolAtividades(){
        tipoAtividadeVender = new TipoAtividadeVender();
        tipoAtividadeNegociar = new TipoAtividadeNegociar();
        tipoAtividadeAtender = new TipoAtividadeAtender();
    }
    
    public static RolAtividades getInstance(){
        return rolAtividades;
    }
    public TipoAtividadeVender getTipoAtividadeVender() {
        return tipoAtividadeVender;
    }
    public TipoAtividadeNegociar getTipoAtividadeNegociar() {
        return tipoAtividadeNegociar;
    }
    public TipoAtividadeAtender getTipoAtividadeAtender() {
        return tipoAtividadeAtender;
    }
}
