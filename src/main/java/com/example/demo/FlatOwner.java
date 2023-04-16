package com.example.demo;

public class FlatOwner {

    //manage all dependency in ExcelConfig.java file
    private String wing;
    private String flatNumber;
    private String ownerName;
    private String mobileNumber;
    private String whatsappNumber;
    private String emailId;
   

    
    public FlatOwner(String wing, String flatNumber, String ownerName, String mobileNumber, String whatsappNumber,
			String emailId) {
		super();
		this.wing = wing;
		this.flatNumber = flatNumber;
		this.ownerName = ownerName;
		this.mobileNumber = mobileNumber;
		this.whatsappNumber = whatsappNumber;
		this.emailId = emailId;
	}

	public String getWing() {
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

   
    
}
