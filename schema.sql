CREATE TABLE marketing_range_element (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  group_id varchar(255) NOT NULL COMMENT '组id',
  seller_id varchar(255) NOT NULL COMMENT '商家id',
  participate_id varchar(255) NOT NULL COMMENT '参与者id',
  participate_type int(11) NOT NULL COMMENT '参与者类型 sku/seller/item',
  activity_id varchar(255) DEFAULT NULL COMMENT '活动id',
  feature text COMMENT '扩展执行参数',
  start_time datetime NOT NULL COMMENT '开始时间',
  end_time datetime NOT NULL COMMENT '结束时间',
  start_show_time datetime DEFAULT NULL COMMENT '预热开始时间',
  end_show_time datetime DEFAULT NULL COMMENT '预热结束时间',
  state int(11) NOT NULL COMMENT '状态',
  element_id varchar(255) NOT NULL COMMENT '详情id',
  PRIMARY KEY (id),
  KEY idx_activity_id_participate_id (activity_id,participate_id,state),
  KEY idx_group_id_state (group_id,state),
  KEY idx_update_time (update_time)
);

CREATE TABLE marketing_activity (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  activity_id varchar(255) DEFAULT NULL COMMENT '活动id',
  name varchar(255) DEFAULT NULL COMMENT '活动名称',
  activity_type int(11) DEFAULT NULL COMMENT '活动类型 日常/大促',
  tool_code varchar(255) NOT NULL COMMENT '优惠工具code',
  seller_id varchar(255) NOT NULL COMMENT '店铺id',
  calculate_level int(11) DEFAULT NULL COMMENT '计算级别',
  start_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
  end_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
  start_show_time datetime DEFAULT NULL COMMENT '预热开始时间',
  end_show_time datetime DEFAULT NULL COMMENT '预热结束时间',
  state int(11) NOT NULL DEFAULT '0' COMMENT '状态 删除/暂停/生效',
  feature text COMMENT '扩展字段',
  operation_parameter text COMMENT '执行参数',
  source int(11) unsigned NOT NULL DEFAULT '1' COMMENT '来源 平台/商家',
  PRIMARY KEY (id),
  KEY idx_seller_id_state (seller_id,state),
  KEY idx_activity_id_state (activity_id,state),
  KEY idx_seller_id_start_end_time (seller_id,start_time,end_time)
);

CREATE TABLE marketing_detail (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  detail_id varchar(255) DEFAULT NULL COMMENT '优惠详情id',
  name varchar(255) DEFAULT NULL COMMENT '活动名称',
  activity_id varchar(255) DEFAULT NULL COMMENT '优惠活动id',
  participate_id varchar(255) DEFAULT NULL COMMENT '参与者id',
  participate_type int(11) DEFAULT NULL COMMENT '参与者类型 sku/seller/item',
  tool_code varchar(255) NOT NULL COMMENT '工具code',
  seller_id varchar(255) NOT NULL COMMENT '商家id',
  feature text COMMENT '扩展字段',
  operation_parameter text COMMENT '执行参数',
  calculate_level int(11) DEFAULT NULL COMMENT '计算级别',
  state int(11) NOT NULL DEFAULT '0' COMMENT '状态',
  source int(11) unsigned NOT NULL DEFAULT '1' COMMENT '来源',
  start_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
  end_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
  start_show_time datetime DEFAULT NULL COMMENT '预热开始时间',
  end_show_time datetime DEFAULT NULL COMMENT '预热结束时间',
  PRIMARY KEY (id),
  UNIQUE KEY uk_detail_id (detail_id),
  KEY idx_activity_id_participate_id (activity_id,participate_id,state),
  KEY idx_update_time (update_time)
);

CREATE TABLE marketing_rule (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  name varchar(32) NOT NULL COMMENT '规则名',
  description varchar(128) NOT NULL COMMENT '规则描述',
  rule_type varchar(32) DEFAULT NULL COMMENT '规则类型：排他:exclude、叠加:overlying',
  rule_code varchar(64) NOT NULL COMMENT '规则code，唯一标识',
  rule_content text COMMENT '规则内容，json结构',
  status tinyint(4) NOT NULL COMMENT '状态：0:删除，1：生效',
  version int(11) NOT NULL COMMENT '版本号',
  env varchar(32) NOT NULL COMMENT '环境: staging，prod',
  feature varchar(1024) DEFAULT NULL COMMENT '额外信息',
  PRIMARY KEY (id),
  UNIQUE KEY uk_rule_code_version_env (rule_code,version,env)
);

CREATE TABLE marketing_tool (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  tool_code varchar(255) NOT NULL COMMENT '工具code',
  tool_name varchar(255) NOT NULL COMMENT '工具名称',
  tool_version int(11) DEFAULT NULL COMMENT '工具版本',
  product_express text COMMENT '计算表达式',
  state int(11) NOT NULL DEFAULT '0' COMMENT '状态',
  display_express text COMMENT '文案表达式',
  calculate_level int(11) DEFAULT NULL COMMENT '计算级别',
  feature text COMMENT '扩展执行参数',
  priority_level int(11) DEFAULT NULL COMMENT '优先级',
  update_info varchar(255) DEFAULT NULL COMMENT '更新人',
  create_info varchar(255) DEFAULT NULL COMMENT '创建人',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY uk_tool_code (tool_code)
);

CREATE TABLE marketing_blacklist (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  blacklist_id char(24) DEFAULT '' COMMENT '黑名单id',
  activity_id char(24) NOT NULL COMMENT '促销活动ID',
  participate_id char(24) NOT NULL DEFAULT '' COMMENT '参与者ID：SKUID｜商品ID｜店铺ID',
  participate_type tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '参与者类型：0=SKU ID，1=店铺ID，2=商品ID',
  seller_id varchar(50) DEFAULT NULL COMMENT '店铺ID',
  end_time datetime DEFAULT NULL COMMENT '结束时间',
  start_time datetime DEFAULT NULL COMMENT '开始时间',
  state tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '有效状态：0=删除，1=有效',
  PRIMARY KEY (id),
  KEY idx_target_id_state (target_id,state),
  KEY idx_group_seller_id_state (group_id,seller_id,state)
)