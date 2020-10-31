package domain;

import java.math.BigDecimal;

public class Auditoria {
    private String cuenta;
    private String descripcion;
    private String entidad;
    private String act;
    private BigDecimal saldoApertura;
    private BigDecimal saldoInicial;
    private BigDecimal debito;
    private BigDecimal credito;
    private BigDecimal saldoFinal;

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

    public BigDecimal getSaldoApertura() {
        return saldoApertura;
    }

    public void setSaldoApertura(BigDecimal saldoApertura) {
        this.saldoApertura = saldoApertura;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public BigDecimal getDebito() {
        return debito;
    }

    public void setDebito(BigDecimal debito) {
        this.debito = debito;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(BigDecimal saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    @Override
    public String toString() {
        return "Auditoria{" +
                "cuenta='" + cuenta + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", entidad='" + entidad + '\'' +
                ", act='" + act + '\'' +
                ", saldoApertura=" + saldoApertura +
                ", saldoInicial=" + saldoInicial +
                ", debito=" + debito +
                ", credito=" + credito +
                ", saldoFinal=" + saldoFinal +
                '}';
    }
}
