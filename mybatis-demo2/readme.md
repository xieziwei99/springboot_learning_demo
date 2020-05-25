## Mybatis plus 学习
- 参考[官网](https://mp.baomidou.com/guide/)

### 配置
- 采用 H2 内嵌数据库
    - 包含资源文件scheme-create.sql和data-init.sql

### Mybatis 使用操作步骤
1. 添加 mybatis plus 依赖

   ```xml
   <dependency>
       <groupId>com.baomidou</groupId>
       <artifactId>mybatis-plus-boot-starter</artifactId>
       <version>3.3.0</version>
   </dependency>
   ```

2. 在 springboot 主类中添加 @MapperScan 注解

   ```java
   @SpringBootApplication
   @MapperScan("com.xzw.mybatisdemo2.mapper")
   public class MybatisDemo2Application {
       public static void main(String[] args) {
           SpringApplication.run(MybatisDemo2Application.class, args);
       }
   }
   ```

3. 编写 model 类，和 mapper 类，即可实现简单的 CRUD