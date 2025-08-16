/**********************************
 * @FilePath: helpers.js
 * @Author: Ronnie Zhang
 * @LastEditor: Ronnie Zhang
 * @LastEditTime: 2023/12/04 22:46:22
 * @Email: zclzone@outlook.com
 * Copyright © 2023 Ronnie Zhang(大脸怪) | https://isme.top
 **********************************/

/**
 * 根据错误代码和消息解析资源错误，并根据情况提示用户。
 *
 * @param {number} code 错误代码。
 * @param {string} message 错误消息。
 * @param {boolean} needTip 是否需要提示用户，默认为 true。
 * @param {object} config 请求配置对象，包含一些额外的信息。
 * @returns {string} 解析后的错误消息。
 */
export function resolveResError(code, message, needTip = true) {
  switch (code) {
    // 处理表单未填写完成的错误
    // 参数验证不通过
    case 410:
      message = `表单未填写完: ${message}`
      break
    // 处理无权限请求被拒绝的错误
    case 403:
      message = `请求被拒绝: ${message}`
      break
    // 处理请求资源或接口不存在的错误
    case 404:
      message = '请求资源或接口不存在'
      break
    // 处理用户友好异常的错误
    case 500:
      message = `操作错误: ${message}`
      break
    // 处理未知错误
    default:
      message = message ?? `【${code}】: 未知异常!`
      break
  }
  // 如果需要提示，显示错误消息
  needTip && window.$message?.error(message)
  return { message, retry: false }
}
