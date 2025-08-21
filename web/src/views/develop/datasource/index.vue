<template>
  <CommonPage>
    <template #action>
      <NButton v-permission="'AddDataSource'" type="primary" size="small" @click="handleAdd()">
        <i class="i-material-symbols:add mr-4 text-18" />
        新增数据源
      </NButton>
    </template>
    <MeCrud
      ref="$table"
      :scroll-x="1200"
      :columns="columns"
      :get-data="api.read"
    />
  </CommonPage>
</template>

<script setup lang="js">
import { NButton, NSwitch } from 'naive-ui'
import { ref } from 'vue'
import api from './api'
import { CommonPage, MeCrud } from '@/components/index.js'
import { formatDateTime } from '@/utils/index'
import isPermission from '@/utils/permissionsTool'
// 定义组件名称。设置keepAlive需将组件的name设置成当前菜单的code。一定要这样写才可以切换页面时保存当前标签页的状态。
defineOptions({ name: 'DataSourceMgt' })

const $table = ref(null)

// 页码挂载函数
onMounted(() => {
  $table.value?.handleSearch()
})

const columns = [
  {
    title: '图标',
    key: 'type',
    render: ({ icon }) =>
      h(
        'i',
        {
          class: icon,
        },
      ),
  },
  { title: '名称', key: 'name' },
  { title: '驱动类', key: 'driverClassName' },
  { title: '用户名', key: 'username' },
  {
    title: '创建时间',
    key: 'createdTime',
    render(row) {
      return h('span', formatDateTime(row.createdTime))
    },
  },
  {
    title: '操作',
    key: 'actions',
    width: 320,
    align: 'right',
    fixed: 'right',
    render(row) {
      return [
        h(
          NButton,
          {
            size: 'tiny',
            type: 'primary',
            style: 'margin-left: 12px;',
            disabled: row.code === 'SUPER_ADMIN' || !isPermission('EditRole'),
            onClick: () => handelEditRole(row),
          },
          {
            default: () => '编辑',
            icon: () => h('i', { class: 'i-me:edit text-14' }),
          },
        ),

        h(
          NButton,
          {
            size: 'tiny',
            type: 'error',
            style: 'margin-left: 12px;',
            disabled: row.code === 'SUPER_ADMIN' || !isPermission('DelRole'),
            onClick: () => handleDelete({ ids: [row.id] }),
          },
          {
            default: () => '删除',
            icon: () => h('i', { class: 'i-material-symbols:delete-outline text-14' }),
          },
        ),
      ]
    },
  },
]
</script>

<style scoped>
</style>
