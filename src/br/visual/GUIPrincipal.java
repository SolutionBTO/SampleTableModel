package br.visual;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import br.eventos.JFrameListener;
import br.eventos.TableAddRowListener;
import br.eventos.TableAddRowsListener;
import br.eventos.TableRemoveRowListener;
import br.eventos.TableRemoveRowsListener;
import br.modelo.Empregado;
import br.modelo.EmpregadoTableModel;

/**
 * classe JFrame "Formulário Java", U.I-User Interface
 * @author Roberto Silva
 */
public class GUIPrincipal extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5859800290315431918L;
	
	private JTable table=new JTable();
	private EmpregadoTableModel tableModel;
	
	private JButton btnAdd=new JButton("Adicionar Linha");
	private JButton btnRem=new JButton("Remover Linha");
	private JButton btnAddAll=new JButton("Adicionar Dados");
	private JButton btnRemAll=new JButton("Remover Dados");;
	
	public GUIPrincipal() {
		//setando respectivamente...
		//titulo
		this.setTitle("Exemplo de Table Model");
		//layout
		this.setLayout(new FlowLayout());
		//tamanho do JFrame
		this.setSize(new Dimension(600, 400));
		//tipo de fechamento da janela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//centralizando a janela
		this.setLocationRelativeTo(null);
		//alguns eventos da JFrame
		this.addWindowListener(new JFrameListener());
		//neste ponto é criado o modelo da JTable
		tableModel=new EmpregadoTableModel(getListaEmpregados());
		
		//setando propriedades da tabela...
		
		//modelo
		table.setModel(tableModel);
		//barra de rolagem
        table.setPreferredScrollableViewportSize(new Dimension(500,300));
        //auto ajuste na altura da tabela
        table.setFillsViewportHeight(true);
        //selecionar somente uma linha
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //add a table ao scroll pane
		JScrollPane scrollPane=new JScrollPane(table);
		this.add(scrollPane);
		
		//add eventos aos botões
		btnAdd.addActionListener(new TableAddRowListener(this.tableModel));
		btnRem.addActionListener(new TableRemoveRowListener(this.table));
		btnAddAll.addActionListener(new TableAddRowsListener(this.tableModel, getListaEmpregados()));
		btnRemAll.addActionListener(new TableRemoveRowsListener(this.tableModel));
		
		//add botões ao JFrame
		this.add(btnAdd);
		this.add(btnRem);
		this.add(btnAddAll);
		this.add(btnRemAll);
	}
	
	/**
	 * retorna uma lista de empregados
	 * @return {@link List} {@link Empregado}
	 */
	private List<Empregado> getListaEmpregados(){
		//criado lista e seu conteudo os empregados
		//setando suas propriedades
		List<Empregado> empregados=new ArrayList<Empregado>();
		
		Empregado emp1=new Empregado();
		emp1.setNome("Jack");
		emp1.setIdade(19);
		emp1.setSexo('M');
		emp1.setSalario(2500);

		Empregado emp2=new Empregado();
		emp2.setNome("Eddie");
		emp2.setIdade(56);
		emp2.setSexo('M');
		emp2.setSalario(7500);
		
		Empregado emp3=new Empregado();
		emp3.setNome("Gina");
		emp3.setIdade(34);
		emp3.setSexo('F');
		emp3.setSalario(5500);
		
		Empregado emp4=new Empregado();
		emp4.setNome("Klaus");
		emp4.setIdade(18);
		emp4.setSexo('M');
		emp4.setSalario(1500);
		
		Empregado emp5=new Empregado();
		emp5.setNome("Erick");
		emp5.setIdade(20);
		emp5.setSexo('F');
		emp5.setSalario(1600);
		
		Empregado emp6=new Empregado();
		emp6.setNome("Robert");
		emp6.setIdade(30);
		emp6.setSexo('M');
		emp6.setSalario(4500);
		
		Empregado emp7=new Empregado();
		emp7.setNome("Mary");
		emp7.setIdade(30);
		emp7.setSexo('F');
		emp7.setSalario(4500);
		
		//add á lista os empregados criados
		empregados.add(emp1);
		empregados.add(emp2);
		empregados.add(emp3);
		empregados.add(emp4);
		empregados.add(emp5);
		empregados.add(emp6);
		empregados.add(emp7);
		
		return empregados;
	}
}
