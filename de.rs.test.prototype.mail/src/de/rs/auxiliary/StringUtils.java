package de.rs.auxiliary;

public final class StringUtils {
	/**
	 * 
	 */
	private StringUtils() {
		
	}	
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
    public static boolean equals(String str1, String str2) {
        return (str1 != null) ? str1.equals(str2) : str2 == null;
    }
    /**
     * 
     * @param left
     * @param right
     * @return
     */
	public static boolean equalsIgnoreCase (String left, String right) {
	    return (left != null) ? left.equalsIgnoreCase(right) : (right == null);
	}
	/**
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNullOrEmpty (String string) {
		return (string == null || string.length() == 0);
	}
	/**
	 * 
	 * @param string
	 * @return
	 */
	public static boolean hasLength (String string) {
		return (string != null && string.length() > 0);
	}
	/**
	 * 
	 * @param text
	 * @return
	 */
	public static boolean hasText (String text) {
	    if (isNullOrEmpty(text)) {
	        return false;
	    }
	    final int length = text.length ();
	    for (int i=0; i < length; ++i) {
	        if (!Character.isWhitespace (text.charAt (i))) {
	            return true;
	        }	    
	    }	    
	    return false;
	}
}

