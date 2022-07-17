package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_fee
 * 
 * @author ruoyi
 * @date 2022-07-16
 */
public class SysFee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long roomId;

    /** 楼栋 */
    @Excel(name = "楼栋")
    private String roomDept;

    /** 宿舍号 */
    @Excel(name = "宿舍号")
    private Long roomNumber;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal roomFee;

    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setRoomDept(String roomDept) 
    {
        this.roomDept = roomDept;
    }

    public String getRoomDept() 
    {
        return roomDept;
    }
    public void setRoomNumber(Long roomNumber) 
    {
        this.roomNumber = roomNumber;
    }

    public Long getRoomNumber() 
    {
        return roomNumber;
    }
    public void setRoomFee(BigDecimal roomFee) 
    {
        this.roomFee = roomFee;
    }

    public BigDecimal getRoomFee() 
    {
        return roomFee;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roomId", getRoomId())
            .append("roomDept", getRoomDept())
            .append("roomNumber", getRoomNumber())
            .append("roomFee", getRoomFee())
            .toString();
    }
}
