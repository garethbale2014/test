package de.rs.prototype.firdaous.model;

import java.util.Date;
import java.util.List;

public class FieldInfo implements IPDFFieldInfo {

	String name;
	String pdfName;
	FieldType fieldType;
	Integer fieldValueInt;
	Long fieldValueLong;
	String fieldValueString;
	Boolean fieldValueBoolean;
	Date fieldValueDate;
	Character fieldValueCharacter;
	List<Object> fieldValueList;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getPdfName() {
		return pdfName;
	}

	@Override
	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}


	@Override
	public FieldType getFieldType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getFieldValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getFieldValueInt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getFieldValueLong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFieldValueString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getFieldValueBoolean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getFieldValueDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Character getFieldValueCharacter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getFieldValueList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	@Override
	public void setFieldValueInt(Integer fieldValueInt) {
		this.fieldValueInt = fieldValueInt;
	}
	@Override
	public void setFieldValueLong(Long fieldValueLong) {
		this.fieldValueLong = fieldValueLong;
	}
	@Override
	public void setFieldValueString(String fieldValueString) {
		this.fieldValueString = fieldValueString;
	}
	@Override
	public void setFieldValueBoolean(Boolean fieldValueBoolean) {
		this.fieldValueBoolean = fieldValueBoolean;
	}
	@Override
	public void setFieldValueDate(Date fieldValueDate) {
		this.fieldValueDate = fieldValueDate;
	}
	@Override
	public void setFieldValueCharacter(Character fieldValueCharacter) {
		this.fieldValueCharacter = fieldValueCharacter;
	}
	@Override
	public void setFieldValueList(List<Object> fieldValueList) {
		this.fieldValueList = fieldValueList;
	}
	


}
