package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

public class FormSelectProduct extends JFrame {

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
					FormSelectProduct frame = new FormSelectProduct();
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
	public FormSelectProduct() {
		setTitle("Selecionar Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setBounds(325, 108, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Digite o nome do produto ou código");
		lblNewLabel.setBounds(130, 94, 205, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecionar Produto");
		lblNewLabel_1.setFont(new Font("Forte", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(164, 52, 185, 23);
		contentPane.add(lblNewLabel_1);
		
		final JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(281, 167, 151, 162);
		contentPane.add(lblImage);
		
		final JComboBox<Object> cmbSearch = new JComboBox<Object>();
		cmbSearch.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String search = ((JTextField)cmbSearch.getEditor().getEditorComponent()).getText();
				String[] nmProduct = JdbcConnection.selectProductNameId(search);
				cmbSearch.setModel(new DefaultComboBoxModel<Object>(nmProduct));
				cmbSearch.showPopup();
			}
		});

		cmbSearch.setEditable(true);
		cmbSearch.setBounds(130, 108, 174, 22);
		contentPane.add(cmbSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 167, 192, 162);
		contentPane.add(scrollPane);
		
		final JTextArea txtResponse = new JTextArea();
		scrollPane.setViewportView(txtResponse);
		txtResponse.setEditable(false);
		txtResponse.setWrapStyleWord(true);
		txtResponse.setLineWrap(true);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(128, 0, 0));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu form = new MainMenu();
				form.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(216, 340, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblBackground2 = new JLabel("New label");
		lblBackground2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground2.setIcon(new ImageIcon("C:\\Users\\felip\\Desktop\\Estudo\\Banco-de-dados\\productManager\\src\\main\\java\\img\\background\\background-2.jpg"));
		lblBackground2.setBounds(64, 23, 380, 355);
		contentPane.add(lblBackground2);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\felip\\Desktop\\Estudo\\Banco-de-dados\\productManager\\src\\main\\java\\img\\background\\background.jpg"));
		lblBackground.setBounds(0, 0, 486, 401);
		contentPane.add(lblBackground);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String search = ((JTextField)cmbSearch.getEditor().getEditorComponent()).getText();
				String[] nmProduct = JdbcConnection.selectProductNameId(search);
				//System.out.println("Print: " + nmProduct[0]);
				String id = "";
				for(int i = nmProduct[0].length()-1; i > 0; i--) {
					if(nmProduct[0].charAt(i) == '/') {
						break;
					}
					id += nmProduct[0].charAt(i);
				}
				id = new StringBuilder(id).reverse().toString();
				Product product = JdbcConnection.selectProduct(Integer.parseInt(id));
				txtResponse.setText("Nome: " + product.getName());
				txtResponse.setText(txtResponse.getText() + "\n\n");
				txtResponse.setText(txtResponse.getText() + "Descrição: " + product.getDescription());
				txtResponse.setText(txtResponse.getText() + "\n\n");
				txtResponse.setText(txtResponse.getText() +"Valor: " + Double.toString(product.getValue()).replace('.', ','));
				txtResponse.setText(txtResponse.getText() + "\n\n");
				txtResponse.setText(txtResponse.getText() +"Fornecedor: " + product.getSupplier());
				txtResponse.setText(txtResponse.getText() + "\n\n");
				txtResponse.setText(txtResponse.getText() +"Fornecedor: " + product.getImage());
				ImageIcon icon = new ImageIcon(product.getImage());
				Image image = icon.getImage();
				Image newImage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
				lblImage.setIcon(new ImageIcon(newImage));
			}
		});
	}
}
