package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysFee;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-07-16
 */
public interface ISysFeeService 
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
     * 批量删除【请填写功能名称】
     * 
     * @param roomIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysFeeByRoomIds(Long[] roomIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param roomId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysFeeByRoomId(Long roomId);
}
