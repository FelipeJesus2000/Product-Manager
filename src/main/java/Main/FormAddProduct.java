package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class FormAddProduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtSupplier;
	private JTextField txtValue;
	private JTextField txtImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAddProduct frame = new FormAddProduct();
					frame.setVisible(true);
					frame.setSize(453, 390 );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormAddProduct() {
		setBackground(new Color(255, 255, 255));
		setTitle("Adicionar Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 423);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(67, 80, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Produto");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(67, 142, 155, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(67, 201, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fornecedor");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(270, 247, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Valor Unitário");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(270, 80, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Imagem");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(270, 142, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtId = new JTextField();
		txtId.setBounds(67, 95, 155, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(67, 155, 155, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtSupplier = new JTextField();
		txtSupplier.setBounds(270, 262, 155, 20);
		contentPane.add(txtSupplier);
		txtSupplier.setColumns(10);
		
		txtValue = new JTextField();
		txtValue.setBounds(270, 95, 155, 20);
		contentPane.add(txtValue);
		txtValue.setColumns(10);
		
		txtImage = new JTextField();
		txtImage.setEditable(false);
		txtImage.setBounds(270, 155, 155, 20);
		contentPane.add(txtImage);
		txtImage.setColumns(10);
		
		final JTextArea txtDescription = new JTextArea();
		txtDescription.setLineWrap(true);
		txtDescription.setBounds(67, 215, 155, 67);
		contentPane.add(txtDescription);
		
		JLabel lblNewLabel_6 = new JLabel("Adicionar Produto");
		lblNewLabel_6.setFont(new Font("Forte", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(141, 39, 226, 30);
		contentPane.add(lblNewLabel_6);
		
		JButton btnClear = new JButton("Limpar");
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.setBackground(new Color(255, 255, 0));
		btnClear.setBounds(201, 317, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.setBackground(new Color(0, 128, 64));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBounds(336, 317, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Voltar");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(128, 0, 0));
		btnBack.setBounds(67, 317, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnSelectFile = new JButton("Selecionar Aquivo");
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectFile(txtImage);
				//if(getExtension(file.getPath() !=)
				
				
			}
		});
		btnSelectFile.setBounds(270, 179, 155, 23);
		contentPane.add(btnSelectFile);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\felip\\Desktop\\Estudo\\Banco-de-dados\\productManager\\src\\main\\java\\img\\background\\background-2.jpg"));
		lblNewLabel_8.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_8.setBounds(54, 27, 390, 329);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\felip\\Desktop\\Estudo\\Banco-de-dados\\productManager\\src\\main\\java\\img\\background\\background.jpg"));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setBackground(new Color(255, 0, 0));
		lblNewLabel_7.setBounds(0, 0, 484, 384);
		contentPane.add(lblNewLabel_7);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu form = new MainMenu();
				form.setVisible(true);
				dispose();
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear(txtDescription);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Product product = new Product();
				if(isEmpty(txtId.getText(), "Código")) {
					txtId.grabFocus();
					return;
				}else if(!isInteger(txtId.getText())) {
					txtId.grabFocus();
					showMessage("Digite um número no campo CÓDIGO!!!");
					return;
				}
				if(isEmpty(txtName.getText(), "Nome")) {
					txtName.grabFocus();
					return;
				}
				if(isEmpty(txtDescription.getText(), "Descrição")) {
					txtDescription.grabFocus();
					return;
				}
				if(isEmpty(txtValue.getText(), "Valor")) {
					txtValue.grabFocus();
					return;
				}else if(!isDouble(txtValue.getText())) {
					txtValue.grabFocus();
					showMessage("Digite um número no campo VALOR!!!");
					return;
				}
				if(isEmpty(txtSupplier.getText(), "Fornecedor")) {
					txtSupplier.grabFocus();
					return;
				}
				if(isEmpty(txtImage.getText(), "Imagem")) {
					txtImage.grabFocus();
					return;
				}
				if (JOptionPane.showConfirmDialog(null, "Deseja realmente inserir este produto?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				  System.out.println("Iniciando inserção...");
				} else {
					return;
				}
				try {
					txtValue.setText(txtValue.getText().replaceAll(",", "."));
					
					product.setCd(Integer.parseInt(txtId.getText()));
					product.setName(txtName.getText());
					product.setDescription(txtDescription.getText());
					product.setValue(Double.parseDouble(txtValue.getText()));
					product.setSupplier(txtSupplier.getText());
					product.setImage(txtImage.getText());
					
					
					if(JdbcConnection.insertIntoProduct(product)) {
						File file = new File(txtImage.getText());
						File newDir = new File("C:\\Users\\felip\\Desktop\\Estudo\\Banco-de-dados\\productManager\\src\\main\\java\\img\\product");
						boolean wasMoved = file.renameTo(new File(newDir, file.getName()));
						if(wasMoved) {
							 System.out.println("Arquivo movido para '" + newDir.getAbsolutePath() + "'");
			            } else {
			                System.out.println("Erro ao mover arquivo '" + file.getAbsolutePath() + "' para '"
			                        + newDir.getAbsolutePath() + "'");
			            }
						clear(txtDescription);
						showMessage("Produto inserido com sucesso!!!");
					}
				}catch(Exception e) {
					System.out.println("Error: " + e);
					showMessage("Erro ao inserir produto no banco de dados!!!");
				}
				
			}
		});
		
	}
	public static boolean isEmpty(String str, String fieldName) {
		String msg = "";
		if(str.isEmpty()) 
			msg = "Campo "+ fieldName.toUpperCase() +" não foi prenchido";
	
		if(str.replaceAll(" ", "").isEmpty()) 
			msg = "Campo "+ fieldName.toUpperCase() +" não foi prenchido";
		if(!msg.isEmpty()) {
			showMessage(msg);
	        return true;
		}
		return false;	
	}
	public static boolean isInteger(String str) {
		boolean number = (str != null && str.matches("[0-9]+"));
		return number;
	}
	public static boolean isDouble(String str) {
		try {
			Double.parseDouble(str.replaceAll(",", "."));
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
	public static void showMessage(String msg) {
		JOptionPane optionPane = new JOptionPane();
		optionPane.setMessage(msg);
		optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog(null, "Atenção");
        dialog.setVisible(true);
	}
	public void clear(JTextArea txtDescription) {
		txtName.setText("");
		txtId.setText("");
		txtValue.setText("");
		txtDescription.setText("");
		txtSupplier.setText("");
		txtImage.setText("");
	}
	public static String getExtension(String path) {
		int dotPosition = path.lastIndexOf(".");
		String extension = "";
		for(int i = dotPosition; i < path.length(); i++) {
			extension += path.charAt(i);
		}
		return extension;
		
	}
	public static void selectFile(JTextField txtImage) {
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(chooser);
			chooser.setVisible(true);
			File file = chooser.getSelectedFile();
			if(!file.exists()) {
				showMessage("Arquivo não encontrado!!!");
			}
			
			String[] extensions = new String[3];
			extensions[0] = ".png";
			extensions[1] = ".jpeg";
			extensions[2] = ".jpg";
			String ext = getExtension(file.getPath());
			for(int i = 0; i < extensions.length; i++) {
				if(extensions[i].compareTo(ext) == 0) break;

				if(i == extensions.length-1) {
					System.out.println();
					txtImage.setText("");
					showMessage("Aquivo inválido, por favor selecione uma imagem png ou jpeg");
					return;
				}
			}
			
			txtImage.setText(file.getPath());
		}catch(Exception e) {
			System.out.println("Error: " + e);
			showMessage("Ocorreu um erro ao selecionar o arquivo");
			return;
		}
	}
}
