CREATE TABLE `sxzz_syn` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '同步记录id',
  `business_id` varchar(32) NOT NULL COMMENT '对应业务id (医院， 科室， 医生)',
  `business_name` varchar(32) NOT NULL COMMENT '名称',
  `business_type` varchar(3) NOT NULL COMMENT '业务类型(1-医院 ，2-科室 ， 3-医生)',
  `create_date` varchar(20) NOT NULL COMMENT '创建日期yyyyMMdd hh:mm:ss',
  `syn_type` varchar(3) DEFAULT NULL COMMENT '同步类型（1-创建， 2,-更新 ， 3-删除）',
  `syn_state` varchar(3) DEFAULT '0' COMMENT '同步状态（0-待同步， 1-已同步）',
  `syn_result` varchar(2) DEFAULT '' COMMENT '同步状态(0-同步成功 ， 1-同步失败)',
  `syn_nums` int(2) DEFAULT '0' COMMENT '同步次数',
  `syn_response` varchar(255) DEFAULT NULL COMMENT '钉钉响应字符串',
  `syn_desc` varchar(255) DEFAULT NULL COMMENT '结果补充描述',
  `remarks` varchar(255) DEFAULT NULL COMMENT '手工描述',
  `syn_date` varchar(20) DEFAULT NULL COMMENT '同步日期yyyyMMdd hh:mm:ss',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

ALTER TABLE `sxzz_hospital`
ADD COLUMN `hospital_id_ding`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '同步在钉钉平台的医院id' AFTER `CLINIC_CONTACT_PHONE`;


ALTER TABLE `sxzz_dept`
ADD COLUMN `dept_id_ding`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '钉钉平台科室id ' AFTER `STATUS`;


