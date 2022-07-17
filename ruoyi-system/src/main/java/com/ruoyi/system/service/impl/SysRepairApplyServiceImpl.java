package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRepairApplyMapper;
import com.ruoyi.system.domain.SysRepairApply;
import com.ruoyi.system.service.ISysRepairApplyService;
//Invalid bound statement (not found): com.ruoyi.system.mapper.SysRepairApplyMapper.selectSysRepairApplyList
/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
@Service
public class SysRepairApplyServiceImpl implements ISysRepairApplyService 
{
    @Autowired
    private SysRepairApplyMapper sysRepairApplyMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param rid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysRepairApply selectSysRepairApplyByRid(Long rid)
    {
        return sysRepairApplyMapper.selectSysRepairApplyByRid(rid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysRepairApply 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysRepairApply> selectSysRepairApplyList(SysRepairApply sysRepairApply)
    {
        return sysRepairApplyMapper.selectSysRepairApplyList(sysRepairApply);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysRepairApply 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysRepairApply(SysRepairApply sysRepairApply)
    {
        return sysRepairApplyMapper.insertSysRepairApply(sysRepairApply);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysRepairApply 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysRepairApply(SysRepairApply sysRepairApply)
    {
        return sysRepairApplyMapper.updateSysRepairApply(sysRepairApply);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param rids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysRepairApplyByRids(Long[] rids)
    {
        return sysRepairApplyMapper.deleteSysRepairApplyByRids(rids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param rid 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysRepairApplyByRid(Long rid)
    {
        return sysRepairApplyMapper.deleteSysRepairApplyByRid(rid);
    }
}
