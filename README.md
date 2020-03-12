# HCAccountingService

## git commit message
### 格式
```
<type>(<scope>): <subject>
<option body>
```
### type
`feat`: (new feature for the user, not a new feature for build script)

`fix`: (bug fix for the user, not a fix to a build script)

`docs`: (changes to the documentation)

`style`: (formatting, missing semi colons, etc; no production code change)

`refactor`: (refactoring production code eg. renaming a variable)

`test`: (adding missing tests, refactoring tests; no production code change)

`chore`: (updating grunt tasks etc; no production code change)

------

## mysql安装

### 下载镜像文件

```
docker pull mysql:5.7
```

### 创建实例并启动

```
docker run -p 3306:3306 --name mysql \
-v /tmp/mysql/log:/var/log/mysql \
-v /tmp/mysql/data:/var/lib/mysql \
-v /tmp/mysql/conf:/etc/mysql \
-e MYSQL_ROOT_PASSWORD=root \
-d mysql:5.7
```

参数说明

-p 3306:3306：将容器的3306端口映射到主机的3306端口

-v /tmp/mysql/log:/var/log/mysql：将日志文件夹挂载到主机

-v /tmp/mysql/data:/var/lib/mysql：将数据文件夹挂载到主机

-v /tmp/mysql/conf:/etc/mysql：将配置文件夹挂载到主机

-e MYSQL_ROOT_PASSWORD=root：初始化root用户的密码

-d mysql:5.7：指定版本

### 通过容器的mysql命令行工具连接

```
docker exec -it mysql mysql -uroot -p
password: root
```

------

## Standard response headers

### Response格式

#### 错误请求的Response

一定要用HTTP status code

最简单的三类：

OK 200

Client side error: 4XX

Service side error: 5XX

```json
{
	"error": {
    "code": "BadArgument",
    "message": "desc",
    "target": "Where is the error come from",
    "details": [
      {
        "code": "NullValue",
        "target": "PhoneNumber",
        "message": "Phone number must not be null"
      }
    ]
  }
}
```

