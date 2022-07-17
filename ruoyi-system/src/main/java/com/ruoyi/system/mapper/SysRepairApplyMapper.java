package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRepairApply;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
public interface SysRepairApplyMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param rid 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysRepairApplyByRid(Long rid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param rids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRepairApplyByRids(Long[] rids);
}
