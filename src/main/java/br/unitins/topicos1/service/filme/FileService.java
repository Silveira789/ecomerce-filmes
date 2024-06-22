package br.unitins.topicos1.service.filme;

import java.io.File;

public interface FileService {

    void salvar(Long id, String nomeImagem, byte[] imagem);
    File download(String nomeImagem);

    
} 
