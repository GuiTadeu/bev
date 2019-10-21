package br.com.bev.config.security;

public class OpenURLs {

    public final static String[] URLS = {
            "/",
            "/auth",
            "/swagger",

            "/organizador/cadastrar",
            "/organizador/{*}",
            "/organizador/{*}/viagens",

            "/turista/cadastrar",
            "/turista/{*}",
            "/turista/{*}/ingressos",

            "/viagem/cadastrar",
            "/viagem/retrieve",
            "/viagem/{*}",

            "/embarque/viagem/{*}/turista/{*}",

            "/token/getUser"
    };
}
