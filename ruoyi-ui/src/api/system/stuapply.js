import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listStuapply(query) {
  return request({
    url: '/system/stuapply/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getStuapply(applyId) {
  return request({
    url: '/system/stuapply/' + applyId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addStuapply(data) {
  return request({
    url: '/system/stuapply',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateStuapply(data) {
  return request({
    url: '/system/stuapply',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delStuapply(applyId) {
  return request({
    url: '/system/stuapply/' + applyId,
    method: 'delete'
  })
}
