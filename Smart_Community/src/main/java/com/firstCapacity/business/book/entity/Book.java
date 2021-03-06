package com.firstCapacity.business.book.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.id
     *
     * @mbg.generated Wed Sep 20 23:10:19 CST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.name
     *
     * @mbg.generated Wed Sep 20 23:10:19 CST 2017
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.plice
     *
     * @mbg.generated Wed Sep 20 23:10:19 CST 2017
     */
    private String plice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.crest_time
     *
     * @mbg.generated Wed Sep 20 23:10:19 CST 2017
     */
    private String crestTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.id
     *
     * @return the value of book.id
     *
     * @mbg.generated Wed Sep 20 23:10:19 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.id
     *
     * @param id the value for book.id
     *
     * @mbg.generated Wed Sep 20 23:10:19 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.name
     *
     * @return the value of book.name
     *
     * @mbg.generated Wed Sep 20 23:10:19 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.name
     *
     * @param name the value for book.name
     *
     * @mbg.generated Wed Sep 20 23:10:19 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.plice
     *
     * @return the value of book.plice
     *
     * @mbg.generated Wed Sep 20 23:10:19 CST 2017
     */
    public String getPlice() {
        return plice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.plice
     *
     * @param plice the value for book.plice
     *
     * @mbg.generated Wed Sep 20 23:10:19 CST 2017
     */
    public void setPlice(String plice) {
        this.plice = plice == null ? null : plice.trim();
    }

	public String getCrestTime() {
		return crestTime;
	}

	public void setCrestTime(String crestTime) {
		this.crestTime = crestTime;
	}

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.crest_time
     *
     * @return the value of book.crest_time
     *
     * @mbg.generated Wed Sep 20 23:10:19 CST 2017
     */
  
}