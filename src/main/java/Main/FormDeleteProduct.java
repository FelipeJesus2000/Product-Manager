package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FormDeleteProduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDeleteProduct frame = new FormDeleteProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormDeleteProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Deletar Produto");
		lblTitle.setFont(new Font("Forte", Font.PLAIN, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(123, 49, 148, 29);
		contentPane.add(lblTitle);
		
		JLabel lblNewLabel = new JLabel("Digite o código do produto");
		lblNewLabel.setBounds(76, 128, 131, 19);
		contentPane.add(lblNewLabel);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(new Color(255, 255, 255));
		btnDeletar.setBackground(new Color(255, 0, 0));
		
		btnDeletar.setBounds(232, 143, 91, 23);
		contentPane.add(btnDeletar);
		
		//final JComboBox cmbSearch = new JComboBox();
		final JComboBox<Object> cmbSearch = new JComboBox<Object>();
		cmbSearch.setEditable(true);
		cmbSearch.setBounds(76, 143, 131, 22);
		contentPane.add(cmbSearch);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(128, 0, 0));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu form = new MainMenu();
				form.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(154, 241, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\felip\\Desktop\\Estudo\\Banco-de-dados\\productManager\\src\\main\\java\\img\\background\\background-2.jpg"));
		lblNewLabel_2.setBounds(28, 32, 339, 264);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\felip\\Desktop\\Estudo\\Banco-de-dados\\productManager\\src\\main\\java\\img\\background\\background.jpg"));
		lblNewLabel_1.setBounds(0, 0, 388, 319);
		contentPane.add(lblNewLabel_1);
		
		cmbSearch.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String search = ((JTextField)cmbSearch.getEditor().getEditorComponent()).getText();
					int id;
					if(search.isEmpty()) return;
					if(FormAddProduct.isInteger(search)) {
						id = Integer.parseInt(search);
						Product product = JdbcConnection.selectProduct(id);
						ArrayList<String> nmProduct = new ArrayList<String>();
						if(product.getName() == null) {
							cmbSearch.setModel(new DefaultComboBoxModel<Object>(new String[] {search}));
							return;
						};
						nmProduct.add(search);
						nmProduct.add(product.getName() + "/" + product.getCd());
						String[] nmProductArray = nmProduct.toArray(new String[nmProduct.size()]);
						cmbSearch.setModel(new DefaultComboBoxModel<Object>(nmProductArray));
						cmbSearch.showPopup();
					}else {
						FormAddProduct.showMessage("Digite apenas números no campo código");
						cmbSearch.setModel(new DefaultComboBoxModel<Object>());
						return;
					}
					
				}catch(Exception ex) {
					System.out.println("Erro: " + ex);
				}
			}
		});	
		cmbSearch.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String selectedValue = e.getItem().toString();
					String id = "";
					if(!FormAddProduct.isInteger(selectedValue)) {
						for(int i = selectedValue.length()-1; i > 0; i--) {
							if(selectedValue.charAt(i) == '/') {
								break;
							}
							id += selectedValue.charAt(i);
						}
						id = new StringBuilder(id).reverse().toString();
						cmbSearch.setModel(new DefaultComboBoxModel<Object>(new String[] {id}));
					}
				}
			}
		});
		
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String search = ((JTextField)cmbSearch.getEditor().getEditorComponent()).getText();
					if(search.isEmpty()) return;
					Product product = JdbcConnection.selectProduct(Integer.parseInt(search));
					if(product.getName() == null) return;
					
					if (JOptionPane.showConfirmDialog(null, "Deseja realmente deletar este produto?", "WARNING",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					  System.out.println("Deletando...");
					} else {
						return;
					}
					int id = product.getCd();
					if(JdbcConnection.deleteProduct(id)) {
						FormAddProduct.showMessage("Produto deletado com sucesso!!!");
					}else {
						FormAddProduct.showMessage("Não foi possivel deletar o produto!!!");
					}	
				}catch(Exception e) {
					System.out.println("Error: "+ e);
				}
			}
		});
	}
}
