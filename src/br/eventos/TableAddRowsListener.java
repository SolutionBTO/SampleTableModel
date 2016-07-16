package br.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Logger;

import br.modelo.Empregado;
import br.modelo.EmpregadoTableModel;

/**
 * Evento para adicionar linhas
 * @author Solutionbto
 *
 */
public class TableAddRowsListener implements ActionListener {
	
	private Logger logger=Logger.getLogger(getClass().getSimpleName());
	private EmpregadoTableModel tableModel;
	private List<Empregado> empregados;
	
	public TableAddRowsListener(EmpregadoTableModel tableModel, List<Empregado> empregados) {
		this.tableModel = tableModel;
		this.empregados = empregados;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tableModel.onAddAll(this.empregados);
		logger.info("tableModel.onAddAll(this.empregados);");
	}

}
