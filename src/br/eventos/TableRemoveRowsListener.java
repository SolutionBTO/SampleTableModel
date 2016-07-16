package br.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import br.modelo.EmpregadoTableModel;

/**
 * Evento para remover todas linhas
 * @author Solutionbto
 *
 */
public class TableRemoveRowsListener implements ActionListener {
	
	private Logger logger=Logger.getLogger(getClass().getSimpleName()); 
	private EmpregadoTableModel tableModel;
	
	public TableRemoveRowsListener(EmpregadoTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		logger.info("tableModel.onRemoveAll()");
		tableModel.onRemoveAll();
	}

}
