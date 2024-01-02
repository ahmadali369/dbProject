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
	
    public void printProductDetails() {
        System.out.println("Product ID: " + this.productid);
        System.out.println("Name: " + this.name);
        System.out.println("Description: " + this.discription);
        System.out.println("Price: " + this.priceDouble);
        System.out.println("Category: " + this.catagory);
        System.out.println("Cost: " + this.cost);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Image Path: " + this.imgPathString);
        System.out.println("Image Key: " + this.imgKey);
        // Additional logic for printing image bytes if needed
    }
	
    public void setValuesFromProduct(ProductTO otherProduct) {
        if (otherProduct != null) {
            this.productid = otherProduct.getProductid();
            this.name = otherProduct.getName();
            this.discription = otherProduct.getDiscription();
            this.priceDouble = otherProduct.getPriceDouble();
            this.catagory = otherProduct.getCatagory();
            this.cost = otherProduct.getCost();
            this.quantity = otherProduct.getQuantity();
            this.imgPathString = otherProduct.getImgPathString();
            this.imgKey = otherProduct.getImgKey();
            this.imgBytes = otherProduct.getImgBytes();
        }
    }

}
