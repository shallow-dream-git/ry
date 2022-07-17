package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 sys_repair_apply
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
public class SysRepairApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 辨识一次维修的id */
    private Long rid;

    /** 电话号 */
    @Excel(name = "电话号")
    private String phone;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String sname;

    /** 旧楼栋号 */
    @Excel(name = "旧楼栋号")
    private Long olddept;

    /** 新楼栋号 */
    @Excel(name = "新楼栋号")
    private Long newdept;

    /** 旧宿舍
 */
    @Excel(name = "旧宿舍 ")
    private Long oldroom;

    /** 新宿舍号 */
    @Excel(name = "新宿舍号")
    private Long newroom;

    /** 申请状态：同意/审核中/不同意 */
    @Excel(name = "申请状态：同意/审核中/不同意")
    private String staus;

    public void setRid(Long rid) 
    {
        this.rid = rid;
    }

    public Long getRid() 
    {
        return rid;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setSname(String sname) 
    {
        this.sname = sname;
    }

    public String getSname() 
    {
        return sname;
    }
    public void setOlddept(Long olddept) 
    {
        this.olddept = olddept;
    }

    public Long getOlddept() 
    {
        return olddept;
    }
    public void setNewdept(Long newdept) 
    {
        this.newdept = newdept;
    }

    public Long getNewdept() 
    {
        return newdept;
    }
    public void setOldroom(Long oldroom) 
    {
        this.oldroom = oldroom;
    }

    public Long getOldroom() 
    {
        return oldroom;
    }
    public void setNewroom(Long newroom) 
    {
        this.newroom = newroom;
    }

    public Long getNewroom() 
    {
        return newroom;
    }
    public void setStaus(String staus) 
    {
        this.staus = staus;
    }

    public String getStaus() 
    {
        return staus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rid", getRid())
            .append("phone", getPhone())
            .append("sname", getSname())
            .append("olddept", getOlddept())
            .append("newdept", getNewdept())
            .append("oldroom", getOldroom())
            .append("newroom", getNewroom())
            .append("staus", getStaus())
            .toString();
    }
}
