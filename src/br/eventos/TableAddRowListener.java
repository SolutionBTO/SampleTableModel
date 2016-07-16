package br.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import br.modelo.Empregado;
import br.modelo.EmpregadoTableModel;

/**
 * Evento para adicionar uma linha na tableModel
 * @author Solutionbto
 *
 */
public class TableAddRowListener implements ActionListener {
	
	private Logger logger=Logger.getLogger(getClass().getSimpleName());
	private EmpregadoTableModel tableModel;
	
	public TableAddRowListener(EmpregadoTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//sorteia um indice do tamanho da lista para baixo
		//exemplo se a lista tiver o tamanho 10 , então vai de 0 até 9
		int randomIndex=(int)(Math.random()* (tableModel.getRowCount()-1));
		Empregado empregado=tableModel.getValue(randomIndex);
		tableModel.onAdd(empregado);
		logger.info("tableModel.onAdd(empregado);");
	}

}
