# 1.图书管理系统后台API接口文档

## 1.1API 接口说明

 + 接口基准地址:http://127.0.0.1:8889/api/
 + 服务端已开启CORS跨域支持
 + API认证使用Token认证
 + 需要授权的API，在请求头中使用Authorization字段提供token令牌
 + 使用HTTP Status Code 表示状态
 + 数据返回格式使用JSON

### 1.1.1支持的请求方法

- GET（SELECT）：从服务器取出资源（一项或多项）。
- POST（CREATE）：在服务器新建一个资源。
- PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
- PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
- DELETE（DELETE）：从服务器删除资源。
- HEAD：获取资源的元数据。
- OPTIONS：获取信息，关于资源的哪些属性是客户端可以改变的。

### 1.1.2. 通用返回状态说明

| *状态码* | *含义*                | *说明*                                              |
| -------- | --------------------- | --------------------------------------------------- |
| 200      | OK                    | 请求成功                                            |
| 201      | CREATED               | 创建成功                                            |
| 204      | DELETED               | 删除成功                                            |
| 400      | BAD REQUEST           | 请求的地址不存在或者包含不支持的参数                |
| 401      | UNAUTHORIZED          | 未授权                                              |
| 403      | FORBIDDEN             | 被禁止访问                                          |
| 404      | NOT FOUND             | 请求的资源不存在                                    |
| 422      | Unprocesable entity   | [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误 |
| 500      | INTERNAL SERVER ERROR | 内部错误                                            |

## 1.2. 登录

### 1.2.1登录验证接口(用户)

+ 请求路径: login/user

+ 请求方法: post

+ 请求参数

  | 参数名   | 参数说明 | 备注                |
  | -------- | -------- | ------------------- |
  | username | 用户名   | 不能为空 长度(3-20) |
  | password | 密码     | 不能为空 长度(6-15) |
  
  + 响应参数
  
  | 参数名 | 参数说明   | 备注                                                      |
  | ------ | ---------- | --------------------------------------------------------- |
  | status | 响应状态码 | 200表示登录成功                                           |
  | msg    | 请求信息   |                                                           |
  | token  | 令牌       | 基于JWT 的令牌（三部分构成)  Authorization会附带"Bearer " |
  | data   | 请求数据   |                                                           |
  
  + 响应数据
  
  ```json
  {
      "status": 200,
      "msg": "登录成功",
      "data": null,
      "map": {
          "id": 1923,
          "token": "eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkYXRlIjoxNjc1NDI4NzYzOTIwLCJpZCI6MTY3NTQyODc2MzkyMCwidXNlcm5hbWUiOiLnm7jmgJ3mlq3nuqLogqAiLCJleHAiOjE2NzU0MzIzNjN9.aRWWe-l2uy3sYJfkTh2mab-BG4odDdJO3sUCt18yfjw"
      }
  }
  ```
  

### 1.2.2登录验证接口(图书管理员)

+ 请求路径:bookadmin/login
+ 请求方法: post
+ 请求参数

| 参数名   | 参数说明 | 备注                |
| -------- | -------- | ------------------- |
| username | 用户名   | 不能为空 长度(3-20) |
| password | 密码     | 不能为空 长度(6-15) |

+ 响应参数

| 参数名 | 参数说明   | 备注                                                      |
| ------ | ---------- | --------------------------------------------------------- |
| status | 响应状态码 | 200表示登录成功                                           |
| msg    | 请求信息   |                                                           |
| token  | 令牌       | 基于JWT 的令牌（三部分构成)  Authorization会附带"Bearer " |
| data   | 请求数据   |                                                           |

+ 响应数据

```json
{
    "status": 200,
    "msg": "登录成功",
    "data": null,
    "map": {
        "id": 1420,
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkYXRlIjoxNjc1NTAyNTE1MzMwLCJpZCI6MTY3NTUwMjUxNTMzMCwidXNlcm5hbWUiOiJCb29rQWRtaW5zKGJvb2tBZG1pbklkPW51bGwsIHVzZXJuYW1lPWFkbWluLCBwYXNzd29yZD0xMjM0NTYsIGJvb2tBZG1pbk5hbWU9bnVsbCwgc3RhdHVzPW51bGwsIGVtYWlsPW51bGwsIGNyZWF0ZVRpbWU9bnVsbCwgdXBkYXRlVGltZT1udWxsKSIsImV4cCI6MTY3NTUwNjExNX0.Ddjk6bBkvOwYiLULOe3j6MN4KhI4h5gVClTwMZDa8Co"
    }
}
```



### 1.2.3登录验证接口(系统管理员)

+ 请求路径: admin/login
+ 请求方法: post
+ 请求参数

| 参数名   | 参数说明 | 备注                |
| -------- | -------- | ------------------- |
| username | 用户名   | 不能为空 长度(3-20) |
| password | 密码     | 不能为空 长度(6-15) |

+ 响应参数

| 参数名 | 参数说明   | 备注                                                      |
| ------ | ---------- | --------------------------------------------------------- |
| status | 响应状态码 | 200表示登录成功                                           |
| msg    | 请求信息   |                                                           |
| token  | 令牌       | 基于JWT 的令牌（三部分构成)  Authorization会附带"Bearer " |
| data   | 请求数据   |                                                           |

+ 响应数据

  ````json
  {
      "status": 200,
      "msg": "登录成功",
      "data": null,
      "map": {
          "id": 1623,
          "token": "eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkYXRlIjoxNjc1NDI4NzAxMzE3LCJpZCI6MTY3NTQyODcwMTMxNywidXNlcm5hbWUiOiJyb290IiwiZXhwIjoxNjc1NDMyMzAxfQ.0qm-Ukw3u42GB5swNYGnAXxwiuQHAmjviyxkkBs12TY"
      }
  }
  ````

  ### 

## 1.3登录(返回用户数据)

### 1.3.1登录(用户数据)

+ 请求路径: user/getData
+ 请求方式: post
+ 请求参数

| 参数名 | 参数说明 | 备注                         |
| ------ | -------- | ---------------------------- |
| id     | 用户id   | 浏览器的sessionStorage中取出 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

````json
{
    "status": 200,
    "msg": "获取用户数据成功",
    "data": {
        "userId": 1923,
        "username": "相思断红肠",
        "password": "",
        "cardName": "张三",
        "cardNumber": 18012345678,
        "ruleNumber": 18,
        "status": 1,
        "createTime": "2023-02-02 16:12:05",
        "updateTime": "2023-02-02 16:12:05"
    },
    "map": {}
}
````

### 1.3.2登录(图书管理员数据)

+ 请求路径: bookadmin/getData
+ 请求方式: post
+ 请求参数

