package domain;

public class Auditoria {
    private String cuenta;
    private String descripcion;
    private String entidad;
    private String act;
    private long saldoApertura;
    private long saldoInicial;
    private long debito;
    private long credito;
    private long saldoFinal;

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public long getSaldoApertura() {
        return saldoApertura;
    }

    public void setSaldoApertura(long saldoApertura) {
        this.saldoApertura = saldoApertura;
    }

    public long getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(long saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public long getDebito() {
        return debito;
    }

    public void setDebito(long debito) {
        this.debito = debito;
    }

    public long getCredito() {
        return credito;
    }

    public void setCredito(long credito) {
        this.credito = credito;
    }

    public long getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(long saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
}
