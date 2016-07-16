package br.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.modelo.EmpregadoTableModel;

/**
 * Evento para remover linha selecionada
 * @author Solutionbto
 *
 */
public class TableRemoveRowListener implements ActionListener {

	private Logger logger=Logger.getLogger(getClass().getSimpleName());
	private EmpregadoTableModel tableModel;
	private JTable table; 
	
	public TableRemoveRowListener(JTable table) {
		this.table = table;
		this.tableModel = (EmpregadoTableModel) table.getModel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(table.getSelectedRow() != -1 && table.getSelectedRow() < tableModel.getRowCount()){
			tableModel.onRemove(table.getSelectedRow());
			logger.info("tableModel.onRemove(table.getSelectedRow());");
		}else
			JOptionPane.showMessageDialog(null, "Selecione um registro da tabela!");
	}

}
