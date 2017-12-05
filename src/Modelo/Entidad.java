package Modelo;

public abstract class Entidad
{

    protected String OID;

    public abstract String getOID ();
    public abstract void setOID (String OID);

    /**
     *
     */
    public Entidad() {
    }

    /**
     *
     * @param OID
     */
    public Entidad(String OID) {
        this.OID = OID;
    }
    

}

