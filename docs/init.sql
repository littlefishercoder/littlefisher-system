drop table if exists EG_ATTR;

drop table if exists EG_ATTR_CATG;

drop table if exists EG_ATTR_CATG_CHILDREN;

drop table if exists EG_ATTR_CATG_STATE;

drop table if exists EG_ATTR_CATG_TYPE;

drop table if exists EG_ATTR_STATE;

drop table if exists EG_ATTR_TYPE;

drop table if exists EG_ATTR_VALUE;

drop table if exists EG_CERT;

drop table if exists EG_CERT_TYPE;

drop table if exists EG_CONFIG_ITEM;

drop table if exists EG_CONTACT_MAN;

drop table if exists EG_DECORATION_ORDER;

drop table if exists EG_DECORATION_ORDER_HIS;

drop table if exists EG_DECORATION_ORDER_STATE;

drop table if exists EG_DECORATION_ORDER_TEMPLATE;

drop table if exists EG_DECORATION_STYLE;

drop table if exists EG_DECORATION_TYPE;

drop table if exists EG_GARDEN;

drop table if exists EG_HOUSE;

drop table if exists EG_MODEL;

drop table if exists EG_PROPERTY;

drop table if exists EG_REQUIRE_ORDER;

drop table if exists EG_REQUIRE_ORDER_MODEL;

drop table if exists EG_REQUIRE_ORDER_MODEL_ATTR_CATG;

drop table if exists EG_REQUIRE_ORDER_MODEL_VALUE;

drop table if exists EG_STAFF;

drop table if exists EG_STANDARD_ADDR;

drop table if exists EG_SUPPLIER;

drop table if exists EG_SUPPLIER_MODEL;

drop table if exists EG_SUPPLIER_MODEL_ATTR_CATG;

drop table if exists EG_SUPPLIER_MODEL_VALUE;

drop table if exists EG_SUPPLIER_MODEL_VALUE_HIS;

drop table if exists EG_SUPPLIER_PRICE;

drop table if exists EG_SUPPLIER_PRICE_STATE;

drop table if exists EG_SUPPLIER_STATE;

drop table if exists EG_SUPPLIER_TYPE;

drop table if exists EG_TEMPLATE;

drop table if exists EG_TEMPLATE_MODEL;

drop table if exists EG_TEMPLATE_MODEL_ATTR_CATG;

drop table if exists EG_TEMPLATE_MODEL_VALUE;

drop table if exists EG_TEMPLATE_STATE;

drop table if exists EG_UNIT;