| 参数名 | 参数说明 | 备注                         |
| ------ | -------- | ---------------------------- |
| id     | 用户id   | 浏览器的sessionStorage中取出 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取图书管理员数据成功",
    "data": {
        "bookAdminId": 1420,
        "username": "admin",
        "password": "",
        "bookAdminName": "王二离",
        "status": 1,
        "email": "449832156@qq.com",
        "createTime": "2023-02-03 19:43:37",
        "updateTime": "2023-02-03 19:43:37"
    },
    "map": {}
}
```



### 1.3.3登录(系统管理员数据)

+ 请求路径: admin/getData
+ 请求方式: post
+ 请求参数

| 参数名 | 参数说明 | 备注                         |
| ------ | -------- | ---------------------------- |
| id     | 用户id   | 浏览器的sessionStorage中取出 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取系统管理员数据成功",
    "data": {
        "adminId": 1623,
        "username": "root",
        "password": "",
        "adminName": "小白条",
        "status": 1,
        "createTime": "2023-02-03 19:41:47",
        "updateTime": "2023-02-03 19:41:47"
    },
    "map": {}
}
```

## 1.4借阅者功能实现

### 1.4.1图书查询

+ 请求路径: user/search_book_page
+ 请求方法: post

+ 请求参数:

| 参数名    | 参数说明 | 备注               |
| --------- | -------- | ------------------ |
| pageNum   | 页码     | 用于分页构造器传参 |
| pageSize  | 页数     | 用于分页构造器传参 |
| condition | 条件     |                    |
| query     | 查询内容 |                    |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取图书信息成功",
    "data": {
        "records": [
            {
                "bookId": 1,
                "bookNumber": 1234,
                "bookName": "红楼梦",
                "bookAuthor": "曹雪芹",
                "bookLibrary": "南图",
                "bookType": "小说",
                "bookLocation": "E1",
                "bookStatus": "未借出",
                "bookDescription": "《红楼梦》，原名《石头记》，中国古代章回体长篇小说，中国古典四大名著之一。",
                "createTime": "2023-02-04 17:51:04",
                "updateTime": "2023-02-04 17:51:04"
            },
            {
                "bookId": 2,
                "bookNumber": 1235,
                "bookName": "百年孤独",
                "bookAuthor": "加西亚·马尔克斯",
                "bookLibrary": "北图",
                "bookType": "小说",
                "bookLocation": "E2",
                "bookStatus": "未借出",
                "bookDescription": "《百年孤独》，是哥伦比亚作家加西亚·马尔克斯创作的长篇小说，是其代表作，也是拉丁美洲魔幻现实主义文学的代表作，被誉为“再现拉丁美洲历史社会图景的鸿篇巨著”。",
                "createTime": "2023-02-04 17:53:27",
                "updateTime": "2023-02-04 17:53:27"
            },
            {
                "bookId": 3,
                "bookNumber": 1236,
                "bookName": "三体",
                "bookAuthor": "刘慈欣",
                "bookLibrary": "教师之家",
                "bookType": "小说",
                "bookLocation": "F8",
                "bookStatus": "未借出",
                "bookDescription": "科幻小说，全名《地球往事三部曲》，是刘慈欣编写的史诗级巨作，是一部典型的硬科幻作品。",
                "createTime": "2023-02-04 17:53:27",
                "updateTime": "2023-02-04 17:53:27"
            }
        ],
        "total": 3,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```

### 1.4.2读者规则

+ 请求路径: user/get_rulelist
+ 请求方式: get
+ 请求参数(无)

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取读者规则成功",
    "data": [
        {
            "ruleId": 1,
            "bookRuleId": 188,
            "bookDays": 50,
            "bookLimitNumber": 10,
            "bookLimitLibrary": "教师之家,南图,北图",
            "bookOverdueFee": 1.5,
            "createTime": "2023-02-04 17:45:32",
            "updateTime": "2023-02-04 17:45:32"
        },
        {
            "ruleId": 2,
            "bookRuleId": 688,
            "bookDays": 150,
            "bookLimitNumber": 30,
            "bookLimitLibrary": "教师之家,南图,北图",
            "bookOverdueFee": 0.5,
            "createTime": "2023-02-04 17:46:19",
            "updateTime": "2023-02-04 17:46:19"
        },
        {
            "ruleId": 3,
            "bookRuleId": 88,
            "bookDays": 20,
            "bookLimitNumber": 5,
            "bookLimitLibrary": "教师之家,南图,北图",
            "bookOverdueFee": 2.5,
            "createTime": "2023-02-04 17:46:19",
            "updateTime": "2023-02-04 17:46:19"
        }
    ],
    "map": {}
}
```

### 1.4.3查看公告

+ 请求路径: user/get_noticelist
+ 请求方式: get
+ 请求参数(无)

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取公告信息成功",
    "data": [
        {
            "noticeId": 1,
            "noticeTitle": "本项目源代码地址,欢迎star!",
            "noticeContent": "https://luoye6.github.io/",
            "noticeAdminId": 1623,
            "createTime": "2023-02-05 16:11:40",
            "updateTime": "2023-02-05 16:11:40"
        },
        {
            "noticeId": 2,
            "noticeTitle": "注意事项",
            "noticeContent": "发现项目BUG,可以提出issue，大佬请别恶意攻击，小项目承受不起，谢谢",
            "noticeAdminId": 1623,
            "createTime": "2023-02-05 16:13:31",
            "updateTime": "2023-02-05 16:13:31"
        },
        {
            "noticeId": 3,
            "noticeTitle": "祝福",
            "noticeContent": "祝大家天天开心！",
            "noticeAdminId": 1623,
            "createTime": "2023-02-05 16:13:31",
            "updateTime": "2023-02-05 16:13:31"
        }
    ],
    "map": {}
}
```

### 1.4.4个人信息

#### 1.个人信息(获取个人信息)

+ 请求路径: user/get_information
+ 请求方法: get
+ 请求参数: 

| 参数名 | 参数说明 | 备注             |
| ------ | -------- | ---------------- |
| userId | 用户ID   | 用于查询个人信息 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取用户信息成功",
    "data": {
        "userId": 1923,
        "username": "相思断红肠",
        "password": "e10adc3949ba59abbe56e057f20f883e",
        "cardName": "张三",
        "cardNumber": 18012345678,
        "ruleNumber": 18,
        "status": 1,
        "createTime": "2023-02-02 16:12:05",
        "updateTime": "2023-02-02 16:12:05"
    },
    "map": {}
}
```

#### 2.个人信息（修改密码)

+ 请求路径: user/update_password
+ 请求方法: post
+ 请求参数:

