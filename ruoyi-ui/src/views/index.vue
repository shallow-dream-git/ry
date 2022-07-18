<template>
  <div class="app-container home">
    <el-carousel :interval="5000" arrow="always">
      <el-carousel-item v-for="item in 3" :key="item">
        <el-image
          class="image"
          :src="url[item-1]"
          :fit="fits"></el-image>
        <h3>{{ item }}</h3>
      </el-carousel-item>
    </el-carousel>
    <br>
    <el-row :gutter="20">
      <el-col :span="30">
        <div class="grid-content bg-purple">
          <el-scrollbar :fit="fits">
            <div>
              <span class="b">
                宿舍公告
              </span>
              <hr/>
              <p class="ee2">
                因校区外水管爆裂导致校内停水，计划于10月23日（周三）10:00-22:00进行抢修。届时，T4宿舍将会全面停水，请各位同学周知，并提前做好储水准备。由此给您造成的不便敬请谅解。
                特此通知。
              </p><br/>
              <p class="right"> 宿舍管理员<br/>10月22日</p>


            </div>
          </el-scrollbar>
        </div>
      </el-col>
    </el-row>

  </div>
</template>

<script>
  export default {
    name: "Index",
    data() {
      return {
        // 版本号
        version: "3.8.3",
        fits: ['fills', 'contain', 'cover', 'none', 'scale-down'],
        url: ['https://www.jnu.edu.cn/_upload/article/images/c0/8a/33d854f94d4fa622e50ee50d1a7b/808a5197-da61-4a8a-ad2e-a9f43d06db52.jpg',
          'https://www.jnu.edu.cn/_upload/article/images/c7/ab/cd7b351e4d3fb733527212ad4717/41684ed8-570c-4e1a-8750-76b08e9598ae.jpg',
          'https://www.jnu.edu.cn/_upload/article/images/05/d4/a529e54845c8b2a604f2e1974897/6e18e3d1-4cb5-401f-ad4d-9a2df709f52d.jpg']
      };
    },
    methods: {
      goTarget(href) {
        window.open(href, "_blank");
      },
      mounted() {
        // 首次加载时,需要调用一次
        this.screenWidth = window.innerWidth;
        this.setSize();
        // 窗口大小发生改变时,调用一次
        window.onresize = () => {
          this.screenWidth = window.innerWidth;
          this.setSize();
        }
      },
    },
  };
</script>

<style scoped lang="scss">
  .home {
    .el-carousel__item h3 {
      color: #475669;
      font-size: 18px;
      opacity: 0.75;
      line-height: 300px;
      margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
      background-color: #99a9bf;
    }


    .el-carousel__item:nth-child(2n+1) {
      background-color: #d3dce6;
    }

    blockquote {
      padding: 10px 20px;
      margin: 0 0 20px;
      font-size: 17.5px;
      border-left: 5px solid #eee;
    }

    hr {
      margin-top: 20px;
      margin-bottom: 20px;
      border: 0;
      border-top: 1px solid #eee;
    }

    .col-item {
      margin-bottom: 20px;
    }

    ul {
      padding: 0;
      margin: 0;
    }

    font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
    font-size: 13px;
    color: #676a6c;
    overflow-x: hidden;

    ul {
      list-style-type: none;
    }

    h4 {
      margin-top: 0px;
    }

    h2 {
      margin-top: 10px;
      font-size: 26px;
      font-weight: 100;
    }

    p {
      margin-top: 10px;

      b {
        font-weight: 700;
      }
    }

    .update-log {
      ol {
        display: block;
        list-style-type: decimal;
        margin-block-start: 1em;
        margin-block-end: 1em;
        margin-inline-start: 0;
        margin-inline-end: 0;
        padding-inline-start: 40px;
      }
    }

    .right {
      text-align: right;
      font-size: 16px;
    }

    .text {
      font-size: 20px;
    }

    .item {
      margin-bottom: 20px;
    }

    .b {
      font-size: 20px;
      color: #00afff;
    }

    .clearfix:before,
    .clearfix:after {
      display: table;
      content: "";
    }

    .ee2 {
      font-size: 16px;
      /*width: 1030px;*/
      text-indent: 30px;
    }

    .border {
      height: 190px;
      /*width: 1030px;*/
      border-radius: 10px;
      box-shadow: 0 0 25px #cac6c6;
      padding: 20px 35px;
    }

    .clearfix:after {
      clear: both
    }

    .box-card {
      width: 300px;
    }

    img{
      /*设置图片宽度和浏览器宽度一致*/
      width:100%;
      height:inherit;
    }
  }
</style>

