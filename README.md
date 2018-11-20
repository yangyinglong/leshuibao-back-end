项目介绍
```
这是一个发票代开系统的后端，用户通过注册账号，就可以在这个系统上填写代开发票的基本信息，经过后台管理人员的审核之后，帮助用户开发票，然后邮寄给用户，实现了远程开发票的功能，解决了用户需要到一些店面亲自开发票的问题。
从技术上，使用了 Spring boot 、 Mybatis 、 Jersey 等，接入了 支付宝支付、 微信支付、 阿里短信接口等，将各个功能包装成 api 提供给前端
```
模块介绍
```
主要包含以下四个模块：
1. 用户管理模块
2. 文件传输模块
3. 订单增加模块
4. 订单查询模块
```

用户管理模块
```
具体实现了一下功能
1. 登录
2. 注册
3. 登出
4. 密码找回
5. 短信发送

登录
	接口：/api/authorize/login
	参数：LoginReqDto
	返回：HashMap
	描述：根据前端传过来的数据 LoginReqDto(userName, password, remeberPassword)，查询 user 表，
			如果查到，则返回 ('200', UserRespDto)
			如果没有查到，则返回（'400', "登录失败"）
		  在查询 user 表的时候，根据 userName 查询，userName 可以是用户名，也可以是手机号码，首先根据用户名查询，如果没有查到，则根据手机号码查询，查询到的结果为 UserEntity，然后根据 UserEntity，创建 UserRespDto

注册
	接口：/api/authorize/register
	参数：RegisterReqDto
	返回：HashMap
	描述：


```



Bug修复记录
```
1. 登录和注册的反馈框调整至中间 ok
2. 短信验证的发送按钮提示剩余时间 ok
3. 付款成功后跳转回开票页面
4. 后台审核信息的抬头调整为发票抬头，并新增开票人用户名和开票人信息
5. 桌面网页快捷方式安装包
6. 网页记住用户名和密码 ok
7. 个人中心UI布局调整
8. 用户协议上传
9. 身份证上传页面新增师范样例
10. 开票人信息新增修改功能
11. 分页查询  ok
```