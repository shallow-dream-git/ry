package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysRoomStuapply;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
public interface SysRoomStuapplyMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param applyId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysRoomStuapply selectSysRoomStuapplyByApplyId(Long applyId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysRoomStuapply 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysRoomStuapply> selectSysRoomStuapplyList(SysRoomStuapply sysRoomStuapply);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysRoomStuapply 【请填写功能名称】
     * @return 结果
     */
    public int insertSysRoomStuapply(SysRoomStuapply sysRoomStuapply);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysRoomStuapply 【请填写功能名称】
     * @return 结果
     */
    public int updateSysRoomStuapply(SysRoomStuapply sysRoomStuapply);

    /**
     * 删除【请填写功能名称】
     * 
     * @param applyId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysRoomStuapplyByApplyId(Long applyId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param applyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRoomStuapplyByApplyIds(Long[] applyIds);
}
