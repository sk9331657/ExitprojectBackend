package com.nagarro.exitproject.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;



@Entity
@Table(name="Products")
public class Products { 
	
	
     	@Id 
     	@Column(name="YmartId")
     	@GeneratedValue(strategy=GenerationType.AUTO) 
     	private long YmartId;
     	
     	
     	@Column(name = "Color")
	    private String Color;
     	
     	@Column(name = "Comments")
	    private ArrayList<String> comments;
     	
     	public ArrayList<String> getComments() {
			return comments;
		}

		public void setComments(ArrayList<String> comments) {
			this.comments = comments;
		}

		@Column(name = "Ratings")
	    private String Ratings;
     	
     	@Column(name = "Warranty")
	    private String Warranty;
     	
     	@Column(name = "Categories")
	    private String Categories;
     	
     	@Column(name = "Created")
	    private String Created;

		public String getCreated() {
			return Created;
		}

		public void setCreated(String created) {
			Created = created;
		}

		public String getColor() {
			return Color;
		}

		public void setColor(String color) {
			Color = color;
		}

		public String getRatings() {
			return Ratings;
		}

		public void setRatings(String ratings) {
			Ratings = ratings;
		}

		public String getWarranty() {
			return Warranty;
		}

		public void setWarranty(String warranty) {
			Warranty = warranty;
		}

		public String getCategories() {
			return Categories;
		}

		public void setCategories(String categories) {
			Categories = categories;
		}

		@Column(name = "Name")
	    private String name;
	    
		@Column(name = "SellerProductCode")
	    private String sellerproductCode;
		
		@Column(name = "SellerCode")
	    private String sellerCode;
		
		public String getSellerCode() {
			return sellerCode;
		}

		public void setSellerCode(String sellerCode) {
			this.sellerCode = sellerCode;
		}

		@Column(name = "shortDes",columnDefinition = "TEXT")
	    private String shortDes;
	    
	    @Column(name = "longDes",columnDefinition = "TEXT")
	    private String longDes;
	    
	    @Column(name = "dimensions")
	    private String dimensions;
	    
	    @Column(name = "MRP")
	    private double MRP;
	    
	    @Column(name = "SSP")
	    private double SSP;

	    @Column(name = "YMP")
	    private double YMP;
	    
	    @Column(name = "Images")
	    private String images;
	    
	    @Column(name = "Instructions")
	    private String instructions;
	    
	    public long getYmartId() {
			return YmartId;
		}

		public void setYmartId(long ymartId) {
			YmartId = ymartId;
		}
		
	    public String getSellerproductCode() {
			return sellerproductCode;
		}

		public void setSellerproductCode(String sellerproductCode) {
			this.sellerproductCode = sellerproductCode;
		}

	    
	    public String getInstructions() {
			return instructions;
		}

		public void setInstructions(String instructions) {
			this.instructions = instructions;
		}

		@Column(name = "Status")
	    private String status;

	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getShortDes() {
			return shortDes;
		}

		public void setShortDes(String shortDes) {
			this.shortDes = shortDes;
		}

		public String getLongDes() {
			return longDes;
		}

		public void setLongDes(String longDes) {
			this.longDes = longDes;
		}

		public String getDimensions() {
			return dimensions;
		}

		public void setDimensions(String dimensions) {
			this.dimensions = dimensions;
		}

		public double getMRP() {
			return MRP;
		}

		public void setMRP(double mRP) {
			MRP = mRP;
		}

		public double getSSP() {
			return SSP;
		}

		public void setSSP(double sSP) {
			SSP = sSP;
		}

		public double getYMP() {
			return YMP;
		}

		public void setYMP(double yMP) {
			YMP = yMP;
		}

		public String getImages() {
			return images;
		}

		public void setImages(String images) {
			this.images = images;
		}

	

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		@SuppressWarnings("unchecked")
		public String toString() {
			JSONObject obj = new JSONObject();
			obj.put("Name", this.getName());
			obj.put("shortDes",this.getShortDes());
			obj.put("longDes",this.getLongDes());
			obj.put("Dimensions",this.getDimensions());
			obj.put("MRP",this.getMRP() );
			obj.put("SSP",this.getSSP());
			obj.put("YMP",this.getYMP() );
			obj.put("Images",this.getImages());
			obj.put("Instructions",this.getInstructions());
			obj.put("YmartId", this.getYmartId());
			obj.put("Created", this.getCreated());
			obj.put("Status", this.getStatus());
			obj.put("SellerProductCode", this.getSellerproductCode());
			obj.put("Comments", this.getComments() );
			obj.put("Categories", this.getCategories() );
			obj.put("Warranty", this.getWarranty() );

			return obj.toString();
		}


		
}
