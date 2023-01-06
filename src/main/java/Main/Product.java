package Main;



public class Product {
	private int cd_product; 
	private String nm_product;
	private String ds_product;
	private double vl_unit_product; 
	private String nm_supplier_product;
	private String nm_path_image_product;
	
	//GET
	public int getCd() {
		return cd_product;
	}
	public String getName() {
		return nm_product;
	}
	public String getDescription() {
		return ds_product;
	}
	public Double getValue() {
		return vl_unit_product;
	}
	public String getSupplier() {
		return nm_supplier_product;
	}
	public String getImage() {
		return nm_path_image_product;
	}
	//SET
	public void setCd(int cd_product) {
		this.cd_product = cd_product;
	}
	public void setName(String nm_product) {
		this.nm_product = nm_product;
	}
	public void setDescription(String ds_product) {
		this.ds_product = ds_product;
	}
	public void setValue(double vl_unit_product) {
		this.vl_unit_product = vl_unit_product;
	}
	public void setSupplier(String nm_supplier_product) {
		this.nm_supplier_product = nm_supplier_product;
	}
	public void setImage(String nm_path_image_product) {
		this.nm_path_image_product = nm_path_image_product;
	}
	
	


	
	
}
