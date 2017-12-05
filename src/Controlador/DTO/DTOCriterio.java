package DTO;

public class DTOCriterio
{

    private String atributo;
    private String operador;
    private Object valor;
    

    public DTOCriterio() {
    }

    public DTOCriterio(String atributo, String operador, Object valor) {
        this.atributo = atributo;
        this.operador = operador;
        this.valor = valor;
    }
        
    public String getAtributo ()
    {
        return atributo;
    }

    public void setAtributo (String atributo)
    {
        this.atributo = atributo;
    }

    public String getOperador ()
    {
        return operador;
    }

    public void setOperador (String operacion)
    {
        this.operador = operacion;
    }

    public Object getValor ()
    {
        return valor;
    }

    public void setValor (Object valor)
    {
        this.valor = valor;
    }
}