| 参数名   | 参数说明 | 备注         |
| -------- | -------- | ------------ |
| userId   | 用户id   |              |
| password | 新密码   | 修改密码功能 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "更改密码成功",
    "data": null,
    "map": {}
}
```

### 1.4.5借阅信息

+ 请求路径: user/get_bookborrow
+ 请求方式: post

+ 请求参数

| 参数名      | 参数说明 | 备注                         |
| ----------- | -------- | ---------------------------- |
| pageNum     | 页码     | 用于分页构造器传参           |
| pageSize    | 页数     | 用于分页构造器传参           |
| condition   | 条件     |                              |
| query       | 查询内容 |                              |
| card_number | 借阅证   | 根据借阅证查询自己的借阅记录 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取借阅信息成功",
    "data": {
        "records": [
            {
                "borrowId": 1,
                "cardNumber": 18012345678,
                "bookNumber": 1234,
                "borrowDate": "2023-02-05 18:48:19",
                "closeDate": "2023-03-27 18:48:19",
                "returnDate": "2023-02-25 18:48:19",
                "createTime": "2023-02-05 18:48:19",
                "udpateTime": "2023-02-05 18:48:19"
            },
            {
                "borrowId": 2,
                "cardNumber": 18012345678,
                "bookNumber": 1235,
                "borrowDate": "2023-02-05 18:48:51",
                "closeDate": "2023-03-27 18:48:51",
                "returnDate": "2023-02-28 18:48:51",
                "createTime": "2023-02-05 18:48:51",
                "udpateTime": "2023-02-05 18:48:51"
            },
            {
                "borrowId": 3,
                "cardNumber": 18012345678,
                "bookNumber": 1236,
                "borrowDate": "2023-02-05 18:48:51",
                "closeDate": "2023-03-27 18:48:51",
                "returnDate": "2023-03-05 18:48:51",
                "createTime": "2023-02-05 18:48:51",
                "udpateTime": "2023-02-05 18:48:51"
            }
        ],
        "total": 3,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```

### 1.4.6违章信息

+ 请求路径: user/get_violation
+ 请求方法: post
+ 请求参数

| 参数名      | 参数说明 | 备注                         |
| ----------- | -------- | ---------------------------- |
| pageNum     | 页码     | 用于分页构造器传参           |
| pageSize    | 页数     | 用于分页构造器传参           |
| condition   | 条件     |                              |
| query       | 查询内容 |                              |
| card_number | 借阅证   | 根据借阅证查询自己的规章记录 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取违章记录成功",
    "data": {
        "records": [
            {
                "violationId": 1,
                "cardNumber": 18012345678,
                "bookNumber": 1234,
                "borrowDate": "2023-02-05 18:48:19",
                "closeDate": "2023-03-27 18:48:19",
                "returnDate": "2023-02-25 18:48:19",
                "violationMessage": "书籍损坏",
                "violationAdminId": 1420,
                "createTime": "2023-02-06 16:30:12",
                "updateTime": "2023-02-06 16:30:12",
                "violationAdmin": "admin"
            },
            {
                "violationId": 2,
                "cardNumber": 18012345678,
                "bookNumber": 1235,
                "borrowDate": "2023-02-05 18:48:19",
                "closeDate": "2023-03-27 18:48:19",
                "returnDate": "2023-02-28 18:48:19",
                "violationMessage": "书籍丢失",
                "violationAdminId": 1420,
                "createTime": "2023-02-06 16:31:00",
                "updateTime": "2023-02-06 16:31:00",
                "violationAdmin": "admin"
            },
            {
                "violationId": 3,
                "cardNumber": 18012345678,
                "bookNumber": 1236,
                "borrowDate": "2023-02-05 18:48:19",
                "closeDate": "2023-03-27 18:48:19",
                "returnDate": "2023-03-05 18:48:19",
                "violationMessage": "书籍损坏",
                "violationAdminId": 1420,
                "createTime": "2023-02-06 16:31:00",
                "updateTime": "2023-02-06 16:31:00",
                "violationAdmin": "admin"
            }
        ],
        "total": 3,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```

### 1.4.7读者留言

#### 1.读者留言(获取弹幕)

+ 请求路径: user/get_commentlist
+ 请求方法: get
+ 请求参数(无)

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取弹幕列表成功",
    "data": [    {
          id: 3,
          avatar:
            "https://img0.baidu.com/it/u=825023390,3429989944&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500",
          msg: "学习如逆水行舟,不进则退",
          time: 5,
          barrageStyle: "sanbai",
          type: MESSAGE_TYPE.NORMAL,
        },
        {
          id: 4,
          avatar:
            "https://img0.baidu.com/it/u=825023390,3429989944&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500",
          msg: "平凡的生活亦能有非凡的人生",
          time: 8,
          barrageStyle: "sibai",
          type: MESSAGE_TYPE.NORMAL,
        },
        {
          id: 5,
          avatar:
            "https://img0.baidu.com/it/u=825023390,3429989944&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500",
          msg: "The only way to conquer a fear is to face it",
          time: 7,
          barrageStyle: "wubai",
          type: MESSAGE_TYPE.NORMAL,
        },],
    "map": {}
}
```

#### 2.读者留言(添加弹幕)

+ 请求路径: user/add_comment
+ 请求方式: post
+ 请求参数

| 参数名       | 参数说明       | 备注 |
| ------------ | -------------- | ---- |
| id           | id             |      |
| avatar       | 用户头像       |      |
| msg          | 弹幕内容       |      |
| time         | 时间(控制速度) |      |
| barrageStyle | 弹幕高度       |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取弹幕列表成功",
    "data": [],
    "map": {}
}
```

## 1.5图书管理员功能实现

### 1.5.1借阅图书

+ 请求路径: bookadmin/borrow_book
+ 请求方式: post
+ 请求参数: 

| 参数名      | 参数说明     | 备注 |
| ----------- | ------------ | ---- |
| cardNumber  | 借阅证号     |      |
| bookNumber  | 图书编号     |      |
| borrowDate  | 借阅日期     |      |
| bookAdminId | 图书管理员id |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "借阅图书成功",
    "data": null,
    "map": {}
}
```

### 1.5.2归还图书

#### 1.归还图书(查看是否借出)

+ 请求路径: bookadmin/query_book
+ 请求方法: get
+ 请求参数:

| 参数名     | 参数说明 | 备注                 |
| ---------- | -------- | -------------------- |
| bookNumber | 图书编号 | 用于查询图书是否借出 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "图书已借出",
    "data": null,
    "map": {}
}
```

#### 2.归还图书(逾期信息查询)

+ 请求路径: bookadmin/query_expire
+ 请求方式: get
+ 请求参数: 

| 参数名     | 参数说明 | 备注                 |
| ---------- | -------- | -------------------- |
| bookNumber | 图书编号 | 用于查询图书是否借出 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "查询图书逾期信息成功",
    "data": null,
    "map": {}
}
```

