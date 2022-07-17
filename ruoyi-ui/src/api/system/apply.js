import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listApply(query) {
  return request({
    url: '/system/apply/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getApply(rid) {
  return request({
    url: '/system/apply/' + rid,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addApply(data) {
  return request({
    url: '/system/apply',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateApply(data) {
  return request({
    url: '/system/apply',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delApply(rid) {
  return request({
    url: '/system/apply/' + rid,
    method: 'delete'
  })
}
