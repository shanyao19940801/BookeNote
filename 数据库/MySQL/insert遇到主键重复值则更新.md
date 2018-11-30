# MySQL的ON DUPLICATE KEY UPDATE用法

在MySQL数据库中，如果在insert语句后面带上ON DUPLICATE KEY UPDATE 子句，而要插入的行与表中现有记录的惟一索引或主键中产生重复值，那么就会发生旧行的更新；如果插入的行数据与现有表中记录的唯一索引或者主键不重复，则执行新纪录插入操作。<br>
* **现有一张表：**

	create table daily_hit_counter (
	
	day date not null,
	
	slot tinyint unsigned not null,
	
	cnt int unsigned not null,
	
	primary key(day, slot)
	
	) engine = InnoDB;
	
	daily_hit_counter 表的惟一索引是由 day+slot 两个字段组成。

* 现有数据


		day	           slot	    cnt
		2017-11-19  	1	    10
		2017-11-20  	2    	10

* 执行SQL

		insert into daily_hit_counter (day, slot, cnt) values ('2017-11-19', 1, 1) ON DUPLICATE KEY UPDATE cnt = cnt + 1;

数据会更新但不不会新增