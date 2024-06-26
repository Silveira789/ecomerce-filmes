package br.unitins.topicos1.service.filme;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import br.unitins.topicos1.model.Filme;
import br.unitins.topicos1.repository.FilmeRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FilmeFileServiceImpl implements FileService {

    private final String PATH_USER = System.getProperty("user.home")
            + File.separator + "quarkus"
            + File.separator + "imagens"
            + File.separator + "usuario " + File.separator;

    private static final List<String> SUPPORTED_MIME_TYPES = Arrays.asList("image/jpeg", "image/jpg", "image/png",
            "image/gif");
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10 MB

    @Override
    public String salvar(String nomeArquivo, byte[] arquivo) throws IOException {
        // Verificar o tamanho da imagem
        verificarTamanhoImagem(arquivo);

        // Detectar o tipo MIME com base no conteúdo do arquivo
        String mimeType = detectarTipoMime(arquivo);

        if (mimeType == null || !SUPPORTED_MIME_TYPES.contains(mimeType)) {
            throw new IOException("Tipo de imagem não suportada: " + mimeType);
        }

        // Criar o diretório caso não exista
        Path diretorio = Paths.get(PATH_USER);
        Files.createDirectories(diretorio);

        // Criar um nome de arquivo aleatório
        String extensao = mimeType.substring(mimeType.lastIndexOf('/') + 1);
        String novoNomeArquivo = UUID.randomUUID() + "." + extensao;

        // Definir o caminho completo do arquivo
        Path filePath = diretorio.resolve(novoNomeArquivo);

        // Verificar se o arquivo já existe (mesmo sendo improvável com UUID)
        if (filePath.toFile().exists()) {
            throw new IOException("Nome de arquivo já existe. Tente novamente.");
        }

        // Salvar o arquivo
        try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
            fos.write(arquivo);
        }

        return filePath.toFile().getName();
    }

    private String detectarTipoMime(byte[] arquivo) throws IOException {
        // Usar Apache Tika para detectar o tipo MIME baseado no conteúdo
        try (InputStream is = new ByteArrayInputStream(arquivo)) {
            Tika tika = new Tika();
            return tika.detect(is);
        }
    }

    private void verificarTamanhoImagem(byte[] arquivo) throws IOException {
        if (arquivo.length > MAX_FILE_SIZE) {
            throw new IOException("Arquivo maior que 10MB.");
        }
    }

    // Método para obter o arquivo baseado no nome do arquivo
    @Override
    public File obter(String nomeArquivo) {
        File file = new File(PATH_USER + nomeArquivo);
        return file;
    }

    // Método para deletar um arquivo com base no nome do arquivo
    public void deletar(String nomeImagem) {
        // Obtém o caminho do arquivo da imagem
        Path caminhoImagem = Paths.get(PATH_USER + nomeImagem);

        // Tenta excluir o arquivo
        try {
            Files.deleteIfExists(caminhoImagem);
        } catch (IOException e) {
            throw new Error("Não foi possível excluir a imagem", e);
        }
    }
}
