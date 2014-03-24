package de.rs.prototype.firdaous.model;

public final class PhoneNumber {
	
	
    private  int area;   // area code (3 digits)
    private  int exch;   // exchange  (3 digits)
    private  int ext;    // extension (4 digits)

    private String telNumber;
    
    public PhoneNumber() {
		
	}
    
    public PhoneNumber(int area, int exch, int ext) {
        this.area = area;
        this.exch = exch;
        this.ext  = ext;
    }

    // how you're supposed to implement equals
    public boolean equals(Object y) {
        if (y == this) { return true;  }
        if (y == null) { return false; }
        if (y.getClass() != this.getClass()) { return false; }
        PhoneNumber a = this;
        PhoneNumber b = (PhoneNumber) y;
        return (a.area == b.area) && (a.exch == b.exch) && (a.ext == b.ext);
    }

    // 0 for padding with leading 0s
    public String toString() {
    	telNumber = String.format("(%03d) %03d-%04d", area, exch, ext);	
        return telNumber;
    }

    // satisfies the hashCode contract
    public int hashCode() {
        return 10007 * (area + 1009 * exch) + ext;
    }
    
    public String getTelNumber() {
		return telNumber;
	}
    
    public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
}
