package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.SysLate;
import com.ruoyi.system.mapper.SysLateMapper;
import com.ruoyi.system.service.ISysLateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 夜归管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@Service
public class SysLateServiceImpl implements ISysLateService
{
    @Autowired
    private SysLateMapper sysLateMapper;

    /**
     * 查询夜归管理
     * 
     * @param lateId 夜归管理主键
     * @return 夜归管理
     */
    @Override
    public SysLate selectSysLateByLateId(Long lateId)
    {
        return sysLateMapper.selectSysLateByLateId(lateId);
    }

    /**
     * 查询夜归管理列表
     * 
     * @param sysLate 夜归管理
     * @return 夜归管理
     */
    @Override
    public List<SysLate> selectSysLateList(SysLate sysLate)
    {
        return sysLateMapper.selectSysLateList(sysLate);
    }

    /**
     * 新增夜归管理
     * 
     * @param sysLate 夜归管理
     * @return 结果
     */
    @Override
    public int insertSysLate(SysLate sysLate)
    {
        Long id = sysLate.getLateStuId();
        String name = sysLate.getLateStuName();
        try {
            int exist = sysLateMapper.findExist(id, name);
            if (exist > 0) {
                return sysLateMapper.insertSysLate(sysLate);
            } else
                return 0;
        } catch (Exception e) {
            AjaxResult.error("学号姓名不符或不存在");
            return 0;
        }
    }

    /**
     * 修改夜归管理
     * 
     * @param sysLate 夜归管理
     * @return 结果
     */
    @Override
    public int updateSysLate(SysLate sysLate)
    {
        return sysLateMapper.updateSysLate(sysLate);
    }

    /**
     * 批量删除夜归管理
     * 
     * @param lateIds 需要删除的夜归管理主键
     * @return 结果
     */
    @Override
    public int deleteSysLateByLateIds(Long[] lateIds)
    {
        return sysLateMapper.deleteSysLateByLateIds(lateIds);
    }

    /**
     * 删除夜归管理信息
     * 
     * @param lateId 夜归管理主键
     * @return 结果
     */
    @Override
    public int deleteSysLateByLateId(Long lateId)
    {
        return sysLateMapper.deleteSysLateByLateId(lateId);
    }
}
