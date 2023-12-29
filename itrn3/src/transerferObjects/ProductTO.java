package transerferObjects;

public class ProductTO {

	int productid;
	String name;
	String discription;
	Double priceDouble;
	String catagory;
	Double cost;
	int quantity;
	String imgPathString;

	int imgKey;
	byte[] imgBytes;

	public byte[] getImgBytes() {
		return imgBytes;
	}

	public void setImgBytes(byte[] imgBytes) {
		this.imgBytes = imgBytes;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImgPathString() {
		return imgPathString;
	}

	public void setImgPathString(String imgPathString) {
		this.imgPathString = imgPathString;
	}

	public int getImgKey() {
		return imgKey;
	}

	public void setImgKey(int imgKey) {
		this.imgKey = imgKey;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Double getPriceDouble() {
		return priceDouble;
	}

	public void setPriceDouble(Double priceDouble) {
		this.priceDouble = priceDouble;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

}
