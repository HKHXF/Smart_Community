package com.firstCapacity.business.user.entity;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_id
     *
     * @mbg.generated Tue Sep 26 11:27:45 CST 2017
     */
    private String roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_name
     *
     * @mbg.generated Tue Sep 26 11:27:45 CST 2017
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_remarks
     *
     * @mbg.generated Tue Sep 26 11:27:45 CST 2017
     */
    private String roleRemarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_time
     *
     * @mbg.generated Tue Sep 26 11:27:45 CST 2017
     */
    private String createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_id
     *
     * @return the value of role.role_id
     *
     * @mbg.generated Tue Sep 26 11:27:45 CST 2017
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_id
     *
     * @param roleId the value for role.role_id
     *
     * @mbg.generated Tue Sep 26 11:27:45 CST 2017
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_name
     *
     * @return the value of role.role_name
     *
     * @mbg.generated Tue Sep 26 11:27:45 CST 2017
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_name
     *
     * @param roleName the value for role.role_name
     *
     * @mbg.generated Tue Sep 26 11:27:45 CST 2017
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_remarks
     *
     * @return the value of role.role_remarks
     *
     * @mbg.generated Tue Sep 26 11:27:45 CST 2017
     */
    public String getRoleRemarks() {
        return roleRemarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_remarks
     *
     * @param roleRemarks the value for role.role_remarks
     *
     * @mbg.generated Tue Sep 26 11:27:45 CST 2017
     */
    public void setRoleRemarks(String roleRemarks) {
        this.roleRemarks = roleRemarks == null ? null : roleRemarks.trim();
    }

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_time
     *
     * @return the value of role.create_time
     *
     * @mbg.generated Tue Sep 26 11:27:45 CST 2017
     */
   
}