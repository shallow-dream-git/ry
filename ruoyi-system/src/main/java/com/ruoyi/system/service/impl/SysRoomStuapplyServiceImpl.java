package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysRoomStuapply;
import com.ruoyi.system.mapper.SysRoomStuapplyMapper;
import com.ruoyi.system.service.ISysRoomStuapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
@Service
public class SysRoomStuapplyServiceImpl implements ISysRoomStuapplyService 
{
    @Autowired
    private SysRoomStuapplyMapper sysRoomStuapplyMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param applyId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysRoomStuapply selectSysRoomStuapplyByApplyId(Long applyId)
    {
        return sysRoomStuapplyMapper.selectSysRoomStuapplyByApplyId(applyId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysRoomStuapply 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysRoomStuapply> selectSysRoomStuapplyList(SysRoomStuapply sysRoomStuapply)
    {
        return sysRoomStuapplyMapper.selectSysRoomStuapplyList(sysRoomStuapply);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysRoomStuapply 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysRoomStuapply(SysRoomStuapply sysRoomStuapply)
    {
        return sysRoomStuapplyMapper.insertSysRoomStuapply(sysRoomStuapply);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysRoomStuapply 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysRoomStuapply(SysRoomStuapply sysRoomStuapply)
    {
        return sysRoomStuapplyMapper.updateSysRoomStuapply(sysRoomStuapply);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param applyIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysRoomStuapplyByApplyIds(Long[] applyIds)
    {
        return sysRoomStuapplyMapper.deleteSysRoomStuapplyByApplyIds(applyIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param applyId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysRoomStuapplyByApplyId(Long applyId)
    {
        return sysRoomStuapplyMapper.deleteSysRoomStuapplyByApplyId(applyId);
    }
}
