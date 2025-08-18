<script setup lang="js">
import { NButton } from 'naive-ui'
// 定义组件名称。设置keepAlive需将组件的name设置成当前菜单的code。一定要这样写才可以切换页面时保存当前标签页的状态。
defineOptions({ name: 'DataSourceMgt' })
</script>

<template>
  <CommonPage>
    <template #action>
      <NButton v-permission="'AddRole'" type="primary" size="small" @click="handleAdd()">
        <i class="i-material-symbols:add mr-4 text-18" />
        新增数据源
      </NButton>
    </template>
    <NFlex vertical align="stretch">
      <NFlex inline size="large" width="100%">
        <n-card size="small" hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
        <n-card hoverable title="卡片插槽示例">
          <template #header-extra>
            #header-extra
          </template>
          卡片内容
          <template #footer>
            #footer
          </template>
          <template #action>
            #action
          </template>
        </n-card>
      </NFlex>
      <n-pagination :page-count="5" />
    </NFlex>
  </CommonPage>
</template>

<style scoped>
.n-card {
  max-width: 300px;
  border-radius: 8px;
}
</style>