/*==============================================================*/
/* Table: EG_ATTR                                               */
/*==============================================================*/
create table EG_ATTR
(
   ID                   int(9) not null auto_increment comment '属性主键',
   NAME                 varchar(30) not null comment '属性名',
   CODE                 varchar(30) not null comment '属性编码',
   UNIT_ID              int(9) not null comment '单位',
   TYPE                 char(1) not null comment '属性类型',
   STATE                char(1) not null comment '状态',
   STATE_DATE           datetime comment '状态变更时间',
   COMMENTS             varchar(255) comment '备注',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_ATTR_CATG                                          */
/*==============================================================*/
create table EG_ATTR_CATG
(
   ID                   int(9) not null auto_increment comment '主键',
   CATG_NAME            varchar(30) not null comment '目录名',
   CATG_CODE            varchar(30) not null comment '目录编码',
   CATG_TYPE            char(1) not null comment '目录类型',
   STATE                char(1) not null comment '状态',
   STATE_DATE           datetime comment '状态变更时间',
   primary key (ID)
);

alter table EG_ATTR_CATG comment '例如：基本信息，外观，价位等';

/*==============================================================*/
/* Table: EG_ATTR_CATG_CHILDREN                                 */
/*==============================================================*/
create table EG_ATTR_CATG_CHILDREN
(
   ID                   int(9) not null auto_increment comment '主键',
   CATG_ID              int(9) not null comment '当前目录主键',
   CHILD_CATG_ID        int(9) comment '子目录主键',
   CHILD_ATTR_ID        int(9) comment '子属性主键',
   primary key (ID)
);

alter table EG_ATTR_CATG_CHILDREN comment '该表用来记录当前目录下都有哪些子目录或者子属性，一般子目录主键和子属性主键不可同时存在。如果一个目录下既有子目录又有子属';

/*==============================================================*/
/* Table: EG_ATTR_CATG_STATE                                    */
/*==============================================================*/
create table EG_ATTR_CATG_STATE
(
   STATE                char(1) not null comment '状态',
   STATE_NAME           varchar(30) not null comment '状态名',
   COMMENTS             text comment '备注',
   primary key (STATE)
);

/*==============================================================*/
/* Table: EG_ATTR_CATG_TYPE                                     */
/*==============================================================*/
create table EG_ATTR_CATG_TYPE
(
   TYPE                 char(1) not null comment '类型',
   TYPE_NAME            varchar(30) not null comment '类型名',
   COMMENTS             varchar(255) comment '备注',
   primary key (TYPE)
);

alter table EG_ATTR_CATG_TYPE comment '目录类型暂时分为A：Root Catg 根目录和B：General Catg 普通目录
所有的Attr和At';

/*==============================================================*/
/* Table: EG_ATTR_STATE                                         */
/*==============================================================*/
create table EG_ATTR_STATE
(
   STATE                char(1) not null comment '状态',
   STATE_NAME           varchar(30) not null comment '状态名称',
   COMMENTS             text comment '备注',
   primary key (STATE)
);

/*==============================================================*/
/* Table: EG_ATTR_TYPE                                          */
/*==============================================================*/
create table EG_ATTR_TYPE
(
   TYPE                 char(1) not null comment '属性类型',
   TYPE_NAME            varchar(20) not null comment '属性类型名称',
   COMMENTS             varchar(255) comment '备注',
   primary key (TYPE)
);

alter table EG_ATTR_TYPE comment '例如：A：文本输入框，B：单选框，C：多选框，D：时间选择框 等';

INSERT INTO EG_ATTR_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('A', 'Input', '文本输入框');
INSERT INTO EG_ATTR_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('B', 'RadioBox', '单选框');
INSERT INTO EG_ATTR_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('C', 'Checkbox', '多选框');
INSERT INTO EG_ATTR_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('D', 'DatetimePicker', '时间选择框');
INSERT INTO EG_ATTR_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('F', 'PrecisionInput', '金额输入框');
INSERT INTO EG_ATTR_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('G', 'Dropdown', '单选下拉框');
INSERT INTO EG_ATTR_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('H', 'MultiSelect', '多选下拉框');

/*==============================================================*/
/* Table: EG_ATTR_VALUE                                         */
/*==============================================================*/
create table EG_ATTR_VALUE
(
   ID                   int(9) not null auto_increment comment '主键',
   ATTR_ID              int(9) not null comment '属性主键',
   VALUE                varchar(30) comment '属性可选项',
   VALUE_MASK           varchar(30) comment '可选项展示内容',
   PRIORITY             int not null comment '优先级',
   primary key (ID)
);

alter table EG_ATTR_VALUE comment '如果属性类型是单选、多选等，需要有可选项';

/*==============================================================*/
/* Table: EG_CERT                                               */
/*==============================================================*/
create table EG_CERT
(
   CERT_ID              int(9) not null auto_increment comment '证件主键',
   CERT_TYPE            char(1) not null comment '证件类型',
   CERT_NBR             varchar(30) not null comment '证件号码',
   primary key (CERT_ID)
);

/*==============================================================*/
/* Table: EG_CERT_TYPE                                          */
/*==============================================================*/
create table EG_CERT_TYPE
(
   TYPE                 char not null comment '主键',
   TYPE_NAME            varchar(30) not null comment '证件名称',
   COMMENTS             varchar(255) comment '备注',
   primary key (TYPE)
);

INSERT INTO EG_CERT_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('A', 'ID Card', '身份证');
INSERT INTO EG_CERT_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('B', 'Passport', '护照');
INSERT INTO EG_CERT_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('C', 'Current Macau Pass', '港澳通行证');
INSERT INTO EG_CERT_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('D', 'Taiwan pass process', '台湾通行证');

/*==============================================================*/
/* Table: EG_CONFIG_ITEM                                        */
/*==============================================================*/
create table EG_CONFIG_ITEM
(
   ID                   int(9) not null auto_increment comment '主键',
   CODE                 varchar(60) not null comment '编码',
   VALUE                varchar(60) comment '值',
   DEFAULT_VALUE        varchar(60) not null comment '默认值',
   COMMENTS             varchar(255) comment '备注',
   primary key (ID),
   key AK_UQ_CODE (CODE)
);

INSERT INTO EG_CONFIG_ITEM(CODE, VALUE, DEFAULT_VALUE, COMMENTS) VALUES ('', '', '2', '货币金额精度');

/*==============================================================*/
/* Table: EG_CONTACT_MAN                                        */
/*==============================================================*/
create table EG_CONTACT_MAN
(
   ID                   int(9) not null auto_increment comment '联系人主键',
   SUPPLIER_ID          int(9) comment '供应商主键',
   HOUSE_ID             int(9) comment '房屋主键',
   NAME                 varchar(30) not null comment '联系人姓名',
   PHONE                varchar(30) not null comment '联系人电话',
   EMAIL                varchar(30) comment '联系人邮箱',
   CERT_ID              int(9) not null comment '联系人证件',
   primary key (ID)
);

alter table EG_CONTACT_MAN comment '供应商联系人';

/*==============================================================*/
/* Table: EG_DECORATION_ORDER                                   */
/*==============================================================*/
create table EG_DECORATION_ORDER
(
   ID                   int(9) not null auto_increment comment '主键',
   HOUSE_ID             int(9) not null comment '房屋主键',
   TEMPLATE_ID          int(9) comment '模板主键',
   STATE                char(1) not null comment '状态',
   STATE_DATE           datetime not null comment '状态变更时间',
   START_DATE           datetime comment '在开工环节再录入开工时间',
   AFTER_LAYOUT         varchar(30) comment '包含室厅卫厨阳，例如三室一厅一厨一卫一阳，则录入的信息为3,1,1,1,1。数据以逗号分隔。如果没有修改户型则可以不录入信息。',
   SORT                 int(9) not null comment '根据排序来判断该套房源被装修的次数',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_DECORATION_ORDER_HIS                               */
/*==============================================================*/
create table EG_DECORATION_ORDER_HIS
(
   ID                   int(9) not null auto_increment comment '主键',
   PRIORITY             int(9) not null comment '优先级',
   HOUSE_ID             int(9) not null comment '房屋主键',
   TEMPLATE_ID          int(9) comment '模板主键',
   STATE                char(1) not null comment '状态',
   STATE_DATE           datetime not null comment '状态变更时间',
   START_DATE           datetime comment '在开工环节再录入开工时间',
   AFTER_LAYOUT         varchar(30) comment '包含室厅卫厨阳，例如三室一厅一厨一卫一阳，则录入的信息为3,1,1,1,1。数据以逗号分隔。如果没有修改户型则可以不录入信息。',
   SORT                 int(9) not null comment '根据排序来判断该套房源被装修的次数',
   primary key (ID, PRIORITY)
);

/*==============================================================*/
/* Table: EG_DECORATION_ORDER_STATE                             */
/*==============================================================*/
create table EG_DECORATION_ORDER_STATE
(
   STATE                char(1) not null comment '状态',
   STATE_NAME           varchar(30) not null comment '状态名',
   COMMENTS             varchar(255) comment '备注',
   primary key (STATE)
);

INSERT INTO EG_DECORATION_ORDER_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('A', '', '');
INSERT INTO EG_DECORATION_ORDER_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('B', '', '');
INSERT INTO EG_DECORATION_ORDER_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('C', '', '');

/*==============================================================*/
/* Table: EG_DECORATION_ORDER_TEMPLATE                          */
/*==============================================================*/
create table EG_DECORATION_ORDER_TEMPLATE
(
   ID                   int(9) not null auto_increment comment '主键',
   DECORATION_ORDER_ID  int(9) not null comment '装修单主键',
   TEMPLATE_MODEL_ID    int(9) not null comment '模板使用商服类型主键',
   COUNT                int not null comment '数量',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_DECORATION_STYLE                                   */
/*==============================================================*/
create table EG_DECORATION_STYLE
(
   STYLE                char(1) not null comment '风格',
   STYLE_NAME           varchar(20) comment '风格名称',
   COMMENTS             varchar(255) comment '备注',
   primary key (STYLE)
);

INSERT INTO EG_DECORATION_STYLE(STYLE, STYLE_NAME, COMMENTS) VALUES ('A', 'Simple', '简约');
INSERT INTO EG_DECORATION_STYLE(STYLE, STYLE_NAME, COMMENTS) VALUES ('B', 'Pastoral', '田园');
INSERT INTO EG_DECORATION_STYLE(STYLE, STYLE_NAME, COMMENTS) VALUES ('C', 'European', '欧式');

/*==============================================================*/
/* Table: EG_DECORATION_TYPE                                    */
/*==============================================================*/
create table EG_DECORATION_TYPE
(
   TYPE                 char(1) not null comment '分类',
   TYPE_NAME            varchar(30) not null comment '分类名',
   COMMENTS             varchar(255) comment '备注',
   primary key (TYPE)
);

alter table EG_DECORATION_TYPE comment 'A：家具类 B：家电类 C：装修类 D：保洁类';

INSERT INTO EG_DECORATION_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('A','Furniture','家具类');
INSERT INTO EG_DECORATION_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('B','Appliance','家电类');
INSERT INTO EG_DECORATION_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('C','Decoration','装修类');
INSERT INTO EG_DECORATION_TYPE(TYPE, TYPE_NAME, COMMENTS) VALUES ('D','Cleaning','保洁类');

/*==============================================================*/
/* Table: EG_GARDEN                                             */
/*==============================================================*/
create table EG_GARDEN
(
   ID                   int(9) not null auto_increment comment '主键',
   GARDEN_NAME          varchar(30) not null comment '小区名',
   STANDARD_ADDR_ID     int(9) comment '标准地址主键',
   SPECIFIC_ADDR        varchar(60) not null comment '详细地址',
   PROPERTY_ID          int(9) not null comment '物业主键',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_HOUSE                                              */
/*==============================================================*/
create table EG_HOUSE
(
   ID                   int(9) not null auto_increment comment '主键',
   GARDEN_ID            int(9) not null comment '小区主键',
   AREA                 int(9) not null comment '不使用浮点型数据类型以防计算时出现不可预测的问题',
   FLOOR                int(9) not null comment '楼层',
   ALL_FLOOR            int(9) not null comment '总楼层',
   LAYOUT               varchar(30) not null comment '包含室厅卫厨阳，例如三室一厅一厨一卫一阳，则录入的信息为3,1,1,1,1。数据以逗号分隔',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_MODEL                                              */
/*==============================================================*/
create table EG_MODEL
(
   ID                   int(9) not null auto_increment comment '类型主键',
   NAME                 varchar(30) not null comment '类型名称',
   CODE                 varchar(30) not null comment '类型编码',
   TYPE                 char(1) not null comment '类型种类',
   UNIT_ID              int(9) not null comment '单位',
   COMMENTS             varchar(255) comment '评论',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_PROPERTY                                           */
/*==============================================================*/
create table EG_PROPERTY
(
   ID                   int(9) not null auto_increment comment '主键',
   NAME                 varchar(30) not null comment '物业名',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_REQUIRE_ORDER                                      */
/*==============================================================*/
create table EG_REQUIRE_ORDER
(
   ID                   int(9) not null auto_increment comment '主键',
   DECORATION_ORDER_ID  int(9) not null comment '装修单主键',
   DELIVER_DATE         datetime not null comment '送货时间',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_REQUIRE_ORDER_MODEL                                */
/*==============================================================*/
create table EG_REQUIRE_ORDER_MODEL
(
   ID                   int(9) not null auto_increment comment '主键',
   REQUIRE_ORDER_ID     int(9) not null comment '货品需求单主键',
   MODEL_ID             int(9) not null comment '商服类型主键',
   STATE                char(1) not null comment '状态',
   STATE_DATE           datetime not null comment '状态变更时间',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_REQUIRE_ORDER_MODEL_ATTR_CATG                      */
/*==============================================================*/
create table EG_REQUIRE_ORDER_MODEL_ATTR_CATG
(
   ID                   int(9) not null auto_increment comment '主键',
   REQUIRE_ORDER_MODEL_ID int(9) comment '货品需求单要求的商服类型主键',
   ATTR_CATG_ID         int(9) comment '属性目录主键',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_REQUIRE_ORDER_MODEL_VALUE                          */
/*==============================================================*/
create table EG_REQUIRE_ORDER_MODEL_VALUE
(
   ID                   int(9) not null auto_increment comment '主键',
   ATTR_ID              int(9) not null comment '属性主键',
   REQUIRE_ORDER_MODEL_ID int(9) not null comment '货品需求单要求的商服类型主键',
   INPUT_TEXT           varchar(255) comment '界面录入项和属性可选项两者二选一，不能同时存在',
   ATTR_VALUE_ID        int(9) comment '界面录入项和属性可选项两者二选一，不能同时存在',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_STAFF                                              */
/*==============================================================*/
create table EG_STAFF
(
   ID                   int(9) not null auto_increment comment '主键',
   NAME                 varchar(30) not null comment '员工名',
   primary key (ID)
);

alter table EG_STAFF comment '用户中心应该有这些表，具体字段不再写了';

/*==============================================================*/
/* Table: EG_STANDARD_ADDR                                      */
/*==============================================================*/
create table EG_STANDARD_ADDR
(
   ID                   int(9) not null auto_increment comment '标准地址主键',
   COUNTRY_ID           int(9) not null comment '国家',
   PROVINCE_ID          int(9) not null comment '省份',
   CITY_ID              int(9) not null comment '城市',
   AREA_ID              int(9) not null comment '区\县',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_SUPPLIER                                           */
/*==============================================================*/
create table EG_SUPPLIER
(
   ID                   int(9) not null auto_increment comment '主键',
   NAME                 varchar(30) not null comment '供应商名',
   STANDARD_ADDR_ID     int(9) not null comment '供应商标准地址',
   SPECIFIC_ADDR        varchar(60) not null comment '供应商详细地址',
   INDEX_URL            varchar(30) comment '供应商首页',
   PHONE_NBR            varchar(30) comment '供应商企业电话',
   INTRODUCTION         text comment '供应商简介',
   IMAGE_URL            varchar(60) comment '供应商图片',
   CONTRACT_DATE_FROM   datetime comment '签约起始时间',
   CONTRACT_DATE_TO     datetime comment '签约截止时间',
   STATE                char(1) not null comment '供应商状态',
   STATE_DATE           datetime not null comment '供应商状态变更时间',
   primary key (ID)
);

alter table EG_SUPPLIER comment '供应商信息';

/*==============================================================*/
/* Table: EG_SUPPLIER_MODEL                                     */
/*==============================================================*/
create table EG_SUPPLIER_MODEL
(
   ID                   int(9) not null auto_increment comment '主键',
   SUPPLIER_ID          int(9) not null comment '供应商主键',
   MODEL_ID             int(9) not null comment '商服类型主键',
   STATE                char(1) not null comment '状态',
   STATE_DATE           datetime not null comment '状态变更时间',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_SUPPLIER_MODEL_ATTR_CATG                           */
/*==============================================================*/
create table EG_SUPPLIER_MODEL_ATTR_CATG
(
   ID                   int(9) not null auto_increment comment '主键',
   SUPPLIER_MODEL_ID    int(9) comment '供应商提供的商服类型主键',
   ATTR_CATG_ID         int(9) comment '属性目录主键',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_SUPPLIER_MODEL_VALUE                               */
/*==============================================================*/
create table EG_SUPPLIER_MODEL_VALUE
(
   ID                   int(9) not null auto_increment comment '主键',
   ATTR_ID              int(9) not null comment '属性主键',
   SUPPLIER_MODEL_ID    int(9) not null comment '供应商提供的商服类型主键',
   INPUT_TEXT           varchar(255) comment '界面录入项和属性可选项两者二选一，不能同时存在',
   ATTR_VALUE_ID        int(9) comment '界面录入项和属性可选项两者二选一，不能同时存在',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_SUPPLIER_MODEL_VALUE_HIS                           */
/*==============================================================*/
create table EG_SUPPLIER_MODEL_VALUE_HIS
(
   ID                   int(9) not null auto_increment comment '主键',
   ATTR_ID              int(9) not null comment '属性主键',
   SUPPLIER_MODEL_ID    int(9) not null comment '供应商提供的商服类型主键',
   INPUT_TEXT           varchar(255) comment '界面录入项和属性可选项两者二选一，不能同时存在',
   ATTR_VALUE_ID        int(9) comment '界面录入项和属性可选项两者二选一，不能同时存在',
   PRIORITY             int(9) not null comment '排序',
   primary key (ID, PRIORITY)
);

/*==============================================================*/
/* Table: EG_SUPPLIER_PRICE                                     */
/*==============================================================*/
create table EG_SUPPLIER_PRICE
(
   ID                   int(9) not null auto_increment comment '主键',
   HOUSE_ID             int(9) not null comment '房屋主键',
   SUPPLIER_MODEL_ID    int(9) not null comment '供应商提供的商服类型主键',
   DECORATION_ORDER_TEMPLATE_ID int(9) not null comment '装修单所需商服数量主键',
   COUNT                int not null comment '数量',
   STATE                char(1) not null comment '状态',
   STATE_DATE           datetime not null comment '状态变更时间',
   BUDGET_PER_ACCOUNT   int comment '预算单价从属性中获取数据并进行拷贝，意味着供应商在提供报价时可以修改单价，不使用浮点型数据类型以防计算时出现不可预测的问题',
   BUDGET_TOTAL_ACCOUNT int not null comment '不使用浮点型数据类型以防计算时出现不可预测的问题',
   FINAL_PER_ACCOUNT    int comment '不使用浮点型数据类型以防计算时出现不可预测的问题',
   FUNAL_TOTAL_ACCOUNT  int not null comment '不使用浮点型数据类型以防计算时出现不可预测的问题',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_SUPPLIER_PRICE_STATE                               */
/*==============================================================*/
create table EG_SUPPLIER_PRICE_STATE
(
   STATE                char(1) not null comment '状态',
   STATE_NAME           varchar(30) not null comment '状态名',
   COMMENTS             varchar(255) comment '备注',
   primary key (STATE)
);

alter table EG_SUPPLIER_PRICE_STATE comment 'A：未发布 B：发布 C：通过筛选';

INSERT INTO EG_SUPPLIER_PRICE_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('A', 'Published', '发布');
INSERT INTO EG_SUPPLIER_PRICE_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('B', 'Unpublished', '未发布');
INSERT INTO EG_SUPPLIER_PRICE_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('C', 'Passed', '通过筛选');

/*==============================================================*/
/* Table: EG_SUPPLIER_STATE                                     */
/*==============================================================*/
create table EG_SUPPLIER_STATE
(
   STATE                char(1) not null comment '状态',
   STATE_NAME           varchar(30) not null comment '状态名',
   COMMENTS             varchar(255) comment '备注',
   primary key (STATE)
);

INSERT INTO EG_SUPPLIER_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('A','Waiting for input','待录入');
INSERT INTO EG_SUPPLIER_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('B','Pending','待审核');
INSERT INTO EG_SUPPLIER_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('C','Valid','已生效');
INSERT INTO EG_SUPPLIER_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('D','Invalid','失效');

/*==============================================================*/
/* Table: EG_SUPPLIER_TYPE                                      */
/*==============================================================*/
create table EG_SUPPLIER_TYPE
(
   ID                   int(9) not null auto_increment comment '主键',
   SUPPLIER_ID          int(9) not null comment '供应商主键',
   DECORATION_TYPE      char(1) not null comment '装修分类',
   primary key (ID)
);

alter table EG_SUPPLIER_TYPE comment '一个供应商可能会有多个分类，例如一个供应商既可以是装修供应商又可以是家具供应商';

/*==============================================================*/
/* Table: EG_TEMPLATE                                           */
/*==============================================================*/
create table EG_TEMPLATE
(
   ID                   int(9) not null auto_increment comment '主键',
   NAME                 varchar(30) not null comment '模板名',
   STAFF_ID             int(9) not null comment '创建人',
   DECORATION_STYLE     char(1) comment '装修风格',
   STATE                char(1) not null comment '状态',
   STATE_DATE           datetime not null comment '状态变更时间',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_TEMPLATE_MODEL                                     */
/*==============================================================*/
create table EG_TEMPLATE_MODEL
(
   ID                   int(9) not null auto_increment comment '主键',
   TEMPLATE_ID          int(9) not null comment '模板主键',
   MODEL_ID             int(9) not null comment '商服类型主键',
   STATE                char(1) not null comment '状态',
   STATE_DATE           datetime not null comment '状态变更时间',
   COUNT                int not null comment '数量',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_TEMPLATE_MODEL_ATTR_CATG                           */
/*==============================================================*/
create table EG_TEMPLATE_MODEL_ATTR_CATG
(
   ID                   int(9) not null auto_increment comment '主键',
   TEMPLATE_MODEL_ID    int(9) comment '模板使用商服类型主键',
   ATTR_CATG_ID         int(9) comment '属性目录主键',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_TEMPLATE_MODEL_VALUE                               */
/*==============================================================*/
create table EG_TEMPLATE_MODEL_VALUE
(
   ID                   int(9) not null auto_increment comment '主键',
   ATTR_ID              int(9) not null comment '属性主键',
   TEMPLATE_MODEL_ID    int(9) not null comment '模板使用商服类型主键',
   INPUT_TEXT           varchar(255) comment '界面录入项和属性可选项两者二选一，不能同时存在',
   ATTR_VALUE_ID        int(9) comment '界面录入项和属性可选项两者二选一，不能同时存在',
   primary key (ID)
);

/*==============================================================*/
/* Table: EG_TEMPLATE_STATE                                     */
/*==============================================================*/
create table EG_TEMPLATE_STATE
(
   STATE                char(1) not null comment '状态',
   STATE_NAME           varchar(30) not null comment '状态名',
   COMMENTS             varchar(255) comment '备注',
   primary key (STATE)
);

alter table EG_TEMPLATE_STATE comment 'A：未发布 B：已发布';

INSERT INTO EG_TEMPLATE_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('A', 'Published', '发布');
INSERT INTO EG_TEMPLATE_STATE(STATE, STATE_NAME, COMMENTS) VALUES ('B', 'Unpublished', '未发布');

/*==============================================================*/
/* Table: EG_UNIT                                               */
/*==============================================================*/
create table EG_UNIT
(
   UNIT                 int(9) not null auto_increment comment '单位',
   UNIT_NAME            varchar(30) not null comment '单位名称',
   COMMENTS             varchar(255) comment '备注',
   primary key (UNIT)
);

alter table EG_UNIT comment '例如：1代表“个”，2代表“元”等';

alter table EG_ATTR add constraint FK_FK_EG_ATTR_TYPE foreign key (TYPE)
      references EG_ATTR_TYPE (TYPE) on delete restrict on update restrict;

alter table EG_ATTR add constraint FK_FK_EG_ATTR_UNIT_ID foreign key (UNIT_ID)
      references EG_UNIT (UNIT) on delete restrict on update restrict;

alter table EG_ATTR add constraint FK_Reference_56 foreign key (STATE)
      references EG_ATTR_STATE (STATE) on delete restrict on update restrict;

alter table EG_ATTR_CATG add constraint FK_FK_EG_ATTR_CATG_STATE foreign key (STATE)
      references EG_ATTR_CATG_STATE (STATE) on delete restrict on update restrict;

alter table EG_ATTR_CATG add constraint FK_FK_EG_ATTR_CATG_TYPE foreign key (CATG_TYPE)
      references EG_ATTR_CATG_TYPE (TYPE) on delete restrict on update restrict;

alter table EG_ATTR_CATG_CHILDREN add constraint FK_FK_EG_ATTR_CATG_CHILDREN_ATTR_ID foreign key (CHILD_ATTR_ID)
      references EG_ATTR (ID) on delete restrict on update restrict;

alter table EG_ATTR_CATG_CHILDREN add constraint FK_FK_EG_ATTR_CATG_CHILDREN_CATG_ID foreign key (CATG_ID)
      references EG_ATTR_CATG (ID) on delete restrict on update restrict;

alter table EG_ATTR_CATG_CHILDREN add constraint FK_FK_EG_ATTR_CATG_CHILDREN_CHILD_CATG_ID foreign key (CHILD_CATG_ID)
      references EG_ATTR_CATG (ID) on delete restrict on update restrict;

alter table EG_ATTR_VALUE add constraint FK_FK_EG_ATTR_VALUE_ATTR_ID foreign key (ATTR_ID)
      references EG_ATTR (ID) on delete restrict on update restrict;

alter table EG_CERT add constraint FK_FK_EG_CERT_CERT_TYPE foreign key (CERT_TYPE)
      references EG_CERT_TYPE (TYPE) on delete restrict on update restrict;

alter table EG_CONTACT_MAN add constraint FK_FK_EG_CONTACT_MAN_CERT_ID foreign key (CERT_ID)
      references EG_CERT (CERT_ID) on delete restrict on update restrict;

alter table EG_CONTACT_MAN add constraint FK_FK_EG_CONTACT_MAN_HOUSE_ID foreign key (HOUSE_ID)
      references EG_HOUSE (ID) on delete restrict on update restrict;

alter table EG_CONTACT_MAN add constraint FK_FK_EG_CONTACT_MAN_SUPPLIER_ID foreign key (SUPPLIER_ID)
      references EG_SUPPLIER (ID) on delete restrict on update restrict;

alter table EG_DECORATION_ORDER add constraint FK_FK_EG_DECORATION_ORDER_HOUSE_ID foreign key (HOUSE_ID)
      references EG_HOUSE (ID) on delete restrict on update restrict;

alter table EG_DECORATION_ORDER add constraint FK_FK_EG_DECORATION_ORDER_STATE foreign key (STATE)
      references EG_DECORATION_ORDER_STATE (STATE) on delete restrict on update restrict;

alter table EG_DECORATION_ORDER add constraint FK_FK_EG_DECORATION_ORDER_TEMPLATE_ID foreign key (TEMPLATE_ID)
      references EG_TEMPLATE (ID) on delete restrict on update restrict;

alter table EG_DECORATION_ORDER_TEMPLATE add constraint FK_FK_EG_DECORATION_ORDER_TEMPLATE_DECORATION_ORDER_ID foreign key (DECORATION_ORDER_ID)
      references EG_DECORATION_ORDER (ID) on delete restrict on update restrict;

alter table EG_DECORATION_ORDER_TEMPLATE add constraint FK_FK_EG_DECORATION_ORDER_TEMPLATE_TEMPLATE_MODEL_ID foreign key (TEMPLATE_MODEL_ID)
      references EG_TEMPLATE_MODEL (ID) on delete restrict on update restrict;

alter table EG_GARDEN add constraint FK_FK_EG_GARDEN_PROPERTY_ID foreign key (PROPERTY_ID)
      references EG_PROPERTY (ID) on delete restrict on update restrict;

alter table EG_GARDEN add constraint FK_FK_EG_GARDEN_STANDARD_ADDR_ID foreign key (STANDARD_ADDR_ID)
      references EG_STANDARD_ADDR (ID) on delete restrict on update restrict;

alter table EG_HOUSE add constraint FK_FK_EG_HOUSE_GARDEN_ID foreign key (GARDEN_ID)
      references EG_GARDEN (ID) on delete restrict on update restrict;

alter table EG_MODEL add constraint FK_FK_EG_MODEL_TYLE foreign key (TYPE)
      references EG_DECORATION_TYPE (TYPE) on delete restrict on update restrict;

alter table EG_MODEL add constraint FK_FK_EG_MODEL_UNIT_ID foreign key (UNIT_ID)
      references EG_UNIT (UNIT) on delete restrict on update restrict;

alter table EG_REQUIRE_ORDER add constraint FK_FK_EG_REQUIRE_ORDER_DECORATION_ORDER_ID foreign key (DECORATION_ORDER_ID)
      references EG_DECORATION_ORDER (ID) on delete restrict on update restrict;

alter table EG_REQUIRE_ORDER_MODEL add constraint FK_FK_EG_REQUIRE_ORDER_MODEL_MODEL_ID foreign key (MODEL_ID)
      references EG_MODEL (ID) on delete restrict on update restrict;

alter table EG_REQUIRE_ORDER_MODEL add constraint FK_FK_EG_REQUIRE_ORDER_MODEL_REQUIRE_ORDER_ID foreign key (REQUIRE_ORDER_ID)
      references EG_REQUIRE_ORDER (ID) on delete restrict on update restrict;

alter table EG_REQUIRE_ORDER_MODEL_ATTR_CATG add constraint FK_FK_EG_REQUIRE_ORDER_MODEL_ATTR_CATG_ATTR_CATG_ID foreign key (ATTR_CATG_ID)
      references EG_ATTR_CATG (ID) on delete restrict on update restrict;

alter table EG_REQUIRE_ORDER_MODEL_ATTR_CATG add constraint FK_FK_EG_REQUIRE_ORDER_MODEL_ATTR_CATG_REQUIRE_ORDER_MODEL_ID foreign key (REQUIRE_ORDER_MODEL_ID)
      references EG_REQUIRE_ORDER_MODEL (ID) on delete restrict on update restrict;

alter table EG_REQUIRE_ORDER_MODEL_VALUE add constraint FK_FK_EG_REQUIRE_ORDER_MODEL_VALUE_ATTR_ID foreign key (ATTR_ID)
      references EG_ATTR (ID) on delete restrict on update restrict;

alter table EG_REQUIRE_ORDER_MODEL_VALUE add constraint FK_FK_EG_REQUIRE_ORDER_MODEL_VALUE_ATTR_VALUE_ID foreign key (ATTR_VALUE_ID)
      references EG_ATTR_VALUE (ID) on delete restrict on update restrict;

alter table EG_REQUIRE_ORDER_MODEL_VALUE add constraint FK_FK_EG_REQUIRE_ORDER_MODEL_VALUE_REQUIRE_ORDER_MODEL_ID foreign key (REQUIRE_ORDER_MODEL_ID)
      references EG_REQUIRE_ORDER_MODEL (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER add constraint FK_FK_EG_SUPPLIER_STANDARD_ADDR_ID foreign key (STANDARD_ADDR_ID)
      references EG_STANDARD_ADDR (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER add constraint FK_FK_EG_SUPPLIER_STATE foreign key (STATE)
      references EG_SUPPLIER_STATE (STATE) on delete restrict on update restrict;

alter table EG_SUPPLIER_MODEL add constraint FK_FK_EG_SUPPLIER_MODEL_MODEL_ID foreign key (MODEL_ID)
      references EG_MODEL (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER_MODEL add constraint FK_FK_EG_SUPPLIER_MODEL_SUPPLIER_ID foreign key (SUPPLIER_ID)
      references EG_SUPPLIER (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER_MODEL_ATTR_CATG add constraint FK_FK_EG_SUPPLIER_MODEL_ATTR_CATG_ATTR_CATG_ID foreign key (ATTR_CATG_ID)
      references EG_ATTR_CATG (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER_MODEL_ATTR_CATG add constraint FK_FK_EG_SUPPLIER_MODEL_ATTR_CATG_SUPPLIER_MODEL_ID foreign key (SUPPLIER_MODEL_ID)
      references EG_SUPPLIER_MODEL (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER_MODEL_VALUE add constraint FK_FK_EG_SUPPLIER_MODEL_VALUE_ATTR_ID foreign key (ATTR_ID)
      references EG_ATTR (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER_MODEL_VALUE add constraint FK_FK_EG_SUPPLIER_MODEL_VALUE_ATTR_VALUE_ID foreign key (ATTR_VALUE_ID)
      references EG_ATTR_VALUE (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER_MODEL_VALUE add constraint FK_FK_EG_SUPPLIER_MODEL_VALUE_SUPPLIER_MODEL_ID foreign key (SUPPLIER_MODEL_ID)
      references EG_SUPPLIER_MODEL (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER_PRICE add constraint FK_FK_EG_SUPPLIER_PRICE_DECORATION_ORDER_TEMPLATE_ID foreign key (DECORATION_ORDER_TEMPLATE_ID)
      references EG_DECORATION_ORDER_TEMPLATE (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER_PRICE add constraint FK_FK_EG_SUPPLIER_PRICE_HOUSE_ID foreign key (HOUSE_ID)
      references EG_HOUSE (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER_PRICE add constraint FK_FK_EG_SUPPLIER_PRICE_STATE foreign key (STATE)
      references EG_SUPPLIER_PRICE_STATE (STATE) on delete restrict on update restrict;

alter table EG_SUPPLIER_PRICE add constraint FK_FK_EG_SUPPLIER_PRICE_SUPPLIER_MODEL_ID foreign key (SUPPLIER_MODEL_ID)
      references EG_SUPPLIER_MODEL (ID) on delete restrict on update restrict;

alter table EG_SUPPLIER_TYPE add constraint FK_FK_EG_SUPPLIER_TYPE_DECORATION_TYPE foreign key (DECORATION_TYPE)
      references EG_DECORATION_TYPE (TYPE) on delete restrict on update restrict;

alter table EG_SUPPLIER_TYPE add constraint FK_FK_EG_SUPPLIER_TYPE_SUPPLIER_ID foreign key (SUPPLIER_ID)
      references EG_SUPPLIER (ID) on delete restrict on update restrict;

alter table EG_TEMPLATE add constraint FK_FK_EG_TEMPLATE_DECORATION_STYLE foreign key (DECORATION_STYLE)
      references EG_DECORATION_STYLE (STYLE) on delete restrict on update restrict;

alter table EG_TEMPLATE add constraint FK_FK_EG_TEMPLATE_STAFF_ID foreign key (STAFF_ID)
      references EG_STAFF (ID) on delete restrict on update restrict;

alter table EG_TEMPLATE add constraint FK_FK_EG_TEMPLATE_STATE foreign key (STATE)
      references EG_TEMPLATE_STATE (STATE) on delete restrict on update restrict;

alter table EG_TEMPLATE_MODEL add constraint FK_FK_EG_TEMPLATE_MODELMODEL_ID foreign key (MODEL_ID)
      references EG_MODEL (ID) on delete restrict on update restrict;

alter table EG_TEMPLATE_MODEL add constraint FK_FK_EG_TEMPLATE_MODEL_TEMPLATE_ID foreign key (TEMPLATE_ID)
      references EG_TEMPLATE (ID) on delete restrict on update restrict;

alter table EG_TEMPLATE_MODEL_ATTR_CATG add constraint FK_FK_EG_TEMPLATE_MODEL_ATTR_CATG_ATTR_CATG_ID foreign key (ATTR_CATG_ID)
      references EG_ATTR_CATG (ID) on delete restrict on update restrict;

alter table EG_TEMPLATE_MODEL_ATTR_CATG add constraint FK_FK_EG_TEMPLATE_MODEL_ATTR_CATG_TEMPLATE_MODEL_ID foreign key (TEMPLATE_MODEL_ID)
      references EG_TEMPLATE_MODEL (ID) on delete restrict on update restrict;

alter table EG_TEMPLATE_MODEL_VALUE add constraint FK_FK_EG_TEMPLATE_MODEL_VALUE_ATTR_ID foreign key (ATTR_ID)
      references EG_ATTR (ID) on delete restrict on update restrict;

alter table EG_TEMPLATE_MODEL_VALUE add constraint FK_FK_EG_TEMPLATE_MODEL_VALUE_ATTR_VALUE_ID foreign key (ATTR_VALUE_ID)
      references EG_ATTR_VALUE (ID) on delete restrict on update restrict;

alter table EG_TEMPLATE_MODEL_VALUE add constraint FK_FK_EG_TEMPLATE_MODEL_VALUE_TEMPLATE_MODEL_ID foreign key (TEMPLATE_MODEL_ID)
      references EG_TEMPLATE_MODEL (ID) on delete restrict on update restrict;