#### 3.归还图书(归还图书)

+ 请求路径: bookadmin/return_book
+ 请求方法: post
+ 请求参数

| 参数名           | 参数说明 | 备注 |
| ---------------- | -------- | ---- |
| returnDate       | 归还日期 |      |
| violationMessage | 违章信息 |      |
| bookNumber       | 图书编号 |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "归还图书成功",
    "data": null,
    "map": {}
}
```

### 1.5.3借书报表

+ 请求路径: bookadmin/get_borrow_statement
+ 请求方法: post
+ 请求参数

| 参数名    | 参数说明 | 备注               |
| --------- | -------- | ------------------ |
| pageNum   | 页码     | 用于分页构造器传参 |
| pageSize  | 页数     | 用于分页构造器传参 |
| condition | 条件     |                    |
| query     | 查询内容 |                    |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取借书报表信息成功",
    "data": {
        "records": [
            {
                "violationId": 1,
                "cardNumber": 18012345678,
                "bookNumber": 1234,
                "borrowDate": "2023-02-05 18:48:19",
                "closeDate": "2023-03-27 18:48:19",
                "returnDate": "2023-02-25 18:48:19",
                "violationMessage": "",
                "violationAdminId": 1420,
                "createTime": "2023-02-06 16:30:12",
                "updateTime": "2023-02-06 16:30:12",
                "violationAdmin": "admin",
                "expireDays": 0
            },
            {
                "violationId": 2,
                "cardNumber": 18012345678,
                "bookNumber": 1235,
                "borrowDate": "2023-02-05 18:48:19",
                "closeDate": "2023-03-27 18:48:19",
                "returnDate": "2023-02-28 18:48:19",
                "violationMessage": "",
                "violationAdminId": 1420,
                "createTime": "2023-02-06 16:31:00",
                "updateTime": "2023-02-06 16:31:00",
                "violationAdmin": "admin",
                "expireDays": 0
            },
            {
                "violationId": 3,
                "cardNumber": 18012345678,
                "bookNumber": 1236,
                "borrowDate": "2023-02-05 18:48:19",
                "closeDate": "2023-03-27 18:48:19",
                "returnDate": "2023-03-05 18:48:19",
                "violationMessage": "",
                "violationAdminId": 1420,
                "createTime": "2023-02-06 16:31:00",
                "updateTime": "2023-02-06 16:31:00",
                "violationAdmin": "admin",
                "expireDays": 0
            },
            {
                "violationId": 4,
                "cardNumber": 18012345678,
                "bookNumber": 1234,
                "borrowDate": "2023-02-08 19:06:05",
                "closeDate": "2023-03-30 19:06:05",
                "returnDate": "2023-02-08 19:44:21",
                "violationMessage": "",
                "violationAdminId": 1420,
                "createTime": "2023-02-08 19:06:05",
                "updateTime": "2023-02-08 19:06:05",
                "violationAdmin": "admin",
                "expireDays": 0
            },
            {
                "violationId": 5,
                "cardNumber": 18012345678,
                "bookNumber": 1235,
                "borrowDate": "2023-02-08 19:49:14",
                "closeDate": "2023-03-30 19:49:14",
                "returnDate": "2023-02-08 19:49:45",
                "violationMessage": "书籍损坏",
                "violationAdminId": 1420,
                "createTime": "2023-02-08 19:49:14",
                "updateTime": "2023-02-08 19:49:14",
                "violationAdmin": "admin",
                "expireDays": 0
            }
        ],
        "total": 5,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```



### 1.5.4还书报表

+ 请求路径: bookadmin/get_return_statement
+ 请求方法: post
+ 请求参数

| 参数名    | 参数说明 | 备注               |
| --------- | -------- | ------------------ |
| pageNum   | 页码     | 用于分页构造器传参 |
| pageSize  | 页数     | 用于分页构造器传参 |
| condition | 条件     |                    |
| query     | 查询内容 |                    |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取还书报表信息成功",
    "data": {
        "records": [
            {
                "borrowId": 13,
                "cardNumber": 18012345678,
                "bookNumber": 1236,
                "borrowDate": "2023-02-08 19:51:07",
                "closeDate": "2023-03-30 19:51:07",
                "returnDate": null,
                "createTime": "2023-02-08 19:51:08",
                "updateTime": "2023-02-08 19:51:08"
            },
            {
                "borrowId": 14,
                "cardNumber": 18012345678,
                "bookNumber": 1234,
                "borrowDate": "2023-02-08 20:28:39",
                "closeDate": "2023-03-30 20:28:39",
                "returnDate": null,
                "createTime": "2023-02-08 20:28:39",
                "updateTime": "2023-02-08 20:28:39"
            },
            {
                "borrowId": 15,
                "cardNumber": 18012345678,
                "bookNumber": 1235,
                "borrowDate": "2023-02-08 20:28:46",
                "closeDate": "2023-03-30 20:28:46",
                "returnDate": null,
                "createTime": "2023-02-08 20:28:46",
                "updateTime": "2023-02-08 20:28:46"
            }
        ],
        "total": 3,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```

### 1.5.5发布公告

#### 1.发布公告(获取公告列表)

+ 请求路径: bookadmin/get_noticelist
+ 请求方法: post
+ 请求参数

| 参数名   | 参数说明 | 备注               |
| -------- | -------- | ------------------ |
| pageNum  | 页码     | 用于分页构造器传参 |
| pageSize | 页数     | 用于分页构造器传参 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取公告列表成功",
    "data": {
        "records": [
            {
                "noticeId": 1,
                "noticeTitle": "本项目源代码地址,欢迎star!",
                "noticeContent": "https://luoye6.github.io/",
                "noticeAdminId": 1623,
                "createTime": "2023-02-05 16:11:40",
                "updateTime": "2023-02-05 16:11:40"
            },
            {
                "noticeId": 2,
                "noticeTitle": "注意事项",
                "noticeContent": "发现项目BUG,可以提出issue，大佬请别恶意攻击，小项目承受不起，谢谢",
                "noticeAdminId": 1623,
                "createTime": "2023-02-05 16:13:31",
                "updateTime": "2023-02-05 16:13:31"
            },
            {
                "noticeId": 3,
                "noticeTitle": "祝福",
                "noticeContent": "祝大家天天开心！",
                "noticeAdminId": 1623,
                "createTime": "2023-02-05 16:13:31",
                "updateTime": "2023-02-05 16:13:31"
            }
        ],
        "total": 3,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```

#### 2.发布公告(添加新公告)

+ 请求路径: bookadmin/add_notice
+ 请求方法: post
+ 请求参数

| 参数名        | 参数说明     | 备注 |
| ------------- | ------------ | ---- |
| noticeTitle   | 公告标题     |      |
| noticeContent | 公告内容     |      |
| bookAdminId   | 图书管理员id |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "新增公告成功",
    "data": null,
    "map": {}
}
```

#### 3.发布公告(删除公告)

+ 请求路径: bookadmin/delete_notice
+ 请求方法: get
+ 请求参数

| 参数名   | 参数说明 | 备注 |
| -------- | -------- | ---- |
| noticeId | 公告id   |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "删除公告成功",
    "data": null,
    "map": {}
}
```

