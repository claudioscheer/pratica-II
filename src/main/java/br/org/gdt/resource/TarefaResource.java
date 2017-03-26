package br.org.gdt.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import br.org.gdt.model.Tarefa;
import br.org.gdt.service.TarefaService;

@Path("/tarefa")
public class TarefaResource {
	
	@Autowired
	private TarefaService tarefaService;
	
	@GET
	@Produces("application/json")
	public List<Tarefa> getTarefas() {
		
		return tarefaService.findAll();
	}

	public TarefaService getTarefaService() {
		return tarefaService;
	}

	public void setTarefaService(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}
}
