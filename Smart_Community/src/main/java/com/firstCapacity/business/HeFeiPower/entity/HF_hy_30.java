package com.firstCapacity.business.HeFeiPower.entity;

import java.io.Serializable;
import java.util.Date;

public class HF_hy_30 implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	

    private Date time;  //时间

    private Float l1Tt01;  //低区天棚分水器温度=TT-01

    private Float l1Tt02;  //低区天棚集水器温度=TT-02

    private Float l1Tt03;  //新风分水器温度=TT-03

    private Float l1Tt04;  //新风集水器温度=TT-04

    private Float l1Tt05;  //地源集水器温度=TT-05

    private Float l1Tt06;  //地源分水器温度=TT-06

    private Float l1Tt07;  //冷却塔出水温度=TT-07

    private Float l1Tt08;  //冷却塔进水温度=TT-08

    private Float l1Ft01;  //低区天棚系统流量=FT-01

    private Float l1Ft02;  //新风系统流量=FT-02

    private Float l1Ft03;  //地源侧流量=FT-03

    private Float l1dybD6;  //地源循环泵变频频率反馈

    private Float l1tpbD6;  //天棚循环泵变频频率反馈

    private Float l1xfbD6;  //新风循环泵变频频率反馈

    private Float l1lqbD6;  //冷却循环泵变频频率反馈

    private Float cTSp1;  //1#机组制冷温度设定

    private Float cTSp2;  //2#机组制冷温度设定

    private Float cTSp3;  //3#机组制冷温度设定

    private Float cTSp4;  //4#机组制冷温度设定

    private Float cTSp5;  //5#机组制冷温度设定

    private Float hTSp1;  //1#机组热泵温度设定
 
    private Float hTSp2;  //2#机组热泵温度设定

    private Float hTSp3;  //3#机组热泵温度设定

    private Float hTSp4;  //4#机组热泵温度设定

    private Float hTSp5;  //5#机组热泵温度设定
 
    private Float t1Rf1T3;  //T1_RF_1送风温度

    private Float t1Rf1H1;  //T1_RF_1送风湿度

    private Float t1Rf1T4;  //T1_RF_1回风温度

    private Float t1Rf1H2;  //T1_RF_1回风湿度

    private Float t1Rf1Co2;  //T1_RF_1二氧化碳浓度监测

    private Float t1B11T3;  //T1_B1_1送风温度

    private Float t1B11H1;  //T1_B1_1送风湿度

    private Float t1B11T4;  //T1_B1_1回风温度

    private Float t1B11H2;  //T1_B1_1回风湿度

    private Float t1B11Co2;  //T1_B1_1二氧化碳浓度监测

    private Float t2B11T3;  //T2_B1_1送风温度

    private Float t2B11H1;  //T2_B1_1送风湿度

    private Float t2B11T4;  //T2_B1_1回风温度

    private Float t2B11H2;  //T2_B1_1回风湿度

    private Float t2B11Co2;  //T2_B1_1二氧化碳浓度监测

    private Float t2Rf1T3;  //T2_RF_1送风温度

    private Float t2Rf1H1;  //T2_RF_1送风湿度

    private Float t2Rf1T4;  //T2_RF_1回风温度

    private Float t2Rf1H2;  //T2_RF_1回风湿度

    private Float t2Rf1Co2;  //T2_RF_1二氧化碳浓度监测

    private Float t3Rf1T3;  //T3_RF_1送风温度

    private Float t3Rf1H1;  //T3_RF_1送风湿度

    private Float t3Rf1T4;  //T3_RF_1回风温度

    private Float t3Rf1H2;  //T3_RF_1回风湿度

    private Float t3Rf1Co2;  //T3_RF_1二氧化碳浓度监测

    private Float t3B11T3;  //T3_B1_1送风温度

    private Float t3B11H1;  //T3_B1_1送风湿度

    private Float t3B11T4;  //T3_B1_1回风温度

    private Float t3B11H2;  //T3_B1_1回风湿度

    private Float t3B11Co2;  //T3_B1_1二氧化碳浓度监测

    
    
    
    //虚拟字段
    private Float loadTotal;  //系统总负荷
    
    private Float loadDQTP;  //低区天棚负荷
    
    private Float loadGQXF;  //高区天棚加新风负荷
    
    private Double areaHVAC;  //空调面积
    
    private Float loadAvg;  //单位平米负荷
    
    private String timeGo;  //格式化日期
    
    private String time1;  //传入时间1
    
    private String time2;  //传入时间2
    
    private String runningTime;  //运行时间
    
    
    private Float fuheNow;  //当前负荷
    
    private Float fuheLast;  //同比上小时负荷
    
    private Float fuheLastBai;  //同比上小时负荷百分比
    
    
    
    
    
    
    
    
    public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public Float getFuheNow() {
		return fuheNow;
	}

	public void setFuheNow(Float fuheNow) {
		this.fuheNow = fuheNow;
	}

	public Float getFuheLast() {
		return fuheLast;
	}

	public void setFuheLast(Float fuheLast) {
		this.fuheLast = fuheLast;
	}

	public Float getFuheLastBai() {
		return fuheLastBai;
	}

	public void setFuheLastBai(Float fuheLastBai) {
		this.fuheLastBai = fuheLastBai;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getTimeGo() {
		return timeGo;
	}

	public void setTimeGo(String timeGo) {
		this.timeGo = timeGo;
	}

	public Float getLoadTotal() {
		return loadTotal;
	}

	public void setLoadTotal(Float loadTotal) {
		this.loadTotal = loadTotal;
	}

	public Float getLoadDQTP() {
		return loadDQTP;
	}

	public void setLoadDQTP(Float loadDQTP) {
		this.loadDQTP = loadDQTP;
	}

	public Float getLoadGQXF() {
		return loadGQXF;
	}

	public void setLoadGQXF(Float loadGQXF) {
		this.loadGQXF = loadGQXF;
	}



	public Double getAreaHVAC() {
		return areaHVAC;
	}

	public void setAreaHVAC(Double areaHVAC) {
		this.areaHVAC = areaHVAC;
	}

	public Float getLoadAvg() {
		return loadAvg;
	}

	public void setLoadAvg(Float loadAvg) {
		this.loadAvg = loadAvg;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.Time
     *
     * @return the value of HF_hy_30.Time
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.Time
     *
     * @param time the value for HF_hy_30.Time
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1_tt_01
     *
     * @return the value of HF_hy_30.l1_tt_01
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1Tt01() {
        return l1Tt01;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1_tt_01
     *
     * @param l1Tt01 the value for HF_hy_30.l1_tt_01
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1Tt01(Float l1Tt01) {
        this.l1Tt01 = l1Tt01;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1_tt_02
     *
     * @return the value of HF_hy_30.l1_tt_02
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1Tt02() {
        return l1Tt02;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1_tt_02
     *
     * @param l1Tt02 the value for HF_hy_30.l1_tt_02
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1Tt02(Float l1Tt02) {
        this.l1Tt02 = l1Tt02;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1_tt_03
     *
     * @return the value of HF_hy_30.l1_tt_03
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1Tt03() {
        return l1Tt03;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1_tt_03
     *
     * @param l1Tt03 the value for HF_hy_30.l1_tt_03
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1Tt03(Float l1Tt03) {
        this.l1Tt03 = l1Tt03;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1_tt_04
     *
     * @return the value of HF_hy_30.l1_tt_04
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1Tt04() {
        return l1Tt04;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1_tt_04
     *
     * @param l1Tt04 the value for HF_hy_30.l1_tt_04
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1Tt04(Float l1Tt04) {
        this.l1Tt04 = l1Tt04;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1_tt_05
     *
     * @return the value of HF_hy_30.l1_tt_05
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1Tt05() {
        return l1Tt05;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1_tt_05
     *
     * @param l1Tt05 the value for HF_hy_30.l1_tt_05
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1Tt05(Float l1Tt05) {
        this.l1Tt05 = l1Tt05;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1_tt_06
     *
     * @return the value of HF_hy_30.l1_tt_06
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1Tt06() {
        return l1Tt06;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1_tt_06
     *
     * @param l1Tt06 the value for HF_hy_30.l1_tt_06
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1Tt06(Float l1Tt06) {
        this.l1Tt06 = l1Tt06;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1_tt_07
     *
     * @return the value of HF_hy_30.l1_tt_07
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1Tt07() {
        return l1Tt07;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1_tt_07
     *
     * @param l1Tt07 the value for HF_hy_30.l1_tt_07
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1Tt07(Float l1Tt07) {
        this.l1Tt07 = l1Tt07;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1_tt_08
     *
     * @return the value of HF_hy_30.l1_tt_08
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1Tt08() {
        return l1Tt08;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1_tt_08
     *
     * @param l1Tt08 the value for HF_hy_30.l1_tt_08
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1Tt08(Float l1Tt08) {
        this.l1Tt08 = l1Tt08;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1_ft_01
     *
     * @return the value of HF_hy_30.l1_ft_01
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1Ft01() {
        return l1Ft01;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1_ft_01
     *
     * @param l1Ft01 the value for HF_hy_30.l1_ft_01
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1Ft01(Float l1Ft01) {
        this.l1Ft01 = l1Ft01;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1_ft_02
     *
     * @return the value of HF_hy_30.l1_ft_02
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1Ft02() {
        return l1Ft02;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1_ft_02
     *
     * @param l1Ft02 the value for HF_hy_30.l1_ft_02
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1Ft02(Float l1Ft02) {
        this.l1Ft02 = l1Ft02;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1_ft_03
     *
     * @return the value of HF_hy_30.l1_ft_03
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1Ft03() {
        return l1Ft03;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1_ft_03
     *
     * @param l1Ft03 the value for HF_hy_30.l1_ft_03
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1Ft03(Float l1Ft03) {
        this.l1Ft03 = l1Ft03;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1dyb_d_6
     *
     * @return the value of HF_hy_30.l1dyb_d_6
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1dybD6() {
        return l1dybD6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1dyb_d_6
     *
     * @param l1dybD6 the value for HF_hy_30.l1dyb_d_6
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1dybD6(Float l1dybD6) {
        this.l1dybD6 = l1dybD6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1tpb_d_6
     *
     * @return the value of HF_hy_30.l1tpb_d_6
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1tpbD6() {
        return l1tpbD6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1tpb_d_6
     *
     * @param l1tpbD6 the value for HF_hy_30.l1tpb_d_6
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1tpbD6(Float l1tpbD6) {
        this.l1tpbD6 = l1tpbD6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1xfb_d_6
     *
     * @return the value of HF_hy_30.l1xfb_d_6
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1xfbD6() {
        return l1xfbD6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1xfb_d_6
     *
     * @param l1xfbD6 the value for HF_hy_30.l1xfb_d_6
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1xfbD6(Float l1xfbD6) {
        this.l1xfbD6 = l1xfbD6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.l1lqb_d_6
     *
     * @return the value of HF_hy_30.l1lqb_d_6
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getL1lqbD6() {
        return l1lqbD6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.l1lqb_d_6
     *
     * @param l1lqbD6 the value for HF_hy_30.l1lqb_d_6
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setL1lqbD6(Float l1lqbD6) {
        this.l1lqbD6 = l1lqbD6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.c_t_sp_1
     *
     * @return the value of HF_hy_30.c_t_sp_1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getcTSp1() {
        return cTSp1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.c_t_sp_1
     *
     * @param cTSp1 the value for HF_hy_30.c_t_sp_1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setcTSp1(Float cTSp1) {
        this.cTSp1 = cTSp1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.c_t_sp_2
     *
     * @return the value of HF_hy_30.c_t_sp_2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getcTSp2() {
        return cTSp2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.c_t_sp_2
     *
     * @param cTSp2 the value for HF_hy_30.c_t_sp_2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setcTSp2(Float cTSp2) {
        this.cTSp2 = cTSp2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.c_t_sp_3
     *
     * @return the value of HF_hy_30.c_t_sp_3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getcTSp3() {
        return cTSp3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.c_t_sp_3
     *
     * @param cTSp3 the value for HF_hy_30.c_t_sp_3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setcTSp3(Float cTSp3) {
        this.cTSp3 = cTSp3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.c_t_sp_4
     *
     * @return the value of HF_hy_30.c_t_sp_4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getcTSp4() {
        return cTSp4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.c_t_sp_4
     *
     * @param cTSp4 the value for HF_hy_30.c_t_sp_4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setcTSp4(Float cTSp4) {
        this.cTSp4 = cTSp4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.c_t_sp_5
     *
     * @return the value of HF_hy_30.c_t_sp_5
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getcTSp5() {
        return cTSp5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.c_t_sp_5
     *
     * @param cTSp5 the value for HF_hy_30.c_t_sp_5
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setcTSp5(Float cTSp5) {
        this.cTSp5 = cTSp5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.h_t_sp_1
     *
     * @return the value of HF_hy_30.h_t_sp_1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float gethTSp1() {
        return hTSp1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.h_t_sp_1
     *
     * @param hTSp1 the value for HF_hy_30.h_t_sp_1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void sethTSp1(Float hTSp1) {
        this.hTSp1 = hTSp1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.h_t_sp_2
     *
     * @return the value of HF_hy_30.h_t_sp_2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float gethTSp2() {
        return hTSp2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.h_t_sp_2
     *
     * @param hTSp2 the value for HF_hy_30.h_t_sp_2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void sethTSp2(Float hTSp2) {
        this.hTSp2 = hTSp2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.h_t_sp_3
     *
     * @return the value of HF_hy_30.h_t_sp_3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float gethTSp3() {
        return hTSp3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.h_t_sp_3
     *
     * @param hTSp3 the value for HF_hy_30.h_t_sp_3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void sethTSp3(Float hTSp3) {
        this.hTSp3 = hTSp3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.h_t_sp_4
     *
     * @return the value of HF_hy_30.h_t_sp_4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float gethTSp4() {
        return hTSp4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.h_t_sp_4
     *
     * @param hTSp4 the value for HF_hy_30.h_t_sp_4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void sethTSp4(Float hTSp4) {
        this.hTSp4 = hTSp4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.h_t_sp_5
     *
     * @return the value of HF_hy_30.h_t_sp_5
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float gethTSp5() {
        return hTSp5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.h_t_sp_5
     *
     * @param hTSp5 the value for HF_hy_30.h_t_sp_5
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void sethTSp5(Float hTSp5) {
        this.hTSp5 = hTSp5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t1_rf_1_t3
     *
     * @return the value of HF_hy_30.t1_rf_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT1Rf1T3() {
        return t1Rf1T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t1_rf_1_t3
     *
     * @param t1Rf1T3 the value for HF_hy_30.t1_rf_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT1Rf1T3(Float t1Rf1T3) {
        this.t1Rf1T3 = t1Rf1T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t1_rf_1_h1
     *
     * @return the value of HF_hy_30.t1_rf_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT1Rf1H1() {
        return t1Rf1H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t1_rf_1_h1
     *
     * @param t1Rf1H1 the value for HF_hy_30.t1_rf_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT1Rf1H1(Float t1Rf1H1) {
        this.t1Rf1H1 = t1Rf1H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t1_rf_1_t4
     *
     * @return the value of HF_hy_30.t1_rf_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT1Rf1T4() {
        return t1Rf1T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t1_rf_1_t4
     *
     * @param t1Rf1T4 the value for HF_hy_30.t1_rf_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT1Rf1T4(Float t1Rf1T4) {
        this.t1Rf1T4 = t1Rf1T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t1_rf_1_h2
     *
     * @return the value of HF_hy_30.t1_rf_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT1Rf1H2() {
        return t1Rf1H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t1_rf_1_h2
     *
     * @param t1Rf1H2 the value for HF_hy_30.t1_rf_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT1Rf1H2(Float t1Rf1H2) {
        this.t1Rf1H2 = t1Rf1H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t1_rf_1_co2
     *
     * @return the value of HF_hy_30.t1_rf_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT1Rf1Co2() {
        return t1Rf1Co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t1_rf_1_co2
     *
     * @param t1Rf1Co2 the value for HF_hy_30.t1_rf_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT1Rf1Co2(Float t1Rf1Co2) {
        this.t1Rf1Co2 = t1Rf1Co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t1_b1_1_t3
     *
     * @return the value of HF_hy_30.t1_b1_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT1B11T3() {
        return t1B11T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t1_b1_1_t3
     *
     * @param t1B11T3 the value for HF_hy_30.t1_b1_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT1B11T3(Float t1B11T3) {
        this.t1B11T3 = t1B11T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t1_b1_1_h1
     *
     * @return the value of HF_hy_30.t1_b1_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT1B11H1() {
        return t1B11H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t1_b1_1_h1
     *
     * @param t1B11H1 the value for HF_hy_30.t1_b1_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT1B11H1(Float t1B11H1) {
        this.t1B11H1 = t1B11H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t1_b1_1_t4
     *
     * @return the value of HF_hy_30.t1_b1_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT1B11T4() {
        return t1B11T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t1_b1_1_t4
     *
     * @param t1B11T4 the value for HF_hy_30.t1_b1_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT1B11T4(Float t1B11T4) {
        this.t1B11T4 = t1B11T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t1_b1_1_h2
     *
     * @return the value of HF_hy_30.t1_b1_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT1B11H2() {
        return t1B11H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t1_b1_1_h2
     *
     * @param t1B11H2 the value for HF_hy_30.t1_b1_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT1B11H2(Float t1B11H2) {
        this.t1B11H2 = t1B11H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t1_b1_1_co2
     *
     * @return the value of HF_hy_30.t1_b1_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT1B11Co2() {
        return t1B11Co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t1_b1_1_co2
     *
     * @param t1B11Co2 the value for HF_hy_30.t1_b1_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT1B11Co2(Float t1B11Co2) {
        this.t1B11Co2 = t1B11Co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t2_b1_1_t3
     *
     * @return the value of HF_hy_30.t2_b1_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT2B11T3() {
        return t2B11T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t2_b1_1_t3
     *
     * @param t2B11T3 the value for HF_hy_30.t2_b1_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT2B11T3(Float t2B11T3) {
        this.t2B11T3 = t2B11T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t2_b1_1_h1
     *
     * @return the value of HF_hy_30.t2_b1_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT2B11H1() {
        return t2B11H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t2_b1_1_h1
     *
     * @param t2B11H1 the value for HF_hy_30.t2_b1_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT2B11H1(Float t2B11H1) {
        this.t2B11H1 = t2B11H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t2_b1_1_t4
     *
     * @return the value of HF_hy_30.t2_b1_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT2B11T4() {
        return t2B11T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t2_b1_1_t4
     *
     * @param t2B11T4 the value for HF_hy_30.t2_b1_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT2B11T4(Float t2B11T4) {
        this.t2B11T4 = t2B11T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t2_b1_1_h2
     *
     * @return the value of HF_hy_30.t2_b1_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT2B11H2() {
        return t2B11H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t2_b1_1_h2
     *
     * @param t2B11H2 the value for HF_hy_30.t2_b1_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT2B11H2(Float t2B11H2) {
        this.t2B11H2 = t2B11H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t2_b1_1_co2
     *
     * @return the value of HF_hy_30.t2_b1_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT2B11Co2() {
        return t2B11Co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t2_b1_1_co2
     *
     * @param t2B11Co2 the value for HF_hy_30.t2_b1_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT2B11Co2(Float t2B11Co2) {
        this.t2B11Co2 = t2B11Co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t2_rf_1_t3
     *
     * @return the value of HF_hy_30.t2_rf_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT2Rf1T3() {
        return t2Rf1T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t2_rf_1_t3
     *
     * @param t2Rf1T3 the value for HF_hy_30.t2_rf_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT2Rf1T3(Float t2Rf1T3) {
        this.t2Rf1T3 = t2Rf1T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t2_rf_1_h1
     *
     * @return the value of HF_hy_30.t2_rf_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT2Rf1H1() {
        return t2Rf1H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t2_rf_1_h1
     *
     * @param t2Rf1H1 the value for HF_hy_30.t2_rf_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT2Rf1H1(Float t2Rf1H1) {
        this.t2Rf1H1 = t2Rf1H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t2_rf_1_t4
     *
     * @return the value of HF_hy_30.t2_rf_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT2Rf1T4() {
        return t2Rf1T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t2_rf_1_t4
     *
     * @param t2Rf1T4 the value for HF_hy_30.t2_rf_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT2Rf1T4(Float t2Rf1T4) {
        this.t2Rf1T4 = t2Rf1T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t2_rf_1_h2
     *
     * @return the value of HF_hy_30.t2_rf_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT2Rf1H2() {
        return t2Rf1H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t2_rf_1_h2
     *
     * @param t2Rf1H2 the value for HF_hy_30.t2_rf_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT2Rf1H2(Float t2Rf1H2) {
        this.t2Rf1H2 = t2Rf1H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t2_rf_1_co2
     *
     * @return the value of HF_hy_30.t2_rf_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT2Rf1Co2() {
        return t2Rf1Co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t2_rf_1_co2
     *
     * @param t2Rf1Co2 the value for HF_hy_30.t2_rf_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT2Rf1Co2(Float t2Rf1Co2) {
        this.t2Rf1Co2 = t2Rf1Co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t3_rf_1_t3
     *
     * @return the value of HF_hy_30.t3_rf_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT3Rf1T3() {
        return t3Rf1T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t3_rf_1_t3
     *
     * @param t3Rf1T3 the value for HF_hy_30.t3_rf_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT3Rf1T3(Float t3Rf1T3) {
        this.t3Rf1T3 = t3Rf1T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t3_rf_1_h1
     *
     * @return the value of HF_hy_30.t3_rf_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT3Rf1H1() {
        return t3Rf1H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t3_rf_1_h1
     *
     * @param t3Rf1H1 the value for HF_hy_30.t3_rf_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT3Rf1H1(Float t3Rf1H1) {
        this.t3Rf1H1 = t3Rf1H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t3_rf_1_t4
     *
     * @return the value of HF_hy_30.t3_rf_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT3Rf1T4() {
        return t3Rf1T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t3_rf_1_t4
     *
     * @param t3Rf1T4 the value for HF_hy_30.t3_rf_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT3Rf1T4(Float t3Rf1T4) {
        this.t3Rf1T4 = t3Rf1T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t3_rf_1_h2
     *
     * @return the value of HF_hy_30.t3_rf_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT3Rf1H2() {
        return t3Rf1H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t3_rf_1_h2
     *
     * @param t3Rf1H2 the value for HF_hy_30.t3_rf_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT3Rf1H2(Float t3Rf1H2) {
        this.t3Rf1H2 = t3Rf1H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t3_rf_1_co2
     *
     * @return the value of HF_hy_30.t3_rf_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT3Rf1Co2() {
        return t3Rf1Co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t3_rf_1_co2
     *
     * @param t3Rf1Co2 the value for HF_hy_30.t3_rf_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT3Rf1Co2(Float t3Rf1Co2) {
        this.t3Rf1Co2 = t3Rf1Co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t3_b1_1_t3
     *
     * @return the value of HF_hy_30.t3_b1_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT3B11T3() {
        return t3B11T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t3_b1_1_t3
     *
     * @param t3B11T3 the value for HF_hy_30.t3_b1_1_t3
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT3B11T3(Float t3B11T3) {
        this.t3B11T3 = t3B11T3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t3_b1_1_h1
     *
     * @return the value of HF_hy_30.t3_b1_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT3B11H1() {
        return t3B11H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t3_b1_1_h1
     *
     * @param t3B11H1 the value for HF_hy_30.t3_b1_1_h1
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT3B11H1(Float t3B11H1) {
        this.t3B11H1 = t3B11H1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t3_b1_1_t4
     *
     * @return the value of HF_hy_30.t3_b1_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT3B11T4() {
        return t3B11T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t3_b1_1_t4
     *
     * @param t3B11T4 the value for HF_hy_30.t3_b1_1_t4
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT3B11T4(Float t3B11T4) {
        this.t3B11T4 = t3B11T4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t3_b1_1_h2
     *
     * @return the value of HF_hy_30.t3_b1_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT3B11H2() {
        return t3B11H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t3_b1_1_h2
     *
     * @param t3B11H2 the value for HF_hy_30.t3_b1_1_h2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT3B11H2(Float t3B11H2) {
        this.t3B11H2 = t3B11H2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HF_hy_30.t3_b1_1_co2
     *
     * @return the value of HF_hy_30.t3_b1_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public Float getT3B11Co2() {
        return t3B11Co2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HF_hy_30.t3_b1_1_co2
     *
     * @param t3B11Co2 the value for HF_hy_30.t3_b1_1_co2
     *
     * @mbg.generated Mon Nov 13 13:42:44 CST 2017
     */
    public void setT3B11Co2(Float t3B11Co2) {
        this.t3B11Co2 = t3B11Co2;
    }
}