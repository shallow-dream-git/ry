package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysRepairApply;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
public interface ISysRepairApplyService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param rid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysRepairApply selectSysRepairApplyByRid(Long rid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysRepairApply 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysRepairApply> selectSysRepairApplyList(SysRepairApply sysRepairApply);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysRepairApply 【请填写功能名称】
     * @return 结果
     */
    public int insertSysRepairApply(SysRepairApply sysRepairApply);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysRepairApply 【请填写功能名称】
     * @return 结果
     */
    public int updateSysRepairApply(SysRepairApply sysRepairApply);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param rids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysRepairApplyByRids(Long[] rids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param rid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysRepairApplyByRid(Long rid);
}
