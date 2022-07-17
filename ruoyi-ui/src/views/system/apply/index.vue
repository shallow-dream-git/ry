<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="电话号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入电话号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生姓名" prop="sname">
        <el-input
          v-model="queryParams.sname"
          placeholder="请输入学生姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="旧楼栋号" prop="olddept">
        <el-input
          v-model="queryParams.olddept"
          placeholder="请输入旧楼栋号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="新楼栋号" prop="newdept">
        <el-input
          v-model="queryParams.newdept"
          placeholder="请输入新楼栋号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="旧宿舍" prop="oldroom">
        <el-input
          v-model="queryParams.oldroom"
          placeholder="请输入旧宿舍"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="新宿舍号" prop="newroom">
        <el-input
          v-model="queryParams.newroom"
          placeholder="请输入新宿舍号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申请状态" prop="staus">
<!--        <el-input-->
<!--          v-model="queryParams.staus"-->
<!--          placeholder="请输入申请状态：同意/审核中/不同意"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
        <el-cascader
          v-model="queryParams.staus"
          :options="options"
          :props="{ expandTrigger: 'hover' }"
          @change="handleChange"></el-cascader>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:apply:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate3"
          v-hasPermi="['system:apply:edit']"
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
          v-hasPermi="['system:apply:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:apply:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="applyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="25" align="center" />
      <el-table-column label="申请id" align="center" prop="rid" />
      <el-table-column label="电话号" align="center" prop="phone" />
      <el-table-column label="学生姓名" align="center" prop="sname" />
      <el-table-column label="旧楼栋号" align="center" prop="olddept" />
      <el-table-column label="新楼栋号" align="center" prop="newdept" />
      <el-table-column label="旧宿舍
" align="center" prop="oldroom" />
      <el-table-column label="新宿舍号" align="center" prop="newroom" />
      <el-table-column label="申请状态" align="center" prop="staus" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
<!--          同意-->
          <el-button
            type="success"
            circle
            icon="el-icon-success"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:apply:edit']"
          ></el-button>
<!--          不同意-->
          <el-button
            type="warning"
            circle
            icon="el-icon-error"
            @click="handleUpdate2(scope.row)"
            v-hasPermi="['system:apply:edit']"
          ></el-button>
          <el-button
            type="danger"
            circle
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:apply:remove']"
          ></el-button>
        </template>
      </el-table-column>
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
        <el-form-item label="电话号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入电话号" />
        </el-form-item>
        <el-form-item label="学生姓名" prop="sname">
          <el-input v-model="form.sname" placeholder="请输入学生姓名" />
        </el-form-item>
        <el-form-item label="旧楼栋号" prop="olddept">
          <el-input v-model="form.olddept" placeholder="请输入旧楼栋号" />
        </el-form-item>
        <el-form-item label="新楼栋号" prop="newdept">
          <el-input v-model="form.newdept" placeholder="请输入新楼栋号" />
        </el-form-item>
        <el-form-item label="旧宿舍
" prop="oldroom">
          <el-input v-model="form.oldroom" placeholder="请输入旧宿舍
" />
        </el-form-item>
        <el-form-item label="新宿舍号" prop="newroom">
          <el-input v-model="form.newroom" placeholder="请输入新宿舍号" />
        </el-form-item>
        <el-form-item label="申请状态" prop="staus">
<!--          <el-input v-model="form.staus" placeholder="请输入申请状态：同意/审核中/不同意" />-->
<!--          <el-cascader-->
<!--            v-model="value"-->
<!--            :options="options"-->
<!--            :props="{ expandTrigger: 'hover' }"-->
<!--            @change="handleChange"></el-cascader>-->
          <el-cascader
            v-model="form.staus"
            :options="options"
            :props="{ expandTrigger: 'hover' }"
            @change="handleChange2"></el-cascader>
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
import { listApply, getApply, delApply, addApply, updateApply } from "@/api/system/apply";

export default {
  name: "Apply",
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
      applyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        phone: null,
        sname: null,
        olddept: null,
        newdept: null,
        oldroom: null,
        newroom: null,
        staus: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        staus: [
          { message: "申请状态：同意/审核中/不同意不能为空", trigger: "blur" }
        ]
      },
      // 下拉框
      value: [],
      options: [{
        value: '同意',
        label: '同意',
      },
        {
        value: '审核中',
        label: '审核中',
      },
        {
        value: '不同意',
        label: '不同意',
      }]
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 下拉框*/
    handleChange() {
      this.queryParams.staus = this.queryParams.staus['0']
    },
    handleChange2() {
      this.form.staus = this.form.staus['0']
    },
    /** 查询【请填写功能名称】列表 */
    getList() {
      // console.log("@@@@@@@@@@@@@@@@",this.queryParams);
      this.loading = true;
      listApply(this.queryParams).then(response => {
        this.applyList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        rid: null,
        phone: null,
        sname: null,
        olddept: null,
        newdept: null,
        oldroom: null,
        newroom: null,
        staus: null
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
      this.ids = selection.map(item => item.rid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "新增一次申请";
    },
    /** 修改按钮操作 */
    handleUpdate3(row) {
      this.reset();
      const rid = row.rid || this.ids
      console.log("@@",this.form)
      getApply(rid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改";
      });
      console.log("@@@",this.form)
    },
    //同意按钮
    handleUpdate(row) {
      this.reset();
      const rid = row.rid || this.ids;
      getApply(rid).then(response => {
        this.form = response.data;
        this.form.staus = '同意';
        this.title = "同意";
        this.open = true;
        // console.log("tongyi2",this.form);
        // this.submitForm();
      });

      // console.log("@@",this.form)
      // console.log("@@@",this.form)
    },
    //不同意按钮
    handleUpdate2(row) {
      this.reset();
      const rid = row.rid || this.ids;
      getApply(rid).then(response => {
        this.form = response.data;
        this.form.staus = '不同意';
        this.title = "不同意";
        this.open = true;
        // console.log("tongyi2",this.form);
      });
    },
    /** 提交按钮 */
    submitForm() {
      console.log("submit");
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.rid != null) {
            console.log("@@@@",this.form);
            updateApply(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
              // this.reset();
            });
          } else {
            addApply(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
              // this.reset();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const rids = row.rid || this.ids;
      this.$modal.confirm('是否确认删除【请填写功能名称】编号为"' + rids + '"的数据项？').then(function() {
        return delApply(rids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/apply/export', {
        ...this.queryParams
      }, `apply_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
