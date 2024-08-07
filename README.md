# ai-library-system
基于SpringBoot+Vue的智能 AI 推荐的图书管理系统

#### 介绍

随着信息技术的飞速发展，软件管理系统在各个领域的应用日益广泛。近年来，人工智能（AI）技术的迅猛发展为这些系统的进一步优化提供了新的契机。本文旨在探讨如何将 AI 技术和图书管理系统结合在一起中，以提升系统的智能化和用户体验。本文描述的主体是图书管理系统，系统分为三个界面，用户界面、图书管理员界面、系统管理员界面。用户界面可以查询图书及信息，查看借阅违章等信息，可以留言图书馆，可以通过智能推荐获取适合的图书推荐。图书管理员界面可以控制检查借还书籍，并且可以发布公告。系统管理员界面可以管理书籍和类型，控制角色，以及借阅规则的定制。其特点主要是可以调用其人工智能的 api 实现对数据库里图书的存在进行推荐，方便借阅者可以选择适合图书，不存在的图书直接一目了然。读者也可以对图书馆进行留言并以弹幕形式显示。

**有偿获得完整源码+Q：1902317191**

**CSDN项目合集：http://t.csdnimg.cn/j7xXJ**

#### 安装教程

1. 运行环境准备mysql8+java17+node16.9.1+redis3

2. 配置maven路径，加载依赖

3. 运行sql文件，确保application.yml的数据库名称和账号密码是数据库所在主机的账号密码

#### 使用说明

1. 登入

   账号：admin	密码：123456
   账号：aaa	密码：123456

2.运行流程

前端初始化指令：

> npm install

前端运行指令：

> npm run dev

详情可以查看这篇csdn博客：http://t.csdnimg.cn/kpuxS

#### 项目演示

##### 用户模块功能图

**首页轮播图演示**

![](https://pic.yupi.icu/5563/202403021406581.png)

**图书查询演示**

![](https://pic.yupi.icu/5563/202403021406053.png)

**读者规则演示**

![](https://pic.yupi.icu/5563/202403021406571.png)

**查看公告演示**

![](https://pic.yupi.icu/5563/202403021406776.png)

**个人信息演示**

![](https://pic.yupi.icu/5563/202403021406779.png)

**借阅信息演示**

![](https://pic.yupi.icu/5563/202403021406890.png)

**违章信息演示**

![](https://pic.yupi.icu/5563/202403021406091.png)

**读者留言演示**

![](https://pic.yupi.icu/5563/202403021406261.png)

**智能推荐演示**

![](https://pic.yupi.icu/5563/202403021406234.png)

##### 图书管理员功能图

**借阅图书演示**

![](https://pic.yupi.icu/5563/202403021406213.png)

**归还图书演示**

![](https://pic.yupi.icu/5563/202403021406604.png)

**借书报表演示**

![](https://pic.yupi.icu/5563/202403021406590.png)

**还书报表演示**

![](https://pic.yupi.icu/5563/202403021406562.png)

**发布公告演示**

![](https://pic.yupi.icu/5563/202403021406616.png)

##### 系统管理员功能图

+ 由于篇幅受限，系统功能展示主要功能。

**系统管理演示**

![](https://pic.yupi.icu/5563/202403021406081.png)

![](https://pic.yupi.icu/5563/202403021406169.png)

**智能分析演示**

![](https://pic.yupi.icu/5563/202403021406245.png)


