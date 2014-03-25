package de.rs.prototype.firdaous.model;

import java.util.Date;
import java.util.List;

public class Field implements IField {

	private IPDFFieldInfo fieldInfo;
	
	public Field(IPDFFieldInfo fieldInfo) {
		this.fieldInfo = fieldInfo;
	}

	@Override
	public String getName() {
		return fieldInfo.getName();
	}

	@Override
	public String getPdfName() {
		return fieldInfo.getPdfName();
	}	
	@Override
	public FieldType getFieldType() {
		return fieldInfo.getFieldType();
	}
	@Override
	public Object getFieldValue() {
		return fieldInfo.getFieldValue();
	}
	@Override
	public Integer getFieldValueInt() {
		return fieldInfo.getFieldValueInt();
	}
	@Override
	public Long getFieldValueLong() {
		return fieldInfo.getFieldValueLong();
	}
	@Override
	public String getFieldValueString() {
		return fieldInfo.getFieldValueString();
	}
	@Override
	public Boolean getFieldValueBoolean() {
		return fieldInfo.getFieldValueBoolean();
	}
	@Override
	public Date getFieldValueDate() {
		return fieldInfo.getFieldValueDate();
	}
	@Override
	public Character getFieldValueCharacter() {
		return fieldInfo.getFieldValueCharacter();
	}
	@Override
	public List<Object> getFieldValueList() {
		return fieldInfo.getFieldValueList();
	}
	@Override
	public void setName(String name) {
		fieldInfo.setName(name);
	}
	@Override
	public void setPdfName(String pdfName) {
		fieldInfo.setPdfName(pdfName);
	}
	@Override
	public void setFieldType(FieldType fieldType) {
		fieldInfo.setFieldType(fieldType);
	}
	@Override
	public void setFieldValueInt(Integer fieldValueInt) {
		fieldInfo.setFieldValueInt(fieldValueInt);
	}
	@Override
	public void setFieldValueLong(Long fieldValueLong) {
		fieldInfo.setFieldValueLong(fieldValueLong);
	}
	@Override
	public void setFieldValueString(String fieldValueString) {
		fieldInfo.setFieldValueString(fieldValueString);
	}
	@Override
	public void setFieldValueBoolean(Boolean fieldValueBoolean) {
		fieldInfo.setFieldValueBoolean(fieldValueBoolean);
	}
	@Override
	public void setFieldValueDate(Date fieldValueDate) {
		fieldInfo.setFieldValueDate(fieldValueDate);
	}
	@Override
	public void setFieldValueCharacter(Character fieldValueCharacter) {
		fieldInfo.setFieldValueCharacter(fieldValueCharacter);
	}
	@Override
	public void setFieldValueList(List<Object> fieldValueList) {
		fieldInfo.setFieldValueList(fieldValueList);
	}
	
	
}
