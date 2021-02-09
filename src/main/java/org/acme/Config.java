package org.acme;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class Config {
    @ConfigProperty(name = "formatoRelatorios")
    private String formatoRelatorios = "pdf";

    @ConfigProperty(name = "tipoGraficos")
    private String tipoGraficos = "barras";

    public String getFormatoRelatorios() {
        return formatoRelatorios;
    }

    public void setFormatoRelatorios(String valor) {
        this.formatoRelatorios = valor;
    }

    public String getTipoGraficos() {
        return tipoGraficos;
    }

    public void setTipoGraficos(String valor) {
        this.tipoGraficos = valor;
    }
}


