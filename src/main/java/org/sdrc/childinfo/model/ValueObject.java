package org.sdrc.childinfo.model;

public class ValueObject {
	private String key;
	private Object value;
	private String description;
	private String metadata;
	private Integer nid;
	
	
	
	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public ValueObject(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	public ValueObject(int key, String value) {
		this(new Integer(key).toString(),value);
	}
	public ValueObject(int key, String value,Integer nid) {
		this.key = String.valueOf(key);
		this.value = value;
		this.nid = nid;
	}

	public ValueObject() {
		// TODO Auto-generated constructor stub
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "ValueObject [key=" + key + ", value=" + value
				+ ", description=" + description + ", metadata="+ metadata +"]";
	}
	
	
}
