package br.modelo;

import java.sql.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * classe Table Model "modelo de tabela" p/entidade Empregado
 * @author Roberto Silva
 */
public class EmpregadoTableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8097227158357945L;
	
	//constantes p/identificar colunas
	private final int NOME=0;
	private final int IDADE=1;
	private final int SEXO=2;
	private final int DATA_NASC=3;
	private final int SALARIO=4;
	private final int BENEFICIO=5;
	
	private final String colunas[]={"Nome:","Idade:","Sexo:","Data.Nasc:","Sal�rio:","Beneficio:"};
	private final List<Empregado> dados;//usamos como dados uma lista gen�rica de Empregado
	
	public EmpregadoTableModel(List<Empregado> dados) {
		//seto os dados no construtor
		this.dados=dados;
	}
	
	@Override
	public int getColumnCount() {
		//retorna o total de colunas
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		//retorna o total de linhas na tabela
		return dados.size();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		//retorna o tipo de dado, para cada coluna
		switch (columnIndex) {
		case NOME:
			return String.class;
		case IDADE:
			return int.class;
		case SEXO:
			return char.class;
		case DATA_NASC:
			return Date.class;
		case SALARIO:
			return double.class;
		case BENEFICIO:
			return Boolean.class;
		default:
			throw new IndexOutOfBoundsException("Coluna Inv�lida!!!");
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//retorna o valor conforme a coluna e linha
		
		//pega o dados corrente da linha
		Empregado empregado=dados.get(rowIndex);
		
		//retorna o valor da coluna
		switch (columnIndex) {
		case NOME:
			return empregado.getNome();
		case IDADE:
			return empregado.getIdade();
		case SEXO:
			return empregado.getSexo();
		case DATA_NASC:
			return empregado.getDataNasc();
		case SALARIO:
			return empregado.getSalario();
		case BENEFICIO:
			return empregado.isBeneficio();
		default:
			throw new IndexOutOfBoundsException("Coluna Inv�lida!!!");
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//metodo identifica qual coluna � editavel
		
		//s� iremos editar a coluna BENEFICIO, 
		//que ser� um checkbox por ser boolean
		if(columnIndex == BENEFICIO)
			return true;
		
		return false;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Empregado empregado=dados.get(rowIndex);
		
		if(columnIndex == BENEFICIO){
			empregado.setBeneficio(((boolean)aValue));
		}
	}
	
	/*M�todos abaixo s�o para manipula��o de dados*/
	
	/**
	 * retorna o valor da linha indicada
	 * @param rowIndex
	 * @return
	 */
	public Empregado getValue(int rowIndex){
		return dados.get(rowIndex);
	}
	
	/**
	 * retorna o indice do objeto
	 * @param empregado
	 * @return
	 */
	public int indexOf(Empregado empregado) {
		return dados.indexOf(empregado);
	}
	
	/**
	 * add um empregado � lista
	 * @param empregado
	 */
	public void onAdd(Empregado empregado) {
		dados.add(empregado);
		fireTableRowsInserted(indexOf(empregado), indexOf(empregado));
	}
	
	/**
	 * add uma lista de empregados
	 * @param dadosIn
	 */
	public void onAddAll(List<Empregado> dadosIn) {
		dados.addAll(dadosIn);
		fireTableDataChanged();
	}
	
	/**
	 * remove um registro da lista, atrav�s do indice
	 * @param rowIndex
	 */
	public void onRemove(int rowIndex) {
		dados.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}
	
	/**
	 * remove um registro da lista, atrav�s do objeto
	 * @param empregado
	 */
	public void onRemove(Empregado empregado) {
		dados.remove(empregado);
		fireTableRowsDeleted(indexOf(empregado), indexOf(empregado));
	}
	
	/**
	 * remove todos registros da lista
	 */
	public void onRemoveAll() {
		dados.clear();
		fireTableDataChanged();
	}
	
}
