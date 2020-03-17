package br.com.fiap.dao;

import java.util.ArrayList;

import br.com.fiap.bean.Cliente;

public class ClienteDAO {

	private static ArrayList<Cliente> lista = new ArrayList<Cliente>();
	
	
	//Este método cadastra um cliente novo em nossa lista, por isso 
	//temos um contrutor na classe Cliente sem o código, aqui inserimos o próximo código
	public void cadastrar(Cliente cliente) {
		cliente.setCodigo(lista.size()+1);
		lista.add(cliente);
	}
	
	//Neste método estamos criando uma lista de cliente que adquiriram um determinado serviço	
	public ArrayList<Cliente> buscarPorServico(int codigoServico){
		ArrayList<Cliente> busca = new ArrayList<Cliente>();
		
		for(Cliente c : lista) {
			if(c.getCodigoServico() == codigoServico) {
				busca.add(c);
			}		
		}
		return busca;
	}
	
	//Método para localizar um cliente na lista pelo código
	//Vamos usar ele para alterar e remover clientes da lista
	public Cliente buscarPorCodigo(int codigo) {
		for(Cliente c : lista) {
			if(c.getCodigo() == codigo) return c;
			} 
			return null;			
	}
	
	//recebe o objeto cliente com os dados para alteração,
	//localiza o cliente na lista e substitui os dados
	public void alterar(Cliente cliente) {
		Cliente c = buscarPorCodigo(cliente.getCodigo());
		c.setDataNascimento(cliente.getDataNascimento());
		c.setCpf(cliente.getCpf());
		c.setEndereco(cliente.getEndereco());
		c.setNome(cliente.getNome());
		c.setCodigoServico(cliente.getCodigoServico());
	}
	
	//recebe o codigo do cliente que deve ser excluído
	//remove o cliente da lista
	public void remover(int codigo) throws Exception{
		Cliente c = buscarPorCodigo(codigo);
		if(c == null) {
			throw new Exception("Cliente não encontrado");
		}
		lista.remove(c);
	}
	
	//retorna toda a lista de clientes
	public ArrayList<Cliente> buscarTodos(){
		return lista;
	}
	
}
