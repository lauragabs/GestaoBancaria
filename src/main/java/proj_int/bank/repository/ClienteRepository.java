package proj_int.bank.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import proj_int.bank.domain.Cliente;

@Repository
public class ClienteRepository {

    private JdbcTemplate conexaoBanco;

    public ClienteRepository(JdbcTemplate conexaoBanco) {
        this.conexaoBanco = conexaoBanco;
    }

    public void deletarClientePorId(Integer id) {
        String sql = "DELETE FROM Cliente WHERE id = ?";
        conexaoBanco.update(sql, id);
    }

    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (login, cpf, nome, telefone, endereco, email, senha, sexo, dataNascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conexaoBanco.update(sql, cliente.getLogin(), 
                                cliente.getCpf(), 
                                cliente.getNome(), 
                                cliente.getTelefone(), 
                                cliente.getEndereco(), 
                                cliente.getEmail(), 
                                cliente.getSenha(), 
                                cliente.getSexo(), 
                                cliente.getDataNascimento()
                            );
    }

    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET login = ?, telefone = ?, endereco = ?, email = ?, senha = ?, sexo = ?  WHERE id = ?";
        conexaoBanco.update(sql, cliente.getLogin(), 
                                cliente.getTelefone(), 
                                cliente.getEndereco(), 
                                cliente.getEmail(), 
                                cliente.getSenha(), 
                                cliente.getSexo(), 
                                cliente.getId()
                            );
    }

}
