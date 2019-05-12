# springboot-jpa-test

Here is a demo for springboot jpa test demo

please change mysql configs in  application.yml,

Tables needed are as follow：

```
CREATE TABLE `student` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