#### 4.发布公告(获取单个公告)

+ 请求路径: bookadmin/get_notice
+ 请求方法: get
+ 请求参数: 

| 参数名   | 参数说明 | 备注 |
| -------- | -------- | ---- |
| noticeId | 公告id   |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取公告信息成功",
    "data": {
        "noticeId": 2,
        "noticeTitle": "注意事项",
        "noticeContent": "发现项目BUG,可以提出issue，大佬请别恶意攻击，小项目承受不起，谢谢",
        "noticeAdminId": 1623,
        "createTime": "2023-02-05 16:13:31",
        "updateTime": "2023-02-05 16:13:31"
    },
    "map": {}
}
```

#### 5.发布公告(修改公告)

+ 请求路径: bookadmin/update_notice
+ 请求方式: put
+ 请求参数

| 参数名        | 参数说明 | 备注 |
| ------------- | -------- | ---- |
| noticeId      | 公告id   |      |
| noticeTitle   | 公告标题 |      |
| noticeContent | 公告内容 |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "修改公告成功",
    "data": null,
    "map": {}
}
```

## 1.6系统管理员功能实现

### 1.6.1书籍管理

#### 1.书籍管理(获取图书列表)

+ 请求路径: admin/get_booklist
+ 请求方法: post
+ 请求参数

| 参数名    | 参数说明 | 备注               |
| --------- | -------- | ------------------ |
| pageNum   | 页码     | 用于分页构造器传参 |
| pageSize  | 页数     | 用于分页构造器传参 |
| query     | 内容     |                    |
| condition | 查询条件 | 模糊查询           |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取图书列表成功",
    "data": {
        "records": [
            {
                "bookId": 1,
                "bookNumber": 1234,
                "bookName": "红楼梦",
                "bookAuthor": "曹雪芹",
                "bookLibrary": "南图",
                "bookType": "小说",
                "bookLocation": "E1",
                "bookStatus": "已借出",
                "bookDescription": "《红楼梦》，原名《石头记》，中国古代章回体长篇小说，中国古典四大名著之一。",
                "createTime": "2023-02-04 17:51:04",
                "updateTime": "2023-02-04 17:51:04"
            },
            {
                "bookId": 2,
                "bookNumber": 1235,
                "bookName": "百年孤独",
                "bookAuthor": "加西亚·马尔克斯",
                "bookLibrary": "北图",
                "bookType": "小说",
                "bookLocation": "E2",
                "bookStatus": "已借出",
                "bookDescription": "《百年孤独》，是哥伦比亚作家加西亚·马尔克斯创作的长篇小说，是其代表作，也是拉丁美洲魔幻现实主义文学的代表作，被誉为“再现拉丁美洲历史社会图景的鸿篇巨著”。",
                "createTime": "2023-02-04 17:53:27",
                "updateTime": "2023-02-04 17:53:27"
            },
            {
                "bookId": 3,
                "bookNumber": 1236,
                "bookName": "三体",
                "bookAuthor": "刘慈欣",
                "bookLibrary": "教师之家",
                "bookType": "小说",
                "bookLocation": "F8",
                "bookStatus": "已借出",
                "bookDescription": "科幻小说，全名《地球往事三部曲》，是刘慈欣编写的史诗级巨作，是一部典型的硬科幻作品。",
                "createTime": "2023-02-04 17:53:27",
                "updateTime": "2023-02-04 17:53:27"
            },
            {
                "bookId": 4,
                "bookNumber": 1237,
                "bookName": "战争与和平",
                "bookAuthor": "列夫·尼古拉耶维奇·托尔斯泰",
                "bookLibrary": "南图",
                "bookType": "小说",
                "bookLocation": "A3",
                "bookStatus": "未借出",
                "bookDescription": "该作以1812年的卫国战争为中心，反映从1805到1820年间的重大历史事件。以鲍尔康斯、别祖霍夫、罗斯托夫和库拉金四大贵族的经历为主线，在战争与和平的交替描写中把众多的事件和人物串联起来",
                "createTime": "2023-02-10 17:00:48",
                "updateTime": "2023-02-10 17:00:48"
            },
            {
                "bookId": 5,
                "bookNumber": 1238,
                "bookName": "巴黎圣母院",
                "bookAuthor": "雨果",
                "bookLibrary": "北图",
                "bookType": "小说",
                "bookLocation": "B1",
                "bookStatus": "未借出",
                "bookDescription": "本书以1482年的法国为背景，塑造了一个个栩栩如生的形象——天真纯洁的吉普赛姑娘爱丝美拉达、年轻英俊...",
                "createTime": "2023-02-10 17:03:32",
                "updateTime": "2023-02-10 17:03:32"
            }
        ],
        "total": 5,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```

#### 2.书籍管理(添加图书获取分类)

+ 请求路径: admin/get_type
+ 请求方法: get
+ 请求参数(无)

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取书籍分类成功",
    "data": [
        {
            "typeId": 1,
            "typeName": "小说",
            "typeContent": "以刻画人物形象为中心，通过完整的故事情节和环境描写来反映社会生活的文学体裁",
            "createTime": "2023-02-04 17:41:53",
            "updateTime": "2023-02-04 17:41:53"
        },
        {
            "typeId": 2,
            "typeName": "儿童读物",
            "typeContent": "儿童读物是指少年儿童阅读的文学作品、知识读物、连环画、游戏样式读物等的总称",
            "createTime": "2023-02-04 17:43:30",
            "updateTime": "2023-02-04 17:43:30"
        },
        {
            "typeId": 3,
            "typeName": "工具书",
            "typeContent": "工具书是专供查找知识信息的文献，是系统汇集某方面的资料，按特定方法加以编排，以供需要时查考使用。",
            "createTime": "2023-02-04 17:43:30",
            "updateTime": "2023-02-04 17:43:30"
        }
    ],
    "map": {}
}
```



#### 3.书籍管理(添加图书)

+ 请求路径: admin/add_book
+ 请求方法: post
+ 请求参数:

| 参数名          | 参数说明         | 备注 |
| --------------- | ---------------- | ---- |
| bookName        | 图书名称         |      |
| bookAuthor      | 作者             |      |
| bookLibrary     | 图书馆           |      |
| booTypeNumber   | 书籍类型对应的id |      |
| bookLocation    | 图书位置         |      |
| bookStatus      | 图书状态         |      |
| bookDescription | 图书介绍         |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "添加书籍成功",
    "data": null,
    "map": {}
}
```

#### 4.书籍管理(删除图书)

+ 请求路径: admin/delete_book
+ 请求方法: get
+ 请求参数:

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| bookId | 图书主键 |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "删除书籍成功",
    "data": null,
    "map": {}
}
```

