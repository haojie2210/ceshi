package com.lianghaojie.haojie_redis.domain;

import java.io.Serializable;
/**
 * 
 * @ClassName: Employee 
 * @Description: TODO
 * @author:单击开始
 * @date: 2019年8月10日 上午9:26:32
 */
public class Employee implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @fieldName: id
	 * @fieldType: Integer
	 * @Description: TODO
	 */
	private Integer id;
	/**
	 * @fieldName: name
	 * @fieldType: String
	 * @Description: TODO
	 */
	private String name;
	/**
	 * @fieldName: phone
	 * @fieldType: String
	 * @Description: TODO
	 */
	private String phone;
	/**
	 * @fieldName: address
	 * @fieldType: String
	 * @Description: TODO
	 */
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	public Employee(Integer id, String name, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public Employee() {
		super();
	}
	
}
