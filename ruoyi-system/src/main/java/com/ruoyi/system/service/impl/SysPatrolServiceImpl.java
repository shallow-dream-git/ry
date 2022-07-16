package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.SysPatrol;
import com.ruoyi.system.mapper.SysPatrolMapper;
import com.ruoyi.system.service.ISysPatrolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 巡查管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@Service
public class SysPatrolServiceImpl implements ISysPatrolService 
{
    @Autowired
    private SysPatrolMapper sysPatrolMapper;

    /**
     * 查询巡查管理
     * 
     * @param patrolId 巡查管理主键
     * @return 巡查管理
     */
    @Override
    public SysPatrol selectSysPatrolByPatrolId(Long patrolId)
    {
        return sysPatrolMapper.selectSysPatrolByPatrolId(patrolId);
    }

    /**
     * 查询巡查管理列表
     * 
     * @param sysPatrol 巡查管理
     * @return 巡查管理
     */
    @Override
    public List<SysPatrol> selectSysPatrolList(SysPatrol sysPatrol)
    {
        return sysPatrolMapper.selectSysPatrolList(sysPatrol);
    }

    /**
     * 新增巡查管理
     * 
     * @param sysPatrol 巡查管理
     * @return 结果
     */
    @Override
    public int insertSysPatrol(SysPatrol sysPatrol)
    {
        Long id=sysPatrol.getPatrolStaffId();
        String name=sysPatrol.getPatrolName();
        try{
            int exist = sysPatrolMapper.findExist(id,name);
            if(exist>0){
                return sysPatrolMapper.insertSysPatrol(sysPatrol);
            }else

                return 0;
        }catch (Exception e){
            AjaxResult.error("巡查人员不存在");
            return 0;
        }

    }

    /**
     * 修改巡查管理
     * 
     * @param sysPatrol 巡查管理
     * @return 结果
     */
    @Override
    public int updateSysPatrol(SysPatrol sysPatrol)
    {
        Long id=sysPatrol.getPatrolStaffId();
        String name=sysPatrol.getPatrolName();
        System.out.println();
        try{
            int exist = sysPatrolMapper.findExist(id,name);
            if(exist>0){
                return sysPatrolMapper.insertSysPatrol(sysPatrol);
            }else

                return 0;
        }catch (Exception e){
            AjaxResult.error("巡查人员不存在");
            return 0;
        }
    }

    /**
     * 批量删除巡查管理
     * 
     * @param patrolIds 需要删除的巡查管理主键
     * @return 结果
     */
    @Override
    public int deleteSysPatrolByPatrolIds(Long[] patrolIds)
    {
        return sysPatrolMapper.deleteSysPatrolByPatrolIds(patrolIds);
    }

    /**
     * 删除巡查管理信息
     * 
     * @param patrolId 巡查管理主键
     * @return 结果
     */
    @Override
    public int deleteSysPatrolByPatrolId(Long patrolId)
    {
        return sysPatrolMapper.deleteSysPatrolByPatrolId(patrolId);
    }
}
