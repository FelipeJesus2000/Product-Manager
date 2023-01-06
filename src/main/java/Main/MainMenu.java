package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class MainMenu extends JFrame  {

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
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//addKeyListener(this);
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("Menu Principal");
		lblTitle.setFont(new Font("Forte", Font.PLAIN, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		final JLabel lblImage = new JLabel("");
		
		lblImage.setIcon(new ImageIcon(MainMenu.class.getResource("/img/select.png")));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblImage, BorderLayout.CENTER);
		
		JButton btnArrowRight = new JButton("");
		btnArrowRight.setBorder(null);
		btnArrowRight.setBackground(new Color(255, 255, 255));
		ImageIcon icon = new ImageIcon("C:\\Users\\felip\\Desktop\\Estudo\\Banco-de-dados\\productManager\\src\\main\\java\\img\\icon\\p-right.png");
		Image image = icon.getImage();
		Image newImage = image.getScaledInstance(80, 420, Image.SCALE_SMOOTH);
		btnArrowRight.setIcon(new ImageIcon(newImage));
		contentPane.add(btnArrowRight, BorderLayout.EAST);
		
		JButton btnArrowLeft = new JButton("");
		btnArrowLeft.setBorder(null);
		btnArrowLeft.setForeground(new Color(0, 0, 0));
		btnArrowLeft.setBackground(new Color(255, 255, 255));
		icon = new ImageIcon("C:\\Users\\felip\\Desktop\\Estudo\\Banco-de-dados\\productManager\\src\\main\\java\\img\\icon\\p-left.png");
		image = icon.getImage();
		newImage = image.getScaledInstance(80, 420, Image.SCALE_SMOOTH);
		btnArrowLeft.setIcon(new ImageIcon(newImage));
		contentPane.add(btnArrowLeft, BorderLayout.WEST);
		
		btnArrowRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextOption(lblImage);
			}
		});
		btnArrowLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				backOption(lblImage);
			}
		});
		
		


		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "myAction");
			    getRootPane().getActionMap().put("myAction", new AbstractAction() {
			        /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public void actionPerformed(java.awt.event.ActionEvent e) {
			        	backOption(lblImage);
			        }
		});
			    
	    getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "myAction1");
				getRootPane().getActionMap().put("myAction1", new AbstractAction() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public void actionPerformed(java.awt.event.ActionEvent e) {
						nextOption(lblImage);
					}
		});
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "myAction2");
				getRootPane().getActionMap().put("myAction2", new AbstractAction() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public void actionPerformed(java.awt.event.ActionEvent e) {
						String option = getOption(lblImage);
						if(option == "select") {
							FormSelectProduct form = new FormSelectProduct();
							form.setVisible(true);
							dispose();
						}
						if(option == "add") {
							FormAddProduct form = new FormAddProduct();
							form.setVisible(true);
							dispose();
						}
						if(option == "alter") {
							FormUpdateProduct form = new FormUpdateProduct();
							form.setVisible(true);
							dispose();
						}
						if(option == "delete") {
							FormDeleteProduct form = new FormDeleteProduct();
							form.setVisible(true);
							dispose();
						}
				}
		});
				
		
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String option = getOption(lblImage);
				if(option == "select") {
					FormSelectProduct form = new FormSelectProduct();
					form.setVisible(true);
					dispose();
				}
				if(option == "add") {
					FormAddProduct form = new FormAddProduct();
					form.setVisible(true);
					dispose();
				}
				if(option == "alter") {
					FormUpdateProduct form = new FormUpdateProduct();
					form.setVisible(true);
					dispose();
				}
				if(option == "delete") {
					FormDeleteProduct form = new FormDeleteProduct();
					form.setVisible(true);
					dispose();
				}
			}
		});
		
		
		
	}
	public void nextOption(JLabel lblImg) {	
		String option = getOption(lblImg);
		if(option == "select") {
			lblImg.setIcon(new ImageIcon(MainMenu.class.getResource("/img/add.png")));
		}
		if(option == "add") {
			lblImg.setIcon(new ImageIcon(MainMenu.class.getResource("/img/alter.png")));
		}
		if(option == "alter") {
			lblImg.setIcon(new ImageIcon(MainMenu.class.getResource("/img/delete.png")));
		}
		if(option == "delete") {
			lblImg.setIcon(new ImageIcon(MainMenu.class.getResource("/img/select.png")));
		}
	}
	public void backOption(JLabel lblImg) {
		String option = getOption(lblImg);
		
		if(option == "select") {
			lblImg.setIcon(new ImageIcon(MainMenu.class.getResource("/img/delete.png")));
		}
		if(option == "add") {
			lblImg.setIcon(new ImageIcon(MainMenu.class.getResource("/img/select.png")));
		}
		if(option == "alter") {
			lblImg.setIcon(new ImageIcon(MainMenu.class.getResource("/img/add.png")));
		}
		if(option == "delete") {
			lblImg.setIcon(new ImageIcon(MainMenu.class.getResource("/img/alter.png")));
		}
	}
	public String getOption(JLabel lblImg) {
		String str = lblImg.getIcon().toString();
		if(str.indexOf("select") > -1) {
			return "select";
		}
		if(str.indexOf("add") > -1) {
			return "add";
		}
		if(str.indexOf("alter") > -1) {
			return "alter";
		}
		if(str.indexOf("delete") > -1) {
			return "delete";
		}
		return "Não foi encontrado";
	}
}
