package com.firstCapacity.business.powerProject.mapper;

import java.util.List;

import com.firstCapacity.business.powerProject.entity.powerProject;
import com.firstCapacity.util.aop.DataSource;

public interface powerProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project
     *
     * @mbg.generated Fri Oct 20 10:24:47 CST 2017
     */
	@DataSource("A")
    int deleteByPrimaryKey(String projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project
     *
     * @mbg.generated Fri Oct 20 10:24:47 CST 2017
     */
	@DataSource("A")
    int insert(powerProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project
     *
     * @mbg.generated Fri Oct 20 10:24:47 CST 2017
     */
	@DataSource("A")
    int insertSelective(powerProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project
     *
     * @mbg.generated Fri Oct 20 10:24:47 CST 2017
     */
	@DataSource("A")
    powerProject selectByPrimaryKey(String projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project
     *
     * @mbg.generated Fri Oct 20 10:24:47 CST 2017
     */
	@DataSource("A")
    int updateByPrimaryKeySelective(powerProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project
     *
     * @mbg.generated Fri Oct 20 10:24:47 CST 2017
     */
	@DataSource("A")
    int updateByPrimaryKeyWithBLOBs(powerProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table power_project
     *
     * @mbg.generated Fri Oct 20 10:24:47 CST 2017
     */
	@DataSource("A")
    int updateByPrimaryKey(powerProject record);
    
	//新增校验是否存在
	@DataSource("A")
	public List<powerProject> chickOne(String projectName);
	
	//查询详情
	@DataSource("A")
	public powerProject selectOne(String projectId);
	
	//查询项目下的所有子集
	@DataSource("A")
	public List<powerProject> selectPid(String projectPid);
	
	//查询组织结构树
	@DataSource("A")
	public List<powerProject> queryListAll();
	
	//查询所有区域
	@DataSource("A")
	public List<powerProject> selectQuyu();
	
	//模糊查询项目列表
	@DataSource("A")
    public List<powerProject> selectqueryList(powerProject recor);
    
    //查询所有项目
    @DataSource("A")
    public List<powerProject> selectProject();
    
    //按照区域ID查询项目列表
    @DataSource("A")
    public List<powerProject> selectProbjectByQuyu(String projectId);
    
    //按照项目类型删除
    @DataSource("A")
    public void deleteFoProjectType(String projectType);
	
}