#### 5.书籍管理(获取图书信息)

+ 请求路径: admin/get_bookinformation
+ 请求方法: get
+ 请求参数:

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| bookId | 图书主键 |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取书籍信息成功",
    "data": null,
    "map": {}
}
```

#### 6.书籍管理(修改图书)

+ 请求路径: admin/update_book
+ 请求方法: post
+ 请求参数:

| 参数名          | 参数说明 | 备注 |
| --------------- | -------- | ---- |
| bookName        | 图书名称 |      |
| bookAuthor      | 作者     |      |
| bookLibrary     | 图书馆   |      |
| booType         | 书籍类别 |      |
| bookLocation    | 图书位置 |      |
| bookStatus      | 图书状态 |      |
| bookDescription | 图书介绍 |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "修改书籍信息成功",
    "data": null,
    "map": {}
}
```

#### 7.书籍管理(批量删除图书)

+ 请求路径: admin/delete_book_batch
+ 请求方法: delete
+ 请求参数

| 参数名          | 参数说明         | 备注 |
| --------------- | ---------------- | ---- |
| bookName        | 图书名称         |      |
| bookAuthor      | 作者             |      |
| bookLibrary     | 图书馆           |      |
| booTypeNumber   | 书籍类型对应的id |      |
| bookLocation    | 图书位置         |      |
| bookStatus      | 图书状态         |      |
| bookDescription | 图书介绍         |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "批量删除图书成功",
    "data": null,
    "map": {}
}
```



### 1.6.2书籍类型

#### 1.书籍类型(获取书籍类型列表)

+ 请求路径: admin/get_booktype_page
+ 请求方法: post
+ 请求参数

| 参数名   | 参数说明 | 备注               |
| -------- | -------- | ------------------ |
| pageNum  | 页码     | 用于分页构造器传参 |
| pageSize | 页数     | 用于分页构造器传参 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取书籍分类列表成功",
    "data": {
        "records": [
            {
                "typeId": 1,
                "typeName": "小说",
                "typeContent": "以刻画人物形象为中心，通过完整的故事情节和环境描写来反映社会生活的文学体裁",
                "createTime": "2023-02-04 17:41:53",
                "updateTime": "2023-02-04 17:41:53"
            },
            {
                "typeId": 2,
                "typeName": "儿童读物",
                "typeContent": "儿童读物是指少年儿童阅读的文学作品、知识读物、连环画、游戏样式读物等的总称",
                "createTime": "2023-02-04 17:43:30",
                "updateTime": "2023-02-04 17:43:30"
            },
            {
                "typeId": 3,
                "typeName": "工具书",
                "typeContent": "工具书是专供查找知识信息的文献，是系统汇集某方面的资料，按特定方法加以编排，以供需要时查考使用。",
                "createTime": "2023-02-04 17:43:30",
                "updateTime": "2023-02-04 17:43:30"
            },
            {
                "typeId": 4,
                "typeName": "科幻",
                "typeContent": "一般认为优秀的科幻小说须具备“逻辑自洽”、“科学元素”、“人文思考”三要素。当下以叙事为重点，追求人文思考已成为科幻小说主流，科幻与奇幻小说界限日益模糊，国内科幻小说还呈现出轻科学偏文艺的趋势。",
                "createTime": "2023-02-12 14:05:28",
                "updateTime": "2023-02-12 14:05:28"
            }
        ],
        "total": 4,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```

#### 2.书籍类别(添加书籍分类)

+ 请求路径: admin/add_booktype
+ 请求方法: post
+ 请求参数:

| 参数名      | 参数说明     | 备注 |
| ----------- | ------------ | ---- |
| typeName    | 书籍类别名称 |      |
| typeContent | 类别介绍     |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "添加书籍类别成功",
    "data": null,
    "map": {}
}
```

#### 3.书籍类别(获取类别信息)

+ 请求路径: admin/get_booktype/{typeId}
+ 请求方法: get
+ 请求参数:

| 参数名 | 参数说明   | 备注 |
| ------ | ---------- | ---- |
| typeId | 书籍类别id |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取书籍类别成功",
    "data": {
        "typeId": 1,
        "typeName": "小说",
        "typeContent": "以刻画人物形象为中心，通过完整的故事情节和环境描写来反映社会生活的文学体裁",
        "createTime": "2023-02-04 17:41:53",
        "updateTime": "2023-02-04 17:41:53"
    },
    "map": {}
}
```

#### 4.书籍类别(修改书籍类别)

+ 请求路径: admin/update_booktype
+ 请求方法: post
+ 请求参数:

| 参数名      | 参数说明     | 备注 |
| ----------- | ------------ | ---- |
| typeId      | 书籍类别id   |      |
| typeName    | 书籍类别名称 |      |
| typeContent | 书籍类别内容 |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "修改书籍类别成功",
    "data": null,
    "map": {}
}
```

#### 5.书籍类别(删除书籍类别)

+ 请求路径: admin/delete_booktype/{typeId}
+ 请求方法: get
+ 请求参数:

| 参数名 | 参数说明   | 备注 |
| ------ | ---------- | ---- |
| typeId | 书籍类别id |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "删除书籍类别成功",
    "data": null,
    "map": {}
}
```

### 1.6.3借阅证管理

#### 1.借阅证管理(获取借阅证列表)

+ 请求路径: admin/get_statementlist
+ 请求方法: post
+ 请求参数

