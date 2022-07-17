package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysFee;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-16
 */
public interface SysFeeMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param roomId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysFee selectSysFeeByRoomId(Long roomId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysFee 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysFee> selectSysFeeList(SysFee sysFee);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysFee 【请填写功能名称】
     * @return 结果
     */
    public int insertSysFee(SysFee sysFee);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysFee 【请填写功能名称】
     * @return 结果
     */
    public int updateSysFee(SysFee sysFee);

    /**
     * 删除【请填写功能名称】
     * 
     * @param roomId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysFeeByRoomId(Long roomId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param roomIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysFeeByRoomIds(Long[] roomIds);
}
