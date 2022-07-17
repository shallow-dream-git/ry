import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listFee(query) {
  return request({
    url: '/system/fee/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getFee(roomId) {
  return request({
    url: '/system/fee/' + roomId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addFee(data) {
  return request({
    url: '/system/fee',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateFee(data) {
  return request({
    url: '/system/fee',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delFee(roomId) {
  return request({
    url: '/system/fee/' + roomId,
    method: 'delete'
  })
}
