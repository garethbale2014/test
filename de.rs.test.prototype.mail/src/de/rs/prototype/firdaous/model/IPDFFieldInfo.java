package de.rs.prototype.firdaous.model;

import java.util.Date;
import java.util.List;

public interface IPDFFieldInfo {

	public String getName();
	
	public String getPdfName() ;
	
	public FieldType getFieldType();
	
	public Object getFieldValue();
	
	public Integer getFieldValueInt();
	
	public Long getFieldValueLong();
	
	public String getFieldValueString();
	
	public Boolean getFieldValueBoolean();
	
	public Date getFieldValueDate();
	
	public Character getFieldValueCharacter();
	
	public List<Object> getFieldValueList();
	
	public void setName(String name) ;
	
	public void setPdfName(String pdfName);

	public void setFieldType(FieldType fieldType) ;

	public void setFieldValueInt(Integer fieldValueInt);

	public void setFieldValueLong(Long fieldValueLong);

	public void setFieldValueString(String fieldValueString);

	public void setFieldValueBoolean(Boolean fieldValueBoolean) ;

	public void setFieldValueDate(Date fieldValueDate);

	public void setFieldValueCharacter(Character fieldValueCharacter);

	public void setFieldValueList(List<Object> fieldValueList);
}
