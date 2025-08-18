<script setup lang="js">
import { NButton } from 'naive-ui'
// 定义组件名称。设置keepAlive需将组件的name设置成当前菜单的code。一定要这样写才可以切换页面时保存当前标签页的状态。
defineOptions({ name: 'DataSourceMgt' })

const showTable = ref(true)
</script>

<template>
  <CommonPage>
    <template #action>
      <NButton v-permission="'AddRole'" type="primary" size="small" @click="handleAdd()">
        <i class="i-material-symbols:add mr-4 text-18" />
        新增数据源
      </NButton>
      <NButton class="ml-4" size="large" ghost color="#4b5563" secondary type="tertiary">
        <i :class="showTable ? 'i-me:xicon-card' : 'i-me:xicon-table'" @click="showTable = !showTable" />
      </NButton>
    </template>
  </CommonPage>
</template>

<style scoped>
</style>
