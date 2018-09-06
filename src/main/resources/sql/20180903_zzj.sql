CREATE TABLE `sxzz_syn` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'ͬ����¼id',
  `business_id` varchar(32) NOT NULL COMMENT '��Ӧҵ��id (ҽԺ�� ���ң� ҽ��)',
  `business_name` varchar(32) NOT NULL COMMENT '����',
  `business_type` varchar(3) NOT NULL COMMENT 'ҵ������(1-ҽԺ ��2-���� �� 3-ҽ��)',
  `create_date` varchar(20) NOT NULL COMMENT '��������yyyyMMdd hh:mm:ss',
  `syn_type` varchar(3) DEFAULT NULL COMMENT 'ͬ�����ͣ�1-������ 2,-���� �� 3-ɾ����',
  `syn_state` varchar(3) DEFAULT '0' COMMENT 'ͬ��״̬��0-��ͬ���� 1-��ͬ����',
  `syn_result` varchar(2) DEFAULT '' COMMENT 'ͬ��״̬(0-ͬ���ɹ� �� 1-ͬ��ʧ��)',
  `syn_nums` int(2) DEFAULT '0' COMMENT 'ͬ������',
  `syn_response` varchar(255) DEFAULT NULL COMMENT '������Ӧ�ַ���',
  `syn_desc` varchar(255) DEFAULT NULL COMMENT '�����������',
  `remarks` varchar(255) DEFAULT NULL COMMENT '�ֹ�����',
  `syn_date` varchar(20) DEFAULT NULL COMMENT 'ͬ������yyyyMMdd hh:mm:ss',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

ALTER TABLE `sxzz_hospital`
ADD COLUMN `hospital_id_ding`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ͬ���ڶ���ƽ̨��ҽԺid' AFTER `CLINIC_CONTACT_PHONE`;


ALTER TABLE `sxzz_dept`
ADD COLUMN `dept_id_ding`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����ƽ̨����id ' AFTER `STATUS`;