| 参数名    | 参数说明 | 备注               |
| --------- | -------- | ------------------ |
| pageNum   | 页码     | 用于分页构造器传参 |
| pageSize  | 页数     | 用于分页构造器传参 |
| condition | 条件     |                    |
| query     | 查询内容 |                    |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取借阅证列表成功",
    "data": {
        "records": [
            {
                "userId": 1923,
                "username": "相思断红肠",
                "password": "e10adc3949ba59abbe56e057f20f883e",
                "cardName": "张三",
                "cardNumber": 18012345678,
                "ruleNumber": 188,
                "status": 1,
                "createTime": "2023-02-02 16:12:05",
                "updateTime": "2023-02-02 16:12:05"
            },
            {
                "userId": 2543,
                "username": "落叶者",
                "password": "e10adc3949ba59abbe56e057f20f883e",
                "cardName": "一鲲年",
                "cardNumber": 18068834231,
                "ruleNumber": 88,
                "status": 1,
                "createTime": "2023-02-06 16:23:07",
                "updateTime": "2023-02-06 16:23:07"
            }
        ],
        "total": 2,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```

#### 2.借阅证管理(获取规则复用读者规则)

#### 3.借阅证管理(添加借阅证)

+ 请求路径: admin/add_statement
+ 请求方法: post
+ 请求参数

| 参数名     | 参数说明 | 备注 |
| ---------- | -------- | ---- |
| username   | 用户名   |      |
| password   | 密码     |      |
| ruleNumber | 规则编号 |      |
| userStatus | 用户状态 |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "添加借阅证成功",
    "data": null,
    "map": {}
}
```

#### 4.借阅证管理(获取借阅证)

+ 请求路径: admin/get_statement
+ 请求方法: get
+ 请求参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| userId | 用户id   |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取用户信息成功",
    "data": {
        "userId": 1923,
        "username": "相思断红肠",
        "password": "e10adc3949ba59abbe56e057f20f883e",
        "cardName": "张三",
        "cardNumber": 18012345678,
        "ruleNumber": 188,
        "status": 1,
        "createTime": "2023-02-02 16:12:05",
        "updateTime": "2023-02-02 16:12:05",
        "userStatus": "可用"
    },
    "map": {}
}
```

#### 5.借阅证管理(修改借阅证)

+ 请求路径: admin/update_statement
+ 请求方法: post
+ 请求参数

| 参数名     | 参数说明 | 备注 |
| ---------- | -------- | ---- |
| username   | 用户名   |      |
| password   | 密码     |      |
| ruleNumber | 规则编号 |      |
| userStatus | 用户状态 |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "修改借阅证成功",
    "data": null,
    "map": {}
}
```

#### 6.借阅证管理(删除借阅证)

+ 请求路径: admin/delete_statement/{userId}
+ 请求方法: delete
+ 请求参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| userId | 用户id   |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "修改借阅证成功",
    "data": null,
    "map": {}
}
```



### 1.6.4借阅信息查询(复用图书管理员查询)

+ 请求路径: bookadmin/get_borrow_statement
+ 请求方法: post
+ 请求参数

| 参数名    | 参数说明 | 备注               |
| --------- | -------- | ------------------ |
| pageNum   | 页码     | 用于分页构造器传参 |
| pageSize  | 页数     | 用于分页构造器传参 |
| condition | 条件     |                    |
| query     | 查询内容 |                    |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取借书报表信息成功",
    "data": {
        "records": [
            {
                "violationId": 1,
                "cardNumber": 18012345678,
                "bookNumber": 1234,
                "borrowDate": "2023-02-05 18:48:19",
                "closeDate": "2023-03-27 18:48:19",
                "returnDate": "2023-02-25 18:48:19",
                "violationMessage": "",
                "violationAdminId": 1420,
                "createTime": "2023-02-06 16:30:12",
                "updateTime": "2023-02-06 16:30:12",
                "violationAdmin": "admin",
                "expireDays": 0
            },
            {
                "violationId": 2,
                "cardNumber": 18012345678,
                "bookNumber": 1235,
                "borrowDate": "2023-02-05 18:48:19",
                "closeDate": "2023-03-27 18:48:19",
                "returnDate": "2023-02-28 18:48:19",
                "violationMessage": "",
                "violationAdminId": 1420,
                "createTime": "2023-02-06 16:31:00",
                "updateTime": "2023-02-06 16:31:00",
                "violationAdmin": "admin",
                "expireDays": 0
            },
            {
                "violationId": 3,
                "cardNumber": 18012345678,
                "bookNumber": 1236,
                "borrowDate": "2023-02-05 18:48:19",
                "closeDate": "2023-03-27 18:48:19",
                "returnDate": "2023-03-05 18:48:19",
                "violationMessage": "",
                "violationAdminId": 1420,
                "createTime": "2023-02-06 16:31:00",
                "updateTime": "2023-02-06 16:31:00",
                "violationAdmin": "admin",
                "expireDays": 0
            },
            {
                "violationId": 4,
                "cardNumber": 18012345678,
                "bookNumber": 1234,
                "borrowDate": "2023-02-08 19:06:05",
                "closeDate": "2023-03-30 19:06:05",
                "returnDate": "2023-02-08 19:44:21",
                "violationMessage": "",
                "violationAdminId": 1420,
                "createTime": "2023-02-08 19:06:05",
                "updateTime": "2023-02-08 19:06:05",
                "violationAdmin": "admin",
                "expireDays": 0
            },
            {
                "violationId": 5,
                "cardNumber": 18012345678,
                "bookNumber": 1235,
                "borrowDate": "2023-02-08 19:49:14",
                "closeDate": "2023-03-30 19:49:14",
                "returnDate": "2023-02-08 19:49:45",
                "violationMessage": "书籍损坏",
                "violationAdminId": 1420,
                "createTime": "2023-02-08 19:49:14",
                "updateTime": "2023-02-08 19:49:14",
                "violationAdmin": "admin",
                "expireDays": 0
            }
        ],
        "total": 5,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```

### 1.6.5借阅规则管理

#### 1.借阅规则管理(获取规则列表)

+ 请求路径: admin/get_rulelist_page
+ 请求方法: post
+ 请求参数:

