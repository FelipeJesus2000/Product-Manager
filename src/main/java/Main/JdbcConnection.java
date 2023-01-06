package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;



public class JdbcConnection {
	private static Connection conn = null;
	private static Connection getConnection() {
		return conn;
	}
	public static Connection openConnection() {
		
        try {
        	conn = getConnection();
        	String mariaDb = "org.mariadb.jdbc.Driver";
			String url = "jdbc:mariadb://localhost:3306/db_product"; 
			String user = "root"; 
			String password = "root";
			
        	Class.forName(mariaDb);
        	conn = DriverManager.getConnection(url, user, password);
        /*	ResultSet query = conn.createStatement().executeQuery("show tables");
        	while (query.next()){
        		System.out.println(query.getString(1));
        	}*/
        	System.out.println("Conexão realizada com sucesso!!!");
        }catch(Exception e){
        	System.out.println(e);
        	conn = null;
        }
		return conn;	
	}
	public static void closeConnection() {
		try {
		conn.close();
		System.out.println("Conexão fechada com sucesso!!!");
		}catch(Exception e) {
			System.out.println("Não foi possivel fechar a conexão!!! Erro: " + e);
		}
	}	
		
	public static boolean insert(String sql, PreparedStatement ps) {
		boolean success = false;
		try {
			conn = openConnection();
			if(ps.execute()) {
				System.out.println("Inserção feita com sucesso!!!");
			}
			success = true;
		}catch(SQLException e) {
			System.out.println(e);
			success = false;
		}finally {
			closeConnection();
		}
		return success;
	}
	public static boolean insertIntoProduct(Product product) {
		try {
			conn = openConnection();
			String sql = "insert into tb_product (cd_product, nm_product, ds_product, vl_unit_product, "
					+ "nm_supplier_product, nm_path_image_product) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, product.getCd());
			ps.setString(2, product.getName());
			ps.setString(3, product.getDescription());
			ps.setDouble(4, product.getValue());
			ps.setString(5, product.getSupplier());
			ps.setString(6, product.getImage());
			
			//System.out.println(ps);
			if(insert(sql, ps)) 
				return true;
			else 
				return false;
			
		}catch(Exception e) {
			System.out.println("Não foi possivel inserir na tabela produto: " + e);
			return false;
		}
	}
	public static ResultSet select(String query) {
		try {
			conn = openConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        closeConnection();
	        return rs;
		}catch(Exception e){
			System.out.println("error: "+e);
			closeConnection();
			return null;
		}
		
	}
	public  static String[] selectProductNameId(String search){
		try {
			String query = "Select CONCAT((nm_product), '/\', (cd_product))\r\n"
					+ "from tb_product where CONCAT((nm_product), \"/\", (cd_product))\r\n"
					+ "LIKE '%"+search+"%'";
			
			ResultSet rs = select(query);
			if(rs == null)
				return null;
	       
	        //String[] nmProduct = null;
	        ArrayList<String> nmProduct = new ArrayList<String>();
	        nmProduct.add(search);
			while(rs.next()) { 
			      nmProduct.add(rs.getString(1));
			}
			return nmProduct.toArray(new String[nmProduct.size()]);
			        
		}catch(Exception e) {
			System.out.println("Erro ao selecionar produto!!! \n"+e);
			return null;
		}
		
	}
	public static Product selectProduct(int id) {
		try {
		String query = "Select * from tb_product where cd_product="+id;
		ResultSet rs = select(query);
	/*	if(rs == null)
			return null;*/
		
		//ArrayList<String> product = new ArrayList<String>();
		Product product = new Product();
		while(rs.next()) { 
			product.setCd(Integer.parseInt(rs.getString("cd_product")));
			product.setName(rs.getString("nm_product"));
			product.setDescription(rs.getString("ds_product"));
			product.setValue(Double.parseDouble(rs.getString("vl_unit_product")));
			product.setSupplier(rs.getString("nm_supplier_product"));
			product.setImage(rs.getString("nm_path_image_product"));
		}
		
		return product;
		//System.out.println("product" + product);
	}catch(Exception e) {
			System.out.println("Error" + e);
			return null;
		}
	}
	
	public static boolean deleteProduct(int cd) {
		try {
			conn = openConnection();
			String query = "Delete from tb_product where cd_product=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cd);
			ps.execute();
			closeConnection();
			return true;
		}catch(Exception e) {
			System.out.println("Não foi possivel deletar o produto!!!");
			System.out.println("Erro: " + e);
			return false;
		}
	}
	public static void updateProduct(Map<String, String> fields, int cd) {
		//String query = "update users set num_points = ? where first_name = ?";
		try {
			Product product = selectProduct(cd);
			if(product.getName() == null) return;
			conn = openConnection();
			String query = "Update tb_product ";
			int index = 0;
			
			for(String item:fields.keySet()) {
				query += "set " + item + "=?,";
			}
			query = query.substring(0, query.length()-1);
			query += " where cd_product=?";
			System.out.println(query);
			
			PreparedStatement ps = conn.prepareStatement(query);
			//System.out.println(str);
			
			index = 0;
			for(String item:fields.keySet()) {
					index++;
					if(item == "vl_unit_product") {
						ps.setDouble(index, Double.parseDouble(fields.get("vl_unit_product")));
					}else {
						ps.setString(index, fields.get(item));
					}
			}
			ps.setInt(index+1, cd);
			
			ps.executeUpdate();
			System.out.println(ps);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
