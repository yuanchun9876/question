/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/7/7 20:47:37                            */
/*==============================================================*/


drop table if exists TEST_PATER;

drop table if exists TEST_PLAN;

drop table if exists TEST_PLAN_DETAILED;

/*==============================================================*/
/* Table: TEST_PATER                                            */
/*==============================================================*/
create table TEST_PATER
(
   TP_PT_ID             varchar(50) not null,
   TP_ID                varchar(50),
   QSTN_ID              varchar(50),
   primary key (TP_PT_ID)
);

/*==============================================================*/
/* Table: TEST_PLAN                                             */
/*==============================================================*/
create table TEST_PLAN
(
   TP_ID                varchar(50) not null,
   TP_TITLE             varchar(50),
   TP_BEGIN_DATE        datetime,
   TP_END_DATE          datetime,
   TP_COUNT             int,
   TP_TOTAL             int,
   TP_DATE              datetime,
   TP_INFO              varchar(500),
   TP_TYPE              varchar(50) comment '0.随机  1.固定',
   TP_TARGET            varchar(50),
   primary key (TP_ID)
);

/*==============================================================*/
/* Table: TEST_PLAN_DETAILED                                    */
/*==============================================================*/
create table TEST_PLAN_DETAILED
(
   TP_DTD_ID            varchar(50) not null,
   TP_ID                varchar(50),
   SUBJ_UNIT_ID         varchar(50),
   SUBJ_SCTN_ID         varchar(50),
   SUBJ_ID              varchar(50),
   QSTN_TYPE_ID         varchar(50),
   QSTN_FROM_TYPE_ID    varchar(50),
   FROM_NUM             int,
   TYPE_NUM             int,
   SUBJ_NUM             int,
   UNIT_NUM             int,
   SCTN_NUM             int,
   TP_DTD_TYPE          varchar(50) comment '1.类型 2.来源 3.科目 4.章 5.节',
   primary key (TP_DTD_ID)
);

alter table TEST_PATER add constraint FK_Reference_24 foreign key (TP_ID)
      references TEST_PLAN (TP_ID) on delete restrict on update restrict;

alter table TEST_PATER add constraint FK_Reference_27 foreign key (QSTN_ID)
      references QUESTION (QSTN_ID) on delete restrict on update restrict;

alter table TEST_PLAN_DETAILED add constraint FK_Reference_18 foreign key (TP_ID)
      references TEST_PLAN (TP_ID) on delete restrict on update restrict;

alter table TEST_PLAN_DETAILED add constraint FK_Reference_19 foreign key (SUBJ_UNIT_ID)
      references SUBJ_UNIT (SUBJ_UNIT_ID) on delete restrict on update restrict;

alter table TEST_PLAN_DETAILED add constraint FK_Reference_20 foreign key (SUBJ_SCTN_ID)
      references SUBJ_SECTION (SUBJ_SCTN_ID) on delete restrict on update restrict;

alter table TEST_PLAN_DETAILED add constraint FK_Reference_21 foreign key (SUBJ_ID)
      references SUBJECT_COURSE (SUBJ_ID) on delete restrict on update restrict;

alter table TEST_PLAN_DETAILED add constraint FK_Reference_22 foreign key (QSTN_TYPE_ID)
      references QUESTION_TYPE (QSTN_TYPE_ID) on delete restrict on update restrict;

alter table TEST_PLAN_DETAILED add constraint FK_Reference_23 foreign key (QSTN_FROM_TYPE_ID)
      references QSTN_FROM_TYPE (QSTN_FROM_TYPE_ID) on delete restrict on update restrict;

