package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 sys_room_stuapply
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
public class SysRoomStuapply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请id */
    private Long applyId;

    /** 申请人 */
    @Excel(name = "申请人")
    private String applySname;

    /** 申请人电话 */
    @Excel(name = "申请人电话")
    private String applyPhone;

    /** 旧宿舍楼 */
    @Excel(name = "旧宿舍楼")
    private Long olddept;

    /** 新宿舍楼 */
    @Excel(name = "新宿舍楼")
    private Long newdept;

    /** 旧宿舍 */
    @Excel(name = "旧宿舍")
    private Long oldroom;

    /** 新宿舍楼 */
    @Excel(name = "新宿舍楼")
    private Long newroom;

    /** 申请状态 */
    @Excel(name = "申请状态")
    private String status;

    public void setApplyId(Long applyId) 
    {
        this.applyId = applyId;
    }

    public Long getApplyId() 
    {
        return applyId;
    }
    public void setApplySname(String applySname) 
    {
        this.applySname = applySname;
    }

    public String getApplySname() 
    {
        return applySname;
    }
    public void setApplyPhone(String applyPhone) 
    {
        this.applyPhone = applyPhone;
    }

    public String getApplyPhone() 
    {
        return applyPhone;
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
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("applyId", getApplyId())
            .append("applySname", getApplySname())
            .append("applyPhone", getApplyPhone())
            .append("olddept", getOlddept())
            .append("newdept", getNewdept())
            .append("oldroom", getOldroom())
            .append("newroom", getNewroom())
            .append("status", getStatus())
            .toString();
    }
}
