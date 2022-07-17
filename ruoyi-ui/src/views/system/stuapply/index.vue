<template>
  <div class="app-container">
<!--    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">-->
<!--      <el-form-item label="电话号" prop="phone">-->
<!--        <el-input-->
<!--          v-model="queryParams.applyPhone"-->
<!--          placeholder="请输入电话号"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="学生姓名" prop="sname">-->
<!--        <el-input-->
<!--          v-model="queryParams.applySname"-->
<!--          placeholder="请输入学生姓名"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item>-->
<!--        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>-->
<!--        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>-->
<!--      </el-form-item>-->
<!--    </el-form>-->

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:stuapply:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:stuapply:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:stuapply:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:stuapply:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="stuapplyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="申请id" align="center" prop="applyId" />-->
      <el-table-column label="申请人" align="center" prop="applySname" />
      <el-table-column label="联系电话" align="center" prop="applyPhone" />
      <el-table-column label="旧宿舍楼" align="center" prop="olddept" />
      <el-table-column label="新宿舍楼" align="center" prop="newdept" />
      <el-table-column label="旧宿舍" align="center" prop="oldroom" />
      <el-table-column label="新宿舍" align="center" prop="newroom" />
      <el-table-column label="申请状态" align="center" prop="status" />
<!--      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">-->
<!--        <template slot-scope="scope">-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-edit"-->
<!--            @click="handleUpdate(scope.row)"-->
<!--            v-hasPermi="['system:stuapply:edit']"-->
<!--          >修改</el-button>-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            type="text"-->
<!--            icon="el-icon-delete"-->
<!--            @click="handleDelete(scope.row)"-->
<!--            v-hasPermi="['system:stuapply:remove']"-->
<!--          >删除</el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="申请人" prop="applySname">
          <el-input v-model="form.applySname" placeholder="请输入申请人"  :disabled="true"/>
        </el-form-item>
        <el-form-item label="联系电话" prop="applyPhone">
          <el-input v-model="form.applyPhone" placeholder="请输入申请人电话" />
        </el-form-item>
        <el-form-item label="旧宿舍楼" prop="olddept">
          <el-input v-model="form.olddept" placeholder="请输入旧宿舍楼" />
        </el-form-item>
        <el-form-item label="新宿舍楼" prop="newdept">
          <el-input v-model="form.newdept" placeholder="请输入新宿舍楼" />
        </el-form-item>
        <el-form-item label="旧宿舍" prop="oldroom">
          <el-input v-model="form.oldroom" placeholder="请输入旧宿舍" />
        </el-form-item>
        <el-form-item label="新宿舍楼" prop="newroom">
          <el-input v-model="form.newroom" placeholder="请输入新宿舍楼" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listStuapply, getStuapply, delStuapply, addStuapply, updateStuapply } from "@/api/system/stuapply";

export default {
  name: "Stuapply",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 【请填写功能名称】表格数据
      stuapplyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        applySname: null,
        applyPhone: null,
        olddept: null,
        newdept: null,
        oldroom: null,
        newroom: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      // console.log("@",this.queryParams);
      var username = this.$store.state.user.name;
      this.queryParams.applySname = username;
      // console.log("@@",username);
      listStuapply(this.queryParams).then(response => {
        this.stuapplyList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
      this.queryParams.applySname = null;
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        applyId: null,
        applySname: null,
        applyPhone: null,
        olddept: null,
        newdept: null,
        oldroom: null,
        newroom: null,
        status: "0"
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.applyId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.form.applySname = this.$store.state.user.name;
      this.title = "添加【请填写功能名称】";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const applyId = row.applyId || this.ids
      getStuapply(applyId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.applyId != null) {
            updateStuapply(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStuapply(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const applyIds = row.applyId || this.ids;
      this.$modal.confirm('是否确认删除【请填写功能名称】编号为"' + applyIds + '"的数据项？').then(function() {
        return delStuapply(applyIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/stuapply/export', {
        ...this.queryParams
      }, `stuapply_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
