项目介绍
```
这是一个发票代开系统的后端，用户通过注册账号，就可以在这个系统上填写代开发票的基本信息，
经过后台管理人员的审核之后，帮助用户开发票，然后邮寄给用户，实现了远程开发票的功能，解
决了用户需要到一些店面亲自开发票的问题。
从技术上，使用了 Spring boot 、 Mybatis 、 Jersey 等，接入了 支付宝支付、 微信支付、 
阿里短信接口等，将各个功能包装成 api 提供给前端
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
具体实现了以下功能
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
		在查询 user 表的时候，根据 userName 查询，userName 可以是用户名，也可以是手机号码，首先根据用户名查询，如果没有查到，则根据手机号码查询，查询到的结果为 
		UserEntity，然后根据 UserEntity，创建 UserRespDto

注册
	接口：/api/authorize/register
	参数：RegisterReqDto
	返回：HashMap
	描述：根据前端传过来的数据 RegisterReqDto(userName, phone, password, smsCode, smsId)，首先查询表 user，
		判断该手机号码是否已被注册，如果已被注册，则返回(201, "老用户，请直接登录。或从：登录 -> 忘记密码 找回密码。")
		否则根据 smsId 查询表 sms_log ,获取验证码与smsCode进行比较，如果不相等，则返回(300, "验证码不正确")
		否则根据 registerReqDto 创建一个 UserEntity, 写入表 user，并返回(200, UserRespDto)

登出
	接口：/api/authorize/logout
	参数：String
	返回：HashMap
	描述：//todo

密码找回
	接口：/api/authorize/passChange
	参数：PasswdChangeReqDto
	返回：HashMap
	描述：根据 PasswdChangeReqDto(smsId, pass, phone, validatecode) 查询表 sms_log 得到 SmsLogEntity，如果能查到并且 
		SmsLogEntity 的 smsCode 与 validatecode 相等，则根据 phone 更新表 user 的字段 password，返回 (200, "密码修改
		成功!")，否则返回(201, "验证码验证错误，密码修改未成功！")

短信发送
	接口：/api/authorize/smsSend
	参数：String phone
	返回：HashMap
	描述：首先在 com.leshuibao.fragmentTax.util.SmsUtil 中封装了阿里短信发送的函数，然后随机生成长度为24的一个字符串作为 smsKey
		和 长度为6的整数字符串作为验证码 smsCode，然后循环调用 SendSmsResp = sendSms(phone, smsCode) 函数，判断 SendSmsResp 
		的状态是否为 "OK"，如果是，则在表 sms_log 中增加一条记录，返回 (200, smsKey)，smsKey 的作用是用来在 sms_log 中查找 smsCode，
		如果不是，循环5次，返回 (300, "短信发送失败")

```

文件传输模块
```
具体实现了以下功能
1. 上传文件
2. 下载身份证图片
3. 下载微信二维码
4. 下载 Excel
5. 下载快递单号

上传文件
	接口：/api/suppliment/upload
	参数：@FormDataParam("file") InputStream fileInputStream,
         @FormDataParam("file") FormDataContentDisposition fileDisposition,
         @FormDataParam("fileName") String fileName,
         @FormDataParam("isFront") String isFront
	返回：void
	描述：调用 FileUtils.copyInputStreamToFile(fileInputStream, new File(IMAGE_PATH + fileName)) 写入文件 // todo

下载身份证图片
	接口：/api/authorize/printIC
	参数：@QueryParam("payeeId") String payeeId, 
		 @QueryParam("payeeName") String payeeName, 
		 @QueryParam("isFront") String isFront
	返回：Response
	描述：根据 payeeName、 payeeId、 isFront 生成一个 fileName，
		StreamingOutput fileStream = new StreamingOutput() {
            @Override
            public void write(java.io.OutputStream output) throws WebApplicationException {
                try {
                    java.nio.file.Path path = Paths.get(IMAGE_PATH + fileName);
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                } catch (Exception e) {
                    throw new WebApplicationException("File Not Found !!");
                }
            }
        };
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename =" + fileName)
                .build();

下载微信二维码
	接口：/api/authorize/printQrImg
	参数：@QueryParam("orderId") String orderId
	返回：Response
	描述：根据 orderId 生成一个 fileName，后续跟 prinIC 相同

下载 Excel
	接口：/api/authorize/printOrder
	参数：@QueryParam("orderId") String orderId
	返回：Response
	描述：首先根据 orderId 生成一个文件名 fileName，然后调用 genExcel(fileName, orderId) 生成一个 File，写入到文件中，
		如果生成失败，则返回 return Response.status(Response.Status.NOT_FOUND).build()，否则将文件的编码转成 "utf-8"，
		返回 return Response
                .ok(file)
                .header("Content-disposition", "attachment;filename=" + fileName).build();
        genExcel() 是封装好的一个专门讲数据写入到Excel中指定位置的函数

```

订单增加模块
```
具体实现了以下功能
1. 增加订单
2. 支付宝支付
3. 微信支付
4. 支付宝支付的订单支付结果查询
5. 微信支付的订单支付结果查询
6. 修改订单
7. 支付结果更新
8. 增加开票人
9. 审核驳回
10. 审核通过
```

订单查询模块
```
具体实现了以下功能
1. 通过 UserId 查询开票人
2. 通过 OrderId 查询开票人
3. 根据 UserId 查询付款方
4. 根据 OrderId 查询付款方
5. 查询地址
6. 查询货物
7. 查询订单
8. 查询订单（管理员）

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