package br.unitins.topicos1.service.cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.cliente.ClienteDTO;
import br.unitins.topicos1.dto.cliente.ClienteResponseDTO;
import br.unitins.topicos1.dto.endereco.EnderecoDTO;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.EnderecoRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;


@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    ClienteRepository repository;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public ClienteResponseDTO insert(ClienteDTO dto) {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(dto.nome());
        novoCliente.setCpf(dto.cpf());
        novoCliente.setEmail(dto.email());
        if (dto.listaEnderecos() != null &&
                !dto.listaEnderecos().isEmpty()) {
            novoCliente.setListaEnderecos(new ArrayList<Endereco>());
            for (EnderecoDTO end : dto.listaEnderecos()) {
                Endereco endereco = new Endereco();
                endereco.setNome(end.nome());
                endereco.setLogradouro(end.logradouro());
                endereco.setNumero(end.numero());
                endereco.setBairro(end.bairro());
                endereco.setComplemento(end.complemento());
                endereco.setCidade(end.cidade());
                endereco.setEstado(end.estado());
                novoCliente.getListaEnderecos().add(endereco);
            }
        }
        
        if (dto.listaTelefones() != null &&
                !dto.listaTelefones().isEmpty()) {
            novoCliente.setListaTelefones(new ArrayList<String>());
            for (String telefone : dto.listaTelefones()) {
                novoCliente.getListaTelefones().add(telefone);
            }
        }
        Usuario usuario = usuarioRepository.findById(dto.idUsuario());
        novoCliente.setUsuario(usuario);

        repository.persist(novoCliente);

        return ClienteResponseDTO.valueOf(novoCliente);
    }

    @Override
    @Transactional
    public ClienteResponseDTO update(ClienteDTO dto, Long id) {

        Cliente clienteUpdate = repository.findById(id);
        if (clienteUpdate != null) {
            clienteUpdate.setNome(dto.nome());
            clienteUpdate.setCpf(dto.cpf());
            clienteUpdate.setEmail(dto.email());
            if (dto.listaEnderecos() != null && !dto.listaEnderecos().isEmpty()) {
                clienteUpdate.setListaEnderecos(new ArrayList<Endereco>());
                for (EnderecoDTO enderecoDTO : dto.listaEnderecos()) {
                    Endereco endereco = new Endereco();
                    endereco.setNome(enderecoDTO.nome());
                    endereco.setLogradouro(enderecoDTO.logradouro());
                    endereco.setNumero(enderecoDTO.numero());
                    endereco.setBairro(enderecoDTO.bairro());
                    endereco.setComplemento(enderecoDTO.complemento());
                    endereco.setCidade(enderecoDTO.cidade());
                    endereco.setEstado(enderecoDTO.estado());
                    clienteUpdate.getListaEnderecos().add(endereco);
                }
            }
            if (dto.listaTelefones() != null && !dto.listaTelefones().isEmpty()) {
                clienteUpdate.setListaTelefones(new ArrayList<String>());
                for (String tel : dto.listaTelefones()) {
                    clienteUpdate.getListaTelefones().add(tel);
                }
            }

            Usuario usuario = usuarioRepository.findById(dto.idUsuario());
            clienteUpdate.setUsuario(usuario);

            repository.persist(clienteUpdate);
        } else {
            throw new NotFoundException();
        }

        return ClienteResponseDTO.valueOf(clienteUpdate);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return ClienteResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }

}