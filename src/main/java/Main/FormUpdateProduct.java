package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;

public class FormUpdateProduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtValue;
	private JTextField txtImage;
	private JTextField txtSupplier;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormUpdateProduct frame = new FormUpdateProduct();
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
	public FormUpdateProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnVoltar.setBounds(73, 361, 89, 23);
		contentPane.add(btnVoltar);
		
		//final JComboBox cmbSearch = new JComboBox();
		final JComboBox<Object> cmbSearch = new JComboBox<Object>();
		cmbSearch.setEditable(true);
		cmbSearch.setBounds(214, 104, 131, 22);
		contentPane.add(cmbSearch);
		
		JLabel lblAlterarProduto = new JLabel("Alterar Produto");
		lblAlterarProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarProduto.setFont(new Font("Forte", Font.PLAIN, 20));
		lblAlterarProduto.setBounds(258, 35, 148, 29);
		contentPane.add(lblAlterarProduto);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(0, 128, 255));
		
	
		btnBuscar.setBounds(355, 104, 91, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Produto");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(73, 150, 155, 14);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(73, 163, 155, 20);
		contentPane.add(txtName);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(73, 194, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Valor Unitário");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(360, 150, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		txtValue = new JTextField();
		txtValue.setEditable(false);
		txtValue.setColumns(10);
		txtValue.setBounds(360, 163, 155, 20);
		contentPane.add(txtValue);
		
		JLabel lblNewLabel_5 = new JLabel("Imagem");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(360, 201, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtImage = new JTextField();
		txtImage.setEditable(false);
		txtImage.setColumns(10);
		txtImage.setBounds(360, 215, 155, 20);
		contentPane.add(txtImage);
		
		JLabel lblNewLabel_3 = new JLabel("Fornecedor");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(73, 285, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		txtSupplier = new JTextField();
		txtSupplier.setEditable(false);
		txtSupplier.setColumns(10);
		txtSupplier.setBounds(73, 298, 155, 20);
		contentPane.add(txtSupplier);
		
		JLabel lblNewLabel = new JLabel("Digite o código do produto");
		lblNewLabel.setBounds(214, 82, 131, 19);
		contentPane.add(lblNewLabel);
		
		JButton btnClear = new JButton("Limpar");
	
		btnClear.setForeground(Color.BLACK);
		btnClear.setBackground(Color.YELLOW);
		btnClear.setBounds(283, 361, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnChange = new JButton("Alterar");
		
		btnChange.setForeground(Color.WHITE);
		btnChange.setBackground(new Color(0, 128, 64));
		btnChange.setBounds(481, 361, 89, 23);
		contentPane.add(btnChange);
		
		final JButton btnImage = new JButton("Selecionar Aquivo");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormAddProduct.selectFile(txtImage);
			}
		});
		btnImage.setEnabled(false);
		btnImage.setBounds(360, 241, 155, 23);
		contentPane.add(btnImage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 213, 184, 61);
		contentPane.add(scrollPane);
		
		final JTextArea txtDescription = new JTextArea();
		txtDescription.setEditable(false);
		scrollPane.setViewportView(txtDescription);
		txtDescription.setLineWrap(true);
		
		final JCheckBox checkboxName = new JCheckBox("Alterar");
		
		checkboxName.setBounds(234, 162, 73, 23);
		contentPane.add(checkboxName);
		
		final JCheckBox checkboxDescription = new JCheckBox("Alterar");
		checkboxDescription.setBounds(265, 214, 73, 23);
		contentPane.add(checkboxDescription);
		
		final JCheckBox checkboxValue = new JCheckBox("Alterar");
		checkboxValue.setBounds(520, 162, 74, 23);
		contentPane.add(checkboxValue);
		
		final JCheckBox checkboxImage = new JCheckBox("Alterar");
		checkboxImage.setBounds(521, 214, 73, 23);
		contentPane.add(checkboxImage);
		
		final JCheckBox checkboxSupplier = new JCheckBox("Alterar");
		checkboxSupplier.setBounds(234, 297, 73, 23);
		contentPane.add(checkboxSupplier);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setEnabled(false);
		txtId.setBounds(73, 105, 30, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblBackground2 = new JLabel("");
		lblBackground2.setIcon(new ImageIcon("C:\\Users\\felip\\Desktop\\Estudo\\Banco-de-dados\\productManager\\src\\main\\java\\img\\background\\background-2.jpg"));
		lblBackground2.setBounds(47, 11, 566, 398);
		contentPane.add(lblBackground2);
		
		JLabel lblBackground = new JLabel("");
		ImageIcon icon = new ImageIcon("C:\\Users\\felip\\Desktop\\Estudo\\Banco-de-dados\\productManager\\src\\main\\java\\img\\background\\background.jpg");
		Image image = icon.getImage();
		Image newImage = image.getScaledInstance(652, 420, Image.SCALE_SMOOTH);
		lblBackground.setIcon(new ImageIcon(newImage));
		lblBackground.setBounds(0, 0, 652, 420);
		
		contentPane.add(lblBackground);
		//txtCd.setVisible(false);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear(txtDescription);
			}
		});
		
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
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String search = ((JTextField)cmbSearch.getEditor().getEditorComponent()).getText();
					if(search.isEmpty()) return;
					Product product = JdbcConnection.selectProduct(Integer.parseInt(search));
					if(product.getName() == null) return;
						
					txtId.setText(Integer.toString(product.getCd()));
					txtName.setText(product.getName());
					txtDescription.setText(product.getDescription());
					txtValue.setText(Double.toString(product.getValue()));
					txtSupplier.setText(product.getSupplier());
					txtImage.setText(product.getImage());
					((JTextField)cmbSearch.getEditor().getEditorComponent()).setText("");
					
				}catch(Exception e) {
					System.out.println("Error: "+ e);
				}
		}});
		checkboxName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				changeEditableState(arg0, txtName);
			}
		});
		checkboxDescription.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				changeEditableState(arg0, txtDescription);
			}
		});
		checkboxValue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				changeEditableState(arg0, txtValue);
			}
		});
		checkboxImage.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				changeEditableState(arg0, btnImage);
			}
		});
		checkboxSupplier.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				changeEditableState(arg0, txtSupplier);
			}
		});	
		
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, String> fields = new LinkedHashMap<>();
				
				if(txtId.getText().isEmpty()) {
					FormAddProduct.showMessage("Não foi possivel selecionar o produto!!!");
					return;
				}
				int cd = Integer.parseInt(txtId.getText());
				Product product = JdbcConnection.selectProduct(cd);
				if(checkboxName.isSelected()) {
					if(FormAddProduct.isEmpty(txtName.getText(), "nome")) return;
					if(!product.getName().toUpperCase().equals(txtName.getText().toUpperCase())) {
						fields.put("nm_product", txtName.getText());
					}
					
				}
				if(checkboxDescription.isSelected()) {
					if(FormAddProduct.isEmpty(txtDescription.getText(), "descrição")) return;
					if(!product.getDescription().equals(txtDescription.getText())) {
						fields.put("ds_product", txtDescription.getText());
					}
				}
				if(checkboxValue.isSelected()) {
					if(FormAddProduct.isEmpty(txtValue.getText(), "valor")) return;
					if(!FormAddProduct.isDouble(txtValue.getText())) { 
						FormAddProduct.showMessage("Digite um número no campo valor");
						txtValue.setText(""); 
						return;
					}
					if(!product.getValue().equals(Double.parseDouble(txtValue.getText().replaceAll(",", ".")))) {
						txtValue.setText(txtValue.getText().replaceAll(",", "."));
						fields.put("vl_unit_product", txtValue.getText());
					}
				}
				if(checkboxImage.isSelected()) {
					if(FormAddProduct.isEmpty(txtImage.getText(), "imagem")) return;
					if(!product.getImage().equals(txtImage.getText())) {
						fields.put("nm_path_image_product", txtImage.getText());
					}
				}
				if(checkboxSupplier.isSelected()) {
					if(FormAddProduct.isEmpty(txtSupplier.getText(), "fornecedor")) return;
					if(!product.getSupplier().equals(txtSupplier.getText())) {
						fields.put("nm_supplier_product", txtSupplier.getText());
					}
				}
				
				if(fields.size() == 0) return;
				
				JdbcConnection.updateProduct(fields, cd);
				clear(txtDescription);
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
	}
	public void changeEditableState(ItemEvent e, JTextField field) {
		if(e.getStateChange()  == ItemEvent.SELECTED) {
			System.out.println("editable = true");
			field.setEditable(true);
		}else {
			System.out.println("editable = false");
			field.setEditable(false);
			field.setText("");
		}
	}
	public void changeEditableState(ItemEvent e, JTextArea field) {
		if(e.getStateChange()  == ItemEvent.SELECTED) {
			System.out.println("editable = true");
			field.setEditable(true);
		}else {
			System.out.println("editable = false");
			field.setEditable(false);
			field.setText("");
		}
	}
	public void changeEditableState(ItemEvent e, JButton btn) {
		if(e.getStateChange()  == ItemEvent.SELECTED) {
			System.out.println("editable = true");
			btn.setEnabled(true);
		}else {
			System.out.println("editable = false");
			btn.setEnabled(false);
		}
		
	}

	public void clear(JTextArea txtDescription) {
		txtName.setText("");
		txtId.setText("");
		txtValue.setText("");
		txtDescription.setText("");
		txtSupplier.setText("");
		txtImage.setText("");
	}
}
