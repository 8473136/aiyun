create table aiyun_users(
id VARCHAR(32) primary key COMMENT '主键',
user_nick_name VARCHAR(32) COMMENT '昵称',
user_password VARCHAR(16) COMMENT '用户密码',
salt varchar(32) COMMENT '盐',
email varchar(64) COMMENT '邮箱',
phone VARCHAR(11) COMMENT '手机号',
avatar VARCHAR(11) COMMENT '头像',
user_groups VARCHAR(32) COMMENT '用户组',
create_time datetime default now() COMMENT '创建时间',
create_by VARCHAR(32) COMMENT '创建人',
update_time datetime default now() COMMENT '修改时间',
update_by VARCHAR(32) COMMENT '修改人',
is_deleteed INT COMMENT '删除标识 0为正常 1删除'
)



create table aiyun_users_groups(
id VARCHAR(32) primary key COMMENT '主键',
groub_name VARCHAR(32) COMMENT '用户组名称',
groub_capacity BIGINT COMMENT '用户容量 单位MB',
create_time datetime default now() COMMENT '创建时间',
create_by VARCHAR(32) COMMENT '创建人',
update_time datetime default now() COMMENT '修改时间',
update_by VARCHAR(32) COMMENT '修改人',
is_deleteed INT COMMENT '删除标识 0为正常 1删除'
)charset=utf8mb4;


create table aiyun_file
(
id VARCHAR(32) primary key COMMENT '主键',
source_file_name VARCHAR(64) COMMENT '原文件名',
upload_file_name VARCHAR(64) COMMENT '上传文件名',
folder_id VARCHAR(32) COMMENT '所属文件夹',
user_id VARCHAR(64) COMMENT '所属用户',
file_size BIGINT COMMENT '文件大小 单位MB',
create_time datetime default now() COMMENT '创建时间',
create_by VARCHAR(32) COMMENT '创建人',
update_time datetime default now() COMMENT '修改时间',
update_by VARCHAR(32) COMMENT '修改人',
is_deleteed INT COMMENT '删除标识 0为正常 1删除'
)charset=utf8mb4;

create table aiyun_folder
(
id VARCHAR(32) primary key COMMENT '主键',
folder_name VARCHAR(64) COMMENT '文件夹名称',
parent_folder_id VARCHAR(32) COMMENT '父文件夹',
user_id VARCHAR(64) COMMENT '所属用户',
create_time datetime default now() COMMENT '创建时间',
create_by VARCHAR(32) COMMENT '创建人',
update_time datetime default now() COMMENT '修改时间',
update_by VARCHAR(32) COMMENT '修改人',
is_deleteed INT COMMENT '删除标识 0为正常 1删除'
)charset=utf8mb4;