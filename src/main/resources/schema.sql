CREATE TABLE IF NOT EXISTS `address` (
  `id` char(24) NOT NULL,
  `address` text NOT NULL,
  `addressee_id` char(24) NOT NULL,
  `addressee_type` smallint(2) NOT NULL,
  `status` smallint(2) NOT NULL DEFAULT '0',
  `memo` varchar(255) DEFAULT NULL,
  `created_time` varchar(20) NOT NULL,
  `changed_lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `i_addr_addressee_id` (`addressee_id`),
  KEY `i_addr_changed` (`changed_lasttime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `authority` (
  `id` char(24) NOT NULL,
  `data_url` varchar(255) NOT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_class` varchar(255) NOT NULL COMMENT '0-用户端 2-后台管理端',
  `parent_id` char(24) DEFAULT NULL,
  `status` smallint(2) NOT NULL DEFAULT '0' COMMENT '0-正常 1-删除',
  `memo` varchar(255) DEFAULT NULL,
  `created_time` varchar(20) NOT NULL,
  `changed_lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `i_authority_changed` (`changed_lasttime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `invoice_delivery` (
  `id` char(24) NOT NULL,
  `user_id` char(24) NOT NULL,
  `address_id` char(24) NOT NULL,
  `express_company` varchar(50) DEFAULT NULL,
  `auditor_id` char(24) DEFAULT NULL,
  `auditer_status` varchar(50) DEFAULT NULL,
  `status` smallint(2) NOT NULL,
  `created_time` varchar(20) DEFAULT NULL,
  `changed_lasttime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `i_invoice_delivery_user_id` (`user_id`),
  KEY `i_invoice_delivery_address_id` (`address_id`),
  KEY `i_invoice_delivery_changed` (`changed_lasttime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `order` (
  `id` char(24) NOT NULL,
  `payer_id` varchar(24) NOT NULL,
  `payee_id` char(24) NOT NULL,
  `user_id` char(24) DEFAULT NULL,
  `address_id` char(24) NOT NULL,
  `trade_name` varchar(100) NOT NULL COMMENT '1-商业 2-工业 3-交通运输业 4-陆路运输业 5-装卸搬运业 6-建筑服务业 7-现代服务业 8-租赁业',
  `tax_rate` decimal(14,4) NOT NULL,
  `express_company` varchar(100) NOT NULL COMMENT '1-EMS 2-顺丰 3-中通 4-韵达 5-申通 6-百世汇通',
  `express_fee` decimal(14,4) NOT NULL,
  `express_tracking_code` varchar(100) DEFAULT NULL,
  `total_amount` decimal(14,4) NOT NULL,
  `total_tax_amout` decimal(14,4) NOT NULL,
  `audit_status` smallint(2) NOT NULL DEFAULT '0' COMMENT '0-待审核 1-审核通过  2-已发货  3-驳回',
  `auditer` varchar(24) DEFAULT NULL,
  `reject_reason` varchar(50) DEFAULT NULL,
  `reject_desc` varchar(1000) DEFAULT NULL,
  `status` smallint(2) NOT NULL DEFAULT '0' COMMENT '0-未付款 1-用户删除 2-已付清 3-付款少了 4-付款多了',
  `memo` varchar(255) DEFAULT NULL,
  `created_time` varchar(20) NOT NULL,
  `changed_lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `i_order_payer_id` (`payer_id`),
  KEY `i_order_payee_id` (`payee_id`),
  KEY `i_order_audit_status` (`audit_status`),
  KEY `i_order_changed` (`changed_lasttime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `payee` (
  `id` char(24) NOT NULL,
  `user_id` char(24) NOT NULL,
  `payee_name` varchar(255) NOT NULL,
  `payee_cidno` varchar(18) NOT NULL,
  `payee_cid_url` text NOT NULL,
  `payee_type` smallint(2) NOT NULL DEFAULT '0',
  `status` smallint(2) NOT NULL DEFAULT '0',
  `memo` longtext,
  `created_time` varchar(20) NOT NULL,
  `changed_lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_payee_cidno` (`payee_cidno`),
  KEY `i_payee_user_id` (`user_id`),
  KEY `i_changed_lasttime` (`changed_lasttime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `payer` (
  `id` char(24) NOT NULL,
  `payer_code` varchar(50) NOT NULL,
  `payer_name` varchar(255) NOT NULL,
  `user_id` char(24) NOT NULL,
  `payer_addr` varchar(255) DEFAULT NULL,
  `payer_phone` varchar(20) DEFAULT NULL,
  `payer_bank` varchar(255) DEFAULT NULL,
  `payer_bank_no` varchar(50) DEFAULT NULL,
  `status` smallint(2) NOT NULL DEFAULT '0',
  `payer_type` smallint(2) NOT NULL DEFAULT '0',
  `memo` varchar(255) DEFAULT NULL,
  `create_time` varchar(20) NOT NULL,
  `changed_lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `i_payer_name` (`payer_name`(191)),
  KEY `i_payer_changed_lasttime` (`changed_lasttime`),
  KEY `i_payer_user_id` (`user_id`),
  KEY `i_payer_paye_code` (`payer_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `payment` (
  `id` char(24) NOT NULL,
  `user_id` char(24) NOT NULL,
  `order_id` char(24) DEFAULT NULL,
  `pay_type` varchar(50) NOT NULL,
  `pay_trace_code` varchar(20) NOT NULL,
  `pay_for` smallint(2) NOT NULL,
  `status` smallint(2) NOT NULL DEFAULT '0',
  `memo` varchar(255) DEFAULT NULL,
  `create_time` varchar(20) NOT NULL,
  `changed_lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_payee_payer_order_id` (`order_id`,`pay_for`),
  KEY `i_payee_payer_user_id` (`user_id`),
  KEY `i_payee_payer_changed` (`changed_lasttime`),
  KEY `i_payee_trace_code` (`pay_trace_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `role` (
  `id` char(24) NOT NULL,
  `rolename` varchar(50) NOT NULL,
  `user_id` char(24) NOT NULL,
  `role_desc` varchar(150) DEFAULT NULL,
  `status` smallint(2) NOT NULL DEFAULT '0' COMMENT '0-正常 1-弃用',
  `memo` varchar(255) DEFAULT NULL,
  `created_time` varchar(20) NOT NULL,
  `changed_lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_rols_rolename` (`rolename`),
  KEY `i_rols_changed_lasttime` (`changed_lasttime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `role_authority` (
  `id` char(24) NOT NULL,
  `role_id` char(24) NOT NULL,
  `authority_id` char(24) NOT NULL,
  `status` smallint(2) NOT NULL DEFAULT '0',
  `memo` varchar(255) DEFAULT NULL,
  `created_time` varchar(20) NOT NULL,
  `changed_lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `shopping_trolley` (
  `id` char(24) NOT NULL,
  `order_id` char(24) NOT NULL,
  `goods_name` varchar(255) NOT NULL,
  `goods_type` varchar(255) DEFAULT NULL,
  `measure_unit` varchar(50) NOT NULL,
  `buyed_num` int(10) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `sales_volume` decimal(10,2) DEFAULT NULL,
  `tax` decimal(10,2) DEFAULT NULL,
  `tax_amount` decimal(10,2) DEFAULT NULL,
  `status` smallint(2) NOT NULL DEFAULT '0',
  `memo` varchar(255) DEFAULT NULL,
  `created_time` varchar(20) NOT NULL,
  `changed_lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `i_shopping_trolley_order_id` (`order_id`),
  KEY `i_shopping_trolley_changed` (`changed_lasttime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `sms_log` (
  `id` char(24) COLLATE utf8mb4_bin NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT '待发送的号码',
  `sms_code` varchar(6) COLLATE utf8mb4_bin NOT NULL DEFAULT '验证码',
  `request_id` varchar(45) COLLATE utf8mb4_bin DEFAULT '请求id',
  `status_code` varchar(60) COLLATE utf8mb4_bin DEFAULT '状态码',
  `message` varchar(45) COLLATE utf8mb4_bin DEFAULT '描述状态码',
  `bizid` varchar(45) COLLATE utf8mb4_bin DEFAULT '发送的回执Id,根据此Id可以查具体发送状态',
  `memo` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `changed_lasttime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `i_sms_phone` (`phone`),
  KEY `i_sms_changed_time` (`changed_lasttime`),
  KEY `i_sms_request_id` (`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE IF NOT EXISTS `user` (
  `id` char(24) NOT NULL,
  `username` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `salt` varchar(10) DEFAULT NULL,
  `mail_addr` varchar(255) DEFAULT NULL,
  `status` smallint(2) NOT NULL DEFAULT '0' COMMENT '0-未登录 1-已登录 2-重新登录 3-限制登录',
  `memo` varchar(255) DEFAULT NULL,
  `created_time` varchar(20) NOT NULL,
  `changed_lasttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_user_phone` (`phone`),
  KEY `i_user_username` (`username`),
  KEY `i_user_status` (`status`),
  KEY `i_user_changed_lasttime` (`changed_lasttime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;