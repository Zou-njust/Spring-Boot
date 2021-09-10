# IntentionAnalysis
#### 初始化

1. mysql创建数据库，名称为intention，执行intention.sql
2. 启动springboot，输入http://localhost:8080/user/select，查询到数据即运行成功

#### 说明

1. mysql配置在resources/application.yml，可以设置数据库路径、用户名、密码

2. pom.xml中添加需要的依赖包

3. mapper提供了两种sql语句书写途径

4. controller-service-mapper三层结构应一一对应

5. 具体算法应封装在algorithm/_文件夹中，各组之间互不干扰

   