| 参数名   | 参数说明 | 备注               |
| -------- | -------- | ------------------ |
| pageNum  | 页码     | 用于分页构造器传参 |
| pageSize | 页数     | 用于分页构造器传参 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取规则列表成功",
    "data": {
        "records": [
            {
                "ruleId": 1,
                "bookRuleId": 188,
                "bookDays": 50,
                "bookLimitNumber": 10,
                "bookLimitLibrary": "教师之家,南图,北图",
                "bookOverdueFee": 1.5,
                "createTime": "2023-02-04 17:45:32",
                "updateTime": "2023-02-04 17:45:32"
            },
            {
                "ruleId": 2,
                "bookRuleId": 688,
                "bookDays": 150,
                "bookLimitNumber": 30,
                "bookLimitLibrary": "教师之家,南图,北图",
                "bookOverdueFee": 0.5,
                "createTime": "2023-02-04 17:46:19",
                "updateTime": "2023-02-04 17:46:19"
            },
            {
                "ruleId": 3,
                "bookRuleId": 88,
                "bookDays": 20,
                "bookLimitNumber": 5,
                "bookLimitLibrary": "教师之家,南图,北图",
                "bookOverdueFee": 2.5,
                "createTime": "2023-02-04 17:46:19",
                "updateTime": "2023-02-04 17:46:19"
            }
        ],
        "total": 3,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```

#### 2.借阅规则管理(添加规则)

+ 请求路径: admin/add_rule
+ 请求方法: post
+ 请求参数:

| 参数名           | 参数说明   | 备注 |
| ---------------- | ---------- | ---- |
| bookLimitDays    | 限制天数   |      |
| bookLimitNumber  | 限制本数   |      |
| bookOverdueFee   | 逾期费用   |      |
| bookLimitLibrary | 限制图书馆 |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "添加规则成功",
    "data": null,
    "map": {}
}
```

#### 3.借阅规则管理(获取规则)

+ 请求路径:admin/get_rule_ruleid
+ 请求方法: get
+ 请求参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| ruleId | 规则编号 |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取规则信息成功",
    "data": {
        "ruleId": 1,
        "bookRuleId": 188,
        "bookDays": 50,
        "bookLimitNumber": 10,
        "bookLimitLibrary": null,
        "bookOverdueFee": 1.5,
        "createTime": "2023-02-04 17:45:32",
        "updateTime": "2023-02-04 17:45:32",
        "checkList": [
            "教师之家",
            "南图",
            "北图"
        ]
    },
    "map": {}
}
```

#### 4.借阅证管理(修改规则)

+ 请求路径: admin/update_rule
+ 请求方法: put
+ 请求参数

| 参数名           | 参数说明   | 备注 |
| ---------------- | ---------- | ---- |
| bookLimitDays    | 限制天数   |      |
| bookLimitNumber  | 限制本数   |      |
| bookOverdueFee   | 逾期费用   |      |
| bookLimitLibrary | 限制图书馆 |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "修改规则成功",
    "data": null,
    "map": {}
}
```

#### 5.借阅证管理(删除规则)

+ 请求路径: admin/delete_rule/{ruleId}
+ 请求方法: delete
+ 请求参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| ruleId | 规则id   |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "删除规则成功",
    "data": null,
    "map": {}
}
```

### 1.6.6图书管理员管理

#### 1.图书管理员管理(获取图书管理员列表)

+ 请求路径: admin/get_bookadminlist
+ 请求方法: post
+ 请求参数

| 参数名   | 参数说明 | 备注               |
| -------- | -------- | ------------------ |
| pageNum  | 页码     | 用于分页构造器传参 |
| pageSize | 页数     | 用于分页构造器传参 |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取图书管理员列表成功",
    "data": {
        "records": [
            {
                "bookAdminId": 1420,
                "username": "admin",
                "password": "e10adc3949ba59abbe56e057f20f883e",
                "bookAdminName": "王二离",
                "status": 1,
                "email": "449832156@qq.com",
                "createTime": "2023-02-03 19:43:37",
                "updateTime": "2023-02-03 19:43:37"
            },
            {
                "bookAdminId": 1543,
                "username": "admin2",
                "password": "e10adc3949ba59abbe56e057f20f883e",
                "bookAdminName": "礼喆",
                "status": 1,
                "email": "238824@qq.com",
                "createTime": "2023-02-12 19:45:36",
                "updateTime": "2023-02-12 19:45:36"
            }
        ],
        "total": 2,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "searchCount": true,
        "countId": null,
        "maxLimit": null,
        "pages": 1
    },
    "map": {}
}
```

#### 2.图书管理员管理(添加图书管理员)

+ 请求路径: admin/add_bookadmin
+ 请求方法: post
+ 请求参数

| 参数名       | 参数说明 | 备注 |
| ------------ | -------- | ---- |
| booAdminName | 姓名     |      |
| username     | 账号     |      |
| password     | 密码     |      |
| email        | 邮件     |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "添加图书管理员成功",
    "data": null,
    "map": {}
}
```

#### 3.图书管理员管理(获取图书管理员)

+ 请求路径: admin/get_bookadmin/{bookAdminId}
+ 请求方法: post
+ 请求参数

| 参数名     | 参数说明     | 备注 |
| ---------- | ------------ | ---- |
| booAdminId | 图书管理员id |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应参数

```json
{
    "status": 200,
    "msg": "获取图书管理员信息成功",
    "data": {
        "bookAdminId": 1420,
        "username": "admin",
        "password": "e10adc3949ba59abbe56e057f20f883e",
        "bookAdminName": "王二离",
        "status": 1,
        "email": "449832156@qq.com",
        "createTime": "2023-02-03 19:43:37",
        "updateTime": "2023-02-03 19:43:37"
    },
    "map": {}
}
```

#### 4.图书管理员管理(删除图书管理员)

+ 请求路径: admin/delete_bookadmin/{bookAdminId}
+ 请求方法: delete
+ 请求参数

| 参数名     | 参数说明     | 备注 |
| ---------- | ------------ | ---- |
| booAdminId | 图书管理员id |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "删除图书管理员成功",
    "data": null,
    "map": {}
}
```

#### 5.图书管理员管理(修改图书管理员)

+ 请求路径: admin/update_bookadmin
+ 请求方法: put
+ 请求参数

| 参数名       | 参数说明 | 备注 |
| ------------ | -------- | ---- |
| booAdminName | 姓名     |      |
| username     | 账号     |      |
| password     | 密码     |      |
| email        | 邮件     |      |

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "修改图书管理员成功",
    "data": null,
    "map": {}
}
```

### 1.6.7系统管理

#### 1.获取借阅量

+ 请求路径: admin/get_borrowdata
+ 请求方法: get
+ 请求参数(无)

+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

```json
{
    "status": 200,
    "msg": "获取借阅量成功",
    "data": {
        "borrowDates": [
            "2023-01-27-2023-02-03",
            "2023-02-03-2023-02-10",
            "2023-02-10-2023-02-17",
            "2023-02-17-2023-02-24"
        ],
        "borrowNumber": [
            0,
            5,
            8,
            2
        ]
    },
    "map": {}
}
```

#### 2.获取借书分类统计

+ 请求路径: admin/get_borrowtype_statistics
+ 请求方法: get
+ 请求参数:（无)
+ 响应参数

| 参数名 | 参数说明   | 备注                |
| ------ | ---------- | ------------------- |
| status | 响应状态码 | 200表示获取数据成功 |
| msg    | 请求信息   |                     |
| data   | 请求数据   |                     |

+ 响应数据

````json
{
    "status": 200,
    "msg": "获取借书分类统计情况成功",
    "data": [
        {
            "bookTypes": "科幻",
            "borrowNumbers": 2
        },
        {
            "bookTypes": "儿童读物",
            "borrowNumbers": 1
        },
        {
            "bookTypes": "小说",
            "borrowNumbers": 15
        },
        {
            "bookTypes": "计算机",
            "borrowNumbers": 1
        }
    ],
    "map": {}
}
````

