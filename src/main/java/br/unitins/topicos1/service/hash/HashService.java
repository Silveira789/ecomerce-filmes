package br.unitins.topicos1.service.hash;

public interface HashService {

    public String getHashSenha(String senha);
    public boolean confereHash(String senha, String hash);
    
}